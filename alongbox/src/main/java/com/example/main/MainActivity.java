package com.example.main;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityGroup;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.Toast;

import com.example.main.MenuFragment.SLMenuListOnItemClickListener;
import com.example.module.about.Guanyu;
import com.example.module.calculate.Jisuanqi;
import com.example.module.conversionSystem.Jinzhizh;
import com.example.module.geometryGraphics.Jihe;
import com.example.module.matrix.Juzhen;
import com.example.module.statistics.Tongji;
import com.example.module.timer.Jishiqi;
import com.example.module.timer.jishiqi.FragmentActivityListener;
import com.umeng.analytics.MobclickAgent;
import com.umeng.fb.FeedbackAgent;
import com.umeng.update.UmengUpdateAgent;

import net.simonvt.menudrawer.DraggableDrawer;
import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActivityGroup implements SLMenuListOnItemClickListener, FragmentActivityListener {
    private EditText rsText;
    private MenuDrawer m;
    //��ʱ��page
    private ArrayList<View> pageViews;
    //���˷���
    FeedbackAgent fb;
    Fragment fragment = null;

    private List<Fragment> fragmentList = new ArrayList<Fragment>();

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UmengUpdateAgent.setUpdateOnlyWifi(false);
        UmengUpdateAgent.update(this);
        LayoutInflater lf = getLayoutInflater();
        View v = lf.inflate(R.layout.frame_menu, null);
        m = MenuDrawer.attach(this, MenuDrawer.Type.OVERLAY, Position.RIGHT);
        m.setTouchMode(MenuDrawer.TOUCH_MODE_BEZEL);
        m.setDropShadowEnabled(false);
        m.setContentView(R.layout.calculator);
        m.setMenuView(v);

        fragmentList.add(new Jisuanqi());
        fragmentList.add(new Juzhen());
        fragmentList.add(new Jihe());
        fragmentList.add(new Tongji());
        fragmentList.add(new Jinzhizh());
        fragmentList.add(new Jishiqi());
        fragmentList.add(new Guanyu());

        Fragment fragment = fragmentList.get(0);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        Animation animation = new AlphaAnimation(0, 1.0f);   //AlphaAnimation ���ƽ���͸���Ķ���Ч��
        animation.setDuration(900);
        m.setAnimation(animation);
        fragmentTransaction.commit();
        rsText = (EditText) findViewById(R.id.rsText);
        //����
        fb = new FeedbackAgent(MainActivity.this);
        fb.sync();
    }

    //ʵ�ְ������Ƴ�
    private long mExitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Object mHelperUtils;
                Toast.makeText(this, "�ٰ�һ���˳�����", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @SuppressLint("NewApi")
    @Override
    public void selectItem(int position, String title) {
        switch (position) {
            case 7:
                share();
                break;
            case 8:
                pingFen();
                break;
            case 9:
                fb.startFeedbackActivity();
                break;
            default:
                fragment = fragmentList.get(position);
                break;
        }
        ((DraggableDrawer) m).setOnMenuCloseListener(new DraggableDrawer.OnMenuCloseListner() {
            @Override
            public void onClose() {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content, fragment);
                Log.d("flag", "onClose: "+fragment);
                transaction.commit();
                fragment = null;
            }
        });
        Log.d("flag", "null: "+fragment);
        if (fragment != null) {
            Log.d("flag", "null: "+fragment);
            m.closeMenu();
        }
    }

    public void pingFen() {
        Uri uri = Uri.parse("market://details?id=" + "com.example.calculatorjykal");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }

    static String path;

    //����
    public void share() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                //�ǽ�ͼ����
                synchronized (this) { //��wait�������?ynchronized���У����߳��Լ�
                    try {
                        this.wait(40);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } //��һ����ʱ�䣬Ҫ��Ȼû��notify��һֱwait��
                }
                //���ý�ͼ����������sd��
                MainActivity.savePic(MainActivity.takeScreenShot(MainActivity.this), Environment.getExternalStorageDirectory() + "/mnt/sdcard/" + "screenShot.png");
                path = Environment.getExternalStorageDirectory() + "/mnt/sdcard/" + "screenShot.png";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_SUBJECT, "����");
                intent.putExtra(Intent.EXTRA_TITLE, "����");
                intent.putExtra(Intent.EXTRA_TEXT, "һ������ļ�����������һ�£�?");
                intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///" + path));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MainActivity.this.startActivity(Intent.createChooser(intent, "����"));
            }

        }).start();
    }

    //��ͼ
    private static Bitmap takeScreenShot(Activity activity) {
        // View������Ҫ��ͼ��View
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();
        // ��ȡ״̬���߶�
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        // ��ȡ��Ļ���͸�
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay()
                .getHeight();
        // ȥ��������
        Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        return b;
    }

    // ��ͼ���浽sdcard
    private static void savePic(Bitmap b, String strFileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(strFileName);
            if (null != fos) {
                b.compress(Bitmap.CompressFormat.PNG, 90, fos);
                fos.flush();
                fos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //��ʱ��page
    public ArrayList<View> getViewPage() {
        pageViews = new ArrayList<View>();
        View view02 = getLocalActivityManager().startActivity("activity02",
                new Intent(this, com.example.module.timer.jishiqi.DuociTimer.class))
                .getDecorView();
        View view03 = getLocalActivityManager().startActivity("activity03",
                new Intent(this, com.example.module.timer.selecttimee.MainActivity.class))
                .getDecorView();
        pageViews.add(view02);
        pageViews.add(view03);
        return pageViews;
    }
}
package com.example.calculatorjykal;


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
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.feedback.FeedbackAgent;
import com.example.calculatorjykal.MenuFragment.SLMenuListOnItemClickListener;
import com.example.module.about.Guanyu;
import com.example.module.calculate.Jisuanqi;
import com.example.module.conversionSystem.Jinzhizh;
import com.example.module.geometryGraphics.Jihe;
import com.example.module.matrix.Juzhen;
import com.example.module.statistics.Tongji;
import com.example.module.timer.Jishiqi;
import com.example.module.timer.jishiqi.FragmentActivityListener;
import com.umeng.analytics.MobclickAgent;
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
    //¼ÆÊ±Æ÷page
    private ArrayList<View> pageViews;
    //ÓÑÃË·´À¡
    Fragment fragment = null;

    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private FeedbackAgent agent;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UmengUpdateAgent.setUpdateOnlyWifi(false);
        UmengUpdateAgent.update(this);
        //³õÊ¼»¯·´À¡
        AVOSCloud.initialize(getApplicationContext()
                , "7Y6gLzAxf29pxDkEnGqgrkvQ-gzGzoHsz"
                , "5vxAiQAfP9zPtnRqD9eaOPKn");
        agent = new FeedbackAgent(getApplicationContext());
        agent.sync();
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
        Animation animation = new AlphaAnimation(0, 1.0f);   //AlphaAnimation ¿ØÖÆ½¥±äÍ¸Ã÷µÄ¶¯»­Ð§¹û
        animation.setDuration(900);
        m.setAnimation(animation);
        fragmentTransaction.commit();
        rsText = (EditText) findViewById(R.id.rsText);

    }

    //Êµï¿½Ö°ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Æ³ï¿½
    private long mExitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Object mHelperUtils;
                Toast.makeText(this, "ÔÙ°´Ò»´ÎÍË³ö³ÌÐò", Toast.LENGTH_SHORT).show();
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
                //´ò¿ªÓÃ»§·´À¡
                agent.startDefaultThreadActivity();
                break;
            default:
                fragment = fragmentList.get(position);
                break;
        }
        ((DraggableDrawer) m).setOnMenuCloseListener(new DraggableDrawer.OnMenuCloseListner() {
            @Override
            public void onClose() {
                if (fragment == null) {
                    return;
                }
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content, fragment);
                transaction.commit();
                fragment = null;
            }
        });
        if (fragment != null) {
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

    //ï¿½ï¿½ï¿½ï¿½
    public void share() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                //ï¿½Ç½ï¿½Í¼ï¿½ï¿½ï¿½ï¿½
                synchronized (this) { //ï¿½ï¿½waitï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿?ynchronizedï¿½ï¿½ï¿½Ð£ï¿½ï¿½ï¿½ï¿½ß³ï¿½ï¿½Ô¼ï¿½
                    try {
                        this.wait(40);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } //ï¿½ï¿½Ò»ï¿½ï¿½ï¿½ï¿½Ê±ï¿½ä£¬Òªï¿½ï¿½È»Ã»ï¿½ï¿½notifyï¿½ï¿½Ò»Ö±waitï¿½ï¿½
                }
                //ï¿½ï¿½ï¿½Ã½ï¿½Í¼ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½sdï¿½ï¿½
                MainActivity.savePic(MainActivity.takeScreenShot(MainActivity.this), Environment.getExternalStorageDirectory() + "/mnt/sdcard/" + "screenShot.png");
                path = Environment.getExternalStorageDirectory() + "/mnt/sdcard/" + "screenShot.png";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_SUBJECT, "·ÖÏí");
                intent.putExtra(Intent.EXTRA_TITLE, "·ÖÏí");
                intent.putExtra(Intent.EXTRA_TEXT, "Ò»¸ö²»´íµÄ¼ÆËãÆ÷£¡·ÖÏíÒ»ÏÂ£¡");
                intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///" + path));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MainActivity.this.startActivity(Intent.createChooser(intent, "·ÖÏí"));
            }

        }).start();
    }

    //ï¿½ï¿½Í¼
    private static Bitmap takeScreenShot(Activity activity) {
        // Viewï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Òªï¿½ï¿½Í¼ï¿½ï¿½View
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();
        // ï¿½ï¿½È¡×´Ì¬ï¿½ï¿½ï¿½ß¶ï¿½
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        // ï¿½ï¿½È¡ï¿½ï¿½Ä»ï¿½ï¿½ï¿½Í¸ï¿½
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay()
                .getHeight();
        // È¥ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
        Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        return b;
    }

    // ï¿½ï¿½Í¼ï¿½ï¿½ï¿½æµ½sdcard
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

    //ï¿½ï¿½Ê±ï¿½ï¿½page
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
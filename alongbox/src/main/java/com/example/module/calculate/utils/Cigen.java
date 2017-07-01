package com.example.module.calculate.utils;








import java.math.BigDecimal;
import java.util.regex.Pattern;

import bsh.EvalError;
import bsh.Interpreter;


public  class Cigen {
	
	
		
public static  String ciFang(String m1){
	StringBuilder  m = new  StringBuilder(m1);
	String m2="";
	for(int a= 0;a<=m.length()-1;a++){
		if(m.indexOf("∏")==-1)
		{}
		else
		{
			m=m.replace(m.indexOf("∏"),m.indexOf("∏")+1, "3.141592653589793");
		}
		if(m.indexOf("e")==-1)
		{}
		else
		{
			m=m.replace(m.indexOf("e"),m.indexOf("e")+1, "2.718281828459045");
			}
if(m.indexOf("%")==-1)
{}
else
{
	m=m.replace(m.indexOf("%"), m.indexOf("%")+1,"/100");
	}
if(m.indexOf("C")==-1)
	{}
	else
	{
		m=m.replace(m.indexOf("C"), m.indexOf("C")+1,"299792458.4");
		}
if(m.indexOf("G")==-1)
{}
else
{
	m=m.replace(m.indexOf("G"), m.indexOf("G")+1,"0.00000000006674");
	}
if(m.indexOf("h")==-1)
{}
else
{
	m=m.replace(m.indexOf("h"), m.indexOf("h")+1,"0");
	}
if(m.indexOf("N")==-1)
{}
else
{
	m=m.replace(m.indexOf("N"), m.indexOf("N")+1,"602214179000000000000000");
	}
if(m.indexOf("E")==-1)
{}
else
{
	m=m.replace(m.indexOf("E"), m.indexOf("E")+1,"0");
	}
if(m.indexOf("φ")==-1)
{}
else
{
	m=m.replace(m.indexOf("φ"), m.indexOf("φ")+1,"0.618033988749895");
	}
	}
	Youxiansuanfa you = new Youxiansuanfa();
	int b3 = 0;
	int b4 = 0;
	int c3 = 0;
	int c4 = 0;
	int d3 = 0;
	int d4 = 0;
	int x2=0;
	int x3=0;		//434∧34+3∧(87+sin(4+3))
	
	
	for (int a = 0; a <= m.length() - 1; a++) {
		int b=a;
		//if(m.charAt(a)=='∧'){
		char bb = m.charAt(a);
		if(bb=='√'){
			//System.out.println(4444444);
			m = m.replace(0, m.length(),Genhao.genHao(m.toString(),b));
		}
		
		
		
		
		
		
		
		
		
		
		
		 else if(bb=='^'){
			String c = String.valueOf(m.charAt(b - 1));
			

			 if (Pattern.matches("[0-9]", c)) {
				 int d1;
				String a12 = "";
				String a1 = "";
				String a11 = "";
				for (d1 = b - 1; d1 >= 0; d1--) {//
					if (Pattern.matches("[0-9\\.]",
							String.valueOf(m.charAt(d1))) == false) {
						a12 = m.substring(d1 + 1, b);//
						break;
					}
				}
				if(b+2<m.length())//
				{
					 a1 = String.valueOf(m.charAt(b + 1));//
				     a11 = String.valueOf(m.charAt(b + 2));//
				}
				if (Pattern.matches("[0-9]", a1)) {
					for (int a2 = b + 1; a2 <= m.length() - 1; a2++) { // b是根号的位置" + a4 + "
						String a3 = String.valueOf(m.charAt(a2));
						if (Pattern.matches("[0-9\\.]", a3) == false) {
							m=m.replace(m.indexOf("^"),m.indexOf("^")+1, "!");
							String a4 = m.substring(b + 1, a2);//
							//String a5 = a12 + "!" + a4;
							String a6 = "Math.pow((" + a12+"),(" + a4
									+ "))";
							m = m.replace(d1+1,a2, a6);
							break;
						}
					}
//					System.out.println(m);
				} else if (a1.equals("(")) {
					for (int b1 = b + 1; b1 <= m.length() - 1; b1++) {//
						String b5 = "";
						String b2 = String.valueOf(m.charAt(b1));
						if (b2.equals("(")) {
							b3++;
						}
						if (b2.equals(")")) {
							b4++;
						}
						if (b3 == b4) {
							m=m.replace(m.indexOf("^"),m.indexOf("^")+1, "!");
							b5 = m.substring(b + 1, b1 + 1);
						//	String b6 = a12 + "!" + b5;
							
							String b7 = "Math.pow((" + a12 + "),(" + b5
									+ "))";
							m = m.replace(d1+1,b1+1, b7);
							break;
						}
					}
//					System.out.println(m);				//a1.equals("s") || a1.equals("c")
															//|| a1.equals("t")
													//|| (a11.equals("s") && a1.equals("a"))
														//|| (a11.equals("c") && a1.equals("a"))
																///|| (a11.equals("t") && a1.equals("a"))
				} else if(a1.equals("s") 
						|| a1.equals("c")|| a1.equals("t")
						|| (a11.equals("s") && a1.equals("a"))
						|| (a11.equals("c") && a1.equals("a"))
						|| (a11.equals("t") && a1.equals("a"))
						||( a1.equals("l")&&a11.equals("g"))
						||( a1.equals("l")&&a11.equals("n"))) {
					for (int c1 = b + 1; c1 <= m.length() - 1; c1++) {//
						String c5 = "";
						String c2 = String.valueOf(m.charAt(c1));
						if (c2.equals("(")) {
							c3++;

						} 
						else if (c2.equals(")")) {
							c4++;

						}  if (c3 == c4 && c3 != 0) {
							m=m.replace(m.indexOf("^"),m.indexOf("^")+1, "!");
							c5 = m.substring(b + 1, c1+1);//
							//String c6 = a12 + "!" + c5;
							String c7 = "Math.pow((" + a12 + "),(" + c5
									+ "))";
							m = m.replace(d1+1,c1+1, c7);
							c3=c4=0;
							break;
						}
					}
	//				System.out.println(m);
				}
			}

			else if (c.equals(")")) {
				int d5=0;
				String a1 = "";
				String a11 = "";
				String d6 = "";
				for (int d1 = b - 1; d1 >= 0; d1--) {//

					String d2 = String.valueOf(m.charAt(d1));
					
					if (d2.equals("(")) {
						d3++;
						
					} else if (d2.equals(")")) {
						d4++;
						
					}  if (d3 == d4 && d3 != 0) {
						
						String d7 = String.valueOf(m.charAt(d1-1));
						if (Pattern.matches("[+\\-\\*\\/\\#\\(]", d7)) {
							d6 = m.substring(d1 , b);//
							d5+=2;
							break;
						} else if(Pattern.matches("[a-zA-Z]", d7)&&d7.equals("w")==false&&d7.equals("t")==false){
							for (d5 = d1-1; d5 >= 0; d5--) {

								
								if (Pattern.matches("[a-zA-Z]",String.valueOf(m.charAt(d5)))==false) {
										
									d6 = m.substring(d5+1, b);//
									//System.out.println(d6+"jjjj");
									
									break;
								}
							}
						
						
						}else {
							for (d5 = d1; d5 >= 0; d5--) {
								
								
								if (m.charAt(d5) == 'M') {

									d6 = m.substring(d5, b);//
	//								System.out.println(d6);
									break;
								}
							}
						}
						break;
					}
				}
if(a+2<m.length())//
{
	
				 a1 = String.valueOf(m.charAt(b + 1));//

				 a11 = String.valueOf(m.charAt(b + 2));//
				 }
				if (Pattern.matches("[0-9]", a1)) {
					for (int a2 = b + 1; a2 <= m.length() - 1; a2++) { // b是根号的位置//
						String a3 = String.valueOf(m.charAt(a2));
						if (Pattern.matches("[0-9\\.]", a3) == false) {
							m=m.replace(m.indexOf("^"),m.indexOf("^")+1, "!");
							String a4 = m.substring(b + 1, a2);//
		//					System.out.println(a4+"    a4");
							String a5 = d6 + "!" + a4;

							String a6 = "Math.pow((" + d6 + "),(" + a4
									+ "))";
						
							m = m.replace(d5,a2, a6);
						
							break;
						}
					}
	//				System.out.println(m);
				} else if (a1.equals("(")) {
					for (int b1 = b + 1; b1 <= m.length() - 1; b1++) {//
						String b5 = "";
						String b2 = String.valueOf(m.charAt(b1));
						if (b2.equals("(")) {
							b3++;
						}
						
						else if (b2.equals(")")) {
							b4++;
						}
						if (b3 == b4) {
							m=m.replace(m.indexOf("^"),m.indexOf("^")+1, "!");
							b5 = m.substring(b + 1, b1 + 1);//
							String b6 = d6 + "!" + b5;
							String b7 = "Math.pow((" + d6 + "),(" + b5
									+ "))";
							m = m.replace(d5,b1+1, b7);
							break;
						}
					}
	//				System.out.println(m);				//a1.equals("s") || a1.equals("c")
					                        			//|| a1.equals("t")
															//|| (a11.equals("s") && a1.equals("a"))
																			//|| (a11.equals("c") && a1.equals("a"))
															//|| (a11.equals("t") && a1.equals("a"))
				} else if (a1.equals("s") 
						|| a1.equals("c")|| a1.equals("t")
						|| (a11.equals("s") && a1.equals("a"))
						|| (a11.equals("c") && a1.equals("a"))
						|| (a11.equals("t") && a1.equals("a"))
						||( a1.equals("l")&&a11.equals("g"))
						||( a1.equals("l")&&a11.equals("n"))) {
					for (int c1 = b + 1; c1 <= m.length() - 1; c1++) {//
						String c5 = "";
						String c2 = String.valueOf(m.charAt(c1));
						if (c2.equals("(")) {
							c3++;

						}  else if (c2.equals(")")) {
							c4++;

						} 
						if (c3 == c4 && c3 != 0) {
							m=m.replace(m.indexOf("^"),m.indexOf("^")+1, "!");
							c5 = m.substring(b + 1, c1+1);//
							String c6 = d6 + "!" + c5;
							String c7 = "Math.pow((" + d6 + "),(" + c5
									+ "))";
							m = m.replace(d5,c1+1, c7);
							c3=c4=0;
							break;
						}
					}
					
	//				System.out.println(m);
				}

			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
//}
	
	for(int x = 0; x<=m.length()-1;x++){//解决sin（34+sin（3+3））这种情况
		
		System.out.println(m);
		String x6 = "";
		String x1 = "";
		String x4 = "";
		String x5 = "";
		
		x1 = String.valueOf(m.charAt(x));
				if(x1.equals("(")){
					x2=x+1;
				}
				else
				if(x1.equals(")")){
					x3=x;
					if(m.indexOf("(")==-1)
					{
						break;
					}
					x4 = m.substring(x2, x3);
					if(x4==""){break;}
					//System.out.println(x4);
					x6 = x4;
		//			System.out.println("x4-----"+x4);
					//System.out.println(x);
					//System.out.println(Pattern.matches("^[A-Za-z]+$", x4));
					//System.out.println(x4.contains(",")&&Pattern.matches("^[A-Za-z]+$", x4)==false);
				//	if(x4.contains(",")){
					
					//	continue;
					//}
					
					if(x4.contains("sin")&&x4.contains("asin")==false){
						String y2="";
						String y3="";
						x4=x4+"#";
						//System.out.println("hahahha"+x4);
							int y1 = x4.indexOf("n",x4.indexOf("i",0));
							for(int y=y1+1;y<=x4.length()-1;y++){
								//System.out.println(22222222);
								if((String.valueOf(x4.charAt(y)).equals("-"))&&y==y1+1){continue;}
								if(Pattern.matches("[0-9\\.]", String.valueOf(x4.charAt(y)))==false){
									y2 = x4.substring(y1+1, y);
									
									y3 = suan("Math.sin(0.017453292519943295*"+y2+")");
									y3 = suan("(Math.round("+y3+"*1000000000000000.0))/1000000000000000.0");
								//	System.out.println(y3);
									y3 = "("+y3+")";
				//					System.out.println(m.indexOf("s", x2)+"sssss");
				//					System.out.println(x2+y);
									m = m.replace(m.indexOf("s", x2),x2+y, y3);
									//x4 =x4.replace("#", "");
								
									
									 break;
								}
								continue;
						}//#4∧(3+sin(3+3))#
							x=0;
							continue;
					}
					else if(x4.contains("cos")&&x4.contains("acos")==false)
					{
						//System.out.println(35435+".............");
						String y2="";
					String y3="";
					
					x4=x4+"#";
						int y1 = x4.indexOf("s",0);
						for(int y=y1+1;y<=x4.length()-1;y++){
							if((String.valueOf(x4.charAt(y)).equals("-"))&&y==y1+1){continue;}
							if(Pattern.matches("[0-9\\.]", String.valueOf(x4.charAt(y)))==false){
								y2 = x4.substring(y1+1, y);
								//System.out.println(y2);
								
								y3 = suan("Math.cos(0.017453292519943295*"+y2+")");
								y3 = suan("(Math.round("+y3+"*1000000000000000.0))/1000000000000000.0");
								
								//System.out.println(y3);
								y3 = "("+y3+")";
								m = m.replace(m.indexOf("c", x2),x2+y, y3);
								//System.out.println(m);
								//x4 =x4.replace("#", "");
								
								
								 break;
							}
							continue;
					}
						x=0;
						continue;
						}
					else if(x4.contains("tan")&&x4.contains("atan")==false){
						String y2="";
						String y3="";
						
						x4=x4+"#";
							int y1 = x4.indexOf("n",x4.indexOf("t",0));
							for(int y=y1+1;y<=x4.length()-1;y++){
								if((String.valueOf(x4.charAt(y)).equals("-"))&&y==y1+1){continue;}
								if(Pattern.matches("[0-9\\.]", String.valueOf(x4.charAt(y)))==false){
									y2 = x4.substring(y1+1, y);
									y3 = suan("Math.tan(0.017453292519943295*"+y2+")");
									y3 = suan("(Math.round("+y3+"*1000000000000000.0))/1000000000000000.0");
									//if(y3.equals("9223.372036854777"))
									//	y3="1.633123935319537E16";
									y3 = "("+y3+")";
									m = m.replace(m.indexOf("t", x2),x2+y, y3);
									//x4 =x4.replace("#", "");
									
									
									 break;
								}
								continue;
						}
							x=0;
							continue;
					}
					else if(x4.contains("asin")){
						String y2="";
						String y3="";
						
						x4=x4+"#";
						
						int y1=  x4.indexOf("n",x4.indexOf("a",0));
							for(int y=y1+1;y<=x4.length()-1;y++){
								if((String.valueOf(x4.charAt(y)).equals("-"))&&y==y1+1){continue;}
								if(Pattern.matches("[0-9\\.]", String.valueOf(x4.charAt(y)))==false){
									y2 = x4.substring(y1+1, y);
									y3 = suan("Math.asin("+y2+")");
									y3 = suan("Math.toDegrees("+y3+")");
									y3 = suan("(Math.round("+y3+"*1000000000000000.0))/1000000000000000.0");
									y3 = "("+y3+")";
									m = m.replace(m.indexOf("a", x2),x2+y, y3);
									//x4 =x4.replace("#", "");
									
									
									 break;
								}
								continue;
						}
							x=0;
							continue;
					}
					else if(x4.contains("acos")){
						String y2="";
						String y3="";
						//System.out.println("x4---"+x4);
						x4=x4+"#";
							int y1 = x4.indexOf("s",x4.indexOf("a",0));
							for(int y=y1+1;y<=x4.length()-1;y++){
								if((String.valueOf(x4.charAt(y)).equals("-"))&&y==y1+1){continue;}
								if(Pattern.matches("[0-9\\.]", String.valueOf(x4.charAt(y)))==false){
									y2 = x4.substring(y1+1, y);
									//System.out.println(y2);
									
									y3 = suan("Math.acos("+y2+")");
									y3 = suan("Math.toDegrees("+y3+")");
									y3 = suan("(Math.round("+y3+"*1000000000000000.0))/1000000000000000.0");
								//	System.out.println(y3);
									y3 = "("+y3+")";
									
									m = m.replace(m.indexOf("a", x2),x2+y, y3);
									//x4 =x4.replace("#", "");
									
									
									 break;
								}
								continue;
						
							}
							x=0;
							continue;
					}
					else if(x4.contains("atan")){
						String y2="";
						String y3="";
						
						x4=x4+"#";
							int y1 = x4.indexOf("n",x4.indexOf("a",0));
							for(int y=y1+1;y<=x4.length()-1;y++){
								if((String.valueOf(x4.charAt(y)).equals("-"))&&y==y1+1){continue;}
								if((Pattern.matches("[0-9\\.]", String.valueOf(x4.charAt(y)))==false)){
									
									y2 = x4.substring(y1+1, y);
									y3 = suan("Math.atan("+y2+")");
									y3 = suan("Math.toDegrees("+y3+")");
									y3 = suan("(Math.round("+y3+"*1000000000000000.0))/1000000000000000.0");
									y3 = "("+y3+")";
								
									m = m.replace(m.indexOf("a", x2),x2+y, y3);
									//x4 =x4.replace("#", "");
									
									
									 break;
								}
								continue;
						}
							x=0;
							continue;
							}
							else if(x4.contains("ln")){
								String y2="";
								String y3="";
								
								x4=x4+"#";
									int y1 = x4.indexOf("n",x4.indexOf("l",0));
									for(int y=y1+1;y<=x4.length()-1;y++){
										if(Pattern.matches("[0-9\\.]", String.valueOf(x4.charAt(y)))==false){
											y2 = x4.substring(y1+1, y);
											y3 = suan("Math.log("+y2+")");
											
											//y3 = suan("(Math.round("+y3+"*1000000000000000.0))/1000000000000000.0");
											y3 = "("+y3+")";
											
											m = m.replace(m.indexOf("l", x2),x2+y, y3);
											//x4 =x4.replace("#", "");
											
											
											 break;
										}
										continue;
								}
									x=0;
									continue;
						
					}
							else if(x4.contains("lg")){
								String y2="";
								String y3="";
								
								x4=x4+"#";
									int y1 = x4.indexOf("g",0);
									for(int y=y1+1;y<=x4.length()-1;y++){
										if(Pattern.matches("[0-9\\.]", String.valueOf(x4.charAt(y)))==false){
											y2 = x4.substring(y1+1, y);
											y3 = suan("Math.log10("+y2+")");
											//y3 = suan("(Math.round("+y3+"*1000000000000000.0))/1000000000000000.0");
											y3 = "("+y3+")";
											m = m.replace(m.indexOf("l", x2),x2+y, y3);
											//x4 =x4.replace("#", "");
											
											
											 break;
										}
										continue;
								}
									x=0;
									continue;
						
					}
							else if(x4.contains(",")){
						//System.out.println(x4+"------->x4");
						//System.out.println(m.charAt(x2-1));
						//System.out.println(m.charAt(x3));
						//m=Cifan.replacePos(m, x2, "@");
					//System.out.println(m);
					//m=Cifan.replacePos(m, x3+1, "!");
					//System.out.println(m);
						for(int w=x2-1;x2>=1;x2--){
							String w2 ="";
							String w3="";
							String w4= "";
							
							String w1 = String.valueOf(m.charAt(x2-1));
							
							if(w1.equals("M")){
								w2 = m.substring(x2-1, x3+1);
								//																  25.00000000000001
								//w4=w2.replace("!", ")");										    100000000000000
								//w4=w4.replace("@", "(");										  25.000000000000004
							//	System.out.println(w2+"------->w2");            2.2360679775      25.00000000001
								w3 = suan(w2);              //000000000000004   2.23606797749979  25.0000000000094
								//	
								
								try
								{BigDecimal bd = new BigDecimal(w3); 
								w3=bd.toPlainString();}
								catch(Exception e)
								{
									return " ";
								}
								//System.out.println(w3+"--------w3");
								//if(suan1("Math.abs("+w3+"-Math.rint("+w3+"))")<0.0000000000001){
									//if(w3.contains(".00000000")||w3.contains(".99999999")){
									//	w3 = Cifan.round(w3,0,BigDecimal.ROUND_HALF_UP);
								//	}
								//w3 = Cifan.round(w3,12,BigDecimal.ROUND_HALF_UP);
								//}
								//System.out.println(w3+"--------->w3");
								if(w3.contains(".")==false){
									w3=w3+".0";
								}
							//	System.out.println(w3+"------->w3");
								//System.out.println("w2[[[[["+w2);
								m = m.replace(x2-1,x3+1, w3);
								//System.out.println(m+"------->m");
								x6="";
								break;
							}
						}
						
						
					}
					 
					if(x6.contains("+-")||x6.contains("*-")||x6.contains("/-")||x6.contains("--")){//解决-+等情况
						x6 = x6+"#";
						
						for(int z = 0 ;z<=x6.length()-1;z++){
							int z1 = x6.indexOf("-",z);
							if(z1==-1){break;}
							if(z1==0){x6="0"+x6;
							z1=1;}
							if(Pattern.matches("[+\\-\\*\\/]", String.valueOf(x6.charAt(z1-1)))){
								for(int z2 = z1+1;z2<=x6.length()-1;z2++){
									if(Pattern.matches("[0-9\\.]", String.valueOf(x6.charAt(z2)))==false){
										x6=x6.replace(x6.substring(z1, z2)+"#", "("+x6.substring(z1, z2)+")");
										break;
									}
								}
							}
						}
					}
					
					if(x6!=""&&x6!="NaN"){
	//					System.out.println(x6+"------->x6");
					x5 = you.evaluateExpression(x6);
				//	if(x5.contains(".00000000")||x5.contains(".99999999")){
					//	
				//	}
					
	//				System.out.println(x5+"------->x5");
					
	//				System.out.println(x5+"------->x5");
					//try
					//{BigDecimal bd = new BigDecimal(x5); 
					///x5=bd.toPlainString();}
					//catch(Exception e)
					//{
					//	return "cuowu11";
					//}
					if(x5.contains(".")==false){
						x5=x5+".0";
					}
					//System.out.println(x5+"------->x5");
					
					m = m.replace(x2-1,x3+1,x5);
	//				System.out.println(m);
					}
					x=0;
				}
				
	}
	try
	{
		
		m2=m.toString();
		m2=m2.substring(1, m2.length()-1);
	int dian=m2.substring(0, m2.indexOf(".")).length();
	m2 = Cigen.round(m2,15-dian,BigDecimal.ROUND_HALF_UP);
	//System.out.println(suan("Math.sin(6)"));
	BigDecimal bd = new BigDecimal(m2); 
	m2=bd.toPlainString();}
	catch(Exception e)
	{
		return " ";
	}
	
	return m2;
	
	
}
public static String suan(String s) {
	Interpreter bsh = new Interpreter();
	Number s1 = null;
	try {
		s1 = (Number) bsh.eval(s);
		return s1.doubleValue() + "";
	} catch (EvalError e) {
		//e.printStackTrace();
		return " ";
	}
	
}

public static double suan1(String s) {
	Interpreter bsh = new Interpreter();
	Number s1 = null;
	try {
		s1 = (Number) bsh.eval(s);
		return s1.doubleValue();
	} catch (EvalError e) {
		e.printStackTrace();
	}
	return 0;
}
/*public static String  replacePos(String strObj, int pos, String replacetext) 
{ 
   String str = strObj.substring(0, pos-1) + replacetext + strObj.substring(pos, strObj.length()); 
   return str; 
}
*/

public static String round(String v, int scale ,int roundingMode) {
try{
BigDecimal b = new BigDecimal(v);
b= b.setScale(scale, roundingMode);
       double d=b.doubleValue();
       
       return b.doubleValue()+"";}
catch(Exception e)
{
	return " ";
			}
}
}
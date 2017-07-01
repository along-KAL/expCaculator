package com.example.module.calculate.utils;

import java.util.regex.Pattern;

public class Genhao {
	public static String genHao(String m1, int b) {
		StringBuilder m= new StringBuilder(m1);
		
		int b3 = 0;
		int b4 = 0;
		int c3 = 0;
		int c4 = 0;
		int d3 = 0;
		int d4 = 0;
		//String m = "#4545√(3√sin(3+3))#";
		//for (int a = 0; a <= m.length() - 1; a++) {
			//int b = m.indexOf("√", a);
			//if (b == -1) {
			//	break;
			//} else {
				String c = String.valueOf(m.charAt(b - 1));
				
				if (c.equals("+") || c.equals("-") || c.equals("*")
						|| c.equals("/") || c.equals("(") || c.equals("#"))// 前面一个的可能
				{
					
					String a1 = String.valueOf(m.charAt(b + 1));
					String a11 = String.valueOf(m.charAt(b + 2));
					if (Pattern.matches("[0-9]", a1)) {
						for (int a2 = b + 1; a2 <= m.length() - 1; a2++) { // b是根号的位置
							String a3 = String.valueOf(m.charAt(a2));
							if (Pattern.matches("[0-9\\.]", a3) == false) {
								m=m.replace(m.indexOf("√"),m.indexOf("√")+1, "!");
								String a4 = m.substring(b + 1, a2);
								String a5 = "!" + a4;
								String a6 = "Math.pow((" + a4 + "),1.0/2)";
								m = m.replace(b,a2, a6);
								break;
							}
						}
//						System.out.println(m);
				} else if (a1.equals("(")) {
						for (int b1 = b + 1; b1 <= m.length() - 1; b1++) {
							String b5 = "";
							String b2 = String.valueOf(m.charAt(b1));
							if (b2.equals("(")) {
								b3++;
							}
							else if (b2.equals(")")) {
								b4++;
							}
							if (b3 == b4) {
								m=m.replace(m.indexOf("√"),m.indexOf("√")+1, "!");
								b5 = m.substring(b + 1, b1 + 1);
								String b6 = "!" + b5;
								String b7 = "Math.pow((" + b5 + "),1.0/2)";
								m = m.replace(b,b1+1, b7);
								break;
							}
						}
	//					System.out.println(m);
					} else if (a1.equals("s") 
							|| a1.equals("c")|| a1.equals("t")
							|| (a11.equals("s") && a1.equals("a"))
							|| (a11.equals("c") && a1.equals("a"))
							|| (a11.equals("t") && a1.equals("a"))
							||( a1.equals("l")&&a11.equals("g"))
							||( a1.equals("l")&&a11.equals("n"))) {
						for (int c1 = b + 1; c1 <= m.length() - 1; c1++) {
							String c5 = "";
							String c2 = String.valueOf(m.charAt(c1));
							if (c2.equals("(")) {
								c3++;
								// System.out.println(c3);
							} else if (c2.equals(")")) {
								c4++;
								// System.out.println(c4);
							} 
							if (c3 == c4 && c3 != 0) {
								m=m.replace(m.indexOf("√"),m.indexOf("√")+1, "!");
								c5 = m.substring(b + 1, c1+1);
								String c6 = "!" + c5;
								String c7 = "Math.pow((" + c5 + "),1.0/2)";
								m = m.replace(b,c1+1, c7);
								c3=c4=0;
								break;
							}
						}
//						System.out.println(m);
					}
				}

				else if (Pattern.matches("[0-9]", c)) {
					int d1=0;
					String a1 = "";
					String a11 = "";
					String a12 = "";
					for (d1 = b - 1; d1 >= 0; d1--) {
						if (Pattern.matches("[0-9\\.]",
								String.valueOf(m.charAt(d1))) == false) {
							a12 = m.substring(d1 + 1, b);
							
							break;
						}
					}
					if(b+2<m.length())
					{
						
									 a1 = String.valueOf(m.charAt(b + 1));

									 a11 = String.valueOf(m.charAt(b + 2));
									 }
					if (Pattern.matches("[0-9]", a1)) {
						for (int a2 = b + 1; a2 <= m.length() - 1; a2++) { // b是根号的位置
							String a3 = String.valueOf(m.charAt(a2));
							if (Pattern.matches("[0-9\\.]", a3) == false) {
								m=m.replace(m.indexOf("√"),m.indexOf("√")+1, "!");
								String a4 = m.substring(b + 1, a2);
								String a5 = a12 + "!" + a4;
								String a6 = "Math.pow((" + a4 + "),(1.0/" + a12
										+ "))";
								m = m.replace(d1+1,a2, a6);
								break;
							}
						}
	//					System.out.println(m);
						
					} else if (a1.equals("(")) {
						
						for (int b1 = b + 1; b1 <= m.length() - 1; b1++) {
							String b5 = "";
							String b2 = String.valueOf(m.charAt(b1));
						
							if (b2.equals("(")) {
								b3++;
								
							}
							else if (b2.equals(")")) {
								
								b4++;
								
							}
							if (b3 == b4) {
								m=m.replace(m.indexOf("√"),m.indexOf("√")+1, "!");
								b5 = m.substring(b + 1, b1 + 1);
								String b6 = a12 + "!" + b5;
								String b7 = "Math.pow((" + b5 + "),(1.0/" + a12
										+ "))";
								
								m = m.replace(d1+1,b1+1, b7);
								break;
							}
						}
//						System.out.println(m);
					} else if (a1.equals("s") 
							|| a1.equals("c")|| a1.equals("t")
							|| (a11.equals("s") && a1.equals("a"))
							|| (a11.equals("c") && a1.equals("a"))
							|| (a11.equals("t") && a1.equals("a"))
							||( a1.equals("l")&&a11.equals("g"))
							||( a1.equals("l")&&a11.equals("n"))) {
						
						for (int c1 = b + 1; c1 <= m.length() - 1; c1++) {
							String c5 = "";
							
							String c2 = String.valueOf(m.charAt(c1));
							if (c2.equals("(")) {
								c3++;

							} else if (c2.equals(")")) {
								c4++;

							} 
							if (c3 == c4 && c3 != 0) {
								c5 = m.substring(b + 1, c1+1);
								m=m.replace(m.indexOf("√"),m.indexOf("√")+1, "!");
								String c6 = a12 + "!" + c5;
								String c7 = "Math.pow((" + c5 + "),(1.0/" + a12
										+ "))";
								m = m.replace(d1+1,c1+1, c7);
								c3=c4=0;
								break;
							}
						}
//						System.out.println(m);
					}
				}

				else if (c.equals(")")) {
					int d5=0;
					String a1 = "";
					String a11 = "";
					String d6 = "";
					for (int d1 = b - 1; d1 >= 0; d1--) {

						String d2 = String.valueOf(m.charAt(d1));
						if (d2.equals("(")) {
							d3++;
						} else if (d2.equals(")")) {
							d4++;
						} 
						if (d3 == d4 && d3 != 0) {
							String d7 = String.valueOf(m.charAt(d1-1));
						
							if (Pattern.matches("[+\\-\\*\\/\\#\\(]", d7)) {
								
								d6 = m.substring(d1 , b);
								d5+=2;
								break;
							} 
							 else if(Pattern.matches("[a-zA-Z]", d7)&&d7.equals("w")==false&&d7.equals("t")==false){
									for (d5 = d1-1; d5 >= 0; d5--) {

										
										if (Pattern.matches("[a-zA-Z]",String.valueOf(m.charAt(d5)))==false) {
												
											d6 = m.substring(d5+1, b);//
										//	System.out.println(d6+"jjjj");
											d5++;
											break;
										}
									}
								
								
								}else {
								for (d5 = d1; d5 >= 0; d5--) {

									if (m.charAt(d5) == 'M') {

										d6 = m.substring(d5, b);

										break;
									}
								}
							}
							break;
						}
					}

					if(b+2<m.length())
					{
						
									 a1 = String.valueOf(m.charAt(b + 1));

									 a11 = String.valueOf(m.charAt(b + 2));
									 }
					if (Pattern.matches("[0-9]", a1)) {
						for (int a2 = b + 1; a2 <= m.length() - 1; a2++) { // b是根号的位置
							String a3 = String.valueOf(m.charAt(a2));
							if (Pattern.matches("[0-9\\.]", a3) == false) {
								m=m.replace(m.indexOf("√"),m.indexOf("√")+1, "!");
								String a4 = m.substring(b + 1, a2);
								String a5 = d6 + "!" + a4;

								String a6 = "Math.pow((" + a4 + "),(1.0/" + d6
										+ "))";
								m = m.replace(d5,a2, a6);
								break;
							}
						}
	//					System.out.println(m);
					} else if (a1.equals("(")) {
						for (int b1 = b + 1; b1 <= m.length() - 1; b1++) {
							String b5 = "";
							String b2 = String.valueOf(m.charAt(b1));
							if (b2.equals("(")) {
								b3++;
							}
							else if (b2.equals(")")) {
								b4++;
							}
							if (b3 == b4) {
								m=m.replace(m.indexOf("√"),m.indexOf("√")+1, "!");
								b5 = m.substring(b + 1, b1 + 1);
								String b6 = d6 + "!" + b5;
								String b7 = "Math.pow((" + b5 + "),(1.0/" + d6
										+ "))";
								m = m.replace(d5,b1+1, b7);
								break;
							}
						}
//						System.out.println(m);
					} else if (a1.equals("s") 
							|| a1.equals("c")|| a1.equals("t")
							|| (a11.equals("s") && a1.equals("a"))
							|| (a11.equals("c") && a1.equals("a"))
							|| (a11.equals("t") && a1.equals("a"))
							||( a1.equals("l")&&a11.equals("g"))
							||( a1.equals("l")&&a11.equals("n"))) {
						for (int c1 = b + 1; c1 <= m.length() - 1; c1++) {
							String c5 = "";
							String c2 = String.valueOf(m.charAt(c1));
							if (c2.equals("(")) {
								c3++;

							} else if (c2.equals(")")) {
								c4++;

							} 
							if (c3 == c4 && c3 != 0) {
								m=m.replace(m.indexOf("√"),m.indexOf("√")+1, "!");
								c5 = m.substring(b + 1, c1+1);
								String c6 = d6 + "!" + c5;
								String c7 = "Math.pow((" + c5 + "),(1.0/" + d6
										+ "))";
								m = m.replace(d5,c1+1, c7);
								c3=c4=0;
								break;
							}
						}
//						System.out.println(m);
					}

				}
			//}
	//	}
		return m.toString();

		

	}

	/*public static String genhao(String s1, String s2) {
		String s3 = "Math.pow(10, Math.log10(" + s2 + ")*(1.0/" + s1 + "))";
		Interpreter bsh = new Interpreter();
		Number s4 = null;
		try {
			s4 = (Number) bsh.eval(s3);
			return s4.doubleValue() + "";
		} catch (EvalError e) {
			e.printStackTrace();
		}
		return "";
	}*/

}

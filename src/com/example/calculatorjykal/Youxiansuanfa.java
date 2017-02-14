package com.example.calculatorjykal;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.regex.Pattern;
public class Youxiansuanfa {

public String evaluateExpression(String ex){    
	 // 在表达式首尾加上字符'#'以方便比较运算符    
	 StringBuffer exB = new StringBuffer(ex);   
	// System.out.println(exB);
	 exB.insert(0,'#');    
	 exB.append('#');  
	 ex = exB.toString();  //
	// System.out.println(ex);
	 StringBuffer operandBuffer = new StringBuffer(); // 运算数的字符缓冲区    
	 java.util.LinkedList<BigDecimal> operandList = new LinkedList<BigDecimal>();    
	 java.util.LinkedList<String> operatorList = new LinkedList<String>();    
	 int count = 1; // 从ex的序号为1开始，即‘#’后
	  int num=0;
	 operatorList.addLast("#");
	 																//System.out.println(ex);//表达式
	 while(count < ex.length()){
	  String ch = String.valueOf(ex.charAt(count));  
	  																	//System.out.println(ch);//单个字符
	  if(Pattern.matches("[0-9\\.]",ch) // 当前字符如果是数字或.就把它放到运算数缓冲区operandBuffer    
	  ||(ch.equals("-")  // "-"看成是负号的条件：在表达式的首位或在”（“之后；    
	  &&(count ==1 || ex.charAt(count-1) == '('))||(ch.equals("+")&&(count ==1 || ex.charAt(count-1) == '('))){     
	   operandBuffer.append(ch); 
	    															  //System.out.println(operandBuffer);
	  //System.out.println(ch+"属于运算数："); // 调试用    
	   ++count;
	  }    
	  else{    
	    // 把运算数放入栈    
	   if(Pattern.matches("[\\+\\-\\*\\/\\)\\#]",ch) && operandBuffer.length() != 0){    
		  try{
	    operandList.addLast(new BigDecimal(Double.valueOf(operandBuffer.toString()).toString()));    }catch(Exception e){
	    	return "!!";
	    }
	    															//System.out.println(operandList);
	   // System.out.println("序号"+(++num)+"："+operandBuffer.toString()); // 调试用    
	   //  System.out.println("");    
	    operandBuffer.delete(0,operandBuffer.length());  
	   }    
	  // System.out.println(ch+"属于运算符："); // 调试用    
	   //System.out.println("");    
	   // 比较运算符，并根据它进行计算    
	   							//System.out.println(ch);								//  System.out.println(operatorList);
	   switch(compareOperator(operatorList.getLast(),ch)){    
	    // ch优先级高，将ch压入运算符栈    
	    case '<' :  
	     operatorList.addLast(ch);    
	     ++count;    
	     break;    
	    // 优先级相等时，去掉（）或前后的#；    
	    case '=' :  
	     operatorList.removeLast();    
	     ++count;    
	     break;    
	    // ch优先级低，从运算数栈取出两个数，从运算符栈取出运算符，进行计算其结果放入运算数栈；    
	    case '>' :
	     BigDecimal    a; 
	     BigDecimal     b;
	     String curOperator = operatorList.removeLast();    
	     try{    
	    	 b = operandList.removeLast();
	    	 a = operandList.removeLast();
	      operandList.addLast(operate(a,curOperator,b));    
	     }catch(ArithmeticException e){    
	      return "!!"; 
	     }  catch(Exception e){
	    	 return "!!";
	     }  
	     break;    
	    // 运算符输入错误的处理：终止计算，在屏幕显示input error!    
	    default :    
	     return "!!";    
	   }    
	  }    
	 }
	 //End 0f while    
	// for(BigDecimal e : operandList)  // 调试用    
	  //System.out.println(e.toString());
	 try{
		 BigDecimal bd = new BigDecimal(operandList.getLast().toString()); 
	 return bd.toPlainString();
	 
	 }catch(Exception e){
		 return "!!";
	 }   
	}    
	/** 比较前后运算符的优先级 */    
	public char compareOperator(String operator1,String operator2){    
	 char result = 0; // 局部内部类的实例方法的局部变量能自动初始化为'/u0000'吗？不得行！！！    
	 char o1 = operator1.charAt(0);    
	 char o2 = operator2.charAt(0);    
	 switch(o1){    
	  case '+':    
	   switch(o2){    
	    case '+':    
	     result = '>';    
	     break;    
	    case '-':    
	     result = '>';    
	     break;    
	    case '*':    
	     result = '<';    
	     break;    
	    case '/':    
	     result = '<';    
	     break;    
	    case '(':    
	     result = '<';    
	     break;    
	    case ')':    
	     result = '>';    
	     break;    
	    case '#':    
	     result = '>';    
	     break;    
	   }    
	   break; // 跳出case '+';    
	  case '-':    
	   switch(o2){    
	    case '+':    
	     result = '>';    
	     break;    
	    case '-':    
	     result = '>';    
	     break;    
	    case '*':    
	     result = '<';    
	     break;    
	    case '/':    
	     result = '<';    
	     break;    
	    case '(':    
	     result = '<';    
	     break;    
	    case ')':    
	     result = '>';    
	     break;    
	    case '#':    
	     result = '>';    
	     break;    
	   }    
	   break; // 跳出case '-';    
	  case '*':    
	   switch(o2){    
	    case '+':    
	     result = '>';    
	     break;    
	    case '-':    
	     result = '>';    
	     break;    
	    case '*':    
	     result = '>';    
	     break;    
	    case '/':    
	     result = '>';    
	     break;    
	    case '(':    
	     result = '<';    
	     break;    
	    case ')':    
	     result = '>';    
	     break;    
	    case '#':    
	     result = '>';    
	     break;    
	   }    
	   break; // 跳出case '*';    
	  case '/':    
	   switch(o2){    
	    case '+':    
	     result = '>';    
	     break;    
	    case '-':    
	     result = '>';    
	     break;    
	    case '*':    
	     result = '>';    
	     break;    
	    case '/':    
	     result = '>';    
	     break;    
	    case '(':    
	     result = '<';    
	     break;    
	    case ')':    
	     result = '>';    
	     break;    
	    case '#':    
	     result = '>';    
	     break;    
	   }    
	   break; // 跳出case '/';    
	  case '(':    
	   switch(o2){    
	    case '+':    
	     result = '<';    
	     break;    
	    case '-':    
	     result = '<';    
	     break;    
	    case '*':    
	     result = '<';    
	     break;    
	    case '/':    
	     result = '<';    
	     break;    
	    case '(':    
	     result = '<';    
	     break;    
	    case ')':    
	     result = '=';    
	     break;    
	    case '#':    
	     result = '?'; // （后不能是#，如果是则是错误输入；    
	     break;    
	   }    
	   break; // 跳出case '(';    
	  case ')':    
	   switch(o2){    
	    case '+':    
	     result = '>';    
	     break;    
	    case '-':    
	     result = '>';    
	     break;    
	    case '*':    
	     result = '>';    
	     break;    
	    case '/':    
	     result = '>';    
	     break;    
	    case '(':    
	     result = '?'; // )后不能接（；    
	     break;    
	    case ')':    
	     result = '>';    
	     break;    
	    case '#':    
	     result = '>';    
	     break;    
	   }    
	   break; // 跳出case ')';    
	  case '#':    
	   switch(o2){    
	    case '+':    
	     result = '<';    
	     break;    
	    case '-':    
	     result = '<';    
	     break;    
	    case '*':    
	     result = '<';    
	     break;    
	    case '/':    
	     result = '<';    
	     break;    
	    case '(':    
	     result = '<';    
	     break;    
	    case ')':    
	     result = '?'; // #后不能接）；    
	     break;    
	    case '#':    
	     result = '=';    
	     break;    
	   }    
	   break; // 跳出case '#';.    
	 }// End Of switch    
	     
	 return result;         
	}    
	    
	/** 根据运算符进行二元计算，  
	* @param  
	*  BigDecimal类型 a ? b  
	* @return：  
	*  BigDecimal类型的结果  
	*/    
	public BigDecimal operate(BigDecimal a,String operator,BigDecimal b){    
	  final int DEF_DIV_SCALE = 20;    
	  BigDecimal result = null;    
	     
	 switch(operator.charAt(0)){    
	  case '+':  
	  //  System.out.println("+");
	   result = a.add(b); 
	   break;    
	  case '-':  
	   result = a.subtract(b);   
	//   System.out.println("-");
	   break;    
	  case '*':    
	   result = a.multiply(b);    
	 //  System.out.println("*");
	   break;    
	  case '/':    
	   result = a.divide(b,DEF_DIV_SCALE,BigDecimal.ROUND_HALF_UP);    
	 //  System.out.println("/");
	   break;    
	 }    
	 return result;    
	}   
	}
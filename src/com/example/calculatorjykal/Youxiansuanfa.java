package com.example.calculatorjykal;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.regex.Pattern;
public class Youxiansuanfa {

public String evaluateExpression(String ex){    
	 // �ڱ��ʽ��β�����ַ�'#'�Է���Ƚ������    
	 StringBuffer exB = new StringBuffer(ex);   
	// System.out.println(exB);
	 exB.insert(0,'#');    
	 exB.append('#');  
	 ex = exB.toString();  //
	// System.out.println(ex);
	 StringBuffer operandBuffer = new StringBuffer(); // ���������ַ�������    
	 java.util.LinkedList<BigDecimal> operandList = new LinkedList<BigDecimal>();    
	 java.util.LinkedList<String> operatorList = new LinkedList<String>();    
	 int count = 1; // ��ex�����Ϊ1��ʼ������#����
	  int num=0;
	 operatorList.addLast("#");
	 																//System.out.println(ex);//���ʽ
	 while(count < ex.length()){
	  String ch = String.valueOf(ex.charAt(count));  
	  																	//System.out.println(ch);//�����ַ�
	  if(Pattern.matches("[0-9\\.]",ch) // ��ǰ�ַ���������ֻ�.�Ͱ����ŵ�������������operandBuffer    
	  ||(ch.equals("-")  // "-"�����Ǹ��ŵ��������ڱ��ʽ����λ���ڡ�����֮��    
	  &&(count ==1 || ex.charAt(count-1) == '('))||(ch.equals("+")&&(count ==1 || ex.charAt(count-1) == '('))){     
	   operandBuffer.append(ch); 
	    															  //System.out.println(operandBuffer);
	  //System.out.println(ch+"������������"); // ������    
	   ++count;
	  }    
	  else{    
	    // ������������ջ    
	   if(Pattern.matches("[\\+\\-\\*\\/\\)\\#]",ch) && operandBuffer.length() != 0){    
		  try{
	    operandList.addLast(new BigDecimal(Double.valueOf(operandBuffer.toString()).toString()));    }catch(Exception e){
	    	return "!!";
	    }
	    															//System.out.println(operandList);
	   // System.out.println("���"+(++num)+"��"+operandBuffer.toString()); // ������    
	   //  System.out.println("");    
	    operandBuffer.delete(0,operandBuffer.length());  
	   }    
	  // System.out.println(ch+"�����������"); // ������    
	   //System.out.println("");    
	   // �Ƚ�������������������м���    
	   							//System.out.println(ch);								//  System.out.println(operatorList);
	   switch(compareOperator(operatorList.getLast(),ch)){    
	    // ch���ȼ��ߣ���chѹ�������ջ    
	    case '<' :  
	     operatorList.addLast(ch);    
	     ++count;    
	     break;    
	    // ���ȼ����ʱ��ȥ��������ǰ���#��    
	    case '=' :  
	     operatorList.removeLast();    
	     ++count;    
	     break;    
	    // ch���ȼ��ͣ���������ջȡ�����������������ջȡ������������м�����������������ջ��    
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
	    // ������������Ĵ�����ֹ���㣬����Ļ��ʾinput error!    
	    default :    
	     return "!!";    
	   }    
	  }    
	 }
	 //End 0f while    
	// for(BigDecimal e : operandList)  // ������    
	  //System.out.println(e.toString());
	 try{
		 BigDecimal bd = new BigDecimal(operandList.getLast().toString()); 
	 return bd.toPlainString();
	 
	 }catch(Exception e){
		 return "!!";
	 }   
	}    
	/** �Ƚ�ǰ������������ȼ� */    
	public char compareOperator(String operator1,String operator2){    
	 char result = 0; // �ֲ��ڲ����ʵ�������ľֲ��������Զ���ʼ��Ϊ'/u0000'�𣿲����У�����    
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
	   break; // ����case '+';    
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
	   break; // ����case '-';    
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
	   break; // ����case '*';    
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
	   break; // ����case '/';    
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
	     result = '?'; // ��������#����������Ǵ������룻    
	     break;    
	   }    
	   break; // ����case '(';    
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
	     result = '?'; // )���ܽӣ���    
	     break;    
	    case ')':    
	     result = '>';    
	     break;    
	    case '#':    
	     result = '>';    
	     break;    
	   }    
	   break; // ����case ')';    
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
	     result = '?'; // #���ܽӣ���    
	     break;    
	    case '#':    
	     result = '=';    
	     break;    
	   }    
	   break; // ����case '#';.    
	 }// End Of switch    
	     
	 return result;         
	}    
	    
	/** ������������ж�Ԫ���㣬  
	* @param  
	*  BigDecimal���� a ? b  
	* @return��  
	*  BigDecimal���͵Ľ��  
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
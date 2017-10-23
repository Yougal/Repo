package com.yougal.stack;

import java.math.BigDecimal;

/**
 * 
 * 
 * Why postfix representation of the expression?
 * The compiler scans the expression either from left to right or from right to left.
 * Consider the below expression: a op1 b op2 c op3 d
 * If op1 = +, op2 = *, op3 = +
 * The compiler first scans the expression to evaluate the expression b * c, 
 * then again scan the expression to add a to it. The result is then added to d after another scan.
 * The repeated scanning makes it very in-efficient. It is better to convert the expression 
 * to postfix(or prefix) form before evaluation.
 * The corresponding expression in postfix form is: abc*d++. 
 * 
 * @author yougal.bisht
 *
 */

public class InfixToPostfix {

	enum Operator{
		POWER("^", 5),
		DIV("/", 4),
		MULTI("*", 3),
		ADD("+", 2),
		SUB("-", 1),
		OPEN_PARENTHESIS("(",0),
		CLOSE_PARENTHESIS(")",0);
		Operator(String symbol, int priority){
			this.symbol=symbol;
			this.priority=priority;
		}
		String symbol;
		int priority;
		
		public static boolean isOperator(String symbol){
			for (Operator operator : Operator.values()) {
				if(operator.symbol.equals(symbol)){
					return true;
				}
			}
			return false;
		}
		
		public Number performOperation(Number a, Number b){
			
			switch (this) {
			case ADD: return new BigDecimal(a.toString()).add(new BigDecimal(b.toString()));

			case MULTI: return new BigDecimal(a.toString()).multiply(new BigDecimal(b.toString()));
				
			case DIV: return new BigDecimal(a.toString()).divide(new BigDecimal(b.toString()));
				
			case POWER: return new BigDecimal(a.toString()).pow(b.intValue());
				
			case SUB: return new BigDecimal(a.toString()).subtract(new BigDecimal(b.toString()));
			default:
				return null;
			}
		}
		
		public static Operator findOperator(String symbol){
			for (Operator operator : Operator.values()) {
				if(operator.symbol.equals(symbol)){
					return operator;
				}
			}
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		String expression = new String("a+b*((c^d)-e)^((f+g)*h)-i");
		/**
		 * abc*d++ 
		 * 
		 * 
		 * 
		 */
		
		String postfix = convertToPostFix(expression);
		System.out.println(postfix);
	}

	public static String convertToPostFix(String expression) {
		Stack<String> operandStk = new Stack<String>(expression.length());
		Stack<Operator> operatorStk = new Stack<Operator>(expression.length());
		for(int i =0;i<expression.length();i++){
			String character =expression.charAt(i) +"";
			if(Operator.isOperator(character)){
				Operator operator = Operator.findOperator(character);
				if(operatorStk.isEmpty() || operator == Operator.OPEN_PARENTHESIS){
					operatorStk.push(operator);
				}else{
					if(operator ==  Operator.CLOSE_PARENTHESIS){
						while(operatorStk.peek()!=Operator.OPEN_PARENTHESIS){
							adjustStacks(operandStk, operatorStk);
						}
						operatorStk.pop();
					}else{
						populate(operandStk,operatorStk,operator);
					}
				}
			}else{
				operandStk.push(character);
			}
		}
		while(!operatorStk.isEmpty()){
			adjustStacks(operandStk, operatorStk);
		}
		String postfix = operandStk.pop();
		return postfix;
	}

	private static void populate(Stack<String> operandStk, Stack<Operator> operatorStk, Operator operator) {
		Operator peek = operatorStk.peek();
		while(peek!=null && peek!=Operator.OPEN_PARENTHESIS &&  peek.priority>operator.priority){
			adjustStacks(operandStk, operatorStk);
			peek = operatorStk.peek();
		}
		operatorStk.push(operator);
	}

	private static void adjustStacks(Stack<String> operandStk, Stack<Operator> operatorStk) {
		String operand1 = operandStk.pop();
		String operand2 = operandStk.pop();
		Operator popedOperator = operatorStk.pop();
		operandStk.push(operand2+operand1+popedOperator.symbol);
	}
	
}

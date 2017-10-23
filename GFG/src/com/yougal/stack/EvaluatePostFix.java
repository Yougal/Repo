package com.yougal.stack;

import com.yougal.stack.InfixToPostfix.Operator;

public class EvaluatePostFix {
	
	public static void main(String[] args) {
		String expression = "231*+9-";
		int value = evaluatePostfix(expression);
		System.out.println(value);
	}
	
	static int evaluatePostfix(String expression){
		Stack<Number> operandStk = new Stack<Number>(expression.length());
		for(int i =0;i<expression.length();i++){
			String character =expression.charAt(i) +"";
			if(Operator.isOperator(character)){
				Operator operator = Operator.findOperator(character);
				Number operand1 = operandStk.pop();
				Number operand2 = operandStk.pop();
				operandStk.push(operator.performOperation(operand2, operand1));
			}else{
				operandStk.push(Integer.valueOf(character));
			}
		}
		return operandStk.pop().intValue();
	}
}

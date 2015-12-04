package com.easygo.opcode;
import java.util.HashMap;  
import java.util.Map;  
import java.util.Stack;  
import java.util.StringTokenizer;  
import java.util.Vector;  
import java.util.regex.Pattern;  
  
public class ToOperation {  
  
  
    public double computeWithVector(String computeExpr) {  
        StringTokenizer tokenizer = new StringTokenizer(computeExpr, "+-*/()", true);  
        Vector<Double> nums = new Vector<Double>();  
        Vector<Operator> operators = new Vector<Operator>();  
        Map<String, Operator> computeOper = this.getComputeOper();  
        Operator curOper;  
        String currentEle;  
        while (tokenizer.hasMoreTokens()) {  
            currentEle = tokenizer.nextToken().trim();  
            if (!"".equals(currentEle)) {  
                if (this.isNum(currentEle)) {  
                    nums.add(Double.valueOf(currentEle));  
                } else {
                    curOper = computeOper.get(currentEle);  
                    if (curOper != null) { 
                        while (!operators.isEmpty()  
                                && operators.lastElement().priority() >= curOper  
                                        .priority()) {  
                            compute(nums, operators);  
                        }  
                        operators.add(curOper);  
                    } else {   
                        if ("(".equals(currentEle)) {   
                            operators.add(Operator.BRACKETS);  
                        } else {
                            while (!operators.lastElement().equals(Operator.BRACKETS)) {  
                                compute(nums, operators);  
                            }  
                            operators.remove(operators.size()-1);  
                        }  
                    }  
                }  
            }  
        }  
        while (!operators.isEmpty()) {  
            compute(nums, operators);  
        }  
        return   nums.firstElement();
    }  
    public double computeWithStack(String computeExpr) {  
        StringTokenizer tokenizer = new StringTokenizer(computeExpr, "+-*/()", true);  
        Stack<Double> numStack = new Stack<Double>();    
        Stack<Operator> operStack = new Stack<Operator>();    
        Map<String, Operator> computeOper = this.getComputeOper();      
        String currentEle;  
        while (tokenizer.hasMoreTokens()) {  
            currentEle = tokenizer.nextToken().trim();    
            if (!"".equals(currentEle)) {    
                if (this.isNum(currentEle)) {   
                    numStack.push(Double.valueOf(currentEle));  
                } else {   
                    Operator currentOper = computeOper.get(currentEle); 
                    if (currentOper != null) { 
                        while (!operStack.empty() && operStack.peek().priority() >= currentOper.priority()) {  
                            compute(numStack, operStack);  
                        }  
                        
                        operStack.push(currentOper);  
                    } else {  
                        if ("(".equals(currentEle)) { 
                            operStack.push(Operator.BRACKETS);  
                        } else {   
                            while (!operStack.peek().equals(Operator.BRACKETS)) {  
                                compute(numStack, operStack);  
                            }  
                            operStack.pop();
                        }  
                    }  
                }  
            }  
        }  
        
        while (!operStack.empty()) {  
            compute(numStack, operStack);  
        }  
        return numStack.pop();  
    }  
      
    
    private boolean isNum(String str) {  
        String numRegex = "^\\d+(\\.\\d+)?$";   //数字的正则表达式  
        return Pattern.matches(numRegex, str);  
    }  
      
    /** 
     * 获取运算操作符 
     * @return 
     */  
    private Map<String, Operator> getComputeOper() {  
        return new HashMap<String, Operator>() { // 运算符  
            private static final long serialVersionUID = 7706718608122369958L;  
            {  
                put("+", Operator.PLUS);  
                put("-", Operator.MINUS);  
                put("*", Operator.MULTIPLY);  
                put("/", Operator.DIVIDE);  
            }  
        };  
    }  
  
    private void compute(Vector<Double> nums, Vector<Operator> operators) {  
        Double num2 = nums.remove(nums.size() - 1); 
        Double num1 = nums.remove(nums.size() - 1); 
        Double computeResult = operators.remove(operators.size() - 1).compute(  
                num1, num2);
        nums.add(computeResult);
    }  
      
    private void compute(Stack<Double> numStack, Stack<Operator> operStack) {  
        Double num2 = numStack.pop();
        Double num1 = numStack.pop();  
        Double computeResult = operStack.pop().compute(  
                num1, num2); 
        numStack.push(computeResult); 
    }  
 
    private enum Operator {  
        /** 
         * 加 
         */  
        PLUS {  
            @Override  
            public int priority() {  
                return 1;   
            }  
  
            @Override  
            public double compute(double num1, double num2) {  
                return num1 + num2;   
            }  
        },  
        /** 
         * 减 
         */  
        MINUS {  
            @Override  
            public int priority() {  
                return 1;   
            }  
  
            @Override  
            public double compute(double num1, double num2) {  
                return num1 - num2;   
            }  
        },  
        /** 
         * 乘 
         */  
        MULTIPLY {  
            @Override  
            public int priority() {  
                return 2;   
            }  
  
            @Override  
            public double compute(double num1, double num2) {  
                return num1 * num2;   
            }  
        },  
        /** 
         * 除 
         */  
        DIVIDE {  
            @Override  
            public int priority() {  
                return 2;   
            }  
  
            @Override  
            public double compute(double num1, double num2) {  
                return num1 / num2;   
            }  
        },  
        BRACKETS {  
            @Override  
            public int priority() {  
                return 0;   
            }  
  
            @Override  
            public double compute(double num1, double num2) {  
                return 0;   
            }  
        };  
        public abstract int priority();  
        public abstract double compute(double num1, double num2);  
    }  
}  
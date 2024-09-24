package leetcode.recommendlist;

import java.util.Stack;

public class BasicCalculatorII227 {

    public static void main(String[] args) {
        BasicCalculatorII227 b = new BasicCalculatorII227();
        int result = b.calculate("3+2*2");
//        int result = b.calculate("1*2-3/4+5*6-7*8+9/10");
        System.out.println(result);
    }

    enum Operator {
        PLS('+'),
        MIN('-'),
        MUL('*'),
        DIV('/')
        ;
        final char op;

        Operator(char op) {
            this.op = op;
        }

        static Operator getInstance(char c) {
            for (Operator op : Operator.values()) {
                if (op.op == c) {
                    return op;
                }
            }
            return PLS;
        }

        static boolean isOperator(char c) {
            for (Operator op : Operator.values()) {
                if (op.op == c) {
                    return true;
                }
            }
            return false;
        }

    }

    Stack<Integer> operands;

    void init() {
        this.operands = new Stack<>();
    }

    public int calculate(String s) {
        init();

        s = s.trim();
        int num = 0;
        Operator operator = Operator.getInstance('+');
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c);
            }
            if (Operator.isOperator(c) || i == s.length()-1) {
                switch (operator) {
                    case PLS -> operands.push(num);
                    case MIN -> operands.push(-num);
                    case MUL -> operands.push(operands.pop() * num);
                    case DIV -> operands.push(operands.pop() / num);
                }
                operator = Operator.getInstance(c);
                num = 0;
            }
        }

        int result = 0;
        while (!operands.isEmpty()) {
            result += operands.pop();
        }
        return result;
    }

}

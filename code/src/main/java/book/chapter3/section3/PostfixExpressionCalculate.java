package book.chapter3.section3;

public class PostfixExpressionCalculate {
    public double calculate(String str) {
        String[] strings = str.split(" ");
        MyStack<Double> myStack = new MyStack<Double>();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("+")) {
                double a = myStack.pop();
                double b = myStack.pop();
                myStack.push(a + b);
            } else if (strings[i].equals("-")) {
                double a = myStack.pop();
                double b = myStack.pop();
                myStack.push(a - b);
            } else if (strings[i].equals("*")) {
                double a = myStack.pop();
                double b = myStack.pop();
                myStack.push(a * b);
            } else if (strings[i].equals("/")) {
                double a = myStack.pop();
                double b = myStack.pop();
                myStack.push(a / b);
            } else {
                myStack.push(Double.parseDouble(strings[i]));
            }
        }
        return myStack.pop();
    }
}

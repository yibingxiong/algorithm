package book.chapter3.section3;

import java.util.HashMap;

public class MidExpression2PostfixExpression {
    public String mid2Post(String str) {
        String[] strings = str.split(" ");

        MyStack<String> myStack = new MyStack<String>();

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("+", 0);
        hashMap.put("-", 0);
        hashMap.put("*", 1);
        hashMap.put("/", 1);
        hashMap.put("(", -1);
        hashMap.put(")", 2);

        String res = "";
        for (int i = 0; i < strings.length; i++) {
            String now = strings[i];
            if (hashMap.keySet().contains(now)) {   // 是一个符号
                if (myStack.isEmpty()) {
                    myStack.push(now);
                } else {
                    if (now.equals("(")) {
                        myStack.push(now);
                    } else {
                        if (now.equals(")")) {
                            while (!myStack.peek().equals("(")) {
                                res += " " + myStack.pop();
                            }
                            myStack.pop();
                        } else {
                            while (!myStack.isEmpty() && hashMap.get(myStack.peek()) >= hashMap.get(now)) {
                                res += " " + myStack.pop();
                            }
                            myStack.push(now);
                        }
                    }
                }
            } else {   // 是一个操作数
                res += " " + now;
            }
        }

        while (!myStack.isEmpty()) {
            res += " " + myStack.pop();
        }
        return res.trim();
    }
}

package book.chapter3.section3;

import org.junit.Test;

public class MyStackTest {
    @Test
    public void  test() {
        MyStack<Integer> myStack = new MyStack<Integer>();
        System.out.println(myStack.isEmpty());
        myStack.push(1);
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        System.out.println(myStack.size());

    }
}

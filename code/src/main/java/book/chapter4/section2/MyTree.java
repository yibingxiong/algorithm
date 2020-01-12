package book.chapter4.section2;

import book.chapter3.section3.MyStack;

import java.util.HashSet;

class Node<T> {
    private T data;
    public Node left;
    public Node right;


    public Node(T data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

public class MyTree<T> {

    // 先序遍历
    public void preTraverse(Node root) {
        System.out.print(root.getData() + " ");
        if (root.getLeft() != null) {
            preTraverse(root.getLeft());
        }
        if (root.getRight() != null) {
            preTraverse(root.getRight());
        }
    }

    // 后续遍历
    public void postTraverse(Node root) {
        if (root.getLeft() != null) {
            postTraverse(root.getLeft());
        }
        if (root.getRight() != null) {
            postTraverse(root.getRight());
        }
        System.out.print(root.getData() + " ");
    }

    // 中序遍历
    public void midTraverse(Node root) {
        if (root.getLeft() != null) {
            midTraverse(root.getLeft());
        }
        System.out.print(root.getData() + " ");
        if (root.getRight() != null) {
            midTraverse(root.getRight());
        }
    }

    // 将后缀表达式转换为一棵树
    public Node<String> postfixExpressiont2Tree(String str) {
        String[] strings = str.split(" ");
        MyStack<Node<String>> myStack = new MyStack<Node<String>>();
        HashSet<String> operations = new HashSet<String>();
        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");
        for(int i = 0; i< strings.length; i++) {
            if (operations.contains(strings[i])) {  // 是一个符号
                Node<String> node1 = myStack.pop();
                Node<String> node2 = myStack.pop();
                Node<String> newNode = new Node<String>(strings[i], node2, node1);
                myStack.push(newNode);
            } else  {
                myStack.push(new Node<String>(strings[i], null, null));
            }
        }
        return myStack.pop();
    }
}

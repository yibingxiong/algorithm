package book.chapter4.section2;

import org.junit.Before;
import org.junit.Test;

public class MyTreeTest {

    Node<Character> root = null;

    @Before
    public void testBefore() {
        root = new Node<Character>('+');

        root.left = new Node('+', null, null);
        root.left.left = new Node('a');
        root.left.right = new Node('*');
        root.left.right.left = new Node('b');
        root.left.right.right = new Node('c');

        root.right = new Node('*');
        root.right.right = new Node('g');
        root.right.left = new Node('+');
        root.right.left.right = new Node('f');
        root.right.left.left = new Node('*');
        root.right.left.left.left = new Node('d');
        root.right.left.left.right = new Node('e');
    }

    @Test
    public void test() {
        MyTree<Character> myTree = new MyTree<Character>();


        myTree.preTraverse(root);
        System.out.println();
        myTree.postTraverse(root);
        System.out.println();
        myTree.midTraverse(root);
    }

    @Test
    public void  postfixExpressiont2TreeTest() {
        MyTree<String> myTree = new MyTree<String>();
        Node<String> node = myTree.postfixExpressiont2Tree("a b c * + d e * f + g * + ");
        myTree.postTraverse(node);

    }
}

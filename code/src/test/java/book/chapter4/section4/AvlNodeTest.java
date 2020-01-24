package book.chapter4.section4;


import book.chapter4.utils.TreeUtils;
import org.junit.Test;

public class AvlNodeTest {

    @Test
    public void test1() {
        AvlTree<Integer> avlTree = new AvlTree<Integer>();
        avlTree.insert(3);
        avlTree.insert(2);
        avlTree.insert(1);
        avlTree.insert(4);
        avlTree.insert(5);
        avlTree.insert(6);
        avlTree.insert(7);
        avlTree.insert(16);
        avlTree.insert(15);
        avlTree.insert(14);
        avlTree.insert(13);
        avlTree.insert(12);
        avlTree.insert(11);
        avlTree.insert(10);
        avlTree.insert(9);
//        avlTree.remove(9);
//        avlTree.remove(1);
        avlTree.remove(7);
        TreeUtils.printTree(avlTree.head);
    }

}

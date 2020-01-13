package book.chapter4.section3;

import book.chapter2.section4.BinarySearch;
import book.chapter4.utils.TreeUtils;
import org.junit.Test;

public class BinarySearchTreeTest {
    @Test
    public void test() {
        BinarySearchTree<Integer> binarySearch = new BinarySearchTree<Integer>();
        binarySearch.insert(2);
        binarySearch.insert(3);
        binarySearch.insert(1);
        binarySearch.insert(4);
        binarySearch.insert(0);
        binarySearch.insert(10);
        TreeUtils.printTree(binarySearch.root);
        System.out.println("--------");
        binarySearch.remove(0);
        TreeUtils.printTree(binarySearch.root);

    }
}

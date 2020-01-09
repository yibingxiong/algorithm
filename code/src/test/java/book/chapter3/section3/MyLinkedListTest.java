package book.chapter3.section3;

import org.junit.Test;

import java.util.Iterator;

public class MyLinkedListTest {

    private void printList(MyLinkedList<Integer> linkedList) {
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
    }

    @Test
    public void test() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
        linkedList.add(0, 1);
        linkedList.add(0, 2);
        linkedList.add(0, 3);
        linkedList.add(6);
        linkedList.remove(1);
        linkedList.remove(0);
//        System.out.println(linkedList.size());

        printList(linkedList);

        Iterator<Integer> it = linkedList.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

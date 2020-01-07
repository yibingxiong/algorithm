package book.chapter3.section3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyArralListTest {
    private MyArrayList<Integer> arrayList = null;
    @Test
    @Before
    public void cons() {
        arrayList = new MyArrayList<Integer>();
        Assert.assertEquals(0, arrayList.size());
    }

    @Test
    public void test() {
        arrayList.add(3);
        // 3
        Assert.assertEquals(3, arrayList.get(0).intValue());
        arrayList.add(4);
        Assert.assertEquals(2, arrayList.size());
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(0, 12);
        Assert.assertEquals(12, arrayList.get(0).intValue());
        arrayList.add(13);
        Assert.assertEquals(13, arrayList.get(arrayList.size()-1).intValue());
        arrayList.add(15);
        Assert.assertEquals(15, arrayList.get(arrayList.size()-1).intValue());

        int size = arrayList.size();
        int a = arrayList.remove(0);
        Assert.assertEquals(12, a);
        Assert.assertEquals(size-1,arrayList.size());
        int b = arrayList.remove();
        Assert.assertEquals(15, b);
        Assert.assertEquals(size-2,arrayList.size());
    }
}

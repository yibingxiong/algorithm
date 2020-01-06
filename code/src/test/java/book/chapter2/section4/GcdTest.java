package book.chapter2.section4;

import org.junit.Assert;
import org.junit.Test;

public class GcdTest {
    @Test
    public void testGcd() {
        Gcd gcd = new Gcd();
        Assert.assertEquals(gcd.gcd(1,2),1);
        Assert.assertEquals(gcd.gcd(2,4),2);
        Assert.assertEquals(gcd.gcd(3,4),1);
        Assert.assertEquals(gcd.gcd(8,12),4);
    }
}

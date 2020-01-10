package book.chapter3.section3;

import org.junit.Assert;
import org.junit.Test;

public class BalanceSymbolsTest {
    @Test
    public void test() {
        BalanceSymbols balanceSymbols = new BalanceSymbols();

        Assert.assertEquals(true, balanceSymbols.isBalance("[()]"));
        Assert.assertEquals(true, balanceSymbols.isBalance("{[00000(222222)]}"));
        Assert.assertEquals(false, balanceSymbols.isBalance("("));
        Assert.assertEquals(false, balanceSymbols.isBalance("([)]"));
    }
}

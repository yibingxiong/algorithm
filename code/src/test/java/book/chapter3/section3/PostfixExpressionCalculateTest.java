package book.chapter3.section3;

import org.junit.Test;

public class PostfixExpressionCalculateTest {
    @Test
    public void test() {
        PostfixExpressionCalculate postfixExpressionCalculate = new PostfixExpressionCalculate();
        System.out.println(postfixExpressionCalculate.calculate("4.99 1.06 * 5.99 + 6.99 1.06 * +"));
    }
}

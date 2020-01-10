package book.chapter3.section3;

import org.junit.Test;

public class MidExpression2PostfixExpressionTest {
    @Test
    public void test() {
        MidExpression2PostfixExpression midExpression2PostfixExpression = new MidExpression2PostfixExpression();
        System.out.println(midExpression2PostfixExpression.mid2Post("a + b * c + ( d * e + f ) * g"));
    }
}

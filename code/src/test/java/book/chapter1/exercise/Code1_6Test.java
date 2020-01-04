package book.chapter1.exercise;

import com.sun.tools.javac.jvm.Code;
import org.junit.Test;

public class Code1_6Test {
    @Test
    public void testPermute() {
        Code1_6 code1_6 = new Code1_6();
        String str = "abc";
        code1_6.permute(str);
    }
}

package book.chapter2.section4;

public class Gcd {
    public int gcd(int m , int n) {
        while (n!=0) {
            int rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }
}

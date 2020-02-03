package book.chapter8;

// 按大小求并的并查集
public class DisjSizeSets {
    private int[] s;

    public DisjSizeSets(int numElements) {
        s = new int[numElements];
        for (int i = 0; i < s.length; i++) {
            s[i] = -1;
        }
    }

    public void union(int root1, int root2) {
        if (s[root1] < s[root2]) {
            int size = s[root2];
            s[root2] = root1;
            s[root1] = size + s[root1];
        } else {
            int size = s[root1];
            s[root1] = root2;
            s[root2] = size + s[root2];
        }
    }

    public int find(int x) {
        if (s[x] < 0) {
            return x;
        }
        return find(s[x]);
    }
}

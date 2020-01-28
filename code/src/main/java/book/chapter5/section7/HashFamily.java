package book.chapter5.section7;

public interface HashFamily<T> {
    int hash(T x, int which);

    int getNumberOfFunctions();

    void generateNewFunctions();
}

public class OffByN implements CharacterComparator {
    private int N; //exact number of abs(diff of x and y)

    public OffByN(int N) {
        this.N = N;
    }

    /**
     Returns true for characters whose ascii numbers are
     exactly 5 integers apart.
     */
    @Override
    public boolean equalChars(char x, char y) {
        int asciiX = (int) x;
        int asciiY = (int) y;
        int difference = abs(x - y);
        return difference == N;
    }

    private int abs(int value) {
        return (value < 0) ? value * -1 : value;
    }

}

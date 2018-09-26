
public class OffByOne implements CharacterComparator {


    @Override
    public boolean equalChars(char x, char y) {
        int asciiX = (int) x;
        int asciiY = (int) y;
        int difference = abs(x - y);
        return difference == 1;
    }

    private int abs(int value) {
        return (value < 0) ? value * -1 : value;
    }

}




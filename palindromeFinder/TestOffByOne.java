import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('r', 'q'));
        assertTrue(offByOne.equalChars('3', '2'));
        assertTrue(offByOne.equalChars('&', '%'));
        assertTrue(offByOne.equalChars('=', '<'));
        assertFalse(offByOne.equalChars('a', 'e'));
        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('a', 'a'));
        assertFalse(offByOne.equalChars('A', 'b'));
        assertFalse(offByOne.equalChars('a', 'B'));
        assertFalse(offByOne.equalChars('3', '#'));
        assertFalse(offByOne.equalChars('&', '&'));
        assertFalse(offByOne.equalChars('a', 'a'));
        assertTrue(offByOne.equalChars('\\', ']'));
        assertTrue(offByOne.equalChars('\\', '['));
        assertTrue(offByOne.equalChars('_', '^'));
        assertTrue(offByOne.equalChars('Q', 'P'));
        assertFalse(offByOne.equalChars('q', 'P'));
        assertTrue(offByOne.equalChars(' ', '!'));
        assertTrue(offByOne.equalChars('!', '"'));
        assertTrue(offByOne.equalChars('A', '@'));
        assertTrue(offByOne.equalChars('Z', '['));
        assertTrue(offByOne.equalChars('z', '{'));
        assertFalse(offByOne.equalChars(' ', '"'));
        assertFalse(offByOne.equalChars('@', 'a'));
        assertFalse(offByOne.equalChars(']', 'Z'));
        assertFalse(offByOne.equalChars('\\', '^'));
        assertFalse(offByOne.equalChars('}', 'z'));
        assertFalse(offByOne.equalChars('Z', '{'));
        assertFalse(offByOne.equalChars('o', '/'));
        assertFalse(offByOne.equalChars('/', 'o'));
    }

}

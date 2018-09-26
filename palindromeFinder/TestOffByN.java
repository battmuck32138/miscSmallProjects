import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testEqualChars() {
        assertTrue(offByN.equalChars('a', 'f'));
        assertTrue(offByN.equalChars('f', 'a'));
        assertTrue(offByN.equalChars('3', '8'));
        assertTrue(offByN.equalChars('&', '+'));
        assertTrue(offByN.equalChars('=', '8'));
        assertFalse(offByN.equalChars('f', 'h'));
        assertFalse(offByN.equalChars('z', 'a'));
        assertFalse(offByN.equalChars('a', 'a'));
        assertFalse(offByN.equalChars('A', 'f'));
        assertFalse(offByN.equalChars('f', 'A'));
        assertFalse(offByN.equalChars('3', '#'));
        assertFalse(offByN.equalChars('&', '&'));
        assertFalse(offByN.equalChars('a', 'a'));
    }
}

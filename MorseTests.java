import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import java.util.*;

/** 
 * JUnit tests cases for the Morse Code assignment.
 * 
 * @author Vitaly Ford
 */ 
public class MorseTests {
    @Test
    public void dashDotDash() {
        ArrayList<String> decoded = Morse.decodeMorse("-.-");
        Collections.sort(decoded);
        ArrayList<String> actual = new ArrayList<>(Arrays.asList(new String[]{"tet", "ta", "nt", "k"}));
        Collections.sort(actual);
        assertArrayEquals(actual.toArray(), decoded.toArray());
    }

    @Test
    public void dotDotDot() {
        ArrayList<String> decoded = Morse.decodeMorse("...");
        Collections.sort(decoded);
        ArrayList<String> actual = new ArrayList<>(Arrays.asList(new String[]{"eee", "ei", "ie", "s"}));
        Collections.sort(actual);
        assertArrayEquals(actual.toArray(), decoded.toArray());
    }

    @Test
    public void dashDotDashDotDash() {
        ArrayList<String> decoded = Morse.decodeMorse("-.-.-");
        Collections.sort(decoded);
        ArrayList<String> actual = new ArrayList<>(Arrays.asList(new String[]{"tetet", "teta", "tent", "tek", "taet", "taa", "trt", "ntet", "nta", "nnt", "nk", "ket", "ka", "ct"}));
        Collections.sort(actual);
        assertArrayEquals(actual.toArray(), decoded.toArray());
    }
}

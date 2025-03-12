package Q1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ProblemsTest {

    static Problems p = new Problems();

    /**
     * inputCheck the collections of the test case
     * 
     * @return Stream<Arguments> when called to check
     */
    private static Stream<Arguments> inputCheck() {
        return Stream.of(
                Arguments.of(3, 4, 1),
                Arguments.of(81, 675, 27),
                Arguments.of(12, 4, 4));
    }

    /**
     * passTest case for the HCF
     * 
     * @param int x one of the number for the HCF
     * @param int y another number for the HCF
     * @param op  the op we are expecting
     */
    @ParameterizedTest
    @MethodSource("inputCheck")
    public void passTest(int x, int y, int op) {
        assertEquals(op, p.HCF(x, y));
    }

    /**
     * inputCheck the collections of the test case
     * 
     * @return Stream<Arguments> when called to check
     */
    private static Stream<Arguments> inputCheckLCM() {
        return Stream.of(
                Arguments.of(3, 4, 12),
                Arguments.of(12, 4, 12));
    }

    /**
     * passTest case for the HCF
     * 
     * @param int x one of the number for the HCF
     * @param int y another number for the HCF
     * @param op  the op we are expecting
     */
    @ParameterizedTest
    @MethodSource("inputCheckLCM")
    public void passTestLCM(int x, int y, int op) {
        assertEquals(op, p.LCM(x, y));
    }

    /**
     * test_fail condition for the when the array is empty
     */
    @Test
    public void testFailLCM() {
        
        assertThrows(AssertionError.class, () -> p.LCM(0,1));
    }
     /**
     * test_fail condition for the when the array is empty
     */
    @Test
    public void testFailHCF() {
        
        assertThrows(AssertionError.class, () -> p.LCM(0,1));
    }


}

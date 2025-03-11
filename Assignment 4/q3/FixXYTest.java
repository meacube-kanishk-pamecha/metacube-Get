package q3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FixXYTest {
    private static FixXY fxy = new FixXY();

    /**
     * inputandresult which gives the them the input case for testing
     * 
     * @return Strem Of Arguments for testing
     */
    private static Stream<Arguments> inputandresult() {
        return Stream.of(
                Arguments.of(new int[] { 5, 4, 9, 4, 9, 5 }, 4, 5, new int[] { 9, 4, 5, 4, 5, 9 }),
                Arguments.of(new int[] { 1, 4, 1, 5 }, 4, 5, new int[] { 1, 4, 5, 1 }),
                Arguments.of(new int[] { 1, 4, 1, 5, 5, 4, 1 }, 4, 5, new int[] { 1, 4, 5, 1, 1, 4, 5 }));
    }

    /**
     * test_zeroArray_fail if the array is empty then this testing function
     */
    @Test
    public void test_zeroArray_fail() {
        int[] arr = new int[0];
        int x = 4;
        int y = 5;
        assertThrows(AssertionError.class, () -> fxy.arrayFixXY(arr, x, y));
    }

    /**
     * test_continousX_fail for consecutive X this test is made
     */
    @Test
    public void test_continousX_fail() {
        int[] arr = { 10, 2, 3, 4, 4, 5, 5 };
        int x = 4;
        int y = 5;
        assertThrows(AssertionError.class, () -> fxy.arrayFixXY(arr, x, y));
    }

    /**
     * testUnequalFail for unequal number of x and y
     */
    @Test
    public void testUnequalFail() {
        int[] arr = { 10, 2, 3, 4, 5, 5 };
        int x = 4;
        int y = 5;
        assertThrows(AssertionError.class, () -> fxy.arrayFixXY(arr, x, y));
    }

    /**
     * testLastXFail if the condition has the last element as X
     */
    @Test
    public void testLastXFail() {
        int[] arr = { 10, 2, 3, 5, 4 };
        int x = 4;
        int y = 5;
        assertThrows(AssertionError.class, () -> fxy.arrayFixXY(arr, x, y));
    }

    /**
     * passFixX Test all the pass Conditions for the correct cases
     * 
     * @param int [] input input array on which functioning is done
     * @param int x the value of X which will be used to function
     * @param int y the value of Y which will be used to function
     * @param int op the expected output we are expecting
     */
    @ParameterizedTest
    @MethodSource("inputandresult")
    public void passFixX(int[] input, int x, int y, int[] op) {
        assertArrayEquals(op, fxy.arrayFixXY(input, x, y));
    }

}

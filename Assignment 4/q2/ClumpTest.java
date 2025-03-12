package q2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ClumpTest {
    private static Clump cp = new Clump();

    /**
     * inputandresult which gives the them the input case for testing
     * 
     * @return Strem Of Arguments for testing
     */
    private static Stream<Arguments> inputAndResult() {
        return Stream.of(
                Arguments.of(new int[] { 1, 2, 2, 3, 4, 4 }, 2),
                Arguments.of(new int[] { 1, 1, 2, 1, 1 }, 2),
                Arguments.of(new int[] { 1, 1, 1, 1, 1 }, 1));
    }

    /**
     * testPass in this the pass test are passed
     *
     * @param int [] arr in which we want to see the clumps present
     * @param int x the output which we are expecting
     */
    @ParameterizedTest
    @MethodSource("inputAndResult")
    public void testPass(int[] arr, int x) {
        assertEquals(x, cp.noOfClumps(arr));
    }

    public void test_fail() {
        int[] arr = new int[0];
        assertThrows(AssertionError.class, () -> cp.noOfClumps(arr));
    }

}

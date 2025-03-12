package Q3;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NQueenTest {
    private static NQueen nQ = new NQueen();

    /**
     * inputCheck provides the input conditions for the testing purpose
     * 
     * @return Stream<Arguments>
     */
    private static Stream<Arguments> inputCheck() {

        return Stream.of(
                Arguments.of(4, new int[][] { { 0, 1, 0, 0 },
                        { 0, 0, 0, 1 }, { 1, 0, 0, 0 },
                        { 0, 0, 1, 0 } }));
    }

    /**
     * passTest for the passing Test Case
     * 
     * @param int     n no of or the size of the array
     * @param int[][] op output the function gives of the array
     */
    @ParameterizedTest
    @MethodSource("inputCheck")
    public void passTest(int n, int[][] op) {
        assertArrayEquals(op, nQ.nQueen(n));
    }
    
    /**
     * Negative or failed cases for the nQueen problem
     */
    @Test
    public void testFail() {
        assertThrows(AssertionError.class, () -> nQ.nQueen(0));
    }
    
}

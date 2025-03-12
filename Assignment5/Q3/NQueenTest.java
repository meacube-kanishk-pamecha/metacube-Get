package Q3;

import static org.junit.Assert.assertArrayEquals;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NQueenTest {
    private static NQueen nQ = new NQueen();

    /**
     * 
     * @return
     */
    private static Stream<Arguments> inputCheck() {

        return Stream.of(
                Arguments.of(4, new int[][] { { 0, 1, 0, 0 },
                        { 0, 0, 0, 1 }, { 1, 0, 0, 0 },
                        { 0, 0, 1, 0 } }));
    }

    /**
     * 
     * @param n
     * @param op
     */
    @ParameterizedTest
    @MethodSource("inputCheck")
    public void passTest(int n, int[][] op) {
        assertArrayEquals(op, nQ.nQueen(n));
    }
}

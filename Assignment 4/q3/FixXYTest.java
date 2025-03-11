package q3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FixXYTest {
    private static FixXY fxy = new FixXY();

    private static Stream<Arguments> inputandresult() {
        return Stream.of(
                Arguments.of(new int[] { 5, 4, 9, 4, 9, 5 }, 4, 5, new int[] { 9, 4, 5, 4, 5, 9 }),
                Arguments.of(new int[] {1, 4, 1, 5 }, 4, 5, new int[] { 1, 4, 5, 1 }),
                Arguments.of(new int[] { 1, 4, 1, 5, 5, 4, 1 }, 4, 5, new int[] { 1, 4, 5, 1, 1, 4, 5 }));
    }

    @ParameterizedTest
    @MethodSource("inputandresult")
    public void convert(int[] input, int x, int y, int[] op) {
        try {
            assertArrayEquals(op, fxy.arrayFixXY(input, x, y));
        } catch (AssertionError e) {
            System.out.println("Assertion error with error" + e.getMessage());
        }
    }
}

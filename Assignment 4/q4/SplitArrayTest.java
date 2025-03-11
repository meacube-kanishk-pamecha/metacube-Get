package q4;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SplitArrayTest {

    private static SplitArray sp = new SplitArray();

    private static Stream<Arguments> inputandresult() {
        return Stream.of(
                Arguments.of(new int[] { 1, 1, 1, 2, 1 }, 3),
                Arguments.of(new int[] { 2, 1, 1, 2, 1 }, -1),
                Arguments.of(new int[] { 10, 10 }, 1));
    }

    @ParameterizedTest
    @MethodSource("inputandresult")
    public void convert(int[] input, int op) {
      try{  assertEquals(op, sp.split(input));}
      catch(AssertionError e){
        System.out.println("Assertion error with error" + e.getMessage());
     }
    }
}

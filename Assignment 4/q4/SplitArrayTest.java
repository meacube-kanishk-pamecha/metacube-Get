package q4;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SplitArrayTest {

  private static SplitArray sp = new SplitArray();

   /**
     * inputandresult which gives the them the input case for testing
     * 
     * @return Strem Of Arguments for testing
     */
  private static Stream<Arguments> inputandresult() {
    return Stream.of(
        Arguments.of(new int[] { 1, 1, 1, 2, 1 }, 3),
        Arguments.of(new int[] { 2, 1, 1, 2, 1 }, -1),
        Arguments.of(new int[] { 10, 10 }, 1));
  }


/**
 * 
 * passSplit  in this if we are expecting 
 * @param int [] input the array on which Split is to be performed 
 * @param int op what output we are expecting 
 */
  @ParameterizedTest
  @MethodSource("inputandresult")
  public void passSplit(int[] input, int op) {
          assertEquals(op, sp.split(input));
    
  }
  /**
   * testFail forfailed condition like empty array
   */
  public void testFail(){
        int[] arr = new int[0];
        assertThrows(AssertionError.class, () -> sp.split(arr));
    }
}

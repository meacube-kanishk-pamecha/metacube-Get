package q1;

//import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.Test;
//import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MirrorTest {
    private static Mirror m = new Mirror();
    // public static void main(String[] args) {
        
    //  System.out.println(  m.maxMirror(new int[]{ 7, 1, 4, 9, 7, 4, 1 }));
    // }

    
    /**
     * inputandresult which gives the them the input case for testing
     * 
     * @return Strem Of Arguments for testing
     */
    private static Stream<Arguments> inputandresult() {
        return Stream.of(
                Arguments.of(new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }, 3),
                Arguments.of(new int[] { 7, 1, 4, 9, 7, 4, 1 }, 2),
                Arguments.of(new int[] { 1, 2, 1, 4 }, 3)
                );
    }

    /**
     * 
     * @param int [] input
     * @param op
     */
    @ParameterizedTest
    @MethodSource("inputandresult")
    public void testPass(int[] input, int op) {
        assertEquals(op, m.maxMirror(input));
    }

    /**
     * 
     */
    @Test
    public void test_fail(){
        int[] arr = new int[0];
        assertThrows(AssertionError.class, () -> m.maxMirror(arr));
    }

     
    

}

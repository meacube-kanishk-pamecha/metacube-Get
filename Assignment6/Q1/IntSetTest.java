package Q1;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.Test;
//import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

 public class IntSetTest {
   
    // public static void main(String[] args) {

    // System.out.println( m.maxMirror(new int[]{ 7, 1, 4, 9, 7, 4, 1 }));
    // }

    /**
     * isMemeberPass which gives the them the input case for testing
     * 
     * @return Strem Of Arguments for testing
     */
    private static Stream<Arguments> isMemeberPass() {
        return Stream.of(
                Arguments.of( 30),
                Arguments.of( 200),
                Arguments.of(10));
    }
  
    private static intSet st = new intSet(new int[] { 10, 20, 30, 80, 90, 100, 200,40 });

    /**
     * 
     * testPass checks
     * 
     * @param int [] input the input array we are giving
     * @param int op the output we are expecting
     */
    @ParameterizedTest
    @MethodSource("isMemeberPass")
    public void testPass(int num) {
        
        assertTrue( st.isMember(num));
    }

    private static Stream<Arguments> isMemeberFail() {
        return Stream.of(
                Arguments.of( 0),
                Arguments.of( 2),
                Arguments.of(1));
    }

    @ParameterizedTest
    @MethodSource("isMemeberFail")
    public void FailPass(int num) {
        
        assertFalse( st.isMember(num));
    }


    private static Stream<Arguments> isSubSetPass() {
        return Stream.of(
                Arguments.of( new intSet(new int[]{10,20,30})),
                Arguments.of(  new intSet(new int[]{10}))
        );
    }

    @ParameterizedTest
    @MethodSource("isSubSetPass")
    public void testSubsetPass(intSet num) {
        
        assertTrue( st.isSubSet(num));
    }
   
}

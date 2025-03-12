package Q2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SearchTest {
       
   private static Search sc = new Search();
    /**
     * inputCheck the collections of the test case 
     * @return Stream<Arguments> when called to check 
     */
    private static Stream<Arguments>inputCheck(){
        return Stream.of(
            Arguments.of(new int[]{10,20,30,40,50,60,70,80,90} ,10,0),
            Arguments.of(new int[]{10,20,30,40,50,60,70,80,90} ,20,1),
            Arguments.of(new int[]{10,20,30,40,50,60,70,80,90} ,40,3)
        );
    }
    /**
     * passTestBinary case for the binarySearch
     * @param int []  arr the array we are checking
     * @param int num the number that is to be searchec
     * @param int op output we are expecting
     */
    @ParameterizedTest
    @MethodSource("inputCheck")
    public void passTestBinary(int[]arr,int num , int op)
    {
        System.out.println("Running");
        assertEquals(op, sc.binary(arr,num));
    }
  
    /**
     * passTestLinear case for the LinearSearch
     * @param int []  arr the array we are checking
     * @param int num the number that is to be searchec
     * @param int op output we are expecting
     */
    @ParameterizedTest
    @MethodSource("inputCheck")
    public void passTestLinear(int[]arr,int num , int op)
    {
        assertEquals(op, sc.linear(arr,num));
    }
      /**
     * testFail condition for the when the array is empty
     */
    @Test
    public void testFail() {
        int[] arr = new int[0];
        assertThrows(AssertionError.class, () -> sc.linear(arr,0));
    }



}

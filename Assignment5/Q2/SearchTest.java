package Q2;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SearchTest {
       
   private static Search sc = new Search();
    /**
     * 
     * @return
     */
    private static Stream<Arguments>inputCheck(){
        return Stream.of(
            Arguments.of(new int[]{10,20,30,40,50,60,70,80,90} ,10,0),
            Arguments.of(new int[]{10,20,30,40,50,60,70,80,90} ,20,1),
            Arguments.of(new int[]{10,20,30,40,50,60,70,80,90} ,40,3)
        );
    }
    /**
     * 
     * @param arr
     * @param num
     * @param op
     */
    @ParameterizedTest
    @MethodSource("inputCheck")
    public void passTest(int[]arr,int num , int op)
    {
        System.out.println("Running");
        assertEquals(op, sc.binary(arr,num));
    }
  
    /**
     * 
     * @param arr
     * @param num
     * @param op
     */
    @ParameterizedTest
    @MethodSource("inputCheck")
    public void passTestLinear(int[]arr,int num , int op)
    {
        assertEquals(op, sc.linear(arr,num));
    }



}

package q2;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ClumpTest {
    private static Clump cp = new Clump();
    private static Stream<Arguments> inputAndResult(){
        return Stream.of(
            Arguments.of(new int[]{1, 2, 2, 3, 4, 4},2),
            Arguments.of(new int[]{1, 1, 2, 1, 1},2), 
            Arguments.of(new int[]{1, 1, 1, 1, 1},1)    
        );
    }
    @ParameterizedTest
    @MethodSource("inputAndResult")
    public void convert(int[]arr, int x)
    {
        try{assertEquals( x,cp.noOfClumps(arr));}
        catch(AssertionError e){
            System.out.println("Assertion error with error" + e.getMessage());
         }

    }
}

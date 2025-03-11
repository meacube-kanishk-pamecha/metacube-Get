package q1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class MirrorTest {

   private static Mirror m = new Mirror();
    
    private static Stream<Arguments> inputandresult(){
        return Stream.of(
            Arguments.of( new int []{1, 2, 3, 8, 9, 3, 2, 1},3),
            Arguments.of( new int []{7, 1, 4, 9, 7, 4, 1},2),
            Arguments.of( new int []{1, 2, 1, 4},3),
            Arguments.of( new int []{},0)
            );
    }
    @ParameterizedTest
@MethodSource("inputandresult")
public void convert(int [] input, int op) {
	 try{assertEquals(op,m.maxMirror(input));}
     catch(AssertionError e){
        System.out.println("Assertion error with error" + e.getMessage());
     }
}

}

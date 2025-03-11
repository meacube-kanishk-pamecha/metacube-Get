package Q1;

import static org.junit.Assert.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class ProblemsTest {
    
   static Problems p = new Problems();
    private static Stream<Arguments> inputCheck(){
        return Stream.of(
            Arguments.of(3,4,1),
            Arguments.of(81,675,27),
            Arguments.of(12,4,4)
        );
    }
    @ParameterizedTest
    @MethodSource("inputCheck")
    public void convert(int x, int y , int op){
        assertEquals(op,p.HCF(x, y));
        

    }

}

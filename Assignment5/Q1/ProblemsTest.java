package Q1;

import static org.junit.Assert.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class ProblemsTest {
    
   static Problems p = new Problems();
   
   /**
    * 
    * @return
    */
    private static Stream<Arguments> inputCheck(){
        return Stream.of(
            Arguments.of(3,4,1),
            Arguments.of(81,675,27),
            Arguments.of(12,4,4)
        );
    }
    /**
     * 
     * @param x
     * @param y
     * @param op
     */
    @ParameterizedTest
    @MethodSource("inputCheck")
    public void passTest(int x, int y , int op){
        assertEquals(op,p.HCF(x, y));
    }
    /**
     * 
     * @return
     */
    private static Stream<Arguments> inputCheckLCM(){
        return Stream.of(
            Arguments.of(3,4,12),
            Arguments.of(12,4,12)
        );
    }
    /**
     * 
     * @param x
     * @param y
     * @param op
     */
    @ParameterizedTest
    @MethodSource("inputCheckLCM")
    public void passTestLCM(int x, int y , int op){
        assertEquals(op,p.LCM(x, y));
    }

    // private static Stream<Arguments> inputfailCheck(){
    //     return Stream.of(
    //         Arguments.of(3,4,2),
    //         Arguments.of(81,675,100),
    //         Arguments.of(12,4,0)
    //     );
    // }
    // @ParameterizedTest
    // @MethodSource("inputfailCheck")
    // public void failTest(int x, int y , int op){
    //     assertEquals(op,p.HCF(x, y));
    // }
}

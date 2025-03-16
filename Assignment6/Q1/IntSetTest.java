package Q1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class IntSetTest {

    /**
     * isMemeberPass which gives the them the input case for testing
     * 
     * @return Strem Of Arguments for testing
     */
    private static Stream<Arguments> isMemeberPass() {
        return Stream.of(
                Arguments.of(30),
                Arguments.of(200),
                Arguments.of(10));
    }

    private static intSet st = new intSet(new int[] { 10, 20, 30, 80, 90, 100, 200, 40 });

    /**
     * 
     * testPass checks the  passing test cases of isMember function
     * 
     * @param int num the input we are fedding to get true
     */
    @ParameterizedTest
    @MethodSource("isMemeberPass")
    public void testPass(int num) {

        assertTrue(st.isMember(num));
    }

    /**
     * isMemeberPass which gives the them the input case for testing
     * 
     * @return Strem Of Arguments for testing
     */
    private static Stream<Arguments> isMemeberFail() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(2),
                Arguments.of(1));
    }


      /**
     * 
     * FailPass checks the  Failling test cases of isMember function
     * 
     * @param int  the input we are feeding to get false
     */
    @ParameterizedTest
    @MethodSource("isMemeberFail")
    public void FailPass(int num) {

        assertFalse(st.isMember(num));
    }
    /**
     * isSubSetPass which gives the them the input case for testing
     * 
     * @return Strem Of Arguments for testing
     */

    private static Stream<Arguments> isSubSetPass() {
        return Stream.of(
                Arguments.of(new intSet(new int[] { 10, 20, 30 })),
                Arguments.of(new intSet(new int[] { 10 })));
    }

    /**
     * 
     * testSubsetPass checks the  Passing test cases of isSubset function
     * 
     * @param int  the input we are feeding to get True
     */
    @ParameterizedTest
    @MethodSource("isSubSetPass")
    public void testSubsetPass(intSet num) {
        System.out.println(st.isSubSet(num));
        assertTrue(num.isSubSet(st));
    }

    /**
     * isSubSetFail which gives the them the input case for testing
     * 
     * @return Strem Of Arguments for testing
     */
    private static Stream<Arguments> isSubSetFail() {
        return Stream.of(
                Arguments.of(new intSet(new int[] { 0, 22, 35 })),
                Arguments.of(new intSet(new int[] { 66 })));
    }

     /**
     * 
     * testSubsetFail checks the  Failling test cases of isSubset function
     * 
     * @param int  the input we are feeding to get False
     */
    @ParameterizedTest
    @MethodSource("isSubSetFail")
    public void testSubsetFail(intSet num) {
        System.out.println(st.isSubSet(num));
        assertFalse(num.isSubSet(st));
    }
}

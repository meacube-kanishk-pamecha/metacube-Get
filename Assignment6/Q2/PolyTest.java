package Q2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;



import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PolyTest {
   
   

    /**
     * Provides test cases for polynomial evaluation.
     */
    private static Stream<Arguments> inputEval() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 5}, 2, 27), 
                Arguments.of(new int[]{1, 4, 0, 2}, 1, 1 + 4 * 1 + 0 + 2)
        );
    }

    @ParameterizedTest
    @MethodSource("inputEval")
    void testEval(int[] coeff, float x, float expected) {
        Poly poly = new Poly(coeff);
        assertEquals(expected, poly.Eval(x));
    }

    /**
     * Provides test cases for polynomial addition.
     */
    private static Stream<Arguments> inputAdd() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 5}, new int[]{1, 4, 0, 2}, new int[]{4, 6, 5, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("inputAdd")
    void testAdd(int[] coeff1, int[] coeff2, int[] expected) {
        Poly poly1 = new Poly(coeff1);
        Poly poly2 = new Poly(coeff2);
        Poly result = poly1.add(poly1, poly2);
        assertArrayEquals(expected, result.coeff);
    }

    

   
    /**
     * Provides test cases for polynomial degree.
     */
    private static Stream<Arguments> inputDegree() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 5}, 2), 
                Arguments.of(new int[]{1, 4, 0, 2}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("inputDegree")
    void testDegree(int[] coeff, int expected) {
        Poly poly = new Poly(coeff);
        assertEquals(expected, poly.degree(poly));
    }

    /**
     * Provides test cases for adding a term dynamically.
     */
    private static Stream<Arguments> inputAddTerm() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 5}, 4, new int[]{3, 2, 5, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("inputAddTerm")
    void testAddTerm(int[] coeff, int newTerm, int[] expected) {
        Poly poly = new Poly(coeff);
        poly.addTerm(newTerm);
        assertArrayEquals(expected, poly.coeff);
    }

    /**
     * Provides test cases for deleting a term dynamically.
     */
    private static Stream<Arguments> inputDeleteTerm() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 5}, new int[]{3, 2}),
                Arguments.of(new int[]{5}, new int[0])  // Single-term case should reset to {0}
        );
    }

    @ParameterizedTest
    @MethodSource("inputDeleteTerm")
    void testDeleteTerm(int[] coeff, int[] expected) {
        Poly poly = new Poly(coeff);
        poly.deleteTerm();
        assertArrayEquals(expected, poly.coeff);
    }
}


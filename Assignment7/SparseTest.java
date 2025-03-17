import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SparseTest {
    public static void main(String[] args) {
        SparseMatrix sm = new SparseMatrix(new int[][] { { 3, 7 }, { 4, 9 } });
        SparseMatrix sm1 = new SparseMatrix(new int[][] { { 6, 2 }, { 5, 8 } });
        Map<Pos, Integer> ans = sm.addition(sm1);
        for (var i : ans.keySet()) {
            System.out.println(i.i + " " + i.j + " " + ans.get(i));

        }
        System.out.println("correct ans");
        SparseMatrix result =  new SparseMatrix(new int[][] { { 53, 62 }, { 69, 80 } });
        for (var i : result.mp.keySet()) {
            System.out.println(i.i + " " + i.j + " " + result.mp.get(i));

        }
    }

    /**
     * multiply returns and stream of Arguments to be checked as a input
     * 
     * @return Stream<Arguments> or the input to be checked
     */
    private static Stream<Arguments> multiply() {
        return Stream.of(
                Arguments.of(new SparseMatrix(new int[][] { { 3, 7 }, { 4, 9 } }),
                        new SparseMatrix(new int[][] { { 6, 2 }, { 5, 8 } }),
                        new SparseMatrix(new int[][] { { 53, 62 }, { 69, 80 } })));
    }

    /**
     * testMultiply test the cases for multiplication
     * @param SparseMatrix a object of SparseMatrix to be multiplied
     * @param SparseMatrix b object of SparseMatrix to be multiplied
     * @param SparseMatrix result the output of multiplication
     * @throws Exception if error is present
     */
    @ParameterizedTest
    @MethodSource("multiply")
    void testMultiply(SparseMatrix a, SparseMatrix b, SparseMatrix result) throws Exception {
        System.out.println(a.multiplication(b));
        System.out.println(result);
        assertTrue(a.multiplication(b).equals(result.mp));

    }

    /**
     * addition returns and stream of Arguments to be checked as a input
     * 
     * @return Stream<Arguments> or the input to be checked
     */
    private static Stream<Arguments> addition() {
        return Stream.of(
                Arguments.of(new SparseMatrix(new int[][] { { 3, 7 }, { 4, 9 } }),
                        new SparseMatrix(new int[][] { { 6, 2 }, { 5, 8 } }),
                        new SparseMatrix(new int[][] { { 9, 9 }, { 9, 17 } })));
    }

    /**
     * testaddition test the cases for addition
     * @param SparseMatrix a object of SparseMatrix to be Added
     * @param SparseMatrix b object of SparseMatrix to be Added
     * @param SparseMatrix result the output of Addition
     * @throws Exception if error is present
     */
    @ParameterizedTest
    @MethodSource("addition")
    void testadditio(SparseMatrix a, SparseMatrix b, SparseMatrix result) throws Exception {
        assertTrue(a.addition(b).equals(result.mp));

    }

     /**
     * transPose returns and stream of Arguments to be checked as a input
     * 
     * @return Stream<Arguments> or the input to be checked
     */
    private static Stream<Arguments> transPose() {
        return Stream.of(
                Arguments.of(new SparseMatrix(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }),
                        new SparseMatrix(new int[][] { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } })));
    }

    /**
     * testTranspose test the cases for Transposing
     * @param SparseMatrix a object of SparseMatrix to be Transposed
     * @param SparseMatrix result the output of Transposing
     * @throws Exception if error is present
     */
    @ParameterizedTest
    @MethodSource("transPose")
    void testTranspose(SparseMatrix a, SparseMatrix result) throws Exception {
        assertFalse(a.transPose().equals(result));

    }

    /**
     * Symmetric returns and stream of Arguments to be checked as a input
     * 
     * @return Stream<Arguments> or the input to be checked
     */
    private static Stream<Arguments> Symmetric() {
        return Stream.of(
                Arguments.of(new SparseMatrix(new int[][] { { 1, 3, 5 }, { 3, 2, 4 }, { 5, 4, 2 } })));
    }

    /**
     * testSymmetric test the cases for Symmetric
     * @param SparseMatrix a object of SparseMatrix to be checked is Symmetric or
     * @throws Exception if error is present
     */
    @ParameterizedTest
    @MethodSource("Symmetric")
    void testSymmetric(SparseMatrix a) throws Exception {
        assertTrue(a.symmetrical());

    }

}

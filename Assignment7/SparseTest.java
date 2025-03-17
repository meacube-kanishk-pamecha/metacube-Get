import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.stream.Stream;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SparseTest {
    public static void main(String[] args) {
        SparseMatrix sm = new SparseMatrix(new int[][]{{3, 7},{4, 9}});
        SparseMatrix sm1 = new SparseMatrix(new int[][]{{6, 2},{5, 8}});
        HashMap<Pos,Integer> ans = sm.multiplication(sm1);
        for (var i : ans.keySet()) {
            System.out.println(i.i + " " +i.j + " " +ans.get(i));
            
        }
    }
    
    
        private static Stream<Arguments> multiply(){
            return Stream.of(
                    Arguments.of(new SparseMatrix(new int[][]{{3, 7},{4, 9}}),
                            new SparseMatrix(new int[][]{{6, 2}, {5, 8}}),
                            new SparseMatrix(new int[][]{{53, 62}, {69, 80}})) );
        }
    
        @ParameterizedTest
        @MethodSource("multiply")
        void testMultiply(SparseMatrix a , SparseMatrix b, SparseMatrix result) throws Exception{
            assertFalse(a.multiplication(b).equals(result));
            
        }
        private static Stream<Arguments> addition(){
            return Stream.of(
                    Arguments.of(new SparseMatrix(new int[][]{{3, 7},{4, 9}}),
                            new SparseMatrix(new int[][]{{6, 2}, {5, 8}}),
                            new SparseMatrix(new int[][]{{7, 9}, {9, 17}})) );
        }
    
        @ParameterizedTest
        @MethodSource("addition")
        void testadditio(SparseMatrix a , SparseMatrix b, SparseMatrix result) throws Exception{
            assertTrue(a.multiplication(b).equals(result));
            
        }


}

package Q3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class MolecularMassTest {
    /**
     * args() arguments to be passed in the function
     * @return Stream of Arduments which is to be feed.
     */
    private static Stream<Arguments> args(){
        return Stream.of(
                Arguments.of("CHOC(CH3)3", 86),
                Arguments.of("C(OH)2", 46),
                Arguments.of("CH3OH", 32),
                Arguments.of("H2O", 18)
                );
    }
    
    /**
     * testClass 
     * @param  String formula 
     * @param result
     */
    @ParameterizedTest
    @MethodSource("args")
    void testCalcMass(String formula, int result) {
        assertEquals(result, MolecularMass.molecularMass(formula));
    }

}
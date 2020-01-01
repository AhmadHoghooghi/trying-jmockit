package rootpackage;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SutClassTest {

    @Mocked Calculator calculator;

    @Test
    public void injectingOnFieldWorksProperly(){
        new Expectations(){{
            calculator.doVeryComplicatedCalculations(1,2);
            result = 3;
        }};
        SutClass sut = new SutClass(calculator);
        int result = sut.calculate(1, 2);
        assertThat(result, is(equalTo(3)));
        new Verifications(){{
            calculator.doVeryComplicatedCalculations(1,2); times = 1;
        }};
    }

    @Test
    public void injectingOnMethodArgumentWorksProperly(@Mocked Calculator argCalculator){
        new Expectations(){{
            argCalculator.doVeryComplicatedCalculations(1,2);
            result = 3;
        }};
        SutClass sut = new SutClass(argCalculator);
        int result = sut.calculate(1, 2);
        assertThat(result, is(equalTo(3)));
        new Verifications(){{
            argCalculator.doVeryComplicatedCalculations(1,2); times = 1;
        }};
    }
}

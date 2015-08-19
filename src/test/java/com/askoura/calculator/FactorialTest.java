package com.askoura.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class FactorialTest {
    
    private Factorial factorial = null;
    
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Before
    public void setup() {
        factorial = new Factorial();
    }
    

    @Test
    public void factorialOf1_returns1() throws Exception {
        // When
        int result = factorial.calculate(1);
        
        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void factorialOf2_returns2() throws Exception {
        // When
        int result = factorial.calculate(2);

        // Then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void factorialOf3_returns6() throws Exception {
        // When
        int result = factorial.calculate(3);

        // Then
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void factorialOf10_returns3628800() throws Exception {
        // When
        int result = factorial.calculate(10);

        // Then
        assertThat(result).isEqualTo(3628800);
    }

    @Test
    public void factorialOf0_returns1() throws Exception {
        // When
        int result = factorial.calculate(0);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void factorialOfminus1_exception() throws Exception {
        // When
        expectedException.expect(IllegalArgumentException.class);
        factorial.calculate(-1);

        // Then Exception
    }

    @Test
    public void factorialOfminus5_exception() throws Exception {
        // When
        expectedException.expect(IllegalArgumentException.class);
        factorial.calculate(-5);

        // Then Exception
    }
}

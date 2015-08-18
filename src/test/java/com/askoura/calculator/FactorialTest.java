package com.askoura.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FactorialTest {

    @Test
    public void factorialOf1_returns1() throws Exception {
        // Given
        Factorial factorial = new Factorial();

        // When
        int result = factorial.calculate(1);
        
        // Then
        assertThat(result).isEqualTo(1);
    }
}

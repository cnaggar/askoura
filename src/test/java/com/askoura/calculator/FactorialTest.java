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

    @Test
    public void factorialOf2_returns2() throws Exception {
        // Given
        Factorial factorial = new Factorial();

        // When
        int result = factorial.calculate(2);

        // Then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void factorialOf3_returns6() throws Exception {
        // Given
        Factorial factorial = new Factorial();

        // When
        int result = factorial.calculate(3);

        // Then
        assertThat(result).isEqualTo(6);
    }
}

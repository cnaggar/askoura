package com.askoura.calculator;

public class Factorial {

    public int calculate(int i) {
        int result = 1;

        if (i == -1) {
            throw new IllegalArgumentException();
        }
        
        for (int a=2; a<=i; a++)
            result *= a;
        
        return result;
    }
}

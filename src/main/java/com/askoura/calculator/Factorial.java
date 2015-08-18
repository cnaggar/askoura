package com.askoura.calculator;

public class Factorial {

    public int calculate(int i) {
        int result = 1;
        
        for (int a=2; a<=i; a++)
            result *= a;
        
        return result;
    }
}

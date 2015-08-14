package com.askoura.travis;


import static junit.framework.TestCase.assertTrue;

import org.junit.Test;



public class TravisCIVerifierTest {

    @Test
    public void returnWhatYouGet_givingTrue_expectingTrue() throws Exception {
        // Given
        TravisCIVerifier travisCIVerifier = new TravisCIVerifier();
        
        // When
        boolean result = travisCIVerifier.returnWhatYouGet(true);
        
        // Then
        assertTrue(result);
    }

    @Test
    public void thisIsAFailingTest() {
        assertTrue(false);
    }
}
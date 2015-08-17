package com.askoura.travis;

import static junit.framework.TestCase.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import com.askoura.travis.TravisCIVerifier;


public class TravisCIVerifierIntegrationTest {

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
    @Ignore
    public void thisIsAFailingTest() {
        assertTrue(false);
    }
}
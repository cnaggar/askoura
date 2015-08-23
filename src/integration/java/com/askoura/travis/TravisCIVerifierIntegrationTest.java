package com.askoura.travis;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

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
    public void onlyInIntegrationSum_1Plus2_return3() throws Exception {
        // Given
        TravisCIVerifier travisCIVerifier = new TravisCIVerifier();

        // When
        int sum = travisCIVerifier.onlyInIntegrationSum(1, 2);

        // Then
        assertThat(sum).isEqualTo(3);
    }

    @Test
    @Ignore
    public void thisIsAFailingTest() {
        assertTrue(false);
    }
}
package com.askoura.travis;


import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;


public class TravisCIVerifierTest {

    @Test
    public void returnWhatYouGet_givingTrue_expectingTrue() throws Exception {
        // Given
        TravisCIVerifier travisCIVerifier = new TravisCIVerifier(mock(JdbcTemplate.class));
        
        // When
        boolean result = travisCIVerifier.returnWhatYouGet(true);
        
        // Then
        assertTrue(result);
    }

//    @Test
//    @Ignore
//    public void thisIsAFailingTest() {
//        assertTrue(false);
//    }
}
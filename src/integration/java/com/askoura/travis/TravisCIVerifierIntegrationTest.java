package com.askoura.travis;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.askoura.helper.DBHelper;
import com.askoura.library.config.Persistence;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Persistence.class})
public class TravisCIVerifierIntegrationTest {

    @Autowired
    private JdbcTemplate jdbc;

    private DBHelper dbHelper = null;

    @Before
    public void initDbHelper() {
        dbHelper = new DBHelper(jdbc);
    }
    

    @Test
    public void returnWhatYouGet_givingTrue_expectingTrue() throws Exception {
        // Given
        TravisCIVerifier travisCIVerifier = new TravisCIVerifier(jdbc);
        
        // When
        boolean result = travisCIVerifier.returnWhatYouGet(true);
        
        // Then
        assertTrue(result);
    }

    @Test
    public void onlyInIntegrationSum_1Plus2_return3() throws Exception {
        // Given
        TravisCIVerifier travisCIVerifier = new TravisCIVerifier(jdbc);

        // When
        int sum = travisCIVerifier.onlyInIntegrationSum(1, 2);

        // Then
        assertThat(sum).isEqualTo(3);
    }

    @Test
    public void putSomeStuffInDb_getSomeStuffFromDB_inMemDBWorks() throws Exception {
        // Given
        TravisCIVerifier travisCIVerifier = new TravisCIVerifier(jdbc);

        // When
        travisCIVerifier.insertIntoTableA(1);
        travisCIVerifier.insertIntoTableA(2);

        // Then
        assertThat(dbHelper.getAllOfA()).containsExactly(1, 2);
    }
}
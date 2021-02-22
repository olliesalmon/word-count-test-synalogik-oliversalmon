package dao;

import dto.TextStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextStatsFileDaoImplTest {
    TextStatsFileDao testDao;

    @BeforeEach
    void setUp() {
        testDao = new TextStatsFileDaoImpl("testtextfiles/");
    }

    @Test
    void testGetListTextFiles() throws NonExistentTextFileException, MissingDirectoryException {
        List<String> expectedListTextFiles = new ArrayList<>();
        expectedListTextFiles.add("0testfile.txt");
        expectedListTextFiles.add("1emptyfile.txt");

        List<String> actualListTextFiles = testDao.getListTextFiles();

        assertEquals(expectedListTextFiles, actualListTextFiles, "actualList should be equal to the expectedList");
    }

    @Test
    void testLoadEmptyTextFileToArray() throws EmptyTextFileException {
        assertThrows(EmptyTextFileException.class, () -> testDao.loadTextFileToArray("1emptyfile.txt"),
            "The file is empty so the exception should be thrown" );

    }

    @Test
    void testLoadFilledTextFileToArray() throws FilePersistenceException, EmptyTextFileException {
        String[] expectedArray = {"Hello", "world", "&", "good", "morning.", "The", "date", "is", "18/05/2016"};

        String[] actualArray = testDao.loadTextFileToArray("0testfile.txt");

        assertTrue(Arrays.equals(expectedArray, actualArray), "The actualArray should be equal to the expectedArray");
    }

    @Test
    void testAnalyseTextArray() {
        TextStats expectedTextStats = new TextStats();
        expectedTextStats.setNoWords(9);
        expectedTextStats.putIntoWordLengthMap(1, 1);
        expectedTextStats.putIntoWordLengthMap(2, 1);
        expectedTextStats.putIntoWordLengthMap(3, 1);
        expectedTextStats.putIntoWordLengthMap(4, 2);
        expectedTextStats.putIntoWordLengthMap(5, 2);
        expectedTextStats.putIntoWordLengthMap(7, 1);
        expectedTextStats.putIntoWordLengthMap(10, 1);

        String[] expectedArray = {"Hello", "world", "&", "good", "morning.", "The", "date", "is", "18/05/2016"};

        TextStats actualTextStats = testDao.analyseTextArray(expectedArray);

        assertEquals(expectedTextStats, actualTextStats, "The actualTextStats should be equal the expectedTextStats");
    }

    @Test
    void testCalculateTextStats() {
        TextStats expectedTextStats = new TextStats();
        expectedTextStats.setNoWords(9);
        expectedTextStats.putIntoWordLengthMap(1, 1);
        expectedTextStats.putIntoWordLengthMap(2, 1);
        expectedTextStats.putIntoWordLengthMap(3, 1);
        expectedTextStats.putIntoWordLengthMap(4, 2);
        expectedTextStats.putIntoWordLengthMap(5, 2);
        expectedTextStats.putIntoWordLengthMap(7, 1);
        expectedTextStats.putIntoWordLengthMap(10, 1);

        expectedTextStats.setAverageLength(new BigDecimal("4.556"));

        List<Integer> expectedListMostFreq = new ArrayList<>();
        expectedListMostFreq.add(4);
        expectedListMostFreq.add(5);
        expectedTextStats.putIntoMostFreqLengthsMap(2, expectedListMostFreq);

        TextStats actualTextStats = new TextStats();
        actualTextStats.setNoWords(9);
        actualTextStats.putIntoWordLengthMap(1, 1);
        actualTextStats.putIntoWordLengthMap(2, 1);
        actualTextStats.putIntoWordLengthMap(3, 1);
        actualTextStats.putIntoWordLengthMap(4, 2);
        actualTextStats.putIntoWordLengthMap(5, 2);
        actualTextStats.putIntoWordLengthMap(7, 1);
        actualTextStats.putIntoWordLengthMap(10, 1);

        actualTextStats = testDao.calculateTextStats(actualTextStats);

        assertEquals(expectedTextStats, actualTextStats, "The actualTextStats should equal the expectedTextStats");
    }
}
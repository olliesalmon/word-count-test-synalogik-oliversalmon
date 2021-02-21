package dao;

import dto.TextStats;

import java.util.List;

public interface TextStatsFileDao {
    List<String> getListTextFiles() throws NonExistentTextFileException;

    void verifyTextFileNotEmpty(String textFileName) throws EmptyTextFileException;

    String[] loadTextFileToArray(String textFileName) throws FilePersistenceException;

    TextStats analyseTextArray(String[] textAsArray);

    TextStats calculateTextStats(TextStats textStatsToPopulate);
}

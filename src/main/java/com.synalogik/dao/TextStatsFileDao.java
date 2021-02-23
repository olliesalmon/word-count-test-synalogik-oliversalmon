package com.synalogik.dao;

import com.synalogik.dto.TextStats;

import java.util.List;

public interface TextStatsFileDao {
    List<String> getListTextFiles() throws NonExistentTextFileException, MissingDirectoryException;

    String[] loadTextFileToArray(String textFileName) throws FilePersistenceException, EmptyTextFileException;

    TextStats analyseTextArray(String[] textAsArray);

    TextStats calculateTextStats(TextStats textStatsToPopulate);
}
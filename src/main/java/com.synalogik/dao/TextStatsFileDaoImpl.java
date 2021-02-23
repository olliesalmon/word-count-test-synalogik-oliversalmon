package com.synalogik.dao;

import com.synalogik.dto.TextStats;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Component
public class TextStatsFileDaoImpl implements TextStatsFileDao {
    public final String TEXT_FILE_DIR;
    public final String DELIMITER = " ";

    public TextStatsFileDaoImpl() {
        TEXT_FILE_DIR = "textfiles/";
    }

    public TextStatsFileDaoImpl(String textFileDir) {
        TEXT_FILE_DIR = textFileDir;
    }

    @Override
    public List<String> getListTextFiles() throws NonExistentTextFileException, MissingDirectoryException {
        File dir = new File(TEXT_FILE_DIR);
        String[] textFilesArray = dir.list((dir1, name) -> name.toLowerCase().endsWith(".txt"));

        if (textFilesArray == null) {
            throw new MissingDirectoryException("The textfile directory is missing.");
        }
        if (textFilesArray.length == 0) {
            throw new NonExistentTextFileException("There are no text-files in the textfile directory.");
        }
        return new ArrayList<>(Arrays.asList(textFilesArray));
    }

    @Override
    public String[] loadTextFileToArray(String textFileName) throws FilePersistenceException, EmptyTextFileException {
        try {
            String textFileAsString = Files.readString(Path.of(TEXT_FILE_DIR + textFileName), StandardCharsets.US_ASCII);
            if (textFileAsString.isBlank()) {
                throw new EmptyTextFileException("The selected text-file is empty");
            }
            return textFileAsString.split(DELIMITER);
        } catch (IOException e) {
            throw new FilePersistenceException("Could not load text-file into memory");
        }
    }

    @Override
    public TextStats analyseTextArray(String[] textAsArray) {
        TextStats textStats = new TextStats();
        Pattern specialCharactersAnywhere = Pattern.compile("[ \\\\\"'/!@#&$%^*)(+=._-]");
        Pattern specialCharactersStartEnd = Pattern.compile("^[ \\\\\":;'/!@#&$%^*)(+=._-]|[ \\\\\"'/!@#&$%^*)(+=._-]$");

        Stream<String> streamArray = Arrays.stream(textAsArray);
        streamArray.forEach(currentString -> {
            //If currentString contains numbers - remove specials from start and end of string only.
            if (currentString.chars().anyMatch(Character::isDigit)) {
                currentString = currentString.replaceAll(specialCharactersStartEnd.pattern(), "");
            }
            // If no numbers and if string isn't "&", remove all special characters
            else if (!currentString.equals("&")) {
                currentString = currentString.replaceAll(specialCharactersAnywhere.pattern(), "");
            }
            //If string not empty, increment textStats accordingly.
            if (!currentString.isBlank()) {
                textStats.incrementWordLengthCount(currentString.length());
                textStats.setNoWords(textStats.getNoWords() + 1);
            }
        });
        return textStats;
    }

    @Override
    public TextStats calculateTextStats(TextStats textStatsToPopulate) {
        textStatsToPopulate.calculateAverageLength();
        textStatsToPopulate.calculateMostFreqLengths();
        return textStatsToPopulate;
    }
}
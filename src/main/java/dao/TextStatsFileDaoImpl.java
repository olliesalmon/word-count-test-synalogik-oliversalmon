package dao;

import dto.TextStats;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Component
public class TextStatsFileDaoImpl implements TextStatsFileDao {
    public final String TEXT_FILE_DIR;
    public final String DELIMITER = " ";

    public TextStatsFileDaoImpl() {
        TEXT_FILE_DIR = "/textfiles";
    }

    public TextStatsFileDaoImpl(String textFileDir) {
        TEXT_FILE_DIR = textFileDir;
    }

    @Override
    public List<String> getListTextFiles() throws NonExistentTextFileException, MissingDirectoryException {
        File dir = new File(TEXT_FILE_DIR);
        String[] textFilesArray = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });

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
            String[] textFileAsArray = textFileAsString.split(DELIMITER);
            return textFileAsArray;
        } catch (IOException e) {
            throw new FilePersistenceException("Could not load text-file into memory");
        }
    }

    //If word contains no letters
        //If word contains numbers and specials e.g."16/02.2011"
            //Remove specials from start and end. Count and increment
        //Else if word contains no specials (only numbers)
            //Count and increment
    //Else (word does contain letters)
        //Remove all specials. Count and increment.



    @Override
    public TextStats analyseTextArray(String[] textAsArray) {
        TextStats textStats = new TextStats();

        Stream<String> streamArray = Arrays.stream(textAsArray);
        streamArray.forEach(word -> {
            if (!word.matches("[A-Za-z]")) {
                if (word.matches("[0-9]") && word.matches("[!@#$%^&*)(+=._-]")) {
                    word.replaceAll("^[!@#$%^&*)(+=._-]$", "");
                    textStats.incrementWordLengthCount(word.length());
                }
            }

            //TODO
        });
        return null;
    }

    @Override
    public TextStats calculateTextStats(TextStats textStatsToPopulate) {
        textStatsToPopulate.calculateAverageLength();
        textStatsToPopulate.calculateMostFreqLengths();
        return textStatsToPopulate;
    }
}

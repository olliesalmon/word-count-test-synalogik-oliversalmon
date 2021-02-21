package dao;

import dto.TextStats;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TextStatsFileDaoImpl implements TextStatsFileDao{
    public final String TEXT_FILE_DIR;
    public final String DELIMITER = " ";

    public TextStatsFileDaoImpl() {
        TEXT_FILE_DIR = "/textfiles";
    }

    public TextStatsFileDaoImpl(String textFileDir) {
        TEXT_FILE_DIR = textFileDir;
    }

    @Override
    public List<String> getListTextFiles() throws NonExistentTextFileException {
        //TODO
        return null;
    }

    public void verifyTextFileNotEmpty(String textFileName) throws EmptyTextFileException {
        //TODO
    }

    @Override
    public String[] loadTextFileToArray(String textFileName) throws FilePersistenceException {
        //TODO
        return new String[0];
    }

    @Override
    public TextStats analyseTextArray(String[] textAsArray) {
        //TODO
        return null;
    }

    @Override
    public TextStats calculateTextStats(TextStats textStatsToPopulate) {
        //TODO
        return null;
    }
}

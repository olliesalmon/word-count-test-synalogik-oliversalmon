package com.synalogik.controller;

import com.synalogik.dao.*;
import com.synalogik.dto.TextStats;
import com.synalogik.ui.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Controller {
    private final int CONTINUE_SELECTION = 1;
    private final int QUIT_SELECTION = 0;
    private final View view;
    private final TextStatsFileDao dao;

    @Autowired
    public Controller(View view, TextStatsFileDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepRunning = true;
        int menuSelection;
        while (keepRunning) {
            try {
                menuSelection = view.displayMenuAndGetUserSelection();
                switch (menuSelection) {
                    case QUIT_SELECTION:
                        keepRunning = false;
                        break;
                    case CONTINUE_SELECTION:
                        String textFileName = getTextFileName();
                        TextStats analysedTextStats = analyseText(textFileName);
                        displayResults(analysedTextStats);
                        break;
                    default:
                        view.unknownCommand();
                }
            } catch (MissingDirectoryException | NonExistentTextFileException | EmptyTextFileException | FilePersistenceException e) {
                view.displayErrorMessage(e.getMessage());
            }
        }
        view.printGoodbyeMessage();
    }

    public String getTextFileName() throws MissingDirectoryException, NonExistentTextFileException {
        List<String> listTextFiles = dao.getListTextFiles();
        return view.displayTextFilesInDirAndGetUserSelection(listTextFiles);
    }

    public TextStats analyseText(String textFileName) throws EmptyTextFileException, FilePersistenceException {
        String[] textFileAsSplitArray = dao.loadTextFileToArray(textFileName);
        TextStats analysedTextStats = dao.analyseTextArray(textFileAsSplitArray);
        analysedTextStats = dao.calculateTextStats(analysedTextStats);
        return analysedTextStats;
    }

    public void displayResults(TextStats completeTextStats) {
        view.displayWordCount(completeTextStats.getNoWords());
        view.displayAverageLength(completeTextStats.getAverageLength());
        view.displayWordLengthMap(completeTextStats.getWordLengthCount());
        view.displayMostFreqWords(completeTextStats.getMostFreqLengths());
        view.pressEnterToContinue();
    }
}
package com.synalogik.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Component
public class View {
    private final UserIO io;

    @Autowired
    public View(UserIO io) {
        this.io = io;
    }

    public int displayMenuAndGetUserSelection() {
        io.print("===== Text File Analysis Program =====");
        io.print("Select from one of the two options:");
        io.print("1 - Analyse text file");
        io.print("0 - Exit Program");
        return io.readInt("Enter the number of your selection and press enter:");
    }

    public String displayTextFilesInDirAndGetUserSelection(List<String> listTextFilesInDir) {
        int i = 1;
        for (String currentFile : listTextFilesInDir) {
            io.print(i + " - " + currentFile);
            i++;
        }
        int selection = io.readInt("Enter the number of your selection and press enter:", 1, listTextFilesInDir.size());
        return listTextFilesInDir.get(selection - 1);
    }

    public void displayWordCount(int noWords) {
        io.print("Word count = " + noWords);
    }

    public void displayAverageLength(BigDecimal averageLength) {
        io.print("Average word length = " + averageLength);
    }

    public void displayWordLengthMap(Map<Integer, Integer> wordLengthCount) {
        for (Map.Entry<Integer, Integer> currentEntry : wordLengthCount.entrySet()) {
            io.print("Number of words of length " + currentEntry.getKey() + " is " + currentEntry.getValue());
        }
    }

    public void displayMostFreqWords(Map<Integer, List<Integer>> mostFreqLengths) {
        for (Map.Entry<Integer, List<Integer>> currentEntry : mostFreqLengths.entrySet()) {
            io.print("The word length(s) that occur most frequently is/are " + currentEntry.getValue() + ", which occurred " + currentEntry.getKey() + " times.");
        }
    }

    public void pressEnterToContinue() {
        io.readString("Press enter to continue:");
    }

    public void displayErrorMessage(String errorMessage) {
        io.print(errorMessage);
        pressEnterToContinue();
    }

    public void unknownCommand() {
        io.print("Unknown command, please enter one of the options");
    }

    public void printGoodbyeMessage() {
        io.print("Thank you for using this program, goodbye.");
    }
}

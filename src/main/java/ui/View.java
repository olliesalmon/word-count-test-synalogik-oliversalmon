package ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class View {
    private final UserIO io;

    @Autowired
    public View(UserIO io) {
        this.io = io;
    }

    public void displayStartBanner() {
        //TODO
    }

    public void displayContinueOrQuit() {
        //TODO
    }

    public int getUserChoiceContinueOrQuit() {
        //TODO
        return 0;
    }

    public void displayTextFilesInDir() {
        //TODO
    }

    public String getUserChoiceTextFile() {
        //TODO
        return null;
    }

    public void displayWordCount() {
        //TODO
    }

    public void displayAverageLength() {
        //TODO
    }

    public void displayWordLengthMap() {
        //TODO
    }

    public void displayMostFreqWords() {
        //TODO
    }
}

package controller;

import dao.TextStatsFileDao;
import dto.TextStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ui.View;

@Component
public class Controller {
    private final int YES_SELECTION = 1;
    private final int NO_SELECTION = 2;
    private final View view;
    private final TextStatsFileDao dao;

    @Autowired
    public Controller(View view, TextStatsFileDao dao) {
        this.view = view;
        this.dao = dao;
    }
    public void run() {
        //TODO
    }

    public String getTextFileName() {
        //TODO
        return null;
    }

    public TextStats analyseText() {
        //TODO
        return null;
    }

    public void displayResults() {
        //TODO
    }
}

package dto;

import java.util.*;

public class TextStats {
    private int noWords;
    private final Map<Integer, Integer> wordLengthCount;
    private float averageLength;
    private final Map<Integer, List<Integer>> mostFreqLengths;

    public TextStats() {
        noWords = 0;
        wordLengthCount = new HashMap<>();
        averageLength = 0;
        mostFreqLengths = new HashMap<>();
    }

    void incrementWordLengthCount(int wordLengthToIncrement) {
        //TODO
    }

    void calculateAverageLength() {
        //TODO
    }

    void calculateMostFreqLengths() {
        //TODO
    }

    public int getNoWords() {
        return noWords;
    }

    public void setNoWords(int noWords) {
        this.noWords = noWords;
    }

    public float getAverageLength() {
        return averageLength;
    }

    public void setAverageLength(float averageLength) {
        this.averageLength = averageLength;
    }

    public Map<Integer, Integer> getWordLengthCount() {
        return wordLengthCount;
    }

    public Map<Integer, List<Integer>> getMostFreqLengths() {
        return mostFreqLengths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextStats textStats = (TextStats) o;
        return noWords == textStats.noWords &&
                Float.compare(textStats.averageLength, averageLength) == 0 &&
                Objects.equals(wordLengthCount, textStats.wordLengthCount) &&
                Objects.equals(mostFreqLengths, textStats.mostFreqLengths);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noWords, wordLengthCount, averageLength, mostFreqLengths);
    }
}

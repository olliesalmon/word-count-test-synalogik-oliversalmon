package dto;

import java.math.BigDecimal;
import java.util.*;

public class TextStats {
    private int noWords;
    private final Map<Integer, Integer> wordLengthCount;
    private BigDecimal averageLength;
    private final Map<Integer, List<Integer>> mostFreqLengths;

    public TextStats() {
        noWords = 0;
        wordLengthCount = new HashMap<>();
        averageLength = new BigDecimal("0");
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

    public void putIntoWordLengthMap(int key, int value) {
        wordLengthCount.put(key, value);
    }

    public void putIntoMostFreqLengthsMap(int countMostFreq, List<Integer> listMostFreq) {
        mostFreqLengths.put(countMostFreq, listMostFreq);
    }

    public int getNoWords() {
        return noWords;
    }

    public void setNoWords(int noWords) {
        this.noWords = noWords;
    }

    public BigDecimal getAverageLength() {
        return averageLength;
    }

    public void setAverageLength(BigDecimal averageLength) {
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
                wordLengthCount.equals(textStats.wordLengthCount) &&
                averageLength.equals(textStats.averageLength) &&
                mostFreqLengths.equals(textStats.mostFreqLengths);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noWords, wordLengthCount, averageLength, mostFreqLengths);
    }
}

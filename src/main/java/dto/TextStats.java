package dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

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

    public void incrementWordLengthCount(int wordLengthToIncrement) {
        wordLengthCount.merge(wordLengthToIncrement, 1, Integer::sum);
    }

    public void calculateAverageLength() {
        final int[] sumLetters = {0};
        wordLengthCount.forEach((k, v) -> sumLetters[0] += k * v);
        averageLength = new BigDecimal(String.valueOf(sumLetters[0])).divide(new BigDecimal(String.valueOf(noWords)), 3, RoundingMode.HALF_UP);
    }

    public void calculateMostFreqLengths() {
        int max = Collections.max(wordLengthCount.values());
        List<Integer> listMostFreq = wordLengthCount.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        mostFreqLengths.put(max, listMostFreq);
    }

    public void putIntoWordLengthMap(int key, int value) {
        wordLengthCount.put(key, value);
    }

    public void putIntoMostFreqLengthsMap(int countMostFreq, List<Integer> listMostFreq) {
        mostFreqLengths.put(countMostFreq, listMostFreq);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextStats)) return false;
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
}

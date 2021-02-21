Synalogik Programming Test - Text analysis
======

## Problem Specification

Please write in Java an API to read the contents of a plain text file and enable the display of the total number of words, the average word length, the most frequently occurring word length and a list of the number of words of each length.

Submit your code along with unit tests and maven POM file, in a zip file via email along with instructions for its installation and use along with any assumptions you have made about what defines a word (using as a basis the rules that can be deduced from the example below) 

For example given a file that contains the following text:

	Hello world & good morning. The date is 18/05/2016

We would expect the following output:

Word count = 9
Average word length = 4.556
Number of words of length 1 is 1
Number of words of length 2 is 1
Number of words of length 3 is 1
Number of words of length 4 is 2
Number of words of length 5 is 2
Number of words of length 7 is 1
Number of words of length 10 is 1
The most frequently occurring word length is 2, for word lengths of 4 & 5

Note that we will test code submissions on a number of files of various lengths ranging from the above example through to the large books such as the Bible (http://janelwashere.com/files/bible_daily.txt).

Clue – Do not forget to consider formatted numbers.


## Plan

CONTROLLER:
	void run();
	String getTextFileName();
	TextStats analyseText();
	void displayResults();
	
DTO:
	TextStats:
		private int noWords;					Getter/Setter
		private HashMap<Integerint> wordLengthCount;		Getter
		private float averageLength;				Getter/Setter
		private HashMap<Integer, List<int>> mostFreqLengths;	Getter

		void incrementWordLengthCount(int wordLengthToIncrement);
		void calculateAverageLength();
		void calculateMostFreqLengths();

DAO:
	List(String) getListTextFiles();
	String[] loadTextFile(String);
	TextStats analyseTextArray(String[] textAsArray)
	TextStats calculateTextStats(TextStats textInfoToPopulate);

VIEW:
	void displayStartBanner();
	int displayContinueOrQuitMenuAndGetUserSelection();
	String displayTextFilesAndGetUserSelection(List(String));
	void displayWordCount();
	void displayAverageLength();
	void displayWordLengthMap();
	








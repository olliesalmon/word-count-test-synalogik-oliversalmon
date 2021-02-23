Synalogik Programming Test - Text analysis - Oliver Salmon
======
## Instructions, assumptions and notes
### Instructions

- In the root directory should exist two required directories: "textfiles/" and "testtextfiles/".
- Please place your text files to analyse in the "textfiles/" directory. The "testtextfiles/" directory and files inside are required for unit tests.
- The program has been packaged into an executable .jar file, which can be found in the projects root directory. To run, extract the project files to your computer, direct your computers command line teriminal to the project directory and execute by using the command "java -jar word-count-test.jar".
- Alternatively, the program can also be ran by opening the project in an IDE and running the App class.

### Assumptions

- Strings of only special characters (e.g. " - ") do not count as a word. The exception to this is the "&" character.
- Other punctuation and special characters do not count towards a words letter count (e.g. full-stops, hyphens-beteen-words, speech marks, etc).
- Formatted numbers are accepted as words, with a range of special characters (e.g. "/", "-", etc) on the inside of the string. Special characters at the start and end of formatted numbers still do not count towards letter count.
- Similarly, special characters inside strings containing both letters and numbers (e.g. H-2O) will count towards the letter count, but those at the string's start and end will not.

### Notes:
- Exceptions will be thrown in the case of the:
	- "textfiles/" directory is missing.
	- "textfiles/" directory does not contain any text files.
	- The selected text file is empty or unreadable. 

- The program sometimes yields slightly different results when compared with other word processors (e.g Microsoft Word). This is due to the assumptions of what constitutes as a word (e.g. Word accepts strings of special characters as a word (e.g. "*****" or " - ")).

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

	TreeMap<Integer, Integer> wordLengthCount; (Getter)
	HashMap<Integer, List<int>> mostFreqLengths;	(Getter)
	int noWords; (Getter/Setter)
	BigDecimal averageLength; (Getter/Setter)


	void incrementWordLengthCount(int wordLengthToIncrement);
	void calculateAverageLength();
	void calculateMostFreqLengths();

DAO:

	List(String) getListTextFiles();
	void verifyTextFileNotEmpty();
	String[] loadTextFileToArray(String);
	TextStats analyseTextArray(String[] textAsArray)
	TextStats calculateTextStats(TextStats textInfoToPopulate);

VIEW:

	int displayMenuAndGetUserSelection();
	String displayTextFilesAndGetUserSelection(List(String));
	void displayWordCount();
	void displayAverageLength();
	void displayWordLengthMap();
	void displayMostFreqWords();
	void displayErrorMessage();
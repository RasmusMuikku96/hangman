package Hangman.Assignment.hangmanW2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App{
	
	private static final Scanner SCANNER = new Scanner(System.in);
	private static StringBuilder guessedCharacters;
	private static int guessCount = 0;
	private static String selectedWord;
	private static char[] arrayWord;
	 
    public static void main(String[] args) throws IOException{
    	
    	
		//TODO Remove when finished
    	//System.out.println(selectedWord);
    	
    	boolean doContinue = true;
    	boolean runOnce = true;
    	
    	while (guessCount <= 10 || doContinue == true){
    		
    		do{
    	    	guessCount = 0;
    			selectedWord = makeRandomWordFromList();
    			arrayWord = new char[selectedWord.length()];
    			arrayWord = fillUnderline(arrayWord, selectedWord);
    			guessedCharacters = new StringBuilder();
    			runOnce = false;
    		}while(runOnce);
    		
			System.out.println("Guess any letter or try to guess the whole word");
			String guess = SCANNER.nextLine().toLowerCase();

			guessHandler(guess);
			
			
			
			
//			
//			
//			if(guess.length() > 1 && guess.equals(selectedWord)){
//				doContinue = guessCompleteWordWin(guessCount);
//				
////				doContinue = false;
////				System.out.println("You won! You guessed the word!");
////				guessCount++;
////				System.out.println("You won after " + guessCount + " guesses");
//			
//			}else if(guess.length() > 1 && !guess.equals(selectedWord)){
//				System.out.println("That was not the word");
//				guessCount++;
//				
//			//}else if(guess.length() == 1){
//				
//				
//				
//				
//			}else if(guess.length() == 1){
//				if(guessIsChar(guess)){
//					
//					
//				}
//				
//				PrintAddGuessedSoFar(arrayWord, guess);
//				fillWord(guess, arrayWord, selectedWord);
//				guessedCharacters.append(guess);
//				guessCount++;
////				guessedCharacters.append(guess);
////				fillWord(guess, arrayWord, selectedWord);
////				System.out.println(arrayWord);
////				System.out.println("You have guessed so far: " + guessedCharacters);
//			}else{
//				System.out.println("default");
//				
			}
			
			System.out.println("Continue? Y/N");
			String menu = SCANNER.nextLine().toLowerCase();
			
			if(menu.equalsIgnoreCase("y")){
				doContinue = true;
			}else{
				System.out.println("Exiting");
				doContinue = false;
			}
				
			
    	}
	
    	
    
    public static String guessHandler(String guess){
    	if(guess.length() > 1 && guess.equals(selectedWord)){
    		addToGuess();
    		return guessCompleteWordWin(guessCount);
    	
    	}else if(guess.length() > 1){
    		singleHandler(guess);
    	
    	}
		return selectedWord;
    	
    	
    }
    
    public static void singleHandler(String guess){
    	boolean existsInArray = false;
    	if(guess.length() == 1){
    		existsInArray = guessHaveBeenGuessed(guess);
    	}
    	
    	if(existsInArray = true){
    		System.out.println("Already guessed this letter.");
    	}else if(existsInArray = true){
    		guessLengthEqualsOneCharacter(guess);
    	}
    		
    }
		//return selectedWord;
    
    
    public static String guessIsWord(String guess){
    	
		return guess;
    	
    }
    
    
    
    public static boolean guessHaveBeenGuessed(String guess){
    	for(int i = 0; i < guessedCharacters.length(); i++){
    		if(guessedCharacters.charAt(i) == guess.charAt(0)){
    			return true;
    		}
    	}
    	return false;
    	
    }
    
    
    
    public static void PrintAddGuessedSoFar(){
    	System.out.println(arrayWord);
    	System.out.println("You have guessed so far: " + guessedCharacters);
    }
    
    public static void guessLengthEqualsOneCharacter(String guess){
    	guessedCharacters.append(guess);
    	fillWord(guess, arrayWord, selectedWord);
    	System.out.println(arrayWord);
    	System.out.println("You have guessed so far: " + guessedCharacters);
    }
    
    public static String guessCompleteWordWin(int guessCount){
		return ("You won in " + guessCount + "! You guessed the word!");
    }
	

    
    
    public static String makeRandomWordFromList() throws IOException{
    	ArrayList<String> hangmanList = new ArrayList<String>();
    	int listIndexAmount = 0;
    	try (BufferedReader br = new BufferedReader(new FileReader("Resources"))) {
            while (br.ready()) {
            	hangmanList.add(br.readLine());
            	listIndexAmount++;
            }
    	}
    	String selectedWord = returnRandomFromList(hangmanList,listIndexAmount).toLowerCase();
    	
        return selectedWord;
    }
    
    public static String returnRandomFromList(ArrayList<String> hangmanList, int listIndexAmount) {
      	int index = ThreadLocalRandom.current().nextInt(listIndexAmount);
        String element = hangmanList.get(index);
        return element;
    }
    
    

    
    public static char[] fillWord(String guess, char[] arrayWord, String selectedWord) {
    	char letter = guess.charAt(0);
		for(int i=0; i < selectedWord.length(); i++) {
			if(selectedWord.charAt(i) == letter) {
				arrayWord[i] = letter;
			}
		}
		return arrayWord;
	}

    public static char[] fillUnderline(char[] arrayWord, String selectedWord) {
    	//String hiddenWord = selectedWord
    	//char[] arrayWord = new char[length];
    	for(int i = 0; i < selectedWord.length(); i++){
    		arrayWord[i] = '-';
    	}
    	return arrayWord;
    }
    
    public static void addToGuess(){
    	guessCount = guessCount + 1;
    }
    
//    
//    
//    
//    
//    public static char[] makeArrayOfWord(String selectedWord) {
//    	char strArray[] = selectedWord.toCharArray(); // = selectedWord.split(" ");
//		return strArray;
//    }
//   
//    public static char[] makeHiddenFromSelectedWord(String selectedWord, int length) {
//    	//String hiddenWord = selectedWord
//    	char[] arrayWord = new char[length];
//    	String hiddenWord;
//    		for(int i = 0; i < length; i++){
//    			arrayWord[i] = '_';
//    		}
//    	return arrayWord;
//    }
//    
//    
//    
}

    //public static char[] replace(char guess, char[] arrayWord, char[] hiddenWord) {
    	
//    	char[] replaceString = hiddenWord.replace('_', guess.charAt(0)));
//        //String rs = str.replace("h","s"); // Replace 'h' with 's'  
//        System.out.println(rs);  
//        rs = rs.replace("s","h"); // Replace 's' with 'h'  
//        System.out.println(rs);
//		return arg2;
//    }  

//String c = SCANNER.nextLine();
//String replaceString=s1.replace("is","was");
//StringBuilder builder = new StringBuilder(charAtZero);

//String[] arrayWord = new String[length];
//System.out.println(length);
//.equalsIgnoreCase();
//String string = selectedWord.equalsIgnoreCase();


//Pattern.compile(Pattern.quote(wantedStr), Pattern.CASE_INSENSITIVE).matcher(source).find();
//boolean doContinue = true;

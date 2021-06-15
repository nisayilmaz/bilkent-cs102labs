

public class Hangman {
    // Properties
    private StringBuffer secretWord;
    private StringBuffer allLetters;
    private StringBuffer usedLetters;
    private StringBuffer knownSoFar;
    private int numberOfIncorrectTries;
    private int maxAllowedIncorrectTries;
    private String[] wordList = {"computer", "science", "bilkent", "project", "homework"};

    public Hangman() {
        secretWord = new StringBuffer(chooseSecretWord());
        allLetters = new StringBuffer( "ABCDEFGHIJKLMNOPQRSTUVWXYZ" );
        usedLetters = new StringBuffer();
        numberOfIncorrectTries = 0;


        
        /* It can be a good idea to get the maximum number of incorrect tries from the parameter (as input). 
         * However, in the prompt the defualt was defined as 6. Thus we initialized it as 6.
        */ 
        maxAllowedIncorrectTries = 6;

        // We initialized the knownSoFar’s capacity according to the secret word’s.
        knownSoFar = new StringBuffer( secretWord.capacity() );  
        for (int i = 0; i < secretWord.length(); i++) {
            knownSoFar.append("*");
        }	
    }    

    // Methods

    /**
     * Checks if the given letter is contained by the secret word and increments
     * the number of incorrect tries if necessary
     * @param letter The letter to try
     * @return times the letter was used in the secret word if the 
     * letter was never tried before, otherwise, {@code -1}
     */
    public int tryThis(char letter) {
    	int counter;

        if(isGameOver())
            return -3;
        


        if (usedLetters.indexOf(letter + "") == -1) { // If the letter is not already used

            counter = 0;
    	    for ( int i = 0; i < this.secretWord.length(); i++ ) {
    	    	if ( this.secretWord.charAt(i) == letter ) {
    	    		counter++;
                    knownSoFar.setCharAt(i, letter);
    	    	} 
    	    }

        	usedLetters.append(letter);

        	if (counter == 0) {
        		numberOfIncorrectTries++;
        	}

            return counter;
        } 
        else {
            return -2;
        }
    }
    
        /** 
 * This method chooses a random secret word from a fixed list.
 * 
 * @apiNote
 * The fixed list in this instance was an instance variable of the Hangman class,
 * typed as an arraylist for the sake of flexibility. The method's body should be
 * adjusted accordingly to the origin of the fixed list in other implementations.
*/
private String chooseSecretWord() {

    String word = this.wordList[(int) (Math.random() * wordList.length)]; // If necessary, change the .get() method to match the fixed list's convention
    return word;
    
}

    //Methods
    public String getAllLetters() {
    
        return allLetters.toString();
    }
    
    
    public String getUsedLetters() {
        
        return usedLetters.toString();
    }
    
    
    public int getNumOfIncorrectTries() {
        
        return numberOfIncorrectTries;
    }
    
    
    public int getMaxAllowedIncorrectTries() {
        
        return maxAllowedIncorrectTries;
    }
    
    
    public String getKnownSoFar() {
        return knownSoFar.toString();
    }
    
    public boolean isGameOver() {
        boolean answer;
        answer = false;
        if(this.hasLost()){

            answer = true;
        }
        if ( (getKnownSoFar()).equals(String.valueOf(secretWord))) {
            answer = true;
        }
        return answer;
        

    }
    
    public boolean hasLost() {
        
        return (numberOfIncorrectTries >= maxAllowedIncorrectTries);
    }


}
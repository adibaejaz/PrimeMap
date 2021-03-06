public class Anagrams{

    final static int MIN_ASCII = 33; final static int MAX_ASCII = 126;
    Character[] asciiArray;
    PrimeMap<Character> asciiMap;

    public Anagrams(){
        asciiArray = new Character[MAX_ASCII - MIN_ASCII + 1];
        for (int i = MIN_ASCII; i <= MAX_ASCII; i++){
            asciiArray[i - MIN_ASCII] = (char) i;
        }
        asciiMap = new PrimeMap<Character>(asciiArray);
    }

    public boolean areAnagrams(String firstWord, String secondWord){
        if (firstWord.length() != secondWord.length()) return false;
        int firstProduct = 1; int secondProduct = 1;
        for (int i = 0; i < firstWord.length(); i++){
            firstProduct *= asciiMap.getPrime(firstWord.charAt(i));
            secondProduct *= asciiMap.getPrime(secondWord.charAt(i));
        }
        if (firstProduct == secondProduct) return true;
        return false;
    }

    public static void main(String[] args){
        Anagrams AnagramChecker = new Anagrams();
        boolean good = true;
        for (int i = 0; i < args.length - 1; i++){
            if(!AnagramChecker.areAnagrams(args[i], args[i+1])){
                System.out.println(args[i] + " and " + args[i+1]+ " are not anagrams");
                good = false;
                break;
            }
        }
        if (good)
            System.out.println("All entered words are anagrams");
    }
}
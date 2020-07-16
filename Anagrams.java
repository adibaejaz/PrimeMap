import java.util.Scanner;
public class Anagrams{

    final static int MIN_ASCII = 33; final static int MAX_ASCII = 126;
    Character[] asciiArray;
    PrimeMap asciiMap;

    public Anagrams(){
        asciiArray = new Character[MAX_ASCII - MIN_ASCII + 1];
        for (int i = MIN_ASCII; i <= MAX_ASCII; i++){
            asciiArray[i - MIN_ASCII] = (char) i;
        }
        asciiMap = new PrimeMap(asciiArray);
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
        /*
        Scanner input = new Scanner(System.in);
        System.out.println("enter first word:");
        String firstWord = input.nextLine();
        System.out.println("enter second word:");
        String secondWord = input.nextLine();
        if (AnagramChecker.areAnagrams(firstWord, secondWord)){
            System.out.println(firstWord + " and " + secondWord + " are anagrams");
        } else{
            System.out.println(firstWord + " and " + secondWord + " are not anagrams");
        }
        */
        String firstWord = args[0]; String secondWord = args[1];
        if (AnagramChecker.areAnagrams(firstWord, secondWord)){
            System.out.println(firstWord + " and " + secondWord + " are anagrams");
        } else{
            System.out.println(firstWord + " and " + secondWord + " are not anagrams");
        }
    }
}
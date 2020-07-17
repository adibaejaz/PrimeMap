import java.util.HashMap;

public class PrimeMap<AnyType> {

    HashMap<AnyType, Integer> primeMap;
    private int[] primes;

    public PrimeMap(){
        primeMap = null;
        primes = null;

    }
    
    public PrimeMap(int size){
        primeMap = new HashMap<AnyType, Integer>();
        this.primes = new int[size];
        fillPrimes(this.primes);
    } 

    public PrimeMap(AnyType[] array){
        primeMap = new HashMap<AnyType, Integer>();
        this.primes = new int[array.length];
        fillPrimes(this.primes);
        int counter = 0;
        for (AnyType item : array) {
            primeMap.put(item, this.primes[counter++]);
        }
    }

    public void fillPrimes(int[] primes){
        int counter = 0;
        for (int i = 2; counter < primes.length; i ++){
            if (isPrime(i)){
                primes[counter++] = i;
            }
        }
    }

    public boolean isPrime(int number){

        if (number == 0 || number == 1) return false;
        if (number == 2) return true;
        for (int i = 2; i <= Math.sqrt(number); i ++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public int getPrime(AnyType c){
        return primeMap.get(c);
    }
    
}
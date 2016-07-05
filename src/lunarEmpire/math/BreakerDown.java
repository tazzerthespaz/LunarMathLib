package lunarEmpire.math;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that creates the Prime factorization of a number.
 * @author Malcolm Boyd
 */

public class BreakerDown {
	private int input;
	private Map<Integer,Integer> dictionary;
	
	/**
	 *Constructor populates fields and creates the prime factorization.
	 *<p>After creating the object call getDictionary() to get the Map
	 * @param input
	 */
	public BreakerDown(int input){
		this.input = input;
		//this.dictionary = new PrimeDict(input).getDict();
        this.dictionary = new HashMap<Integer, Integer>();
		breakDown();
	}
	
	private void breakDown() {
		int runningNum = getInput();
		//The loop that actually does the breakdown
        PrimeDict pd = new PrimeDict(runningNum);
		while(runningNum != 1){
            int primeNum = pd.nextPrime();
            if(canFactor(runningNum, primeNum)) {
                pd.resetPrime();
                if(keyInDict(primeNum)) {
                    dictionary.put(primeNum, dictionary.get(primeNum) + 1);    
                } else {
                    dictionary.put(primeNum, 1);
                }
                runningNum /= primeNum;
            }
		}
	}

    private boolean keyInDict(int target) {
        for(int key : dictionary.keySet()) {
            if(key == target) {
                return true;
            }
        }
        return false;
    }
	
	private boolean canFactor(int number, int potFactor){
		if(number % potFactor == 0){
			return true;
		}else{
			return false;
		}
	}

	public boolean isPrime(int number){
		boolean isPrime = (new BigInteger(Integer.toString(number))).isProbablePrime(32);
		return isPrime;
		
	}

	/**
	 * Return the prime factorization map.
	 * @return Map<Integer,Integer> The prime factorization map
	 */
	
	public Map<Integer,Integer> getDictionary(){
		return this.dictionary;
	}
	
	/**
	 * Return the number the class is breaking down.
	 * @return input The number that the class is breaking down
	 */
	public int getInput(){
		return this.input;
	}
}

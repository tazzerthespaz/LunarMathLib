package lunarEmpire.math;

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
		this.dictionary = new PrimeDict(input).getDict();
		breakDown();
	}
	
	private void breakDown(){
		int runningNum = getInput();
		//The loop that actually does the breakdown
		while(runningNum != 1){
			for(int key : dictionary.keySet()){
				//Thoughts: do i need the is prime? if it were prime wouldn't it jjust get tallied any way 
				//then it would be properly represented in the hashtable
				
				/*
				if(!isPrime(runningNum)){
					break;
				}
				*/
				
				//can you factor out the key from the running number?
				if(canFactor(runningNum,key)){
					//yes, add a tally to the HashMap per the respective key
					runningNum = runningNum / key;
					dictionary.put(key,dictionary.get(key) + 1);
					break;
					
				}else{
					//you can't factor it out, just keep going
					continue;
				}
			}
		}
	}
	
	private boolean canFactor(int number, int potFactor){
		if(number % potFactor == 0){
			return true;
		}else{
			return false;
		}
	}
	/* Doubt that I need this method
	private boolean isPrime(int number){
		boolean isPrime = (new BigInteger(Integer.toString(number))).isProbablePrime(32);
		return isPrime;
		
	}
	*/
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

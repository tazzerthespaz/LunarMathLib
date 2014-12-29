package lunarEmpire.math.Radical;

import java.util.Map;

public class BreakerDown {
	private int input;
	private Map<Integer,Integer> dictionary;
	
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
	
	public Map<Integer,Integer> getDictionary(){
		return this.dictionary;
	}
	
	public int getInput(){
		return this.input;
	}
}

package lunarEmpire.math.radical;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class PrimeDict {
	//this class will take an input and return a hashmap of primes up to half that number
	private int topNum;
	private Map<Integer,Integer> dict = new HashMap<Integer,Integer>();
	
	PrimeDict(int number){
		this.setTopNum(number);
		createHashMap();
	}
	
	private void createHashMap(){
		//This loop creates the hashmap of primes up to half of the topNum
		for(int i = 0;i <= this.topNum/2; i++){
			boolean isPrime = (new BigInteger(Integer.toString(i))).isProbablePrime(32);
			if(isPrime) {
				this.dict.put(i,0);
			}else{
				continue;
			}
		}
	}
	
	public Map<Integer,Integer> getDict(){
		return this.dict;
	}

	public void setTopNum(int value){
		this.topNum = value;
	}
}

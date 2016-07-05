package lunarEmpire.math;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that creates a list of primes up to a specified number.
 * @author Malcolm Boyd
 *
 */

public class PrimeDict {
	//this class will take an input and return a hashmap of primes up to that number
	private int topNum;
	private Map<Integer,Integer> dict = new HashMap<Integer,Integer>();
    private int lastNum;
	
	/**
	 * The constructor takes the number you want a hash map up to and creates the hashmap
	 * @param number The maximum number in the HashMap
	 */
	public PrimeDict(int number){
		this.setTopNum(number);
        this.lastNum = 1;
		//createHashMap();
	}
	
	private void createHashMap(){
		//This loop creates the hashmap of primes up to half of the topNum
		for(int i = 0;i <= this.topNum; i++){
			boolean isPrime = (new BigInteger(Integer.toString(i))).isProbablePrime(32);
			if(isPrime) {
				this.dict.put(i,0);
			}else{
				continue;
			}
		}
	}

    /**
     * Method that returns the next largest prime after the argument.
     *
     * @param previousPrime
     * @return int The next largest prime. -1 if there isn't another prime.
     **/
    public static int nextPrime(int prevPrime, int targetNum) {
        for(int i = prevPrime + 1; i <= targetNum; i++) {
			boolean isPrime = (new BigInteger(Integer.toString(i))).isProbablePrime(32);
            if(isPrime) {
                return i;
            }
        }
        return -1;
    }

    public int nextPrime() {
        for(int i = lastNum + 1; i <= this.topNum; i++) {
			boolean isPrime = (new BigInteger(Integer.toString(i))).isProbablePrime(32);
            if(isPrime) {
                this.lastNum = i;
                return i;
            }
        }
        return -1;
    }

    public void resetPrime() {
        this.lastNum = 1;
    }
	
	/**
	 * Returns a HashMap of primes up to the specified number.
	 * @return Map<Integer, Integer> The list of primes up to a specified number.
	 */
	public Map<Integer,Integer> getDict(){
		return this.dict;
	}

	private void setTopNum(int value){
		this.topNum = value;
	}
}

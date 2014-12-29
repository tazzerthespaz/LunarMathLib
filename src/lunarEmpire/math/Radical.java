package lunarEmpire.math;

import java.util.Map;

/**
 * The class that simplifies all radicals.
 * <p>
 * Class takes input as an inner number, outter number, and an index where it simplifies these numbers in the constructor.
 * To use the class create a new instance and call the getSimpInNum() and getSimpOutNum() methods which will return the simplified
 * values of the radical. 
 * 
 * @author Malcolm Boyd
 *
 */
public class Radical{
	private int inNum;
	private int outNum;
	private int index;
	private int simpInNum;
	private int simpOutNum;
	private boolean imaginary;
	private Map<Integer, Integer> dictionary;
	/**
	 * The constructor for Radical class that fills object's fields and simplifies the a radical.
	 *  
	 * Runs the simplify method and fills all fields
	 * @param inNum
	 * @param outNum
	 * @param index
	 */
	public Radical(int inNum, int outNum, int index){ //Need too make public
		//See if its imaginary
		boolean needsChange = false;

        if(inNum < 0) {
            if (index % 2 != 0) {
                imaginary = false;
                needsChange = true;
            }else {
                imaginary = true;
            }
        }else {
            imaginary = false;
        }

		//avoid an infinite loop by making the number positive
		if(inNum < 0){
			inNum *= -1;
		}
		
		this.inNum = inNum;
		this.outNum = outNum;
		this.index = index;
		//create the the hashmap with everything already factored out
		this.dictionary = new BreakerDown(inNum).getDictionary();
		simplify();
		if(needsChange) {
			simpOutNum *= -1;
		}
		
	}
	
	private void simplify(){
		//now to "pull" out pairs of numbers
		//first have to iterate through the keys and their pairs
		this.simpOutNum = this.outNum;
		this.simpInNum = 1;
		for(int key : dictionary.keySet() ){
			
			if(dictionary.get(key) >= index ){ // If there is enough to take out a set
				simpOutNum = (int) (simpOutNum * (Math.pow(key,(int)(dictionary.get(key) / index)))); // the outer number is multiplied by the taken out groups of numbers
				dictionary.put(key,dictionary.get(key) - (int)(dictionary.get(key) / index) * index); // the left over numbers that weren't taken out are left in the map
			}
			
		}
		for(int key : dictionary.keySet() ) {
			this.simpInNum *= (Math.pow(key, dictionary.get(key))); //the inner number is equal to the prime**(leftover in hashmap)
		}
	}
	/**
	 * Returns the simplified inner number of a Radical.
	 * 
	 * @return int of the simplified inner number
	 */
	public int getSimpInNum(){
		return this.simpInNum;
	}
	/**
	 * Returns the simplified outter number of a Radical
	 * @return int of the simplified outter number
	 */
	public int getSimpOutNum(){
		return this.simpOutNum;
	}
	/**
	 * Returns the non-simplified inner number
	 * @return int of the non simplified inner number
	 */
	public int getInNum(){
		return inNum;
	}
	/**
	 * Returns whether or not the radical is an imaginary number
	 * @return boolean imaginary
	 */
	public boolean isImaginary() {
		return imaginary;
	}
	
}

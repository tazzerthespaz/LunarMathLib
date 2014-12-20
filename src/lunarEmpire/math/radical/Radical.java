package lunarEmpire.math.radical;

import java.util.Map;

public class Radical{
	private int inNum;
	private int outNum;
	private int index;
	private int simpInNum;
	private int simpOutNum;
	private boolean imaginary;
	private Map<Integer, Integer> dictionary;
	
	Radical(int inNum, int outNum, int index){
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
	public int getSimpInNum(){
		return this.simpInNum;
	}
	public int getSimpOutNum(){
		return this.simpOutNum;
	}
	public int getInNum(){
		return inNum;
	}
	public boolean isImaginary() {
		return imaginary;
	}
	
}

package fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(run(1, 25));
	}
	
	public static String run(int N, int M) {
		
		String sequence = "";
		List<String> sequenceList = new ArrayList<String>();
		
//		HashMap<Integer, String> strLib = new HashMap<Integer, String>();
//		strLib.put(3, "Fizz");
//		strLib.put(5, "Buzz");
		
		for(; N <= M; N++)
		{
			sequenceList.add(((N%3 == 0 && N%5 == 0) ? "FizzBuzz" : (N%3 == 0) ? "Fizz" : (N%5 == 0) ? "Buzz" : N).toString());  
		}
		
		sequence = String.join(",", sequenceList);
		
		return sequence;
	}

}

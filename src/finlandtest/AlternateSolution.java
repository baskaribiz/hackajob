package finlandtest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class AlternateSolution {
    public static void main(String args[] ) throws Exception {
        String inputData = "4" + "\n"
        		+ "1 5 2 3 4";
        
        // Output the solution to the console
        System.out.println(codeHere(inputData));
    }
    public static int codeHere(String inputData) throws Exception {
                
        // Split inputData with new line char \n to get number of elements in the array and array of integers
        String[] input = inputData.split("\n");

        // Stores number of elements in the array into an integer variable
        int numOfElements = Integer.valueOf(input[0]);

        // Check for 0 number of elements
        if(numOfElements == 0)
            throw new Exception("Provide Array of Integers");

        // Validate array of integers input
        if(null == input[1] || "".equals(input[1]) || "null".equalsIgnoreCase(input[1]) || input[1].trim().length() <= 0)
            throw new Exception("Input value is Null or Empty");

        // Converts to integer Array
        int[] elementsArr = Arrays.stream(input[1].split(" ")).mapToInt(Integer::parseInt).toArray();  
                
        // Converts to ArrayList
        List<Integer> elementsList = Arrays.stream(elementsArr).boxed().collect(Collectors.toList());
        
        // Sort to Ascending Order
        Collections.sort(elementsList);
        
        // Check for 0 and return as 0 is the closest value to 0 
        Integer zeroVal = elementsList.stream()
        		  .filter(item -> item == 0)
        		  .findAny()
        		  .orElse(null);
        
        if(null != zeroVal && zeroVal == 0)
        	return 0;
        
        // Check the closest element has same positive value and return the positive
        Integer closestValue = elementsList.stream()
      		  .filter(item -> item == Math.abs(elementsList.get(0)))
      		  .findAny()
      		  .orElse(elementsList.get(0));
                
        return closestValue;
    }
}

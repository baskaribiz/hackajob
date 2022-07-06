package finlandtest;

class Solution {
    public static void main(String args[] ) throws Exception {
        String inputData = "4" + "\n"
        		+ "-1 1 2 3 0";
        
        // Output the solution to the console
        System.out.println(codeHere(inputData));
    }
    public static int codeHere(String inputData) throws Exception {
        
        int COMPARE_VALUE = 0;
        int closestValue = COMPARE_VALUE;
        
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

        String[] elements = input[1].split(" ");

        for(int i = 0; i < elements.length; i++)
        {
            int item = Integer.valueOf(elements[i]);

            if (i == 0)
                closestValue = item;

            if(item == COMPARE_VALUE)
                return 0;

            if (Math.abs(item) == Math.abs(closestValue)) {
               closestValue = Math.abs(item);
            }
            else if(item < closestValue){
                closestValue = item;
            }
        }    

        return closestValue;
    }
}

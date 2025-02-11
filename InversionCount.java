public class InversionCount{
   
    //Function to count the inversions in the array
    public static int countInversions(int[] arr){
        int count = 0;       // Initialize inversion count
        int n = arr.length;  // length of the array

        // Checking each pair of the elements
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
               
                // If the earlier element is greater than later one,then it is the inversion
                if(arr[i] > arr[j]){
                    count++; // Increment the inversion count
                 // Print the inversion pair
                    System.out.println("Inversion found: (" + arr[i] + ", " + arr[j] + ")");
                }
            }
        }
        return count; // Returning the total count of inversions
    }

    // Main method
    public static void main(String[] args) {
        int[] P = {30, 45, 25, 60, 20}; // Given array
        int inversionCountP = countInversions(P); // Count inversions
        //printing the output result
        System.out.println("The inversion count for P is: " + inversionCountP);

        int[] A = {1,9,6,4,5}; // Another example
        int inversionCountA = countInversions(A); // Count inversions
        //printing the output result
        System.out.println("The inversion count for A is: " + inversionCountA);
    }
}
import java.util.*;

class KthClosestTemperature {
    
    // Function to partition the array based on pivot distance from the target
    private static int partition(int[][] arr, int low, int high) {
        int[] pivot = arr[high]; // Choose the last element as the pivot
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j][0] <= pivot[0]) { // Compare distances from target
                i++;
                int[] temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int[] temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Quickselect algorithm to find the k-th smallest element
    private static void quickSelect(int[][] arr, int low, int high, int k) {
        if (low < high) {
            int pi = partition(arr, low, high);
            if (pi == k) return;
            else if (pi < k) quickSelect(arr, pi + 1, high, k);
            else quickSelect(arr, low, pi - 1, k);
        }
    }

    // Function to find the K-th closest temperature reading
    public static int findKthClosest(int[] readings, int target, int k) {
        int n = readings.length;
        int[][] diffArray = new int[n][2];
        
        // Store the absolute difference along with original values
        for (int i = 0; i < n; i++) {
            diffArray[i][0] = Math.abs(readings[i] - target);
            diffArray[i][1] = readings[i];
        }
        
        // Use Quickselect to find the k-th closest element
        quickSelect(diffArray, 0, n - 1, k - 1);
        return diffArray[k - 1][1]; // Return the K-th closest reading
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking input for temperature readings
        System.out.print("Enter the number of temperature readings: ");
        int n = scanner.nextInt();
        int[] readings = new int[n];
        
        System.out.println("Enter the temperature readings: ");
        for (int i = 0; i < n; i++) {
            readings[i] = scanner.nextInt();
        }
        
        // Taking input for target temperature and k value
        System.out.print("Enter the target temperature: ");
        int target = scanner.nextInt();
        
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        
        // Finding the K-th closest reading and displaying result
        int result = findKthClosest(readings, target, k);
        System.out.println("The " + k + "-th closest temperature reading is: " + result);
        
        scanner.close();
    }
}

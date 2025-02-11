public class ProductRating {
    public static void main(String[] args) {
        double[] ratings = {9.6,10.5,3.8,9.2,9.2,9.6,8.4,9.2}; 
        double value = 0.0; // Variable to store the most frequent rating
        int maxCount = 0; // Variable to store the maximum count of occurrences

        for (int i=0; i<ratings.length; i++) {
            int count = 0; 
            for (int j=0; j<ratings.length; j++) {
                if(ratings[i]==ratings[j]) {
                    count++;
                }
            }
            
          //checking if count is greater than maxCount then update the value
            if (count > maxCount) {
                maxCount = count;
                value = ratings[i];
            }
        }
         //printing the most frequently occured rating
         System.out.println("The most frequently occurring rating is: " + value);
    }
}

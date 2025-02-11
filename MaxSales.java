public class MaxSales{
    public static void main(String[] args) {
        int[] sales = {20,4000,30,100,600,200,80};
        int max_sales = 0;
        int dayWithMaxSales = 0;
      
      //finding maximum sales
      for(int i=0; i<sales.length; i++){
        if(max_sales<sales[i]){
            max_sales = sales[i];
            dayWithMaxSales = i;
      }
      }

      //printing the maximum sale
        System.out.println("The highest sales was on day " + (dayWithMaxSales+1) + " with sales: " + max_sales);
    }
}
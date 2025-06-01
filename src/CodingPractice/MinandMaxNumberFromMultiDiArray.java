package CodingPractice;

public class MinandMaxNumberFromMultiDiArray {
    public static void main(String[] args) {
        int[][] array = {
                {12, 23, 34},
                {45, 6, 5},
                {0, 1, 80}
        };

        int smallestNumber = array[0][0];
        int largestNumber = 0;
        int smallestCol =0;
       for(int i=0; i<3; i++){
           for(int j=0; j<3; j++){
               if(array[i][j] < smallestNumber) {
                   smallestNumber = array[i][j];
                   smallestCol = j;
               }
           }
       }

       largestNumber = array[0][smallestCol];
       for(int i=0; i<3; i++){
              if(array[i][smallestCol] > largestNumber){
                     largestNumber = array[i][smallestCol];
              }
       }

       System.out.println("The Largest Number for the Smallest Number Column is: " + largestNumber);

    }
}

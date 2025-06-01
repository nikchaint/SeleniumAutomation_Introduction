package CodingPractice;

public class PrintSmallestNumberFromMultiDiMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {3, 5, 1},
            {4, 2, 6},
            {7, 8, 4}
        };

        int smallestNumber = findSmallestNumber(matrix);
        System.out.println("The smallest number in the matrix is: " + smallestNumber);
    }

    public static int findSmallestNumber(int[][] matrix){
        // Step 1: Initialize 'smallestNumber' with the first element of the matrix
        int smallestNumber = matrix[0][0];

        // Step 2: Loop through each row (3 rows assumed)
        for(int i=0; i<3; i++){
            // Step 3: Loop through each column in the current row (3 columns assumed)
            for(int j=0; j<3; j++){
                // Step 4: Check if the current element is smaller than 'smallestNumber'
                if(matrix[i][j] < smallestNumber){
                    // Step 5: Update 'smallestNumber' with the smaller value
                    smallestNumber = matrix[i][j];
                }
            }
        }
        // Step 6: Return the smallest number found in the matrix
        return smallestNumber;
    }
}

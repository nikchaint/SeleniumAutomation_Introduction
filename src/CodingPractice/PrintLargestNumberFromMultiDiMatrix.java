package CodingPractice;

public class PrintLargestNumberFromMultiDiMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {3, 5, 1},
            {4, 2, 6},
            {7, 8, 4}
        };

        int largestNumber = findLargestNumber(matrix);
        System.out.println("The largest number in the matrix is: " + largestNumber);
    }

    private static int findLargestNumber(int[][] matrix) {
        // Step 1: Initialize 'largestNumber' with the first element of the matrix
        int largestNumber = matrix[0][0];

        // Step 2: Loop through each row (3 rows assumed)
        for(int i=0; i<3; i++){
            // Step 3: Loop through each column in the current row (3 columns assumed)
            for(int j=0; j<3; j++){
                // Step 4: Check if the current element is larger than 'largestNumber'
                if(matrix[i][j] > largestNumber){
                    // Step 5: Update 'largestNumber' with the larger value
                    largestNumber = matrix[i][j];
                }
            }
        }
        // Step 6: Return the largest number found in the matrix
        return largestNumber;
    }


}

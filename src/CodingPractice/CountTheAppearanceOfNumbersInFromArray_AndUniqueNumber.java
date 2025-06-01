package CodingPractice;

import java.util.ArrayList;

public class CountTheAppearanceOfNumbersInFromArray_AndUniqueNumber {
    public static void main(String[] args) {
        int a[] ={ 4,5,5,5,4,6,6,9,4};
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i =0; i < a.length; i++){
            int k = 0;
            if(!list.contains(a[i])){
                list.add(a[i]);
                k++;
                for(int j= i+1; j < a.length; j++){
                    if(a[i] == a[j]){
                        k++;
                    }
                }
                System.out.println("Number "+ a[i] +" repeated "+ k +" times");
                if(k==1){
                    System.out.println("Number "+ a[i] +" is unique");
                }
            }
        }

    }
}

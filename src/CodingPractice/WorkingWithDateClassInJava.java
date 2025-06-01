package CodingPractice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkingWithDateClassInJava {
    public static void main(String[] args) {
        Date date =new Date();
        System.out.println(date.toString());

        //to get in a specific format
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("dd-MM-yyyy");
        System.out.println(sdf.format(date));

        sdf.applyPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(sdf.format(date));




    }
}

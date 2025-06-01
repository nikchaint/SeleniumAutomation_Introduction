package CodingPractice;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WorkingWithCalenderClassInJava {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("dd-MM-yyyy");
        System.out.println(sdf.format(cal.getTime()));

        System.out.println(cal.get(Calendar.DAY_OF_MONTH));

    }
}

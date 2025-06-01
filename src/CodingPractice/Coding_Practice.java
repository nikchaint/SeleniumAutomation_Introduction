package CodingPractice;

public class Coding_Practice {
    public static void main(String[] args) {
        int num = 1;
        for(int i=1; i<=4;i++){
            for(int j=i; j<=4;j++){
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        int num1 = 1;

        for(int i=1; i<=4;i++){
            for(int j=1; j<=i;j++){
                System.out.print(num1 + " ");
                num1++;
            }
            System.out.println();
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for(int i=1; i<=4;i++){
            int num2 = 1;
            for(int j=1; j<=i;j++){
                System.out.print(num2 + " ");
                num2++;
            }
            System.out.println();
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        int num3 =3;
        for(int i=1; i<=3;i++){
            for(int j=1; j<=i;j++){
                System.out.print(num3 + " ");
                num3 = num3+3;
            }
            System.out.println();
        }
    }
}

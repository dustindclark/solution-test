import java.util.Scanner;

public class DataTypes {

    public static void main(String[] args) {
        final String[] ANSWERS = {"byte", "short", "int", "long"};

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");

                int exp = 4;
                double pow;
                for (int j = -1; j < ANSWERS.length - 1; j++) {
                    exp *= 2;
                    pow = Math.pow(2, exp - 1);
                    if (x >= pow * -1 && x <= pow - 1) {
                        System.out.println("* " + ANSWERS[j + 1]);
                    }
                }
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
        }
    }
}
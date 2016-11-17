package Programming; /**
 * Created by Nick on 11/12/2016.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        Scanner sc = new Scanner(System.in);

        double total = 0;
        try {
            System.out.println("How many people are you receiving money from this christmas?");

            int receivingFrom = sc.nextInt();
            int moneyReceived[] = new int[receivingFrom];

            for (int i = 0; i < moneyReceived.length; i++) {
                System.out.println("How much money are you getting from this person?");
                moneyReceived[i] = sc.nextInt();
            }
            for (double totalMoneyReceived : moneyReceived) {
                total += totalMoneyReceived;


                System.out.println(total);
            }

        } catch (InputMismatchException e) {
            String fakeArray[] = {};
            c.main(fakeArray);

        }
    }

}

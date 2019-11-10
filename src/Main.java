import bank.Card;
import bank.CheckingAccount;
import bank.Deposit;

import java.text.ParseException;
import java.util.Scanner;

/**Создайте класс, который будет представлять собой расчётный счёт в банке. На этот расчётный счёт деньги можно положить,
 * с него их можно снять, и ещё можно посмотреть, сколько денег на счёте. Создайте два класса-наследника - депозитарный расчётный счёт,
 * с которого нельзя снимать деньги в течение месяца после последнего внесения, и карточный счёт, при снятии денег с которого будет взиматься комиссия 1%.**/

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        CheckingAccount account = new CheckingAccount();
        Card card = new Card();
        Deposit deposit = new Deposit();

        for (; ; ) {
            System.out.println("Выбирете счет: Simple / Card / Deposit");
            String command = scanner.nextLine();
            if (command.equals("Simple")) {
                print();
                command = scanner.nextLine();
                if (command.equals("Put")) {
                    account.putMoney();
                } else if (command.equals("Cash")) {
                    account.withDrawMoney();
                } else if (command.equals("Balance")) {
                    System.out.println("Баланс на счете: " + account.getBalance());
                }
            } else if (command.equals("Card")) {
                print();
                command = scanner.nextLine();
                if (command.equals("Put")) {
                    card.putMoney();
                } else if (command.equals("Cash")) {
                    card.withDrawMoney();
                } else if (command.equals("Balance")) {
                    System.out.println("Баланс на счете: " + card.getBalance());
                }
            } else if (command.equals("Deposit")) {
                print();
                command = scanner.nextLine();
                if (command.equals("Put")) {
                    deposit.putMoney();
                } else if (command.equals("Cash")) {
                    deposit.withDrawMoney();
                } else if (command.equals("Balance")) {
                    System.out.println("Баланс на счете: " + deposit.getBalance() + " от " + deposit.getD1());
                }
            }
        }
    }
    public static void print(){
        System.out.println("Какую операцию произвести:" +
                "\nPut - внести деньги на счет" +
                "\nCash - обналичить" +
                "\nBalance - проверить остаток");
    }
}

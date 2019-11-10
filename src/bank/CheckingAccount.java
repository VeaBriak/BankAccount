package bank;

import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckingAccount {
    private static final Pattern DATE_PATTERN = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((19|20)\\d\\d)");

    private static final Pattern MONEY_PATTERN = Pattern.compile("[0-9]*");

    static boolean isMoney(String string) {
        return MONEY_PATTERN.matcher(string).matches();
    }

    static boolean isDate(String string) {
        return DATE_PATTERN.matcher(string).matches();
    }

    protected double balance;
    protected Scanner scanner = new Scanner(System.in);
    protected String command;

    public CheckingAccount() {

    }

    public CheckingAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean withDrawMoney() throws ParseException {
        System.out.println("Какую сумму снять?:");
        command = scanner.nextLine();
        if (!isMoney(command) || command.equals("")) {
            System.out.println("Вы не ввели сумму!");
        } else if (isMoney(command)) {
            double sum = Double.parseDouble(command);
            if (sum > balance) {
                System.out.println("Вы не можете снять эту сумму!\nДоступная сумма для снятия: " + balance);
            } else {
                balance -= sum;
                System.out.println("Вы сняли " + sum + "\nБаланс на счете: " + balance);
            }
        }
        return true;
    }

    public void putMoney() {
        System.out.println("Внесите деньги на счет:");
        command = scanner.nextLine().trim();
        if (command.equals("") || !isMoney(command)) {
            System.out.println("На счет необходимо вносить деньги!");
        } else if (isMoney(command)) {
            setBalance(balance += Double.parseDouble(command));
        }
    }
}

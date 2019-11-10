package bank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Deposit extends CheckingAccount {

    private String d1;
    private String d2;
    private Date date1 = null;
    private Date date2 = null;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public Deposit(String d1, String d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    public Deposit(double money) {
        super(money);
    }

    public Deposit() {

    }

    public String getD1() {
        return d1;
    }

    public void setD1(String d1) {
        this.d1 = d1;
    }

    public String getD2() {
        return d2;
    }

    public void setD2(String d2) {
        this.d2 = d2;
    }

    public void putMoney() {
        System.out.println("Введите дату внесения денег в формате дд.мм.гггг");
        String command = scanner.nextLine();
        if (isDate(command)) {
            setD1(command);
            System.out.println("Внесите деньги на счет:");
            command = scanner.next();
            if (command.equals("") || command.equals(scanner.nextLine())) {
                System.out.println("На счет необходимо вносить деньги!");
            } else {
                setBalance(balance += Double.parseDouble(command));
                System.out.println("Вы можете снять денги не ранее 30 календарных дней с даты внесения их на депозитный счет!");
            }
        } else {
            System.out.println("Вы ввели некоректный формат даты");
        }
    }

    public boolean withDrawMoney() throws ParseException {
        System.out.println("Какую сумму снять?:");
        command = scanner.nextLine();
        if (!isMoney(command) || command.equals("")) {
            System.out.println("Вы не ввели сумму!");
        } else if (isMoney(command)) {
            double sum = Double.parseDouble(command);
            System.out.println("Введите дату снятия денег  в формате дд.мм.гггг :");
            String day = scanner.nextLine();
            if (isDate(day)) {
                setD2(day);
                if (getDay() < 30) {
                    long data = 30 - getDay();
                    System.out.println("Вы можете снять деньги через " + data + " дней!");
                } else {
                    if (balance == 0 || sum >= balance) {
                        System.out.println("Вы не можете снять эту сумму!\nДоступная сумма для снятия: " + balance);
                    } else {
                        balance -= sum;
                        System.out.println("Вы сняли " + sum + "\nБаланс на счете: " + balance);
                    }
                }
            } else {
                System.out.println("Вы ввели некоректный формат даты");
            }
        }
        return true;
    }

    public long getDay() throws ParseException {
//        Date date1 = new Date();
//        Date date2 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
//        simpleDateFormat.format(date1);
//        simpleDateFormat.format(date2);
        date1 = simpleDateFormat.parse(getD1());
        date2 = simpleDateFormat.parse(getD2());
        long difference = date2.getTime() - date1.getTime();
        long days = difference / (24 * 60 * 60 * 1000);
        return days;
    }
}

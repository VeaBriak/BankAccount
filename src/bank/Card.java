package bank;

public class Card extends CheckingAccount {

    public Card() {
    }

    public Card(double money) {
        super(money);
    }

    public boolean withDrawMoney() {
        System.out.println("При снятии взымается комиссия 1%.\nКакую сумму снять?:");
        command = scanner.nextLine();
        if (!isMoney(command) || command.equals("")) {
            System.out.println("Вы не ввели сумму!");
        } else if (isMoney(command)) {
            double sum = Double.parseDouble(command);
            if (balance == 0.0) {
                System.out.println("Вы не можете снять эту сумму!\nДоступная сумма для снятия: " + balance);
            } else if (sum >= balance) {
                double percent = sum / 100;
                double money = balance - percent;
                System.out.println("Вы не можете снять эту сумму!\nДоступная сумма для снятия: " + money);
            } else {
                double percent = sum / 100;
                balance -= sum;
                balance = balance - percent;
                System.out.println("Вы сняли " + sum + "\nБаланс на счете: " + balance);
            }
        }
        return true;
    }
}

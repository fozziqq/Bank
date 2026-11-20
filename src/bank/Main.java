package bank;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(10000);
        BankAccount target = new BankAccount(5000);

        BankService service = new BankService();

        System.out.println("Баланс account: " + account.getBalance());
        System.out.println("Баланс target: " + target.getBalance());

        try {
            System.out.println("Пополнение: 500");
            account.deposit(500);

            System.out.println("Снятие: 300");
            account.withdraw(300);

            System.out.println("Перевод 1000 на target: ");
            service.transfer(account, target, 1000);
            System.out.println("Баланс account: " + account.getBalance());
            System.out.println("Баланс target: " + target.getBalance());

            System.out.println("Перевод 9999(должен упасть)");
            service.transfer(account, target, 9999);

        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        } finally {
            System.out.println("Итог account: " + account.getBalance());
            System.out.println("Итог target: " + target.getBalance());
        }
    }
}

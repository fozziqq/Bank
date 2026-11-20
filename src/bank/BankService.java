package bank;

public class BankService {
    public void transfer(
            BankAccount from,
            BankAccount to,
            double amount
    ) throws InsufficientFundsException {

        if (from == null || to == null) {
            throw new IllegalArgumentException("Счета не могут быть null");
        }
        if (from == to) {
            throw new IllegalArgumentException("Нельзя переводить на один тот же счет");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма перевода должен быть положительной");
        }
        from.withdraw(amount);

        try {
            to.deposit(amount);
        } catch (RuntimeException | Error e) {
            from.deposit(amount);
            throw e;
        }
    }
}

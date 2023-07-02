package tinkov_middle.concurrency.task2.correct1;

public class AccountThread implements Runnable {
    private final Account accountFrom;
    private final Account accountTo;
    private final int money;

    public AccountThread(Account accountFrom, Account accountTo, int money) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.money = money;
    }

    @Override
    public void run() {
        var first = accountFrom;
        var second = accountTo;
        if (accountFrom.hashCode() <= accountTo.hashCode()) {
            first = accountTo;
            second = accountFrom;
        }
        for (int i = 0; i < 40000;) {
            synchronized (first) {
                synchronized (second) {
                    if (accountFrom.getCacheBalance() > money) {
                        accountFrom.takeOffMoney(money);
                        accountTo.addMoney(money);
                    }
                    i++;
                }
            }
        }
    }
}

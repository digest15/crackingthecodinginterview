package tinkov_middle.concurrency.task2.correct2;

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
        for (int i = 0; i < 4000; ) {
            if (accountFrom.getLock().tryLock()) {
                if (accountTo.getLock().tryLock()) {
                    try {
                        if (accountFrom.getCacheBalance() > money) {
                            accountFrom.takeOffMoney(money);
                            accountTo.addMoney(money);
                        }
                        i++;
                    } finally {
                        accountTo.getLock().unlock();
                        accountFrom.getLock().unlock();
                    }
                } else {
                    accountFrom.getLock().unlock();
                }
            }
        }
    }
}

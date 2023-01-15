package Chainblock.src.main.java;

public class TransactionImpl implements Comparable<TransactionImpl>, Transaction{

    private int id;
    private TransactionStatus status;
    private String from;
    private String to;
    private double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        setStatus(status);
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public int compareTo(TransactionImpl o) {
        return 0;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public TransactionStatus getStatus() {
        return this.status;
    }

    @Override
    public TransactionStatus setStatus(TransactionStatus status) {
        return this.status = status;
    }
}

package Chainblock.src.main.java;

public interface Transaction {

    int getId();

    TransactionStatus getStatus();

    TransactionStatus setStatus(TransactionStatus status);
}

package Chainblock.src.main.java;

import java.util.*;

public class ChainblockImpl implements Chainblock {

    private Map<Integer, Transaction> transactionMap;
    private int id;

    //Transaction transaction;

    public ChainblockImpl() {
        transactionMap = new HashMap<>();
    }

    public int getCount() {
        return transactionMap.size();
    }

    public void add(Transaction transaction) {
        if (!contains(transaction)) {
            transactionMap.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return transactionMap.containsValue((transaction));
    }

    public boolean contains(int id) {
        return transactionMap.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (contains(id)) {
            transactionMap.get(id).setStatus(newStatus);
        } else {
            throw new IllegalArgumentException("Transaction don't exist");
        }
    }

    public void removeTransactionById(int id) {
        if (contains(id)) {
            transactionMap.remove(id);
        } else {
            throw new IllegalArgumentException("Id don't exist.");
        }
    }

    public Transaction getById(int id) {
        if (contains(id)) {
            return transactionMap.get(id);
        } else {
            throw new IllegalArgumentException("Id don't exist.");
        }
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> list = new ArrayList<>();
        for (Transaction transaction : transactionMap.values()) {
            if (transaction.getStatus() == status) {
                list.add(transaction);
            }
        }
        if (list.size() == 0) {
            throw new IllegalArgumentException("Status don't exist.");
        } else {
            return list;
        }

    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {

        return null;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {

        return null;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {

        return null;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {

        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {

        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {

        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}

import Chainblock.src.main.java.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TransactionTest {
    private Chainblock database;

    @Before
    public void setUp(){
        database = new ChainblockImpl();
    }


    @Test
    public void testAdd(){
        addOneTransaction();
        Assert.assertEquals(database.getCount(), 1);
    }



    @Test
    public void testChangeTransactionStatusWithExistingTransaction(){
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Mery", "George", 100.00);
        Assert.assertEquals(database.getCount(), 0);
        database.add(transaction1);
        Assert.assertEquals(database.getCount(), 1);
        Assert.assertTrue(database.contains(transaction1));
        database.add(transaction1);
        database.changeTransactionStatus(1, TransactionStatus.ABORTED);
        Assert.assertEquals(transaction1.getStatus(), TransactionStatus.ABORTED);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionWithNoExistingTransactionShouldBeThrowing(){
        addOneTransaction();
        database.changeTransactionStatus(2, TransactionStatus.FAILED);
    }

    @Test
    public void testRemoveTransactionWithExistingTransaction(){
        addThreeTransaction();
        database.removeTransactionById(2);
        Assert.assertEquals(database.getCount(), 2);
        Assert.assertFalse(database.contains( new TransactionImpl(2, TransactionStatus.ABORTED, "Lily", "Tara", 90.00 )));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNotExistingTransactionShouldNeThrowing(){
        addThreeTransaction();
        database.removeTransactionById(5);
    }

    @Test
    public void testGetByIdWithExistingTransaction(){
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Mery", "George", 100.00);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.ABORTED, "Lily", "Tara", 90.00 );
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Sally", "Danny", 50.00);
        Assert.assertEquals(database.getCount(), 0);
        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);
        Assert.assertEquals(database.getCount(), 3);
        Assert.assertEquals(database.getById(2), transaction2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdWithNotExistingTransactionShouldBeThrowing(){
        addThreeTransaction();
        database.getById(6);
    }

    @Test
    public void testGetByTransactionStatusWithExistingTransaction(){
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Mery", "George", 100.00);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.ABORTED, "Lily", "Tara", 90.00 );
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Sally", "Danny", 50.00);
        Assert.assertEquals(database.getCount(), 0);
        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);
        Assert.assertEquals(database.getCount(), 3);
        Iterable<Transaction> result = database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<Transaction> transactionsWithGivenStatus = new ArrayList<>();
        result.forEach(transactionsWithGivenStatus::add);
        Assert.assertEquals(transactionsWithGivenStatus.size(), 2);
        transactionsWithGivenStatus.forEach(tr -> Assert.assertEquals(tr.getStatus(), TransactionStatus.SUCCESSFUL));
        Assert.assertEquals(transactionsWithGivenStatus.get(0), transaction1);
        Assert.assertEquals(transactionsWithGivenStatus.get(1), transaction3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusWithNotExistingStatusShouldBeThrowing(){
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Mery", "George", 100.00);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.ABORTED, "Lily", "Tara", 90.00 );
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Sally", "Danny", 50.00);
        Assert.assertEquals(database.getCount(), 0);
        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);
        Assert.assertEquals(database.getCount(), 3);
        Iterable<Transaction> result = database.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    private void addOneTransaction() {
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Mery", "George", 100.00);
        Assert.assertEquals(database.getCount(), 0);
        database.add(transaction1);
        Assert.assertEquals(database.getCount(), 1);
        Assert.assertTrue(database.contains(transaction1));
        database.add(transaction1);
    }

    private void addThreeTransaction() {
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Mery", "George", 100.00);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.ABORTED, "Lily", "Tara", 90.00 );
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Sally", "Danny", 50.00);
        Assert.assertEquals(database.getCount(), 0);
        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);
        Assert.assertEquals(database.getCount(), 3);
    }

}

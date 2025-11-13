package com.app;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FundTransferServiceTest {

    private AccountService accountService;

    private FundTransferService fundTransferService;

    

    @Test
    public void testTransfer_InvalidAmount() {
        String result = fundTransferService.transfer("ACC1", "ACC2", 0);
        assertEquals("FAILURE: Invalid amount", result);

        result = fundTransferService.transfer("ACC1", "ACC2", -100);
        assertEquals("FAILURE: Invalid amount", result);
    }

    // Test 2: Source and destination accounts are the same
    @Test
    public void testTransfer_SameAccount() {
        String result = fundTransferService.transfer("ACC1", "ACC1", 100);
        assertEquals("FAILURE: Source and destination cannot be same", result);
    }

    @Test
    public void testTransfer_InsufficientFunds() {
        when(accountService.getBalance("ACC1")).thenReturn(50.0);

        String result = fundTransferService.transfer("ACC1", "ACC2", 100);
        assertEquals("FAILURE: Insufficient funds", result);
    }

    @Test
    public void testTransfer_DestinationAccountNotFound() {
        when(accountService.getBalance("ACC1")).thenReturn(200.0);
        when(accountService.exists("ACC2")).thenReturn(false);

        String result = fundTransferService.transfer("ACC1", "ACC2", 100);
        assertEquals("FAILURE: Destination account not found", result);
    }

    @Test
    public void testTransfer_TransactionError_DebitFails() {
        when(accountService.getBalance("ACC1")).thenReturn(200.0);
        when(accountService.exists("ACC2")).thenReturn(true);
        when(accountService.debit("ACC1", 100)).thenReturn(false); // Debit fails
        when(accountService.credit("ACC2", 100)).thenReturn(true);

        String result = fundTransferService.transfer("ACC1", "ACC2", 100);
        assertEquals("FAILURE: Transaction error", result);
    }

    @Test
    public void testTransfer_TransactionError_CreditFails() {
        when(accountService.getBalance("ACC1")).thenReturn(200.0);
        when(accountService.exists("ACC2")).thenReturn(true);
        when(accountService.debit("ACC1", 100)).thenReturn(true);
        when(accountService.credit("ACC2", 100)).thenReturn(false); // Credit fails

        String result = fundTransferService.transfer("ACC1", "ACC2", 100);
        assertEquals("FAILURE: Transaction error", result);
    }

    // Test 6: Successful transfer
    @Test
    public void testTransfer_Success() {
        when(accountService.getBalance("ACC1")).thenReturn(500.0);
        when(accountService.exists("ACC2")).thenReturn(true);
        when(accountService.debit("ACC1", 200)).thenReturn(true);
        when(accountService.credit("ACC2", 200)).thenReturn(true);

        String result = fundTransferService.transfer("ACC1", "ACC2", 200);
        assertEquals("SUCCESS: Transfer completed", result);
    }
}

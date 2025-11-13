package com.app.test;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import com.app.AccountService;
import com.app.FundTransferService;

import static org.junit.jupiter.api.Assertions.*;

class FundTransferServiceTest {

    private AccountService accountService;
    private FundTransferService fundTransferService;

    @BeforeEach
    void setup() {
        accountService = new AccountService(); 
        fundTransferService = new FundTransferService(accountService);
    }

    @Test
    void testTransferSuccess() {
        String result = fundTransferService.transfer("ACC123", "ACC456", 200);
        assertEquals("SUCCESS: Transfer completed", result);
        assertEquals(800.0, accountService.getBalance("ACC123"));
        assertEquals(700.0, accountService.getBalance("ACC456"));
    }

    @Test
    void testTransferInvalidAmount() {
        String result = fundTransferService.transfer("ACC123", "ACC456", -50);
        assertEquals("FAILURE: Invalid amount", result);
    }

    @Test
    void testTransferSameAccount() {
        String result = fundTransferService.transfer("ACC123", "ACC123", 100);
        assertEquals("FAILURE: Source and destination cannot be same", result);
    }

    @Test
    void testTransferInsufficientFunds() {
        String result = fundTransferService.transfer("ACC456", "ACC123", 1000);
        assertEquals("FAILURE: Insufficient funds", result);
    }

    @Test
    void testTransferDestinationNotFound() {
        String result = fundTransferService.transfer("ACC123", "NONEXIST", 100);
        assertEquals("FAILURE: Destination account not found", result);
    }
}
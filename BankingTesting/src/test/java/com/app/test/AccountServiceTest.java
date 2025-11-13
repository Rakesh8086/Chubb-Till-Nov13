package com.app.test;

import org.junit.jupiter.api.Test;


import com.app.AccountService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class AccountServiceTest {

    private AccountService accountService;

    @BeforeEach
    void setup() {
        accountService = new AccountService();
    }

    @Test
    void testAccountExists() {
        assertTrue(accountService.exists("ACC123"));
        assertFalse(accountService.exists("NONEXIST"));
    }

    @Test
    void testGetBalance() {
        assertEquals(1000.0, accountService.getBalance("ACC123"));
        assertEquals(0.0, accountService.getBalance("NONEXIST"));
    }

    @Test
    void testDebit() {
        assertTrue(accountService.debit("ACC123", 200));
        assertEquals(800.0, accountService.getBalance("ACC123"));
        assertFalse(accountService.debit("ACC123", 2000));
        assertFalse(accountService.debit("NONEXIST", 100));
    }

    @Test
    void testCredit() {
        assertTrue(accountService.credit("ACC123", 500));
        assertEquals(1500.0, accountService.getBalance("ACC123"));
        assertFalse(accountService.credit("NONEXIST", 100));
    }
}

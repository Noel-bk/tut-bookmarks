package com.example.repository;

import com.example.model.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Noel on 12/5/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Before
    public void setUp() throws Exception {
        accountRepository.save(new Account("Noel", "qwerty"));
    }

    @Test
    public void findByUsername() throws Exception {
        Optional<Account> account = accountRepository.findByUsername("Noel");
        assertNotNull(account);
    }

}
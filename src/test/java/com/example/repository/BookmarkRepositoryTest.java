package com.example.repository;

import com.example.model.Account;
import com.example.model.Bookmark;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Noel on 12/6/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookmarkRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Before
    public void setUp() throws Exception {
        Account account = new Account("Noel", "qwerty");
        accountRepository.save(account);
        bookmarkRepository.save(new Bookmark(account, "http://google.com", "google"));
    }

    @Test
    public void findByAccountUsername() throws Exception {
        Collection<Bookmark> bookmarks = bookmarkRepository.findByAccountUsername("Noel");
        assertNotNull(bookmarks);
    }

}
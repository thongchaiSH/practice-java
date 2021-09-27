package com.th.junit.integration;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.th.junit.configuration.WireMockConfig;
import com.th.junit.domain.book.Book;
import com.th.junit.intf.BooksClient;
import com.th.junit.mock.BookMocks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Thongchai
 * @date 2021/09/27
 */
@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WireMockConfig.class })
public class BooksClientIntegrationTest {

    @Autowired
    private WireMockServer mockBooksService;

    @Autowired
    private BooksClient booksClient;

    @BeforeEach
    void setUp() throws IOException {
        BookMocks.setupMockBooksResponse(mockBooksService);
    }

    @Test
    public void whenGetBooks_thenBooksShouldBeReturned() {
        assertFalse(booksClient.getBooks().isEmpty());
    }

    @Test
    public void whenGetBooks_thenTheCorrectBooksShouldBeReturned() {
        List<Book> bookList= booksClient.getBooks();
        assertTrue(bookList
                .containsAll(asList(
                        new Book("Dune", "Frank Herbert"),
                        new Book("Foundation", "Isaac Asimov"))));
    }
}

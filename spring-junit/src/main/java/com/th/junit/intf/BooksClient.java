package com.th.junit.intf;

import com.th.junit.domain.book.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @author Thongchai
 * @date 2021/09/27
 */
@FeignClient(value="simple-books-client", url="${book.service.url}")
public interface BooksClient {
    @RequestMapping("/books")
    List<Book> getBooks();
}

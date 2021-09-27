package com.th.junit.domain.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Thongchai
 * @date 2021/09/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String title;
    private String author;
}

package com.spring.openapi;

import com.spring.openapi.model.Blog;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BlogApiDelegateImpl implements BlogApiDelegate {

    @Override
    public ResponseEntity<Blog> getBlogByTitle(String blogtitle) {
        Blog blog=new Blog();
        blog.setId(100L);
        blog.setBlogtitle("Thongchai SH");
        blog.setContent("My content");
        return ResponseEntity.ok(blog);
    }
}

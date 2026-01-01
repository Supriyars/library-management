package com.example.library.dto;

import com.example.library.model.BookPolicy;
import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String author;
    private BookPolicy policy;
}

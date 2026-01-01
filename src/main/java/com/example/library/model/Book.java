package com.example.library.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    private String id;

    private String title;
    private String author;

    private boolean borrowed;

    private String borrowedByUserId;

    private LocalDateTime borrowedAt;
    private LocalDateTime dueAt;

    private BookPolicy policy;
}

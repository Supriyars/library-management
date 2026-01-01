package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/books")
@RequiredArgsConstructor
public class BorrowController {

    private final BorrowService borrowService;

    // TEMP: userId passed manually (JWT comes later)
    @PostMapping("/{bookId}/borrow")
    public Book borrowBook(
            @PathVariable String bookId,
            @RequestParam String userId
    ) {
        return borrowService.borrowBook(bookId, userId);
    }

    @PostMapping("/{bookId}/return")
    public Book returnBook(
            @PathVariable String bookId,
            @RequestParam String userId
    ) {
        return borrowService.returnBook(bookId, userId);
    }

    @GetMapping("/borrowed")
    public List<Book> borrowedBooks(@RequestParam String userId) {
        return borrowService.getBooksBorrowedByUser(userId);
    }
}


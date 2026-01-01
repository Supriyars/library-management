package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowService {

    private final BookRepository bookRepository;

    public Book borrowBook(String bookId, String userId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.isBorrowed()) {
            throw new RuntimeException("Book already borrowed");
        }

        book.setBorrowed(true);
        book.setBorrowedByUserId(userId);
        book.setBorrowedAt(LocalDateTime.now());

        return bookRepository.save(book);
    }

    public Book returnBook(String bookId, String userId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (!book.isBorrowed() || !userId.equals(book.getBorrowedByUserId())) {
            throw new RuntimeException("You cannot return this book");
        }

        book.setBorrowed(false);
        book.setBorrowedByUserId(null);
        book.setBorrowedAt(null);
        book.setDueAt(null);

        return bookRepository.save(book);
    }

    public List<Book> getBooksBorrowedByUser(String userId) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> userId.equals(book.getBorrowedByUserId()))
                .toList();
    }
}


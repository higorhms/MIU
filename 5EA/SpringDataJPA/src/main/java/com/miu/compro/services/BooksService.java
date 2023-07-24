package com.miu.compro.services;

import com.miu.compro.entities.Book;
import com.miu.compro.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BooksService {

    private BookRepository bookRepository;

    @Autowired
    public BooksService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll(){
        return this.bookRepository.findAll();
    }

    public Book getOne(int bookId) {
        return this.bookRepository.findById(bookId).get();
    }

    public void deleteOne(int bookId) {
        this.bookRepository.deleteById(bookId);
    }
}

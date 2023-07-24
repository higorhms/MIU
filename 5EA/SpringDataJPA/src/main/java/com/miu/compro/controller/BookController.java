package com.miu.compro.controller;

import com.miu.compro.entities.Book;
import com.miu.compro.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BooksService booksService;

    @Autowired
    public BookController(BooksService booksService){
        this.booksService = booksService;
    }

    @GetMapping("")
    public List<Book> getAll(){
        return this.booksService.getAll();
    }

    @GetMapping("/{bookId}")
    public Book getOne(@PathVariable int bookId){
        return this.booksService.getOne(bookId);
    }

    @DeleteMapping("/{bookId}")
    public void deleteOne(@PathVariable int bookId){
        this.booksService.deleteOne(bookId);
    }
}

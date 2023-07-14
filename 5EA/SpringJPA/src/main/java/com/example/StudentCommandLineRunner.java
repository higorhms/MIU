package com.example;

import com.example.entities.Book;
import com.example.entities.Student;
import com.example.repository.BookRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class StudentCommandLineRunner implements CommandLineRunner {

    private StudentRepository studentsRepository;

    private BookRepository bookRepository;


    @Autowired
    public StudentCommandLineRunner(StudentRepository studentsRepository, BookRepository bookRepository){
        this.studentsRepository = studentsRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        try{
            Student jack = new Student("Jack", 30, 10);
            Student jim = new Student("Jim", 40, 9);
            Student john = new Student("John", 35, 8);
            Student jill = new Student("Jill", 28, 7);
            studentsRepository.save(jack);
            studentsRepository.save(jim);
            studentsRepository.save(john);
            studentsRepository.save(jill);
            bookRepository.save(new Book("In Search of Lost Time", 4215, 39.95, jack));
            bookRepository.save(new Book("Ulysses", 730, 25.50, jack));
            bookRepository.save(new Book("Don Quixote", 1023, 18.99, jim));
            bookRepository.save(new Book("The Great Gatsby", 180, 15.99, john));
            bookRepository.save(new Book("Moby Dick", 720, 12.99, jill));
            bookRepository.save(new Book("War and Peace", 1225, 24.50, jill));
            bookRepository.save(new Book("To Kill a Mockingbird", 281, 18.00, jill));
            bookRepository.save(new Book("1984", 328, 22.99, jill));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

package org.example.service;

import org.example.dto.Book;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddBookService {
@Autowired
private BookRepository bookRepository;

    public void addBook(String title, String author, String amount) {
        Book bookTitle = bookRepository.getProfileTitle(title);
        if(bookTitle != null){
            System.out.println("there is this book");
        }
        bookRepository.insertBook(title,author,amount);
    }


        public void bookList() {
        List<Book> bookList= bookRepository.getBookList();
        for (Book book : bookList){
            System.out.println(book);
        }

    }

    public void deleteBook(int id) {
      /*  Book bookTitl = bookRepository.getProfileID(id);
        if(bookTitl == null){
            System.out.println(" user not found ");
        }*/
        bookRepository.deleteBook(id);
    }
}

package com.driver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

//    private List<Book> bookList;
//    private int id;
//
//    public List<Book> getBookList() {
//        return bookList;
//    }
//
//    public void setBookList(List<Book> bookList) {
//        this.bookList = bookList;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public BookController(){
//        this.bookList = new ArrayList<Book>();
//        this.id = 1;
//    }

    // post request /create-book
    // pass book as request body
//    @PostMapping("/create-book")
//    public ResponseEntity<Book> createBook(@RequestBody Book book){
//        // Your code goes here.
//        return new ResponseEntity<>(book, HttpStatus.CREATED);
//    }

    // get request /get-book-by-id/{id}
    // pass id as path variable
    // getBookById()

    // delete request /delete-book-by-id/{id}
    // pass id as path variable
    // deleteBookById()

    // get request /get-all-books
    // getAllBooks()

    // delete request /delete-all-books
    // deleteAllBooks()

    // get request /get-books-by-author
    // pass author name as request param
    // getBooksByAuthor()

    // get request /get-books-by-genre
    // pass genre name as request param
    // getBooksByGenre()
   // @Autowired
    BookService bookService = new BookService();

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity getBook(@PathVariable("id") String id){
        Book newbook = bookService.findBookById(id);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-books")
    public ResponseEntity getAllBooks(){
        List<Book> newbook = bookService.findAllBooks();
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/get-books-by-author")
    public ResponseEntity getBookByAuthor(@RequestParam("author") String author){
        List<Book> newbook = bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/get-books-by-genre")
    public ResponseEntity getBookByGenre(@RequestParam("genre") String genre){
        List<Book> newbook = bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") String id){
        bookService.deleteBookById(id);
        return  new ResponseEntity<>("success ", HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-all-books")
    public ResponseEntity deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("success ", HttpStatus.FOUND);
    }
}

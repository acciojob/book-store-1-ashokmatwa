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

//@RestController
//@RequestMapping("books")
//public class BookController {
//
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
//
//    // post request /create-book
//    // pass book as request body
////    @PostMapping("/create-book")
////    public ResponseEntity<Book> createBook(@RequestBody Book book){
////        // Your code goes here.
////        return new ResponseEntity<>(book, HttpStatus.CREATED);
////    }
//
//
//    @PostMapping("/create-book")
//    public ResponseEntity createBook(@RequestBody Book book){
//        book.setId(id);
//        bookList.add(book);
//        id++;
//        return new ResponseEntity<>(book, HttpStatus.CREATED);
//    }
//
//    // get request /get-book-by-id/{id}
//    // pass id as path variable
//    // getBookById()
//    @GetMapping("/get-book-by-id/{id}")
//    public ResponseEntity getBookById(@PathVariable("id") String id){
//        int id1 = Integer.parseInt(id);
//        for(Book book : bookList){
//            if(book.getId() == id1)
//                return new ResponseEntity<>(book, HttpStatus.CREATED);
//        }
//        //return new ResponseEntity<>(book, HttpStatus.CREATED);
//        return null;
//    }
//
//    // delete request /delete-book-by-id/{id}
//    // pass id as path variable
//    // deleteBookById()
//    @DeleteMapping("/delete-book-by-id/{id}")
//    public ResponseEntity deleteBookById(@PathVariable("id") String id){
//        for(Book book : bookList){
//            if(book.getId() == Integer.parseInt(id)){
//                bookList.remove(book);
//                return new ResponseEntity<>("success", HttpStatus.FOUND);
//            }
//        }
//        return  new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
//    }
//
//    // get request /get-all-books
//    // getAllBooks()
//    @GetMapping("/get-all-books")
//    public ResponseEntity getAllBooks(){
//        return new ResponseEntity<>(bookList, HttpStatus.CREATED);
//    }
//
//    // delete request /delete-all-books
//    // deleteAllBooks()
//    @DeleteMapping("/delete-all-books")
//    public ResponseEntity deleteAllBooks(){
//        bookList.clear();
//        return new ResponseEntity<>("success ", HttpStatus.FOUND);
//    }
//
//    // get request /get-books-by-author
//    // pass author name as request param
//    // getBooksByAuthor()
//    @GetMapping("/get-books-by-author")
//    public ResponseEntity getBooksByAuthor(@RequestParam("author") String author){
//        List<Book> list = new ArrayList<>();
//        for(Book book : bookList){
//            if(book.getAuthor().equals(author))
//                list.add(book);
//        }
//        return new ResponseEntity<>(list, HttpStatus.CREATED);
//    }
//
//    // get request /get-books-by-genre
//    // pass genre name as request param
//    // getBooksByGenre()
//    @GetMapping("/get-books-by-genre")
//    public ResponseEntity getBooksByGenre(@RequestParam("genre") String genre){
//        List<Book> list = new ArrayList<>();
//        for(Book book : bookList){
//            if(book.getGenre().equals(genre))
//                list.add(book);
//        }
//        return new ResponseEntity<>(list, HttpStatus.CREATED);
//    }
//
//}




@RestController
@RequestMapping("books")
public class BookController {

    private List<Book> bookList;
    private int id;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookController(){
        this.bookList = new ArrayList<>();
        this.id = 1;
    }

    // post request /create-book
    // pass book as request body
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        // Your code goes here.
        book.setId(id);
        bookList.add(book);
        id++;
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    // get request /get-book-by-id/{id}
    // pass id as path variable
    // getBookById()
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
        for(Book book : bookList){
            if(book.getId()==id)
                return new ResponseEntity<>(book, HttpStatus.ACCEPTED);
        }
        return null;
    }

    // delete request /delete-book-by-id/{id}
    // pass id as path variable
    // deleteBookById()
    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable int id){
        int count = 0;
        for(int i=0;i<bookList.size();i++){
            if(bookList.get(i).getId()==id){
                bookList.remove(bookList.get(i));
                count++;
            }
        }
        if(count==1)
            return new ResponseEntity<>("Deleted", HttpStatus.FOUND);
        else
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    // get request /get-all-books
    // getAllBooks()
    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookList, HttpStatus.ACCEPTED);
    }

    // delete request /delete-all-books
    // deleteAllBooks()
    @DeleteMapping("/delete-all-books")
    public ResponseEntity<String> deleteAllBooks(){
        bookList.clear();
        return new ResponseEntity<>("All Books are deleted", HttpStatus.ACCEPTED);
    }

    // get request /get-books-by-author
    // pass author name as request param
    // getBooksByAuthor()
    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam("name") String author){
        List<Book> list = new ArrayList<>();
        for(Book book : bookList){
            if(book.getAuthor().equals(author))
                list.add(book);
        }
        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }

    // get request /get-books-by-genre
    // pass genre name as request param
    // getBooksByGenre()
    @GetMapping("/get-books-by-genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam("name") String genre){
        List<Book> list = new ArrayList<>();
        for(Book book : bookList){
            if(book.getGenre().equals(genre))
                list.add(book);
        }
        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }
}
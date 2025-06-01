package com.example.axsos.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.axsos.models.Book;
import com.example.axsos.services.BookService;
import java.util.List;

@RestController
public class BooksApi {    //Access services
    private final BookService bookService;
    
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    
    
    @GetMapping("api/books/display")
    public List<Book> display(){
    	return bookService.allBooks()	;
    	
    }
    

    
    @PostMapping("api/books/create")
    public Book create( 
    		@RequestParam  String title, //اتذكر انو بعمل اشي زي هيك بزبط 
            @RequestParam(value="description") String desc, 
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book( title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    
    // other methods removed for brevity
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(
            @PathVariable("id") Long id, 
            @RequestParam(value="title") String title, 
            @RequestParam(value="description") String desc, 
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages) {
        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
    
    
    
    
    
    
    
    
}
package com.example.axsos.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.axsos.models.Book;
import com.example.axsos.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    //في سؤال هون  
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		// TODO Auto-generated method stub
		Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
        	Book book = new Book(title, desc, lang, numOfPages);
        	book.setId(id);
            return bookRepository.save(book);
        }
        {
            return null;
        }
		
	}
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
             bookRepository.deleteById(id);
         
        }
        
		
	}
    
   
}
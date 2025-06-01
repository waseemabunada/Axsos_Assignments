package com.example.axsos.controllers;
import org.springframework.stereotype.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.axsos.models.Book;
import com.example.axsos.services.BookService;

@Controller
public class BookController {
	@Autowired
    BookService bookService;
	
	
	@GetMapping("/book/{id}")
	public String bookDetails(@PathVariable("id") Long id , Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "show";
		}
	
	
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index";
    }
	
}




package hh.sof03.bookstore.web;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@CrossOrigin
@Controller
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public @ResponseBody List<Book> getAllBooks(){
        return (List<Book>) bookRepository.findAll();
    }    

    @RequestMapping(value = "/books/{id}", method=RequestMethod.GET)
    public @ResponseBody Optional<Book> getBook(@PathVariable("id") Long id) {
        return bookRepository.findById(id);
    }
    
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public @ResponseBody Book saveBookRest(@RequestBody Book book) {
        return bookRepository.save(book);
    }
}

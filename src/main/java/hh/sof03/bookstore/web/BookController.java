package hh.sof03.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/booklist")
    public String booklist(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", repository.findById(bookId));
        return "editbook";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String updateBook(Book book) {

        Optional<Book> existingBook = repository.findById(book.getId());

        Book editedBook = existingBook.get();
        editedBook.setTitle(book.getTitle());
        editedBook.setAuthor(book.getAuthor());
        editedBook.setIsbn(book.getIsbn());
        editedBook.setPublicationYear(book.getPublicationYear());
        editedBook.setPrice(book.getPrice());
        repository.save(editedBook);

        return "redirect:booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }
}

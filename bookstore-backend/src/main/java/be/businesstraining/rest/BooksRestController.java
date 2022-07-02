package be.businesstraining.rest;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.businesstraining.domain.Book;
import be.businesstraining.domain.Category;
import be.businesstraining.repository.IBooksRepository;
import be.businesstraining.repository.ICategoriesRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BooksRestController {

    private IBooksRepository booksRepository;
    private ICategoriesRepository categoriesRepository;

    // The @Autowired decoration is not required for constructor injection
    public BooksRestController(IBooksRepository booksRepository,
                              ICategoriesRepository categoriesRepository){
        this.booksRepository = booksRepository;
        this.categoriesRepository = categoriesRepository;
    }

    @ApiOperation(value = "Get all Books")
    @GetMapping("")
    public List<Book> findAll() {
        return  booksRepository.findAll();
    }
    @ApiOperation(value = "Filter Books By Title Or Authors")
    @GetMapping (value= "", params = "filter")
    public List<Book> findBooksFilteredByTitleOrAuthors( @PathParam(value = "filter") String filter) {
        return  booksRepository.
                findAllByTitleContainingIgnoreCaseOrAuthorsContainingIgnoreCase(filter,filter);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Optional<Book> book = booksRepository.findById(id);
        return  (book.isPresent()) ?
                new ResponseEntity<>(book.get(), HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   
    @PostMapping (path = "/category/{catId}")
    public ResponseEntity<Book> addBook(@PathVariable Long catId,
                                        @RequestBody Book book) {

       Optional<Category> category = categoriesRepository.findById(catId);
       if (! category.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            else {
                book.setCategory(category.get());
                Book result = booksRepository.save(book);
                return (result != null)?
                        new ResponseEntity<Book>(result, HttpStatus.OK)
                        : new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}

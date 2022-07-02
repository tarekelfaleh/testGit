package be.businesstraining.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.businesstraining.domain.Book;
import be.businesstraining.domain.Category;
import be.businesstraining.repository.ICategoriesRepository;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
public class CategoriesRestController {

    private ICategoriesRepository categoriesRepository;

    // The @Autowired decoration is not required for constructor injection
    public CategoriesRestController(ICategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @GetMapping
    public List<Category> findAll() {
        return  categoriesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Optional<Category> category = categoriesRepository.findById(id);
        return  category.isPresent()?
                new ResponseEntity<>(category.get(), HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/{id}/books")
    public ResponseEntity<List<Book>> findBooksForCategory(@PathVariable Long id) {
        Optional<Category> category = categoriesRepository.findById(id);
        if (category.isPresent()) {
             List<Book> books = category.get().getBooks();
             return (books !=null)?
                     new ResponseEntity<>(books, HttpStatus.OK):
                     new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

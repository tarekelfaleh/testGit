package be.businesstraining.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import be.businesstraining.domain.Book;
import be.businesstraining.domain.Category;
import be.businesstraining.repository.IBooksRepository;
import be.businesstraining.repository.ICategoriesRepository;

@ExtendWith(MockitoExtension.class)
public class BooksRestControllerTest {

	@Mock
	IBooksRepository booksRepository;

	@Mock
	ICategoriesRepository categoriesRepository;

	@InjectMocks
	BooksRestController booksRestController;

	@Test
	public void testFindById() {
		// given
		Book book1 = new Book(01L, "Jenkins Up and Running", "Brent Laster", null, "description", BigDecimal.TEN,
				"Book image");

		when(booksRepository.findById(01L)).thenReturn(Optional.of(book1));

		// when
		ResponseEntity<Book> actual = booksRestController.findById(01L);

		// then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(actual.getBody().getTitle()).isEqualTo(book1.getTitle());
		assertThat(actual.getBody().getPrice()).isEqualTo(book1.getPrice());
	}
	@Test
	public void testFindById_Not_Found() {
		// given

		when(booksRepository.findById(20L)).thenReturn(Optional.empty());

		// when
		ResponseEntity<Book> actual = booksRestController.findById(20L);

		// then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}


	@Test
	public void testAddBook() {
		// given
		Book bookToAdd = new Book(1L, "Using Docker", "Adrian Mouat", null, "description", BigDecimal.TEN,
				"Book image");

		Category category = new Category(1L, "DevOps Books", null);

		when(categoriesRepository.findById(1L)).thenReturn(Optional.of(category));
		when(booksRepository.save(bookToAdd)).thenReturn(bookToAdd);

		// when
		ResponseEntity<Book> actual = booksRestController.addBook(1L, bookToAdd);

		// then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(actual.getBody().getTitle()).isEqualTo(bookToAdd.getTitle());
		assertThat(actual.getBody().getPrice()).isEqualTo(bookToAdd.getPrice());
	}
	@Test
	public void testAddBook_Failing() {
		// given
		Book bookToAdd = new Book(55L, "Using Docker", "Adrian Mouat", null, "description", BigDecimal.TEN,
				"Book image");

		//No Category for the book !
		Optional<Category> emptyCategory = Optional.empty();
		when(categoriesRepository.findById(55L)).thenReturn(emptyCategory);

		// It is not necessary to mock the books repository since the execution flow will
		// not walk into it.

		// when
		ResponseEntity<Book> actual = booksRestController.addBook(55L, bookToAdd);

		// then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
	}

	@Test
	public void testFindAllBooks() {
		// given
		Book book1 = new Book(01L, "Jenkins Up and Running", "Brent Laster", null, "description", BigDecimal.TEN,
				"Book image");
		Book book2 = new Book(01L, "Spring Boot In Action", "Craig Walls", null, "description", BigDecimal.ONE,
				"Book image");
		List<Book> books = new ArrayList<>(Arrays.asList(book1, book2));

		when(booksRepository.findAll()).thenReturn(books);

		// when
		List<Book> actual = booksRestController.findAll();

		// then
		assertThat(actual.size()).isEqualTo(2);
		assertThat(actual.get(0).getTitle()).isEqualTo(book1.getTitle());
		assertThat(actual.get(1).getPrice()).isEqualTo(book2.getPrice());

	}

}

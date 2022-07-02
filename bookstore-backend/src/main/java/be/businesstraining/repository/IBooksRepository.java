package be.businesstraining.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.businesstraining.domain.Book;

public interface IBooksRepository extends JpaRepository<Book,Long> {

    public List<Book>findAllByTitleContainingIgnoreCaseOrAuthorsContainingIgnoreCase(String title, String authors);

}

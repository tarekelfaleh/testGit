package be.businesstraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.businesstraining.domain.Category;

public interface ICategoriesRepository extends JpaRepository<Category,Long> {
}

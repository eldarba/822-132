package app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.core.entities.BookStore;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStore, Integer> {

}

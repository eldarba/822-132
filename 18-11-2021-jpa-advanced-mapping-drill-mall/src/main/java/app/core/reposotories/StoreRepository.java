package app.core.reposotories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {

	List<Store> findByNameStartsWith(String prefix);

}

package app.core.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import app.core.entities.Product;
import app.core.entities.Store;
import app.core.exceptions.MallException;
import app.core.reposotories.ProductRepository;
import app.core.reposotories.StoreRepository;

@Service
@Transactional
public class MallService {

	private ProductRepository productRepository;
	private StoreRepository storeRepository;

	public MallService(ProductRepository productRepository, StoreRepository repository) {
		super();
		this.productRepository = productRepository;
		this.storeRepository = repository;
	}

	public int addStore(Store store) {
		store = this.storeRepository.save(store);
		return store.getId();
	}

	public Store getStore(int storeId) {
		// the long way - traditional
		Optional<Store> opt = this.storeRepository.findById(storeId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new MallException("getStore failed - store " + storeId + " not found");
		}

		// the short way - using functional programming syntax
		// return this.storeRepository.findById(storeId) .orElseThrow(() -> new
		// MallException("getStore failed - store " + storeId + " not found"));
	}

	public List<Store> getAllStoresInMall() {
		return this.storeRepository.findAll();
	}

	public List<Store> getAllStoresInMall(String prefix) {
		return this.storeRepository.findByNameStartsWith(prefix);
	}

	public void updateStore(Store store) {
		Store storeFromDb = getStore(store.getId());
		storeFromDb.setName(store.getName());
	}

	public void deleteStore(int storeId) {
		this.storeRepository.deleteById(storeId);
	}

	public void addProductToStore(int storeId, Product product) {
		Store store = getStore(storeId);
		store.getProducts().add(product);
	}

	public Product getProduct(int productId) {
		Optional<Product> opt = this.productRepository.findById(productId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new MallException("getProduct failed - product " + productId + " not found");
		}
	}

	public List<Product> getAllProductsInMall() {
		return this.productRepository.findAll();
	}

	public List<Product> getAllProductsInMall(double maxPrice) {
		return this.productRepository.findByPriceLessThanEqual(maxPrice);
	}
}

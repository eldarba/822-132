package app.core;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Product;
import app.core.entities.Store;
import app.core.services.MallService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		MallService service = ctx.getBean(MallService.class);

		try {

//			{ // add a store
//				Product p1 = new Product(0, "TV", 5000);
//				Product p2 = new Product(0, "Table", 1600);
////				Product p3 = new Product(0, "Belt", 70);
////				List<Product> products = Arrays.asList(p1, p2, p3);
//				List<Product> products = Arrays.asList(p1, p2);
//				Store store = new Store(0, "Fox-Home", products);
//				service.addStore(store);
//			}

			{ // get all stores
				List<Store> stores = service.getAllStoresInMall();
				System.out.println(stores);

				System.out.println(service.getAllStoresInMall("Fox"));
			}

//			{ // get a store
//				Store store = service.getStore(1);
//				System.out.println(store);
//				System.out.println(store.getProducts());
//			}

//			{ // update store
//				Store store = new Store(1, "Fox-Kids", null);
//				service.updateStore(store);
//			}

//			{ //
//				service.deleteStore(2);
//				System.out.println("deleted");
//			}

//			{ // add product to store
//				service.addProductToStore(1, new Product(0, "Socks", 25));
//				System.out.println("added");
//			}

//			{ // get all products
//				System.out.println(service.getAllProductsInMall());
//				System.out.println(service.getAllProductsInMall(70));
//			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}

package app.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Order {

	private String storeAddressA;
	@Value("${store.email:default-email-value}")
	private String email;

	@Autowired
	public Order(String storeAddressB) {
		super();
		this.storeAddressA = storeAddressB;
	}

	public String getStoreAddressB() {
		return storeAddressA;
	}

	public void setStoreAddressB(String storeAddressB) {
		this.storeAddressA = storeAddressB;
	}

	@Override
	public String toString() {
		return "Order [storeAddressA=" + storeAddressA + ", email=" + email + "]";
	}

}

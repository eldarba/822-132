package app.core.beans;

import java.util.Scanner;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements BeanNameAware {
	@Value("${prop1:ERROR}")
	private String prop1;
	private String beanName;
	private int beanProcessOrder;
	private String beanSerial;
	private Scanner scanner;

	public MyBean() {
		System.out.println("=== MyBean CTOR");
		this.scanner = new Scanner(System.in);
		System.out.println(this);
		System.out.println("===============");
	}

	@Override
	public String toString() {
		return "MyBean [prop1=" + prop1 + ", beanName=" + beanName + ", beanProcessOrder=" + beanProcessOrder
				+ ", beanSerial=" + beanSerial + ", scanner=" + scanner + "]";
	}

	// BeanNameAware
	@Override
	public void setBeanName(String name) {
		System.out.println("setBeanName: BeanNameAware");
		this.beanName = name;
	}

	public void setBeanProcessOrder(int beanProcessOrder) {
		this.beanProcessOrder = beanProcessOrder;
	}

}

package app.core.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("thePerson")
@Scope("prototype")
public class Person implements BeanNameAware {

	private String name;
	private String beanName;

	public String getBeanName() {
		return beanName;
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", beanName=" + beanName + "]";
	}

}

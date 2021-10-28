package app.core.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//@Component
public class MyPostProcessor1 implements BeanPostProcessor {

	private int c;

	@Override // before initialization
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		c++;
		System.out.println("--- MyPostProcessor1 - BEFORE - of bean #" + c + " - " + beanName);
		if (bean instanceof MyBean) {
			MyBean myBean = (MyBean) bean;
			myBean.setBeanProcessOrder(c);
		}
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override // before initialization
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("--- MyPostProcessor1 - AFTER - of bean #" + c + " - " + beanName);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

}

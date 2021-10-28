package app.core.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyPostProcessor1 implements BeanPostProcessor {

	private int c;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		c++;
		System.out.println("--- MyPostProcessor1 - before - of bean #" + c + " - " + beanName);
		if (bean instanceof MyBean) {
			MyBean myBean = (MyBean) bean;
			myBean.setBeanProcessOrder(c);
		}
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

}

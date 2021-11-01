package app.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration // tell spring that this is a configuration class that can contain @Bean methods
@ComponentScan // tell spring container to scan classes in the package and sub packages of
				// spring annotations
@PropertySource("application.properties") // tell spring container where properties file is
public class Config {

	@Bean
	@Scope("singleton")
	public Person otherPerson(@Value("${person.name}") String name) {
		Person p = new Person();
		p.setName(name);
		return p;
	}

}

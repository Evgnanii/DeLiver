package by.st.deliver.core.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@ComponentScan(basePackages = "by.st.deliver.core.*")
@EnableJpaRepositories("by.st.deliver.core.dao")
@EntityScan("by.st.deliver.core.entities")
@EnableAutoConfiguration
@EnableScheduling
public class CoreConfiguration {

}

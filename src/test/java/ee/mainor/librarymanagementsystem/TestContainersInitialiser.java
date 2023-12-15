package ee.mainor.librarymanagementsystem;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.lifecycle.Startables;
import org.testcontainers.utility.DockerImageName;

public class TestContainersInitialiser implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    static PostgreSQLContainer<?> postgre = new PostgreSQLContainer<>(DockerImageName.parse("postgres:15"));

    static {
        Startables.deepStart(postgre).join();
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        TestPropertyValues.of(
                "spring.datasource.url=" + postgre.getJdbcUrl(),
                "spring.datasource.username=" + postgre.getUsername(),
                "spring.datasource.password=" + postgre.getPassword()
        ).applyTo(applicationContext.getEnvironment());
    }



}

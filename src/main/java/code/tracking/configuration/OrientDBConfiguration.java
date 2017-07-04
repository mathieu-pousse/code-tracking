package code.tracking.configuration;

import code.tracking.business.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orient.OrientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.orient.commons.core.OrientTransactionManager;
import org.springframework.data.orient.commons.repository.config.EnableOrientRepositories;
import org.springframework.data.orient.object.OrientObjectDatabaseFactory;
import org.springframework.data.orient.object.OrientObjectTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

@Configuration
@EnableTransactionManagement
@EnableOrientRepositories("code.tracking.repository")
public class OrientDBConfiguration {

    @Autowired
    private OrientProperties orientdb;

    @Bean
    public OrientObjectDatabaseFactory factory() {
        OrientObjectDatabaseFactory factory = new OrientObjectDatabaseFactory();

        factory.setUrl(orientdb.getUrl());
        factory.setUsername(orientdb.getUsername());
        factory.setPassword(orientdb.getPassword());

        return factory;
    }

    @Bean
    public OrientTransactionManager transactionManager() {
        return new OrientTransactionManager(factory());
    }

    @Bean
    public OrientObjectTemplate objectTemplate() {
        return new OrientObjectTemplate(factory());
    }


    @PostConstruct
    public void registerEntities() {
        factory().db().getEntityManager().registerEntityClass(Project.class);
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.belchan.config;

import org.belchan.service.email.EmailAccount;
import org.belchan.ui.InMemoryMessageRepository;
import org.belchan.ui.Message;
import org.belchan.ui.MessageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
        "org.belchan.repository"
})
public class Config implements TransactionManagementConfigurer {

    private static final String PACKAGES_TO_SCAN = "org.belchan";

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${dataSource.driverClassName}")
    private String driver;
    @Value("${hibernate.dialect}")
    private String dialect;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;
    @Value("${email.login}")
    private String emailLogin;
    @Value("${email.password}")
    private String emailPassword;
    @Value("${email.server}")
    private String emailServer;
    @Value("${email.port}")
    private String emailPort;

    public static Env env;

    public Config() {
    }
//
//    @Bean
//    public DataSource buildDataSource() {
//        HikariConfig config = new HikariConfig();
//        config.setDriverClassName(this.driver);

//
//        if (Objects.isNull(mysqlPasswordOpenShift)) {
//            //DEV
//            config.setJdbcUrl(this.url);
//            config.setUsername(this.username);
//            config.setPassword(this.password);
//        } else {
//            //PROD
//            //jdbc:mysql://${OPENSHIFT_MYSQL_DB_HOST}:${OPENSHIFT_MYSQL_DB_PORT}/${OPENSHIFT_APP_NAME}

//            config.setJdbcUrl(dataSourceMysqlUrlOpenShift);
//            config.setUsername(mysqlUsernameOpenShift);
//            config.setPassword(mysqlPasswordOpenShift);
//        }
//        System.out.println("=====================BEGIN========================");
//        System.out.println("URL");
//        System.out.println(config.getJdbcUrl());
//        System.out.println("USER");
//        System.out.println(config.getUsername());
//        System.out.println("PASS");
//        System.out.println(config.getPassword());
//        System.out.println("=====================END========================");
//        return new HikariDataSource(config);
//    }


    @Bean
    public DataSource buildDataSource() {
        DataSourceBuilder dsb = DataSourceBuilder.create();
        switch (env) {
            case PROD: {
                String mysqlHostOpenShift = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
                String mysqlPortOpenShift = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
                String appNameOpenShift = System.getenv("OPENSHIFT_APP_NAME");
                String mysqlUsernameOpenShift = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
                String mysqlPasswordOpenShift = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
                String dataSourceMysqlUrlOpenShift = "jdbc:mysql://" + mysqlHostOpenShift + ":" + mysqlPortOpenShift + "/" + appNameOpenShift;
                dsb.driverClassName(driver);
                dsb.url(dataSourceMysqlUrlOpenShift);
                dsb.username(mysqlUsernameOpenShift);
                dsb.password(mysqlPasswordOpenShift);
            }
            break;
            case TEST: {

            }
            break;
            case DEV:
            default: {
                dsb.driverClassName(driver);
                dsb.url(url);
                dsb.username(username);
                dsb.password(password);
            }
            break;
        }
        return dsb.build();
    }


    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new JpaTransactionManager();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(this.buildDataSource());
        localSessionFactoryBean.setPackagesToScan(PACKAGES_TO_SCAN);
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", this.dialect);
        hibernateProperties.setProperty("hibernate.show_sql", Boolean.TRUE.toString());
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);
        return localSessionFactoryBean;
    }

    @Bean
    public EmailAccount emailAccount() {
        EmailAccount emailAccount = new EmailAccount();
        emailAccount.setEMAIL(this.emailLogin);
        emailAccount.setLOGIN(this.emailLogin);
        emailAccount.setPASSWORD(this.emailPassword);
        emailAccount.setSERVER(this.emailServer);
        emailAccount.setSmtpPort(this.emailPort);
        return emailAccount;
    }

    @Bean
    public MessageRepository messageRepository() {
        return new InMemoryMessageRepository();
    }

    @Bean
    public Converter<String, Message> messageConverter() {
        return new Converter<String, Message>() {
            @Override
            public Message convert(String id) {
                return messageRepository().findMessage(Long.valueOf(id));
            }
        };
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(false);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("org.belchan");
        factory.setDataSource(buildDataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }


}

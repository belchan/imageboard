//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.belchan.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.belchan.ImageBoardApplication;
import org.belchan.service.email.EmailAccount;
import org.belchan.ui.InMemoryMessageRepository;
import org.belchan.ui.Message;
import org.belchan.ui.MessageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = {ImageBoardApplication.class}
)
public class Config implements TransactionManagementConfigurer {

    public static final String PackagesToScan = "null";
    static {

    }

    @Value("${dataSource.driverClassName}")
    private String driver;
    @Value("${dataSource.url}")
    private String url;
    @Value("${dataSource.username}")
    private String username;
    @Value("${dataSource.password}")
    private String password;
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

    public Config() {
    }

    @Bean
    public DataSource configureDataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(this.driver);
        config.setJdbcUrl(this.url);
        config.setUsername(this.username);
        config.setPassword(this.password);
        return new HikariDataSource(config);
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new JpaTransactionManager();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(this.configureDataSource());
        localSessionFactoryBean.setPackagesToScan(PackagesToScan);
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


}

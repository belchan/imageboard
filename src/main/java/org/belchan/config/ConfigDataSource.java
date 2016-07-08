package org.belchan.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class ConfigDataSource {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${dataSource.driverClassName}")
    private String driver;

    Logger logger = LoggerFactory.getLogger(getClass().getName());
    
    @Bean
    @Profile("openshift")
    @Qualifier("dataSource")
    public DataSource buildDataSourceOpenShift() {
        DataSourceBuilder dsb = DataSourceBuilder.create();
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
        logger.info("=====================BEGIN=========PROD===============");
        logger.info("URL");
        logger.info(dataSourceMysqlUrlOpenShift);
        logger.info("USER");
        logger.info(mysqlUsernameOpenShift);
        logger.info("PASS");
        logger.info(mysqlPasswordOpenShift);
        logger.info("=====================END==============================");
        return dsb.build();
    }


    @Bean
    @Profile("DEV")
    @Qualifier("dataSource")
    public DataSource buildDataSourceDev() {
        DataSourceBuilder dsb = DataSourceBuilder.create();
        dsb.driverClassName(driver);
        dsb.url(url);
        dsb.username(username);
        dsb.password(password);
        logger.info("=====================BEGIN=========DEV================");
        logger.info("URL");
        logger.info(url);
        logger.info("USER");
        logger.info(username);
        logger.info("PASS");
        logger.info(password);
        logger.info("=====================END==============================");
        return dsb.build();
    }

}

package org.belchan;

import org.belchan.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;
import java.util.Objects;

@SpringBootApplication
public class ImageBoardApplication {
    public ImageBoardApplication() {
    }

    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n", envName, env.get(envName));
        }
        String mysqlHostOpenShift = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
        String mysqlPortOpenShift = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        String appNameOpenShift = System.getenv("OPENSHIFT_APP_NAME");
        String mysqlUsernameOpenShift = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
        String mysqlPasswordOpenShift = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
        if (Objects.nonNull(mysqlPasswordOpenShift)) {
            String dataSourceMysqlUrlOpenShift = "jdbc:mysql://" + mysqlHostOpenShift + ":" + mysqlPortOpenShift + "/" + appNameOpenShift;
            System.out.println("=====================BEGIN========================");
            System.out.println("URL");
            System.out.println(dataSourceMysqlUrlOpenShift);
            System.out.println("USER");
            System.out.println(mysqlUsernameOpenShift);
            System.out.println("PASS");
            System.out.println(mysqlPasswordOpenShift);
            System.out.println("=====================END========================");
        }

        SpringApplication.run(new Class[]{ImageBoardApplication.class, Config.class}, args);
    }
}
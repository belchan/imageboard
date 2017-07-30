package org.belchan;

import org.belchan.config.Config;
import org.belchan.config.ConfigDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ImageBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(
                new Class[]{
                        ImageBoardApplication.class,
                        ConfigDataSource.class,
                        Config.class},
                args);
    }
}
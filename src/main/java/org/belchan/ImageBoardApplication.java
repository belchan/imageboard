package org.belchan;

import org.belchan.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class ImageBoardApplication {
    public ImageBoardApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{ImageBoardApplication.class, Config.class}, args);
    }
}
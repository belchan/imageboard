package org.belchan;

import org.belchan.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class ImageBoardApplication {
    public ImageBoardApplication() {
    }

    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n", envName, env.get(envName));
        }
        SpringApplication.run(new Class[]{ImageBoardApplication.class, Config.class}, args);
    }
}
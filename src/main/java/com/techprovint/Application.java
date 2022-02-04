package com.techprovint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
@Slf4j
public class Application  implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Application.run start");

        createHealthFile();

        // it's important to join the thread to keep container running and avoid pod restart
        Thread.currentThread().join();
    }

    private void createHealthFile() throws Exception {
        final String filePath = System.getProperty("java.io.tmpdir") + "/health";
        File file = new File(filePath);
        file.createNewFile();
    }
}

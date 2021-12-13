package pl.kietlinski.projektjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
@EnableScheduling
public class ProjektJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjektJavaApplication.class, args);
    }

}

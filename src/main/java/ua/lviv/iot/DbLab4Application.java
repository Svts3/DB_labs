package ua.lviv.iot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ua.lviv.iot.view.View;

@SpringBootApplication
public class DbLab4Application implements CommandLineRunner {

    private View view;

    @Autowired
    public DbLab4Application(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        SpringApplication.run(DbLab4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        view.show();
    }

}

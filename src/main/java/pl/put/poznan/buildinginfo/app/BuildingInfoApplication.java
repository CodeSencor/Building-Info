package pl.put.poznan.buildinginfo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.buildinginfo.api"})
public class BuildingInfoApplication {

    public static void main(String[] args) {
        if (args.length > 0) {
            System.setProperty("app.location.jsonPath", args[0]);
        }
        SpringApplication.run(BuildingInfoApplication.class, args);
    }
}

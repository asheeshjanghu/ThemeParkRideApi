package com.asheesh;

import com.asheesh.entity.ThemeParkRide;
import com.asheesh.repository.ThemeParkRideRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThemeParkApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThemeParkApplication.class);
    }

    @Bean
    public CommandLineRunner sampleData(ThemeParkRideRepository repository) {
        return (args) -> {
            repository.save(new ThemeParkRide("LakshmanJhoola", 5, "Dheere se jhulaye"));
            repository.save(new ThemeParkRide("RamJhoola", 20, "Bahut Zor se jhulaye"));
            repository.save(new ThemeParkRide("BharatJhoola", 15, "Zor se jhulaye"));
        };
    }
}

package com.asheesh.controller;

import com.asheesh.entity.ThemeParkRide;
import com.asheesh.repository.ThemeParkRideRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.function.Supplier;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ThemeParkRideController {
    private ThemeParkRideRepository themeParkRideRepository;

    public ThemeParkRideController(ThemeParkRideRepository themeParkRideRepository) {
        this.themeParkRideRepository = themeParkRideRepository;
    }

    @GetMapping(value = "/ride", produces = APPLICATION_JSON_VALUE)
    Iterable<ThemeParkRide> getRides() {
        return themeParkRideRepository.findAll();
    }

    @GetMapping(value = "/ride/{id}", produces = APPLICATION_JSON_VALUE)
    ThemeParkRide getRide(@PathVariable Long id) {
        return themeParkRideRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id looks dodgy"));
    }

    @PostMapping(value = "/ride", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ThemeParkRide createRide(@Valid @RequestBody ThemeParkRide themeParkRide) {
        return themeParkRideRepository.save(themeParkRide);
    }
}

package com.asheesh.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@ToString
@Getter
public class ThemeParkRide {
    @Id
    @GeneratedValue()
    private Long id;

    @NotEmpty
    private String name;

    private Integer fare;

    @NotEmpty
    private String description;

    public ThemeParkRide(@NotEmpty String name, @NotEmpty Integer fare, @NotEmpty String description) {
        this.name = name;
        this.fare = fare;
        this.description = description;
    }
}

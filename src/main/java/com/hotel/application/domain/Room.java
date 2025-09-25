package com.hotel.application.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private int id;
    private Integer floor;
    private Integer number;
    private Double price;

    public Room(Integer floor, Integer number, Double price) {
        this.floor = floor;
        this.number = number;
        this.price = price;
    }
}

package com.hotel.application.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    private int id;
    private String name;
    private List<Room> rooms;
    private Double basePrice;

    public Hotel(String name, List<Room> rooms, Double basePrice) {
        this.name = name;
        this.rooms = rooms;
        this.basePrice = basePrice;
    }
}

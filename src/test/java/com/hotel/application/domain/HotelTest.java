package com.hotel.application.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HotelTest {
    private Hotel hotel;

    @BeforeEach
    void setup() {
        hotel = create();
    }

    @Test
    void hotelExists() {
        assertNotNull(hotel);
        assertEquals("My Hotel", hotel.getName());
        assertNotNull(hotel.getRooms());
        assertEquals(0, hotel.getRooms().size());
    }

    @Test
    void roomsExists() {
        assertEquals(2, hotel.getRooms().size());
    }

    /*
    PRIVATE METHODS
     */

    private List<Room> populate() {
        Room r1 = new Room(1, 101, 50.5);
        Room r2 = new Room(2, 202, 40.5);

        List<Room> rooms = new ArrayList<>();

        rooms.add(r1);
        rooms.add(r2);

        return rooms;
    }

    private Hotel create() {
        return new Hotel("My Hotel", populate());
    }
}

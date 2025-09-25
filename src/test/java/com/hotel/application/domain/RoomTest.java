package com.hotel.application.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RoomTest {
    private Room room;

    @BeforeEach
    void setup() {
        room = create();
    }

    @Test
    void roomExists() {
        assertNotNull(room);
        assertEquals(1, room.getFloor());
    }

    /*
    PRIVATE METHODS
     */

    private Room create() {
        return new Room(1, 101, 50.5);
    }
}

package com.hotel.application.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookingTest {
    private Booking booking;

    @BeforeEach
    void setup() {
        booking = create();
    }

    @Test
    void bookingExists() {
        assertNotNull(booking);
        assertNotNull(booking.getRoom());
        assertEquals(LocalDate.parse("2025-09-25"), booking.getStartDate());
        assertEquals(LocalDate.parse("2025-09-27"), booking.getEndDate());
    }

    /*
    PRIVATE METHODS
     */

    private Booking create() {
        Room room = new Room(1, 1, 101, 50.5);

        return new Booking(room, LocalDate.parse("2025-09-25"), LocalDate.parse("2025-09-27"));
    }
}

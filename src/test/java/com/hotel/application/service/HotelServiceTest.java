package com.hotel.application.service;

import com.hotel.application.domain.Hotel;
import com.hotel.application.domain.Room;
import com.hotel.application.port.IHotelOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HotelServiceTest {
    @Mock
    private IHotelOutput iHotelOutput;

    private HotelService hotelService;

    @BeforeEach
    void setup() {
        hotelService = new HotelService(iHotelOutput);
    }

    @Test
    void saveTest() {
        int id = 1;

        Hotel input = create();
        Hotel persisted = create();
        persisted.setId(id);

        when(iHotelOutput.save(input)).thenReturn(persisted);

        Hotel result = hotelService.save(input);

        assertNotNull(result);
        assertEquals(id, result.getId());

        verify(iHotelOutput).save(input);
    }

    @Test
    void getPriceFirstFloorFail() {
        Hotel hotel = create();

        assertNotEquals(107.0, hotel.getRooms().get(1).getPrice());
    }

    @Test
    void getPriceFirstFloor() {
        Hotel hotel = create();

        assertEquals(107.0, hotel.getRooms().get(2).getPrice());
    }

    @Test
    void getPriceAllFloors() {
        Hotel hotel = create();
        hotel = hotelService.setAllPrices(hotel);

        assertEquals(107.0, hotel.getRooms().get(2).getPrice());
        assertEquals(122.0, hotel.getRooms().get(3).getPrice());
        assertEquals(133.0, hotel.getRooms().get(4).getPrice());
        assertEquals(100.0, hotel.getRooms().get(5).getPrice());
    }

    /*
    PRIVATE METHODS
     */

    private List<Room> populate() {
        Room r1 = new Room(1, 0, 1, 100.0);
        Room r2 = new Room(2, 1, 201, 40.5);
        Room r3 = new Room(3, 1, 202, 107.0);
        Room r4 = new Room(4, 2, 201, 198.0);
        Room r5 = new Room(5, 3, 301, 473.0);
        Room r6 = new Room(7, 0, 1, 40.0);

        List<Room> rooms = new ArrayList<>();

        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        rooms.add(r4);
        rooms.add(r5);
        rooms.add(r6);

        return rooms;
    }

    private Hotel create() {
        return new Hotel("My Hotel", populate(), 100.0);
    }
}

package com.hotel.application.service;

import com.hotel.application.domain.Hotel;
import com.hotel.application.domain.Room;
import com.hotel.application.port.IHotelInput;
import com.hotel.application.port.IHotelOutput;
import java.util.List;

public class HotelService implements IHotelInput {
    private final IHotelOutput iHotelOutput;

    public HotelService(IHotelOutput iHotelOutput) {
        this.iHotelOutput = iHotelOutput;
    }

    @Override
    public Hotel save(Hotel hotel) {
        return iHotelOutput.save(hotel);
    }

    @Override
    public List<Hotel> findAll() {
        return List.of();
    }

    public Hotel setAllPrices(Hotel hotel) {
        List<Room> rooms = hotel.getRooms();

        for (Room room : rooms) {
            if (room.getFloor() > 0) {
                Double additionalCharge = 0.0;
                Double price = 0.0;
                switch(room.getFloor()) {
                    case 1:
                        additionalCharge = (hotel.getBasePrice() / 100) * 7;
                        price = hotel.getBasePrice() + additionalCharge < 200.0 ? hotel.getBasePrice() + additionalCharge : 200.0;
                        room.setPrice(price);
                        break;
                    case 2:
                        additionalCharge = (hotel.getBasePrice() / 100) * 22;
                        price = hotel.getBasePrice() + additionalCharge < 200.0 ? hotel.getBasePrice() + additionalCharge : 200.0;
                        room.setPrice(price);
                        break;
                    case 3:
                        additionalCharge = (hotel.getBasePrice() / 100) * 33;
                        price = hotel.getBasePrice() + additionalCharge < 200.0 ? hotel.getBasePrice() + additionalCharge : 200.0;
                        room.setPrice(price);
                        break;
                    default:
                        room.setPrice(200.0);
                }

            } else {
                room.setPrice(hotel.getBasePrice());
            }

        }

        return hotel;
    }
}

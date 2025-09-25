package com.hotel.application.port;

import com.hotel.application.domain.Hotel;

import java.util.List;

public interface IHotelOutput {
    Hotel save(Hotel hotel);
    List<Hotel> findAll();
}

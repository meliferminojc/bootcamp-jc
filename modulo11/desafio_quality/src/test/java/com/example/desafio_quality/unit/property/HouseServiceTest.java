package com.example.desafio_quality.unit.property;

import com.example.desafio_quality.entity.District;
import com.example.desafio_quality.entity.Property;
import com.example.desafio_quality.entity.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SpringBootTest
public class HouseServiceTest {
    private District district;
    private Property property;
    private List<Room> roomList = new ArrayList<>();

    @BeforeEach
    public void init() {
        this.district = new District(1L, "District Teste", BigDecimal.valueOf(10.0));
        Room quarto = new Room(1L, "Quarto", 10.0, 10.0);
        this.roomList.add(quarto);
        this.property= new Property(1L, "Property Teste", this.district.getName(), roomList);
    }

    @Test
    public void shouldGetBiggerRoom() {
        Room room1 = new Room(1L, "Room 1", 10.0, 10.0);
        Room room2 = new Room(1L, "Room 2", 13.0, 13.0);
        Room room3 = new Room(1L, "Room 3", 11.0, 10.0);

        this.property.getRoomList().add(room1);
        this.property.getRoomList().add(room2);
        this.property.getRoomList().add(room3);

        Room expectRoom = this.property.getRoomList().stream().max(Comparator.comparing(Room::getM2)).orElse(null);

        Assertions.assertEquals(expectRoom, room2);
    }

    @Test
    public void shouldTotalMetersOfRoom() {
        Double resultValue = this.roomList.get(0).getM2();

        Assertions.assertEquals(100.0, resultValue);
    }

    @Test
    public void shouldTotalMetersOfProperty() {
        Double resultValue = this.property.getTotalM2();

        Assertions.assertEquals(100.0, resultValue);
    }
}

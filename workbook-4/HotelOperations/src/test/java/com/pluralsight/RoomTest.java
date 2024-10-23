package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void checkIn() {
        Reservation reservation = new Reservation("king", 2);
        Room testRoom = new Room(2);

        testRoom.checkIn(reservation);
        boolean isAvailable = testRoom.isAvailable();
        boolean isOccupied = testRoom.isOccupied();

        assertFalse(isAvailable);
        assertTrue(isOccupied);

    }

    @Test
    void checkOut() {
        Reservation reservation = new Reservation("king", 2);
        Room testRoom = new Room(2);

        testRoom.checkIn(reservation);
        testRoom.checkOut();
        boolean isOccupied = testRoom.isOccupied();
        boolean isDirty = testRoom.isDirty();

        assertFalse(isOccupied);
        assertTrue(isDirty);
    }

    @Test
    void clean() {
        Reservation reservation = new Reservation("king", 2);
        Room testRoom = new Room(2);

        testRoom.checkIn(reservation);
        testRoom.checkOut();;
        testRoom.clean();

        assertFalse(testRoom.isDirty());

    }
}
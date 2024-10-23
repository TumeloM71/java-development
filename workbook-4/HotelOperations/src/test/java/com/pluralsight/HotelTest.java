package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @org.junit.jupiter.api.Test
    void bookRoom() {
        //arrange
        Hotel testHotel = new Hotel("The Elfsong Tavern",1,10);

        //act
        boolean bookingSuiteSuccess = testHotel.bookRoom(1,true);
        boolean bookingSuiteFailure = testHotel.bookRoom(2,true);
        boolean bookRoomSuccess = testHotel.bookRoom(3,false);
        boolean bookRoomFailure = testHotel.bookRoom(12,false);

        //assert
        assertTrue(bookingSuiteSuccess);
        assertFalse(bookingSuiteFailure);
        assertTrue(bookRoomSuccess);
        assertFalse(bookRoomFailure);

    }

    @org.junit.jupiter.api.Test
    void getAvailableSuites() {
        //arrange
        Hotel testHotel = new Hotel("Last Light Inn", 1,4);

        //act
        int availableSuites = testHotel.getAvailableSuites();
        testHotel.bookRoom(1,true);
        int availableSuitesAfterBooking = testHotel.getAvailableSuites();

        //assert
        assertEquals(1,availableSuites);
        assertEquals(0,availableSuitesAfterBooking);

    }

    @org.junit.jupiter.api.Test
    void getAvailableRooms() {
        //arrange
        Hotel testHotel = new Hotel("Last Light Inn", 0,4);

        //act
        int availableRooms= testHotel.getAvailableRooms();
        testHotel.bookRoom(3,false);
        int availableRoomsAfterBooking = testHotel.getAvailableRooms();

        //assert
        assertEquals(4,availableRooms);
        assertEquals(1,availableRoomsAfterBooking);

    }
}
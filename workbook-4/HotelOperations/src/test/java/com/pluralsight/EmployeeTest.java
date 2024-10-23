package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void punchIn() {
        Employee jack = new Employee(1201,"Jack James","IT",30);

        jack.punchIn(8.0);

        assertEquals(8.0, jack.getClockInTimeAsDouble());
    }

    @Test
    void punchOut() {
        Employee jack = new Employee(1201,"Jack James","IT",30);

        jack.punchIn(8.0);
        jack.punchOut(16.0);

        assertEquals(16.0, jack.getClockOutTimeAsDouble());
        assertEquals(8, jack.getHoursWorked());
    }
}
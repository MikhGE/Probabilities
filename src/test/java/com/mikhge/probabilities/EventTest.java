package com.mikhge.probabilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EventTest {

    public EventTest() {
    }

    @Test
    void getId() {
        Event event = new Event();
        Assertions.assertEquals(1L, event.getId());
    }
}
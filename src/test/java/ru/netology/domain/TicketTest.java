package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketTest {
    Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);

    Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN", 95);

    Ticket ticket3 = new Ticket(3, 2499, "VKO", "LED", 105);

    Ticket ticket4 = new Ticket(4, 2800, "VKO", "ADL", 180);
    Ticket ticket5 = new Ticket(5, 1299, "KZN", "ADL", 160);


    TicketManager manager = new TicketManager();

    @Test
    void addTicket() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);


        Ticket[] actual = manager.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBy() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] actual = manager.searchBy("VK");
        Ticket[] expected = {ticket2, ticket3, ticket4};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBy1() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] actual = manager.searchBy("S");
        Ticket[] expected = {ticket1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBy2() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] actual = manager.searchBy("v");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBy3() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] actual = manager.searchBy("2");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBy4() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] actual = manager.searchBy("Z");
        Ticket[] expected = {ticket1, ticket2};

        assertArrayEquals(expected, actual);
    }


    @Test
    void deleteById() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        manager.removeById(3);
        Ticket[] actual = manager.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket4};

        assertArrayEquals(expected, actual);
    }

    @Test
    void deleteById2() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);


        assertThrows(NotFoundException.class, () -> {
            manager.removeById(10);
        });
    }

    @Test
    void getTicket() {
        Ticket data = new Ticket(4, 5000, "SVO", "VVO", 660);
        assertEquals(4, data.getId());
        assertEquals(5000, data.getPrice());
        assertEquals("SVO", data.getFrom());
        assertEquals("VVO", data.getTo());
        assertEquals(660, data.getDuration());
    }

    @Test
    void getTicket2() {
        Ticket data = new Ticket();
        assertEquals(0, data.getId());
        assertEquals(0, data.getPrice());
        assertEquals(null, data.getFrom());
        assertEquals(null, data.getTo());
        assertEquals(0, data.getDuration());
    }

    @Test
    void ShouldSearchAndCompareTicket() {
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] actual = manager.findTickets("SVO", "KZN");
        Ticket[] expected = {ticket1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldSearchAndCompareTicket1() {
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findTickets("SVO", "");
        Ticket[] expected = {ticket1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldSearchAndCompareTicket2() {
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);


        Ticket[] actual = manager.findTickets("V", "Z");
        Ticket[] expected = {ticket1, ticket2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldSearchAndCompareTicket3() {
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);


        Ticket[] actual = manager.findTickets("", "");
        Ticket[] expected = {ticket1, ticket5, ticket2, ticket3, ticket4};

        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldSearchAndCompareTicket4() {
        TicketManager manager = new TicketManager();
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);


        Ticket[] actual = manager.findTickets("", "L");
        Ticket[] expected = {ticket5, ticket3, ticket4};

        assertArrayEquals(expected, actual);
    }

    @Test
    void matchTest() {
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket4);
        manager.add(ticket5);

        boolean actual = manager.matches(ticket1, "VKO", "KZN");

        assertEquals(false, actual);
    }

    @Test
    void matchTest1() {
        TicketManager manager = new TicketManager();
        manager.add(ticket1);
        manager.add(ticket4);
        manager.add(ticket5);

        boolean actual = manager.matches(ticket4, "VKO", "AL");

        assertEquals(false, actual);
    }
}


package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 1_999, "SVO", "SVX", 95);
    Ticket ticket2 = new Ticket(2, 2_999, "LED", "SVX", 110);
    Ticket ticket3 = new Ticket(3, 17_000, "KGD", "LED", 255);
    Ticket ticket4 = new Ticket(4, 1_500, "LED", "SVX", 115);
    Ticket ticket5 = new Ticket(5, 18_307, "SVO", "AER", 95);
    Ticket ticket6 = new Ticket(6, 13_800, "SVO", "AER", 120);
    Ticket ticket7 = new Ticket(7, 14_000, "SVO", "AER", 130);
    Ticket ticket8 = new Ticket(8, 8_000, "SVO", "AER", 110);
    Ticket ticket9 = new Ticket(9, 14_000, "SVO", "AER", 117);

    @Test
    public void shouldFindAllFromSVOToAER() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);
        repo.save(ticket9);

        Ticket[] actual = manager.findAll("SVO", "AER");
        Ticket[] expected = {ticket8, ticket6, ticket7, ticket9, ticket5};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindAllImpossibleTo() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);

        Ticket[] actual = manager.findAll("SVO", "IKT");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindAllImpossibleFrom() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);

        Ticket[] actual = manager.findAll("BTK", "SVX");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindAllImpossibleFromAndTo() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);

        Ticket[] actual = manager.findAll("BTK", "ASF");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }
}

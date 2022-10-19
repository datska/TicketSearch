package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicketRepositoryTest {
    TicketRepository repo = new TicketRepository();

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
    public void emptyRepo() {
        Ticket[] expected = {};
        Ticket[] actual = repo.getTickets();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneTicket() {
        repo.save(ticket3);

        Ticket[] expected = {ticket3};
        Ticket[] actual = repo.getTickets();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveSeveralTickets() {
        repo.save(ticket1);
        repo.save(ticket3);
        repo.save(ticket5);

        Ticket[] expected = {ticket1, ticket3, ticket5};
        Ticket[] actual = repo.getTickets();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionWhenSaveProductAlreadyExists() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);


        assertThrows(AlreadyExistsException.class, () -> {
            repo.save(ticket2);
        });
    }
}

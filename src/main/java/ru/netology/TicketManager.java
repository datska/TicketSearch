package ru.netology;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.setRepo(repo);
    }

    public Ticket[] findAll(String from, String to) {
        TicketRepository search = new TicketRepository();
        for (Ticket ticket : repo.getTickets()) {
            if (matches(ticket, from, to)) {
                search.save(ticket);
            }
        }
        Arrays.sort(search.getTickets());
        return search.getTickets();

    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().contains(from)) {
            return (ticket.getTo().contains(to));
        } else {
            return false;
        }
    }


    public TicketRepository getRepo() {
        return repo;
    }

    public void setRepo(TicketRepository repo) {
        this.repo = repo;
    }
}

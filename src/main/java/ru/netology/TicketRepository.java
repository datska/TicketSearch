package ru.netology;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public TicketRepository() {

    }

    public Ticket findById(int id) {
        for (Ticket ticket : getTickets())
            if (ticket.getId() == id) {
                return ticket;
            }
        return null;
    }


    public void save(Ticket ticket) {
        if (null == findById(ticket.getId())) {
            Ticket[] tmp = new Ticket[getTickets().length + 1];
            for (int i = 0; i < getTickets().length; i++) {
                tmp[i] = getTickets()[i];
            }
            tmp[tmp.length - 1] = ticket;
            setTickets(tmp);
        } else {
            throw new AlreadyExistsException("Ticket with ID: " + ticket.getId() + " already exists");

        }
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }
}

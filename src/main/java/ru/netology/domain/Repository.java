package ru.netology.domain;

public class Repository {
    private Ticket[] ticket = new Ticket[0];

    public Ticket[] findAll() {
        return ticket;
    }

    public void save(Ticket addTicket) {
        int length = ticket.length + 1;
        Ticket[] tmp = new Ticket[length];
        for (int i = 0; i < ticket.length; i++) {
            tmp[i] = ticket[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = addTicket;

        ticket = tmp;
    }

    public Ticket findById(int id) {
        for (int i = 0; i < ticket.length; i++) {
            if (ticket[i].getId() == id) {
                return ticket[i];
            }
        }
        return null;
    }

    public void removeById(int id) {
        Ticket toIdent = findById(id);
        if (toIdent == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        } else {
            int length = ticket.length - 1;
            Ticket[] tmp = new Ticket[length];
            int index = 0;
            for (int i = 0; i < ticket.length; i++) {
                if (ticket[i].getId() != id) {
                    tmp[index] = ticket[i];
                    index++;
                }
            }
            ticket = tmp;
        }

    }
}


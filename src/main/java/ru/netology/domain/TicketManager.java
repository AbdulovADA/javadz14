package ru.netology.domain;

import java.util.Arrays;

public class TicketManager {
    private Repository repository = new Repository();

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAll() {
        return repository.findAll();
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Ticket[] searchBy(String text) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, text, "") || matches(ticket, "", text)) {
                int length = result.length + 1;
                Ticket[] tmp = new Ticket[length];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public Ticket[] findTickets(String from, String to) {
        Ticket[] ans = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[ans.length + 1];
                for (int i = 0; i < ans.length; i++) {
                    tmp[i] = ans[i];
                }
                tmp[tmp.length - 1] = ticket;
                ans = tmp;
            }
        }
        Arrays.sort(ans);
        return ans;
    }

    public boolean matches(Ticket ticket, String From, String To) {
        if (ticket.matchesFrom(From) && ticket.matchesTo(To)) {
            return true;
        } else {
            return false;
        }
    }
}




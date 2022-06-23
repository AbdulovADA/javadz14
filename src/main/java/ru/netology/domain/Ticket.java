package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {

    protected int id;

    protected int price;

    protected String from;

    protected String to;

    protected int duration;

    public Ticket(int id, int price, String from, String to, int duration) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.duration = duration;

    }


    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public int compareTo(Ticket otherTicket) {
        if (price < otherTicket.price) {
            return -1;
        }
        if (price > otherTicket.price) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && price == ticket.price && duration == ticket.duration && from.equals(ticket.from) && to.equals(ticket.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, from, to, duration);
    }

    public boolean matchesFrom(String search) {
        if (this.getFrom().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchesTo(String search) {
        if (this.getTo().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}


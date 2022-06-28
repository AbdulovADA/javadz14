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

    public Ticket() {
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


package com.example.assignmentspringsecurity.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "price")
    private double price;

    @Column(name = "type")
    private String type;

    @Column(name = "details")
    private String details;

    public Ticket() {
    }

    public Ticket(int id, LocalDateTime time, double price, String type, String details) {
        this.id = id;
        this.time = time;
        this.price = price;
        this.type = type;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", time=" + time +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}

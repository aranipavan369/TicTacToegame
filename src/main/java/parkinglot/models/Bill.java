package parkinglot.models;

import java.time.LocalDateTime;

public class Bill extends BaseModel{
    private int id;
    private LocalDateTime ExitTime;
    private Ticket ticket;
    private double amouunt;
    private Payment payment;
    private Gate gate;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getExitTime() {
        return ExitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        ExitTime = exitTime;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public double getAmouunt() {
        return amouunt;
    }

    public void setAmouunt(double amouunt) {
        this.amouunt = amouunt;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
}

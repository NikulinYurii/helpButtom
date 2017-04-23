package model;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * Created by yurii on 22.04.17.
 */
@Component
@Entity
public class Message {
    private String phone;
    private Address address;
    private Event event;
    @DateTimeFormat
    private LocalDateTime creationTime;


    public Message() {
    }

    public Message(String phone, Address address, Event event, LocalDateTime creationTime) {
        this.phone = phone;
        this.address = address;
        this.event = event;
        this.creationTime = creationTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "phone='" + phone + '\'' +
                ", address=" + address +
                ", event=" + event +
                ", creationTime=" + creationTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        return phone != null ? phone.equals(message.phone) : message.phone == null;
    }

    @Override
    public int hashCode() {
        return phone != null ? phone.hashCode() : 0;
    }
}

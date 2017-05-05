package com.example.yurii.redbuttom.model;

/**
 * Created by yurii on 05.05.17.
 */

import java.util.Calendar;
import java.util.Date;


/**
 * Created by yurii on 22.04.17.
 */
public class Message {

    private String phone;
    private Address address;
    private Message_Event event;
    private Date creationTime;

    public Message() {
    }

    public Message(String phone, Address address, Message_Event event, Date creationTime) {
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

    public Message_Event getEvent() {
        return event;
    }

    public void setEvent(Message_Event event) {
        this.event = event;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
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


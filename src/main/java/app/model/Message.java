package app.model;


import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by yurii on 22.04.17.
 */
@Entity(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userPhone")
    private User userPhone;

    @OneToOne
    private Address address;

    @Enumerated(EnumType.STRING)
    private Event event;
    private LocalDateTime creationTime;

    public Message() {
    }

    public Message(long id, User userPhone, Address address, Event event, LocalDateTime creationTime) {
        this.id = id;
        this.userPhone = userPhone;
        this.address = address;
        this.event = event;
        this.creationTime = creationTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(User userPhone) {
        this.userPhone = userPhone;
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
                "id=" + id +
                ", userPhone=" + userPhone +
                ", address=" + address +
                ", event=" + event +
                ", creationTime=" + creationTime +
                '}';
    }
}

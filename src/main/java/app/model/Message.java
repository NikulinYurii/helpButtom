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
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne
    private Address address;

    @Enumerated(EnumType.STRING)
    private Event event;
    private LocalDateTime creationTime;

    public Message() {
    }

    public Message(long id, User user, Address address, Event event, LocalDateTime creationTime) {
        this.id = id;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User userPhone) {
        this.user = user;
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
                ", userPhone=" + user +
                ", address=" + address +
                ", event=" + event +
                ", creationTime=" + creationTime +
                '}';
    }
}

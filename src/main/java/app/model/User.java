package app.model;

import javax.persistence.*;
import java.util.List;


/**
 * Created by yurii on 22.04.17.
 */
@Entity(name = "users")
public class User {

    private String name;
    @Id
    private String phone;

    @OneToMany(mappedBy = "userPhone"/*targetEntity = Message.class*/)
    private List<Message> messageList;

    public User() {
    }

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

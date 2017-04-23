package model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;

/**
 * Created by yurii on 22.04.17.
 */
@Component
@Entity(name = "events")
public enum  Event {
    DANGER, MEDISINE;
}

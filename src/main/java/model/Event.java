package model;

import javax.persistence.Entity;

/**
 * Created by yurii on 22.04.17.
 */
@Entity(name = "events")
public enum  Event {
    DANGER, MEDISINE;
}

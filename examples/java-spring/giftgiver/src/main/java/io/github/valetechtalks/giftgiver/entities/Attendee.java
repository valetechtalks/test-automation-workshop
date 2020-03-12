package io.github.valetechtalks.giftgiver.entities;

import javax.persistence.*;

@Entity
@Table(name = "attendees")
public class Attendee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private Long vendorUserId;
    private String name;
    private String rsvpAnswer;
    private boolean awarded;

    public Attendee() { }

    public Attendee(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Long getVendorUserId() {
        return vendorUserId;
    }

    public void setVendorUserId(Long vendorUserId) {
        this.vendorUserId = vendorUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRsvpAnswer() {
        return rsvpAnswer;
    }

    public void setRsvpAnswer(String rsvpAnswer) {
        this.rsvpAnswer = rsvpAnswer;
    }

    public boolean isAwarded() {
        return awarded;
    }

    public void setAwarded(boolean awarded) {
        this.awarded = awarded;
    }
}

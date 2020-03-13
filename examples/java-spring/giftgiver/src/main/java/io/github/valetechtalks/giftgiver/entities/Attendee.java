package io.github.valetechtalks.giftgiver.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.valetechtalks.giftgiver.serializers.AttendeeSerializer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "attendees")
@JsonSerialize(using = AttendeeSerializer.class)
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "vendor_user_id", unique = true, nullable = false)
    private Long vendorUserId;

    @Column(nullable = false)
    private String name;

    @Column(name = "rsvp_answer", nullable = true)
    private String rsvpAnswer;

    @Column(nullable = false)
    private boolean awarded = false;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}

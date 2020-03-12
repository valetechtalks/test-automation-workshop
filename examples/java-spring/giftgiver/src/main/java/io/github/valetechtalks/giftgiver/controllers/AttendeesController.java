package io.github.valetechtalks.giftgiver.controllers;

import io.github.valetechtalks.giftgiver.entities.Attendee;
import io.github.valetechtalks.giftgiver.services.DatabaseSession;
import io.github.valetechtalks.giftgiver.services.MeetupConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AttendeesController {
    private DatabaseSession db;
    private MeetupConsumer meetup;

    public AttendeesController() {
        this.db = new DatabaseSession();
        this.meetup = new MeetupConsumer();
    }

    @GetMapping("/attendees")
    public List<Attendee> Index() {
        List<Attendee> attendees = new ArrayList<Attendee>();

        try {
            this.db.open();
            attendees = this.db.getAll(Attendee.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally{
            this.db.close();
        }

        return attendees;
    }
}

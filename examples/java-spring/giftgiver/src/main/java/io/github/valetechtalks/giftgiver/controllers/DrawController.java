package io.github.valetechtalks.giftgiver.controllers;

import io.github.valetechtalks.giftgiver.entities.Attendee;
import io.github.valetechtalks.giftgiver.repositories.AttendeesRepository;
import io.github.valetechtalks.giftgiver.services.DatabaseSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrawController {
    private DatabaseSession db;
    private AttendeesRepository repos;

    public DrawController() {
        this.db = new DatabaseSession();
        this.repos = new AttendeesRepository(this.db);
    }

    @PostMapping("/attendees/draw")
    public Attendee draw() {
        Attendee attendee = new Attendee();

        try {
            this.db.open();
            attendee = this.repos.getRandom();

            if (attendee != null) {
                attendee.setAwarded(true);
                this.repos.save(attendee);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally{
            this.db.close();
        }

        return attendee;
    }
}

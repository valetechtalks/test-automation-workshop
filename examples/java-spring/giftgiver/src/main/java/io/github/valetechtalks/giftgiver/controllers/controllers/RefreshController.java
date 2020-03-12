package io.github.valetechtalks.giftgiver.controllers.controllers;

import io.github.valetechtalks.giftgiver.entities.Attendee;
import io.github.valetechtalks.giftgiver.services.DatabaseSession;
import io.github.valetechtalks.giftgiver.services.MeetupConsumer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefreshController {
    private DatabaseSession db;
    private MeetupConsumer meetup;

    public RefreshController() {
        this.db = new DatabaseSession();
        this.meetup = new MeetupConsumer();
    }

    @PostMapping("/refresh")
    public void Index() {
        try {
            JSONArray results = meetup.getRSVPs();
            this.db.open();

            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
                JSONObject member = item.getJSONObject("member");

                Attendee attendee = this.db.findBy(Attendee.class, "vendorUserId", member.getLong("id"));

                this.db.beginTransaction();
                if (attendee == null) {
                    attendee = new Attendee();
                    attendee.setVendorUserId(member.getLong("id"));
                    attendee.setAwarded(false);
                }

                attendee.setName(member.getString("name"));

                this.db.save(attendee);
                this.db.commitTransaction();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            this.db.rollbackTransaction();
        } finally{
            this.db.close();
        }
    }
}

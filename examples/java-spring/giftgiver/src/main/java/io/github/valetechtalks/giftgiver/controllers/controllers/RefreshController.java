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
            this.db.open();
            this.db.beginTransaction();
            JSONArray results = meetup.getRSVPs();

            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
                JSONObject member = item.getJSONObject("member");

                Attendee attendee = new Attendee();
                attendee.setVendorUserId(member.getLong("id"));
                attendee.setName(member.getString("name"));
                attendee.setAwarded(false);

                this.db.save(attendee);
            }

            this.db.commitTransaction();
        } catch (Exception ex) {
            ex.printStackTrace();
            this.db.rollbackTransaction();
        } finally{
            this.db.close();
        }
    }
}

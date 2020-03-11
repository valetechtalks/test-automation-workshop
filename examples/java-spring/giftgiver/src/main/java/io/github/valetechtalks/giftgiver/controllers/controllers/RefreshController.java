package io.github.valetechtalks.giftgiver.controllers.controllers;

import io.github.valetechtalks.giftgiver.entities.Attendee;
import io.github.valetechtalks.giftgiver.services.MeetupConsumer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RefreshController {
    private final AtomicLong counter = new AtomicLong();

    @PostMapping("/refresh")
    public List<Attendee> Index() {
        List<Attendee> attendees = new ArrayList<Attendee>();
        JSONArray results = new MeetupConsumer().getRSVPs();

        for (int i = 0; i < results.length(); i++) {
            JSONObject item = results.getJSONObject(i);
            JSONObject member = item.getJSONObject("member");

            Attendee attendee = new Attendee(
                    (int) counter.incrementAndGet(),
                    member.getLong("id"),
                    member.getString("name"),
                    "",
                    false
            );
            attendees.add(attendee);
        }

        return attendees;
    }

}

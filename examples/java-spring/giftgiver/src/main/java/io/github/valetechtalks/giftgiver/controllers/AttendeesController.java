package io.github.valetechtalks.giftgiver.controllers;

import java.util.concurrent.atomic.AtomicLong;
import io.github.valetechtalks.giftgiver.entities.Attendee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendeesController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/attendees")
    public Attendee Index() {
        return new Attendee(1, (long) 999, "Paulo", "", false);
    }
}

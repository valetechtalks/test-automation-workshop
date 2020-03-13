package io.github.valetechtalks.giftgiver.repositories;

import io.github.valetechtalks.giftgiver.entities.Attendee;
import io.github.valetechtalks.giftgiver.services.DatabaseSession;

import java.util.List;
import java.util.Random;

public class AttendeesRepository extends Repository implements IRepository {
    public AttendeesRepository(DatabaseSession db) {
        super(db);
    }

    @Override
    public Attendee find(int id) {
        Attendee attendee = this.find(Attendee.class, id);
        return attendee;
    }

    @Override
    public Attendee findBy(String field, Object value) {
        Attendee attendee = this.findBy(Attendee.class, field, value);
        return attendee;
    }

    @Override
    public Attendee findBy(String field, Object value, String orderBy, String direction) {
        Attendee attendee = this.findBy(Attendee.class, field, value, orderBy, direction);
        return attendee;
    }

    public Attendee getRandom() {
        List<Attendee> attendees = this.where(Attendee.class, "awarded", false, "createdAt", "asc");

        Random rand = new Random();
        int index = rand.nextInt(attendees.size());

        Attendee drawn = attendees.get(index);
        return drawn;
    }

    @Override
    public List<Attendee> findAll() {
        List<Attendee> attendees = this.findAll(Attendee.class);
        return attendees;
    }
}

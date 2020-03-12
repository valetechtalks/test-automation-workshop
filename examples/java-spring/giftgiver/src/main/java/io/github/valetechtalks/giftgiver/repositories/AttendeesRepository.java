package io.github.valetechtalks.giftgiver.repositories;

import io.github.valetechtalks.giftgiver.entities.Attendee;
import io.github.valetechtalks.giftgiver.services.DatabaseSession;

import java.util.List;

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
    public Attendee findBy(String field, Long value) {
        Attendee attendee = this.findBy(Attendee.class, field, value);
        return attendee;
    }

    @Override
    public List<Attendee> findAll() {
        List<Attendee> attendees = this.findAll(Attendee.class);
        return attendees;
    }
}

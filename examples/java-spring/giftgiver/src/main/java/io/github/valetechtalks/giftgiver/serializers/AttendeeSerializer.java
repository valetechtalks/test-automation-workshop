package io.github.valetechtalks.giftgiver.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.github.valetechtalks.giftgiver.entities.Attendee;

import java.io.IOException;

public class AttendeeSerializer extends JsonSerializer<Attendee> {
    @Override
    public void serialize(Attendee attendee, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", attendee.getId());
        gen.writeStringField("name", attendee.getName());
        gen.writeNumberField("vendor_user_id", attendee.getVendorUserId());
        gen.writeStringField("rsvp_answer", attendee.getRsvpAnswer());
        gen.writeBooleanField("awarded", attendee.isAwarded());
        gen.writeStringField("created_at", attendee.getCreatedAt().toString());
        gen.writeStringField("updated_at", attendee.getUpdatedAt().toString());
        gen.writeEndObject();
    }
}

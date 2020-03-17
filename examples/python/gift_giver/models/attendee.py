from orator import Model


class Attendee(Model):
    __table__ = 'attendees'
    __fillable__ = ['name', 'vendor_user_id', 'rsvp_answer', 'awarded']

    pass

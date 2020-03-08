from services.list_attendees import ListAttendees


class AttendeesController:
    def index(self):
        return ListAttendees().list.run().value.result

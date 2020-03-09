from services.list_attendees import ListAttendees
from flask_api import status
from flask import jsonify


class AttendeesController:
    def __init__(self, just_awarded=False):
        self.just_awarded = just_awarded

    def index(self):
        response = ListAttendees().list.run(just_awarded=self.just_awarded)
        if response.is_success:
            return jsonify(response.value.attendees)
        else:
            content = {'error': 'There is no attendee'}
            return content, status.HTTP_404_NOT_FOUND

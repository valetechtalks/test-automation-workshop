from services.draw_attendees import DrawAttendees
from flask_api import status
from flask import jsonify


class DrawController:
    def index(self):
        response = DrawAttendees().draw.run()
        if response.is_success:
            return response.value.attendee
        else:
            content = {'status': 'There is no attendee to draw'}
            return content, status.HTTP_404_NOT_FOUND

from services.list_attendees import ListAttendees
from flask_api import status
from flask import jsonify


class AttendeesController:
    def index(self):
        response = ListAttendees().list.run()
        if response.is_success:
            return jsonify(ListAttendees().list.run().value.result)
        else:
            content = {'status': 'not found'}
            return content, status.HTTP_404_NOT_FOUND

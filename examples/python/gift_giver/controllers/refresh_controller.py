from services.refresh_attendees import RefreshAttendees
from flask_api import status
from flask import jsonify


class RefreshController:
    def index(self):
        response = RefreshAttendees().refresh.run()
        if response.is_success:
            return {'status': 'The attendees were refreshed'}
        else:
            content = {'status': 'Something wrong happen'}
            return content, status.HTTP_500_INTERNAL_SERVER_ERROR

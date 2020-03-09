from controllers.attendees_controller import AttendeesController
from controllers.refresh_controller import RefreshController
from controllers.draw_controller import DrawController


def routes(app):
    app.add_url_rule('/attendees', 'attendees', AttendeesController(just_awarded=False).index, methods=['GET'])
    app.add_url_rule('/attendees/awarded', 'awarded', AttendeesController(just_awarded=True).index, methods=['GET'])
    app.add_url_rule('/refresh', 'refresh', RefreshController().index, methods=['POST'])
    app.add_url_rule('/draw', 'draw', DrawController().index, methods=['POST'])
    return app

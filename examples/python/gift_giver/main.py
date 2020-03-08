from flask import Flask
from controllers.attendees_controller import AttendeesController

app = Flask(__name__)
app.add_url_rule('/', 'index', AttendeesController().index)

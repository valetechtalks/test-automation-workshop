import os
from flask import Flask
from routes import routes
from config import config
import database


app = Flask(__name__)
app = config(app)
routes(app)

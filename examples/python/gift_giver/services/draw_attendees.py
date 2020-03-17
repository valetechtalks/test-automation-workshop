import random
import requests
from stories import story, Success, Failure, Result
from models.attendee import Attendee
from serializers.attendee_serializer import attendee_serializer


class DrawAttendees:
    @story
    def draw(I):
        I.attendees
        I.update
        I.parse
        I.finish

    def attendees(self, ctx):
        attendees = Attendee.all().where('awarded', False).lists('id')
        if len(attendees) > 0:
            return Success(attendees=attendees)
        else:
            return Failure()

    def update(self, ctx):
        attendee_id_selected = random.choice(ctx.attendees)
        attendee = Attendee.where('id', attendee_id_selected).first()
        attendee.update(awarded=True)
        return Success(result=attendee)

    def parse(self, ctx):
        return Success(attendee=attendee_serializer(ctx.result))

    def finish(self, ctx):
        return Result(ctx)

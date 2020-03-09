from stories import arguments, story, Success, Failure, Result
from models.attendee import Attendee
from serializers.attendee_serializer import attendee_serializer


class ListAttendees:
    @story
    @arguments('just_awarded')
    def list(I):
        I.attendees
        I.parse
        I.finish

    def attendees(self, ctx):
        attendees_found = Attendee.all()

        if ctx.just_awarded:
            attendees_found = attendees_found.where('awarded', 1)
        return Success(result=attendees_found)

    def parse(self, ctx):
        return Success(attendees=list(ctx.result.map(attendee_serializer)))

    def finish(self, ctx):
        return Result(ctx)

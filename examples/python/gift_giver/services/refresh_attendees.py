import requests
from models.attendee import Attendee
from stories import story, Success, Failure, Result


class RefreshAttendees:
    url = 'https://api.meetup.com/valetechtalks/events/268854460/rsvps?&sign=true&photo-host=public&fields=answers'

    @story
    def refresh(I):
        I.fetch_attendees_from_vendor
        I.find_or_create
        I.finish

    def fetch_attendees_from_vendor(self, ctx):
        response = requests.get(self.url)
        attendees = list(map(lambda attendee: attendee['member'], response.json()))
        return Success(attendees=attendees)

    def find_or_create(self, ctx):
        for attendee in ctx.attendees:
            first_or_new_attendee = Attendee.first_or_new(vendor_user_id=attendee['id'])
            first_or_new_attendee.name = attendee['name']
            first_or_new_attendee.save()
        return Success()

    def finish(self, ctx):
        return Result(ctx)

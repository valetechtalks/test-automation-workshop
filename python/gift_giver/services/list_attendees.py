from stories import story, Success, Result
from flask import jsonify

class ListAttendees:
    @story
    def list(I):
        I.sucess
        I.finish

    def sucess(self, ctx):
        attendess = [{ 'name': 'Foo' }, { 'name': 'Bar' }]
        return Success(result=jsonify(attendess))

    def finish(self, ctx):
        return Result(ctx)

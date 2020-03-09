from stories import story, Success, Failure, Result


class ListAttendees:
    @story
    def list(I):
        I.sucess
        I.finish

    def sucess(self, ctx):
        attendess = [{'name': 'Foo'}, {'name': 'Bar'}]
        return Success(result=attendess)

    def finish(self, ctx):
        return Result(ctx)

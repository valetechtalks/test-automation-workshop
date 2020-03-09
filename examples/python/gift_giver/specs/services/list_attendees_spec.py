from mamba import description, context, it
from expects import *
from services.list_attendees import ListAttendees

with description('ListAttendees') as self:
    with it('returns a list'):
        expected = [{'name': 'Foo'}, {'name': 'Bar'}]
        expect(expected == ListAttendees().list.run().value.result).to(be_true)

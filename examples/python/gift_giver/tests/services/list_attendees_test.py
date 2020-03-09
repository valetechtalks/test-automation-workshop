from services.list_attendees import ListAttendees


def test_list_attendees():
    expected = [{ 'name': 'Foo' }, { 'name': 'Bar' }]
    assert expected == ListAttendees().list.run().value.result

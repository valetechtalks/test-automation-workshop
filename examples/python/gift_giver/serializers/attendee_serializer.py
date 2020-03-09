def attendee_serializer(attendee):
    return {
        'name': attendee.name,
        'vendor_user_id': attendee.vendor_user_id,
        'awarded': bool(attendee.awarded)
    }

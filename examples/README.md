# Examples

This folder contains code samples for many languages covered in the workshop.

Please, add examples using the following directory structure:

- Language
  + Project/Sample name
    * Code

# Gift Giver

The application gets a list of RSVPs from meetup.com and store in a database of your choice.

Follow the guidelines below for database schema and endpoints.

## Schema

The database schema may slightly vary from one application to another.

- `attendees` table
  + `name` (string, required) attendee name
  + `vendor_user_id` (string, required, unique) user id from meetup.com or other network
  + `rsvp_answer` (string, optional) answer for rsvp question
  + `awarded` (boolean, required) true if the attendee already received a prize

## Endpoints

### `GET /attendees`

- (mandatory) Get the full list of attendees
- (optional) Filter list by fields (e.g. `name`)

Response:
```json
[
  { "name": "Foo", "vendor_user_id": 999, "awarded": false },
  { "name": "Bar", "vendor_user_id": 999, "awarded": true }
]
```

### `POST /attendees`

- (optional) Add a new attendee to the database

Body: 
```json
{
  "name": "Foobar"
}
```

### `GET /attendees/awarded`

- (mandatory) Get the list of awarded attendees, in decrescent order

Response:
```json
[
  { "name": "Foo", "vendor_user_id": 999, "awarded": true },
  { "name": "Bar", "vendor_user_id": 999, "awarded": true }
]
```

### `POST /attendees/draw`

- (mandatory) Draw a random attendee from the list
- (mandatory) Mark `awarded = true` for the drawn attendee

Once drawn, an attendee cannot be drawn again.

Response:
```json
[
  { "name": "Bar", "vendor_user_id": 999, "awarded": true }
]
```

### `POST /refresh`

- (mandatory) Sync / refresh the attendees list from meetup.com

Url to fetch RSVP from:

- https://api.meetup.com/valetechtalks/events/268854460/rsvps?&sign=true&photo-host=public&fields=answers


using System;
namespace GiftGiver.Models.Meetup
{
    public class MeetupEvent
    {
        public long Created { get; set; }
        public long Updated { get; set; }
        public string Response { get; set; }
        public long Guests { get; set; }
        public MeetupEventMember Member { get; set; }
        public MeetupEventInfo Event { get; set; }
        public MeetupEventGroup Group { get; set; }
        public MeetupEventVenue Venue { get; set; }
    }
}

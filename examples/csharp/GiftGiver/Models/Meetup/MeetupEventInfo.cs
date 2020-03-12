using System;
namespace GiftGiver.Models.Meetup
{
    public class MeetupEventInfo
    {
        public string Id { get; set; }
        public string Name { get; set; }
        public int YesRsvpCount { get; set; }
        public long Time { get; set; }
        public long UtcOffset { get; set; }
    }
}

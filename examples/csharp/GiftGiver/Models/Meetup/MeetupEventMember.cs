using System;
namespace GiftGiver.Models.Meetup
{
    public class MeetupEventMember
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public MeetupPhoto Photo { get; set; }
        public MeetupEventContext EventContext { get; set; }
    }
}

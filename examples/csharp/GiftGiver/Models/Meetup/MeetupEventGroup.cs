using System;
namespace GiftGiver.Models.Meetup
{
    public class MeetupEventGroup
    {
        public int Id { get; set; }
        public string Urlname { get; set; }
        public string Name { get; set; }
        public string Status { get; set; }
        public string Who { get; set; }
        public int Members { get; set; }
        public string JoinMode { get; set; }
        public string LocalizedLocation { get; set; }
    }
}

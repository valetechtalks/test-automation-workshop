using System;
namespace GiftGiver.Models.Meetup
{
    public class MeetupPhoto
    {
        public int Id { get; set; }
        public string HighresLink { get; set; }
        public string PhotoLink { get; set; }
        public string ThumbLink { get; set; }
        public string Type { get; set; }
        public string BaseUrl { get; set; }
    }
}

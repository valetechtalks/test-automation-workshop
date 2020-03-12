using System;
namespace GiftGiver.Models.Meetup
{
    public class MeetupEventVenue
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public decimal Lat { get; set; }
        public decimal Lon { get; set; }
        public bool Repinned { get; set; }
        public string Address1 { get; set; }
        public string City { get; set; }
        public string Country{ get; set; }
        public string LocalizedCountryName { get; set; }
    }
}

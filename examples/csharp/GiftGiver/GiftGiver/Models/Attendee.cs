using System;

namespace GiftGiver.Models
{
    public class Attendee : BaseEntity
    {
        public int AttendeeId { get; set; }
        public int VendorUserId { get; set; }
        public string RsvpAnswer { get; set; }
        public string Name { get; set; }
        public bool Awarded { get; set; }
    }
}

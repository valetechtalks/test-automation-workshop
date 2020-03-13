using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace GiftGiver.Models.Database
{
    public class Attendee : BaseEntity
    {
        [Required]
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int AttendeeId { get; set; }

        [Required]
        public int VendorUserId { get; set; }

        public string RsvpAnswer { get; set; }

        [Required]
        public string Name { get; set; }

        [Required]
        public bool Awarded { get; set; }

        public string ImageUrl { get; set; }
    }
}

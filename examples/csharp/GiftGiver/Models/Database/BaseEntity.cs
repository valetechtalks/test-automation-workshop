using System;
using System.ComponentModel.DataAnnotations;

namespace GiftGiver.Models.Database
{
    public class BaseEntity
    {
        [Required]
        public DateTime CreatedDate { get; set; }

        [Required]
        public DateTime UpdatedDate { get; set; }
    }
}

using System;
using System.ComponentModel.DataAnnotations;
namespace GiftGiver.Models
{
    public class BaseEntity
    {
        [Required]
        public DateTime CreatedDate { get; set; }

        [Required]
        public DateTime UpdatedDate { get; set; }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using GiftGiver.Models;
using Microsoft.AspNetCore.Mvc;

namespace GiftGiver.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class AttendeesController : ControllerBase
    {
        [HttpGet]
        public IEnumerable<Attendee> Get()
        {
            using (var db = new GiftGiverContext())
            {
                return db.Attendees.ToArray();
            }
        }

        [Route("awarded")]
        [HttpGet]
        public IEnumerable<Attendee> GetAwarded()
        {
            using (var db = new GiftGiverContext())
            {
                return db.Attendees
                    .Where(attendee => attendee.Awarded)
                    .OrderByDescending(attendee => attendee.UpdatedDate)
                    .ToArray();
            }
        }
    }
}
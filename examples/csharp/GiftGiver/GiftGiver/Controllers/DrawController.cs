using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using GiftGiver.Models;
using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace GiftGiver.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class DrawController : ControllerBase
    {
        [HttpPost]
        public Attendee Post()
        {
            using (var db = new GiftGiverContext())
            {
                var query = db.Attendees.Where(attendee => attendee.Awarded == false);
                var attendeeCount = query.Count();

                if (attendeeCount > 0)
                {
                    var random = new Random();
                    var randomIndex = random.Next(attendeeCount);
                    var attendee = query.Take(randomIndex).First();

                    attendee.Awarded = true;
                    db.SaveChanges();

                    return attendee;
                }

                throw new Exception("No Attendee Found");
            }
        }
    }
}

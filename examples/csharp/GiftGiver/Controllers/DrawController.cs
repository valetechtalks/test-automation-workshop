using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using GiftGiver.Models.Database;
using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace GiftGiver.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class DrawController : ControllerBase
    {
        private readonly GiftGiverContext _context;

        public DrawController(GiftGiverContext context)
        {
            _context = context;
        }

        [HttpPost]
        public Attendee Post()
        {
            var query = _context.Attendees.Where(attendee => attendee.Awarded == false);
            var attendeeCount = query.Count();

            if (attendeeCount > 0)
            {
                var random = new Random();
                var randomIndex = random.Next(attendeeCount);
                var attendee = query.Take(randomIndex).First();

                attendee.Awarded = true;
                _context.SaveChanges();

                return attendee;
            }

            throw new Exception("No Attendee Found");
        }
    }
}

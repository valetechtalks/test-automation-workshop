using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using GiftGiver.Models.Database;
using Microsoft.AspNetCore.Mvc;

namespace GiftGiver.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class AttendeesController : ControllerBase
    {
        private readonly GiftGiverContext _context;

        public AttendeesController(GiftGiverContext context)
        {
            _context = context;
        }

        [HttpGet]
        public IEnumerable<Attendee> Get()
        {
            return _context.Attendees.ToArray();
        }

        [Route("awarded")]
        [HttpGet]
        public IEnumerable<Attendee> GetAwarded()
        {
            return _context.Attendees
                .Where(attendee => attendee.Awarded)
                .OrderByDescending(attendee => attendee.UpdatedDate)
                .ToArray();
        }
    }
}

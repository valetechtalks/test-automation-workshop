using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;
using GiftGiver.Models.Database;
using GiftGiver.Models.Meetup;
using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace GiftGiver.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class RefreshController : ControllerBase
    {
        private readonly IHttpClientFactory _clientFactory;
        private readonly GiftGiverContext _context;

        public RefreshController(IHttpClientFactory clientFactory, GiftGiverContext context)
        {
            _clientFactory = clientFactory;
            _context = context;
        }

        [HttpPost]
        public async Task<string> Post()
        {
            var request = new HttpRequestMessage(HttpMethod.Get,
            "valetechtalks/events/268854460/rsvps?&sign=true&photo-host=public&fields=answers");
            var client = _clientFactory.CreateClient("meetup");

            var response = await client.SendAsync(request);

            if (response.IsSuccessStatusCode)
            {
                var options = new JsonSerializerOptions
                {
                    PropertyNamingPolicy = SnakeCaseNamingPolicy.Instance,
                };

                using var responseStream = await response.Content.ReadAsStreamAsync();
                var events = await JsonSerializer.DeserializeAsync<IEnumerable<MeetupEvent>>(
                    responseStream,
                    options
                    );
                
                foreach (var eventInfo in events)
                {
                    var attendee = _context.Attendees.Where(attendee => attendee.VendorUserId == eventInfo.Member.Id).FirstOrDefault();
                    var imageUrl = eventInfo.Member.Photo?.PhotoLink;

                    if (attendee == null)
                    {
                        _context.Attendees.Add(new Attendee
                        {
                            VendorUserId = eventInfo.Member.Id,
                            Name = eventInfo.Member.Name,
                            ImageUrl = imageUrl,
                            Awarded = false,
                        });
                    }
                    else
                    {
                        attendee.VendorUserId = eventInfo.Member.Id;
                        attendee.Name = eventInfo.Member.Name;
                        attendee.ImageUrl = imageUrl;
                    }
                }

                _context.SaveChanges();

                return "Synced";
            }
            else
            {
                return "Error";
            }
        }

        [HttpDelete]
        public void Delete()
        {
            foreach (var attendee in _context.Attendees)
            {
                _context.Attendees.Remove(attendee);
            }

            _context.SaveChanges();
        }
    }
}

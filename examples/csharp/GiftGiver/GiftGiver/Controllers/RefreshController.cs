using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;
using GiftGiver.Models;
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

        public RefreshController(IHttpClientFactory clientFactory)
        {
            _clientFactory = clientFactory;
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

                using (var db = new GiftGiverContext())
                {
                    foreach (var eventInfo in events)
                    {
                        var attendee = db.Attendees.Find(eventInfo.Member.Id);

                        if (attendee == null)
                        { 
                            db.Attendees.Add(new Attendee
                            {
                                AttendeeId = eventInfo.Member.Id,
                                Name = eventInfo.Member.Name,
                                Awarded = false,
                            });
                        }
                        else
                        {
                            attendee.Name = eventInfo.Member.Name;
                        }
                    }

                    db.SaveChanges();
                }

                return "Synced";
            }
            else
            {
                return "Error";
            }
        }
    }
}

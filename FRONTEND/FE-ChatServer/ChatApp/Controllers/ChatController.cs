using ChatApp.Models;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace ChatApp.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ChatController : ControllerBase
    {
        private static List<ChatMessage> _chatMessages = new List<ChatMessage>()
        {
            new ChatMessage()
            {
                Nickname = "systeem",
                Message = "Server is up"
            }
        };



        // GET: api/<ChatController>
        [HttpGet]
        public IEnumerable<ChatMessage> Get()
        {
            return _chatMessages;
        }

        // POST api/<ChatController>
        [HttpPost]
        public void Post([FromBody] ChatMessage value)
        {
            _chatMessages.Add(value);
        }
    }
}

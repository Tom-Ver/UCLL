using Microsoft.AspNetCore.Mvc;
using StudieBelastingsTeller.Web.Models;
using System.Collections.Generic;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace StudieBelastingsTeller.Web.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class LesController : ControllerBase
    {
        private static List<Les> _lessen = new List<Les>()
        {
            new Les
            {
                Id = 0,
                LesNaam = "C# Basis",
                Studiepunten = 6,
                UrenBesteed = 0
            },
            new Les
            {
                Id = 1,
                LesNaam = "C# Gevorderd",
                Studiepunten = 6,
                UrenBesteed = 0
            }

        };
        // GET: api/<LesController>
        [HttpGet]
        public IEnumerable<Les> Get()
        {
            return _lessen;
        }


        // POST api/<LesController>
        [HttpPost]
        public void Post([FromBody] Les value)
        {
            _lessen.Add(value);
        }

    }
}

using FrontEndGevorderdQuiz.Web.Models;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Linq;

namespace FrontEndGevorderdQuiz.Web.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class QuizController : ControllerBase
    {
        private static List<QuizVraag> _vragen = new List<QuizVraag>()
        {
            new QuizVraag()
            {
                Id = 0, // Elke vraag heeft een unieke ID! Best is om te beginnen met 0 en dan steeds +1
                Vraag = "XHR is de afkorting van ...",
                MogelijkAntwoord0 = "XHtmlRev2",
                MogelijkAntwoord1 = "XmlHttpRequest",
                MogelijkAntwoord2 = "XboxHyperloopRecursion",
                MogelijkAntwoord3 = "Geen van bovenstaande",
                JuisteAntwoordIndex = 1
            },
            new QuizVraag()
            {
                Id = 1,
                Vraag = "De grondlegger van het World Wide Web is ...",
                MogelijkAntwoord0 = "Linus Torvalds",
                MogelijkAntwoord1 = "Nikola Tesla",
                MogelijkAntwoord2 = "Bill Gates",
                MogelijkAntwoord3 = "Tim Berners-Lee",
                JuisteAntwoordIndex = 3
            },
            new QuizVraag()
            {
                Id = 2,
                Vraag = "Welke vaardigheden zijn nodig als front-end ontwikkelaar?",
                MogelijkAntwoord0 = "HTML, CSS, JavaScript, JQuery",
                MogelijkAntwoord1 = "C#, Java",
                MogelijkAntwoord2 = "Humor, Sarcasme",
                MogelijkAntwoord3 = "Google",
                JuisteAntwoordIndex = 0
            },
            new QuizVraag()
            {
                Id = 3,
                Vraag = "Wat is het W3C?",
                MogelijkAntwoord0 = "Een nieuw comfortabel toilet",
                MogelijkAntwoord1 = "World Wide Web Comfort",
                MogelijkAntwoord2 = "World Wide Web Consortium",
                MogelijkAntwoord3 = "World Wide Web op Congé",
                JuisteAntwoordIndex = 2
            },
            new QuizVraag()
            {
                Id = 4,
                Vraag = "Wat doet een Front-End ontwikkelaar?",
                MogelijkAntwoord0 = "Niet veel",
                MogelijkAntwoord1 = "De achterliggende processen en databases",
                MogelijkAntwoord2 = "Professioneel googlen",
                MogelijkAntwoord3 = "Het visuele gedeelte van de website",
                JuisteAntwoordIndex = 3
            },
            new QuizVraag()
            {
                Id = 5,
                Vraag = "Waarvoor staat de afkorting JSON?",
                MogelijkAntwoord0 = "JavaScript Object",
                MogelijkAntwoord1 = "JavaScript Object Notation",
                MogelijkAntwoord2 = "Java Serious Objects Notation",
                MogelijkAntwoord3 = "JavaScript Online Notation",
                JuisteAntwoordIndex = 1
            },
            new QuizVraag()
            {
                Id = 6,
                Vraag = "De JSON keys moeten in:",
                MogelijkAntwoord0 = "Single quotes",
                MogelijkAntwoord1 = "Double quotes",
                MogelijkAntwoord2 = "Dollar signs",
                MogelijkAntwoord3 = "Hoofdletters",
                JuisteAntwoordIndex = 1
            },
            new QuizVraag()
            {
                Id = 7,
                Vraag = "HTML pagina's zijn",
                MogelijkAntwoord0 = "Objecten",
                MogelijkAntwoord1 = "Hex codes",
                MogelijkAntwoord2 = "Text documenten",
                MogelijkAntwoord3 = "Foto's",
                JuisteAntwoordIndex = 2
            },
            new QuizVraag()
            {
                Id = 8,
                Vraag = "CSS staat voor: ",
                MogelijkAntwoord0 = "Cascading Style Sheets",
                MogelijkAntwoord1 = "Cascading Style Style",
                MogelijkAntwoord2 = "Heeft geen betekenis",
                MogelijkAntwoord3 = "Cascading Some Style",
                JuisteAntwoordIndex = 0
            },
            new QuizVraag()
            {
                Id = 9,
                Vraag = "ECMAScript is een scripttaal gedefinieerd door",
                MogelijkAntwoord0 = "Ecma International",
                MogelijkAntwoord1 = "Microsoft",
                MogelijkAntwoord2 = "Apple",
                MogelijkAntwoord3 = "Elon Musk",
                JuisteAntwoordIndex = 0
            },
            new QuizVraag()
            {
                Id = 10,
                Vraag = "Wanneer werd de eerste versie van JavaScript ontwikkeld?",
                MogelijkAntwoord0 = "1990",
                MogelijkAntwoord1 = "1993",
                MogelijkAntwoord2 = "1995",
                MogelijkAntwoord3 = "1997",
                JuisteAntwoordIndex = 2
            },
            new QuizVraag()
            {
                Id = 11,
                Vraag = "Wat is jQuery?",
                MogelijkAntwoord0 = "Een betalende JavaScript-library voor dynamische en interactieve websites",
                MogelijkAntwoord1 = "Een vrije JavaScript-library voor dynamische en interactieve websites",
                MogelijkAntwoord2 = "Een vrije JavaScript-library voor statische en interactieve websites",
                MogelijkAntwoord3 = "Een vrije JavaScript-library voor dynamische websites",
                JuisteAntwoordIndex = 1
            },
            new QuizVraag()
            {
                Id = 12,
                Vraag = "Wat is er nodig voor webpack?",
                MogelijkAntwoord0 = "Intiligentie",
                MogelijkAntwoord1 = "Java",
                MogelijkAntwoord2 = "C#",
                MogelijkAntwoord3 = "Node.js",
                JuisteAntwoordIndex = 3
            },
            new QuizVraag()
            {
                Id = 13,
                Vraag = "Bootstrap is een",
                MogelijkAntwoord0 = "Object",
                MogelijkAntwoord1 = "Framework",
                MogelijkAntwoord2 = "Sociaal platform",
                MogelijkAntwoord3 = "Versiebeheer",
                JuisteAntwoordIndex = 1
            },
            new QuizVraag()
            {
                Id = 14,
                Vraag = "Sass is: ",
                MogelijkAntwoord0 = "een scripttaal die css uitbreidt",
                MogelijkAntwoord1 = "een spoelbak van de wc, voor mensen met spraakgebrek",
                MogelijkAntwoord2 = "Serieus anders, serieus stresserend",
                MogelijkAntwoord3 = "een scripttaal die het mogelijk maakt om data naar de server te sturen.",
                JuisteAntwoordIndex = 0
            },
            new QuizVraag()
            {
                Id = 15,
                Vraag = "Ajax staat voor: ",
                MogelijkAntwoord0 = "Asynchronous JavaScript And XML",
                MogelijkAntwoord1 = "zwakke krijger",
                MogelijkAntwoord2 = "A JavsScript And XML Script",
                MogelijkAntwoord3 = "een amateur ploeg uit nederland",
                JuisteAntwoordIndex = 0
            },
            new QuizVraag()
            {
                Id = 16,
                Vraag = "Welk van volgende input types in NIET correct",
                MogelijkAntwoord0 = "button",
                MogelijkAntwoord1 = "color",
                MogelijkAntwoord2 = "date",
                MogelijkAntwoord3 = "object",
                JuisteAntwoordIndex = 3
            },
            new QuizVraag()
            {
                Id = 17,
                Vraag = "Welke hoort niet in het rijtje",
                MogelijkAntwoord0 = "ISO Date",
                MogelijkAntwoord1 = "Short Date",
                MogelijkAntwoord2 = "CET",
                MogelijkAntwoord3 = "Long Date",
                JuisteAntwoordIndex = 2
            },
            new QuizVraag()
            {
                Id = 18,
                Vraag = "Welke versie bestaat nog niet?",
                MogelijkAntwoord0 = "ES4",
                MogelijkAntwoord1 = "ES6",
                MogelijkAntwoord2 = "ES7",
                MogelijkAntwoord3 = "ES5",
                JuisteAntwoordIndex = 2
            },
            new QuizVraag()
            {
                Id = 19,
                Vraag = "Een html5 document duiden we aan door middel van: ",
                MogelijkAntwoord0 = "!DOCTYPE html",
                MogelijkAntwoord1 = "<!DOCTYPE html>",
                MogelijkAntwoord2 = "!DOCTYPE html5",
                MogelijkAntwoord3 = "<!DOCTYPE html5> ",
                JuisteAntwoordIndex = 1
            },
            new QuizVraag()
            {
                Id = 20,
                Vraag = "Welke geeft de grootste tekst",
                MogelijkAntwoord0 = "<h1>",
                MogelijkAntwoord1 = "<h8>",
                MogelijkAntwoord2 = "<h56>",
                MogelijkAntwoord3 = "<h2>",
                JuisteAntwoordIndex = 0
            },
            new QuizVraag()
            {
                Id = 21,
                Vraag = "Welke statement is juist",
                MogelijkAntwoord0 = "webpack --watch",
                MogelijkAntwoord1 = "webpack --do",
                MogelijkAntwoord2 = "webpack --work",
                MogelijkAntwoord3 = "webpack work",
                JuisteAntwoordIndex = 0
            },

        };

        /// <summary>
        /// Deze methode geeft alle vragen terug als een JSON array.
        /// Op te roepen via een HTTP GET call naar /api/quiz
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public IEnumerable<QuizVraag> Get()
        {
            return _vragen;
        }

        /// <summary>
        /// Deze methode ontvangt alle antwoorden van de speler in één keer.
        /// Op te roepen via een HTTP POST naar /api/quiz met een JSON array in de body.
        /// Je zal dus in de browser elk antwoord moeten bijhouden (vb. in een JavaScript array) en
        /// vervolgens de volledige array omzetten naar JSON.
        /// </summary>
        /// <param name="antwoorden">JSON array met de antwoorden van de speler.</param>
        /// <returns>De score (percentage) van de speler.</returns>
        [HttpPost]
        public QuizResultaat Post([FromBody] IEnumerable<QuizAntwoord> antwoorden)
        {
            int aantalJuisteAntwoorden = 0;

            // Alle antwoorden verwerken
            foreach (QuizAntwoord antwoord in antwoorden)
            {
                // Ophalen van de vraag horende bij het antwoord.
                QuizVraag vraag = _vragen
                    .FirstOrDefault(v => v.Id == antwoord.VraagId);

                // Is het gegeven antwoord ook het juiste antwoord?
                if (vraag.JuisteAntwoordIndex == antwoord.GekozenAntwoordIndex)
                {
                    aantalJuisteAntwoorden++;
                }
            }

            // Berekenen van de score
            // (met die (float) zetten we een geheel getal om naar een komma-getal zodat er geen gehele deling gebeurt).
            float scorePercentage = ((float)aantalJuisteAntwoorden / (float)_vragen.Count) * 100;

            // Terugsturen van het resultaat als antwoord op de POST call.
            return new QuizResultaat()
            {
                Percentage = scorePercentage
            };
        }
    }
}
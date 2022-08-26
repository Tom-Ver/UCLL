let questions = [];

fetch('/api/quiz')
    .then((response) => response.json())
    .then((q) => {
        questions = q;
        next();
    });

let answersPossible = document.querySelectorAll('#questions input[type="radio"]');
let answers = [];
let question = 0;
for (var i = 0; i < answersPossible.length; i++) {
    answersPossible[i].addEventListener('change', function (evt) {
        answers.push({
            VraagId: questions[question].id,
            GekozenAntwoordIndex: parseInt(this.value)
        });
        next();
    });
}

function next() {
    question++;
    if (question < questions.length) {

        document.querySelector('#questions legend').innerText = questions[question].vraag;
        for (let i = 0; i < answersPossible.length; i++) {

            answersPossible[i].checked = false;
        }
        document.getElementById('answer0').innerText = questions[question].mogelijkAntwoord0;
        document.getElementById('answer1').innerText = questions[question].mogelijkAntwoord1;
        document.getElementById('answer2').innerText = questions[question].mogelijkAntwoord2;
        document.getElementById('answer3').innerText = questions[question].mogelijkAntwoord3;
    }
    else {
        fetch('api/quiz', {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(answers)
        })
            .then((response) => response.json())
        .then((result) => {
            resultperc = Math.round(result.percentage)
            alert("Je resultaat is " + resultperc)
        })
    }
  
    }




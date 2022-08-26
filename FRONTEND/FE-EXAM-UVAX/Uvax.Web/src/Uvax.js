let person;
function next() {
    fetch("/api/Reservelijst")
        .then((response) => {
            return response.json();
        })
        .then((p) => {
            person = p;
            document.querySelector('input[name="insz"]').value = person.insz;
            document.querySelector('input[name="voornaam"]').value = person.voornaam;
            document.querySelector('input[name="familienaam"]').value = person.familienaam;
            document.querySelector('input[name="telefoonnr"]').value = person.telefoonnummer;

        })
}
next();

document.querySelector('input[name="nietBeschikbaar"]').addEventListener("click", function (e) { next(); });

document.querySelector('input[name="Beschikbaar"]').addEventListener("click", function (e) {

    if (document.querySelector('input[name="inszBeschikbaar"]').value.length > 0) { //https://www.w3resource.com/javascript/form/non-empty-field.php

        fetch("/api/Beschikbaarheid",
            {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({

                    insz: person.insz,
                    isBeschikbaar: true,
                    valtInVoorInsz: document.querySelector('input[name="inszBeschikbaar"]').value
                })

            })
            .then(() => {
                document.querySelector('input[name="inszBeschikbaar"]').value = "",
                    next();
            })
    }
    else {
        document.querySelector('input[name="inszBeschikbaar"]').className = "form-control is-invalid"; //==>https://stackoverflow.com/questions/195951/how-can-i-change-an-elements-class-with-javascript
        document.getElementById("foutcode").innerHTML = "Dit veld is verplicht";
    };
});

document.querySelector('input[name="nietBeschikbaar2"]').addEventListener("click", function (e) {

    fetch("/api/Beschikbaarheid",
        {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({

                insz: document.querySelector('input[name="insz"]').value,
                isBeschikbaar: false,
                
            })

        })
        .then(() => {
                next();
        })
});

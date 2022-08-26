let lessen = [];
function getLes() {
    fetch('api/les')
        .then((response) => {
            return response.json();
        })
        .then((l) => {
            lessen = l;
        })
        .then(() => {createTable();});
}
getLes();
console.log(lessen);
let les = -1;

function createTable() {
    for (var i = 0; i < lessen.length; i++) {
        les++
        var table = document.getElementById("lesTabel");
        var row = table.insertRow(1);
        var IdCell = row.insertCell(0);
        var NaamCell = row.insertCell(1);
        var StudiepuntenCell = row.insertCell(2);
        var UrenBesteedCell = row.insertCell(3);
        IdCell.innerHTML = lessen[les].id;
        NaamCell.innerHTML = lessen[les].lesNaam;
        StudiepuntenCell.innerHTML = lessen[les].studiepunten
        UrenBesteedCell.innerHTML = lessen[les].urenBesteed
    }
};

document.getElementById("postmes").addEventListener("click", function (e) {
    fetch("/api/les",
        {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(
                {
                    id: lessen.length++,
                    lesNaam: document.querySelector('input[name="lesnaam"]').value,
                    studiepunten: document.querySelector('input[name="sp"]').value,
                    urenBesteed: 0
                })
        })
        .then(() => {
            document.querySelector('input[name="lesnaam"]').value = "";
            document.querySelector('input[name="sp"]').value = "";
        })
        .catch((error) => {
            console.error(error);
        });
    e.preventDefault();
    getLes();
}
);

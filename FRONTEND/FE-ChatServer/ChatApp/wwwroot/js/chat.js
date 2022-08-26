document.getElementById("postMessage").addEventListener("click", function (e) {
    fetch("/api/chat",
        {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(
                {
                    nickname: document.querySelector('input[name="nickname"]').value,
                    message: document.querySelector('input[name="message"]').value
                })
        })
        .then(() => {
            document.querySelector('input[name="message"').value = "";
        })
        .catch((error) => {
            console.error(error);
        });
    e.preventDefault();

    function getMessages() {
        fetch("/api/chat")
            .then((response) => {
                return response.json();
            })
            .then((chatMessages) => {
                let chatHistory = "";
                for (var i = 0; i < chatMessages.length; i++) {
                    chatHistory +=
                        chatMessages[i].nickname + ": " + chatMessages[i].message + '\n';
                }
                document.querySelector("textarea").value = chatHistory;
            })
            .catch((error) => {
                console.error(error);
            })
        setTimout(getMessages, 1000);
    }
    getMessages();

});

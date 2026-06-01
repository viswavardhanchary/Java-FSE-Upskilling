const registerBtn =
    document.getElementById("registerBtn");

registerBtn.addEventListener("click", () => {

    document.getElementById("message").textContent =
        "Sending data...";

    setTimeout(() => {

        fetch(
            "https://jsonplaceholder.typicode.com/posts",
            {
                method: "POST",
                headers: {
                    "Content-Type":
                        "application/json"
                },
                body: JSON.stringify({
                    name: "Viswa",
                    event: "Music Night"
                })
            }
        )
        .then(response => response.json())
        .then(data => {

            console.log(data);

            document.getElementById("message")
            .textContent =
                "Registration Successful";
        })
        .catch(error => {

            console.error(error);

            document.getElementById("message")
            .textContent =
                "Registration Failed";
        });

    }, 2000);

});
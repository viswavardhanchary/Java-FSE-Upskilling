function submitForm() {

    console.log("Step 1: Form submission started");

    const user = {
        name: "Viswa",
        email: "viswa@gmail.com"
    };

    console.log("Step 2: User Data");
    console.log(user);

    debugger;

    fetch(
        "https://jsonplaceholder.typicode.com/posts",
        {
            method: "POST",
            headers: {
                "Content-Type":
                    "application/json"
            },
            body: JSON.stringify(user)
        }
    )
    .then(response => response.json())
    .then(data => {

        console.log("Step 3: Response Received");
        console.log(data);

    })
    .catch(error => {

        console.log("Step 4: Error Found");
        console.error(error);

    });

}
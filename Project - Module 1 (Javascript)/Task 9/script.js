const eventList =
    document.getElementById("eventList");

const loader =
    document.getElementById("loader");

function displayEvents(events) {

    eventList.innerHTML = "";

    events.forEach(event => {

        const li =
            document.createElement("li");

        li.textContent = event.title;

        eventList.appendChild(li);
    });
}

function fetchEventsPromise() {

    loader.textContent = "Loading...";

    fetch(
        "https://jsonplaceholder.typicode.com/posts"
    )
    .then(response => response.json())
    .then(data => {

        displayEvents(data.slice(0, 5));

        loader.textContent = "";
    })
    .catch(error => {

        console.error(error);

        loader.textContent =
            "Failed to load data";
    });
}

async function fetchEventsAsync() {

    try {

        loader.textContent = "Loading...";

        const response = await fetch(
            "https://jsonplaceholder.typicode.com/posts"
        );

        const data =
            await response.json();

        displayEvents(data.slice(0, 5));

        loader.textContent = "";

    } catch (error) {

        console.error(error);

        loader.textContent =
            "Failed to load data";
    }
}
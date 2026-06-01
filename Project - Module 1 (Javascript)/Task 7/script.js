const events = [
    {
        id: 1,
        name: "Music Night",
        seats: 20
    },
    {
        id: 2,
        name: "Coding Workshop",
        seats: 15
    }
];

const eventContainer =
    document.querySelector("#eventContainer");

function displayEvents() {

    eventContainer.innerHTML = "";

    events.forEach(event => {

        const card = document.createElement("div");

        card.innerHTML = `
            <h3>${event.name}</h3>
            <p>Available Seats: ${event.seats}</p>
            <button onclick="register(${event.id})">
                Register
            </button>
            <button onclick="cancel(${event.id})">
                Cancel
            </button>
            <hr>
        `;

        eventContainer.appendChild(card);
    });
}

function register(id) {

    const event = events.find(
        event => event.id === id
    );

    if (event.seats > 0) {
        event.seats--;
    }

    displayEvents();
}

function cancel(id) {

    const event = events.find(
        event => event.id === id
    );

    event.seats++;

    displayEvents();
}

displayEvents();
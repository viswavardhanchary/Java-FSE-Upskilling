const events = [
    {
        name: "Music Night",
        category: "Music"
    },
    {
        name: "Rock Concert",
        category: "Music"
    },
    {
        name: "Workshop on Baking",
        category: "Workshop"
    }
];

const eventList =
    document.getElementById("eventList");

function displayEvents(data) {

    eventList.innerHTML = "";

    data.forEach(event => {

        const div = document.createElement("div");

        div.innerHTML = `
            <p>
                ${event.name}
                (${event.category})
            </p>

            <button onclick="register('${event.name}')">
                Register
            </button>
        `;

        eventList.appendChild(div);
    });
}

function register(name) {
    alert(`Registered for ${name}`);
}

document.getElementById("categoryFilter")
.onchange = function () {

    const category = this.value;

    if (category === "All") {
        displayEvents(events);
        return;
    }

    const filtered = events.filter(
        event => event.category === category
    );

    displayEvents(filtered);
};

document.getElementById("searchBox")
.addEventListener("keydown", () => {

    const keyword =
        document.getElementById("searchBox")
        .value
        .toLowerCase();

    const filtered = events.filter(
        event =>
            event.name
            .toLowerCase()
            .includes(keyword)
    );

    displayEvents(filtered);
});

displayEvents(events);
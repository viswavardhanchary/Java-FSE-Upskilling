const events = [
    {
        name: "Music Night",
        category: "Music",
        seats: 20
    },
    {
        name: "Coding Workshop",
        category: "Workshop",
        seats: 30
    }
];

function displayEvent(
    eventName = "Unknown Event"
) {
    console.log(eventName);
}

displayEvent("Music Night");

const { name, category, seats } =
    events[0];

console.log(name);
console.log(category);
console.log(seats);

const clonedEvents = [...events];

const filteredEvents =
    clonedEvents.filter(
        event => event.category === "Music"
    );

const output =
    document.getElementById("output");

filteredEvents.forEach(event => {

    const p =
        document.createElement("p");

    p.textContent =
        `${event.name} - ${event.category}`;

    output.appendChild(p);
});
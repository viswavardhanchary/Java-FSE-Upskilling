const events = [
    {
        id: 1,
        name: "Music Night",
        date: "2025-01-01",
        seats: 20
    },
    {
        id: 2,
        name: "Food Festival",
        date: "2027-07-15",
        seats: 15
    },
    {
        id: 3,
        name: "Coding Workshop",
        date: "2027-08-20",
        seats: 0
    }
];

const eventList = document.getElementById("eventList");
const today = new Date();

events.forEach(event => {
    const eventDate = new Date(event.date);

    if (eventDate > today && event.seats > 0) {
        const p = document.createElement("p");
        p.textContent = `${event.name} - Seats: ${event.seats}`;
        eventList.appendChild(p);
    }
});

function registerForEvent(id) {
    try {
        const event = events.find(e => e.id === id);

        if (!event) {
            throw new Error("Event not found");
        }

        if (event.seats <= 0) {
            throw new Error("No seats available");
        }

        event.seats--;

        alert(`Registered successfully for ${event.name}`);
    } catch (error) {
        console.error(error.message);
        alert(error.message);
    }
}
const events = [];

function addEvent(name, category) {
    events.push({ name, category });
}

function registerUser(eventName) {
    console.log(`User registered for ${eventName}`);
    musicCounter();
}

function filterEventsByCategory(category, callback) {
    const filtered = events.filter(
        event => event.category === category
    );

    callback(filtered);
}

function createRegistrationCounter() {
    let count = 0;

    return function () {
        count++;
        console.log(
            `Total Music Registrations: ${count}`
        );
    };
}

const musicCounter = createRegistrationCounter();

addEvent("Music Night", "Music");
addEvent("Dance Show", "Dance");
addEvent("Rock Concert", "Music");

function searchEvents() {
    filterEventsByCategory(
        "Music",
        result => console.log(result)
    );
}
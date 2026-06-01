function Event(name, date, seats) {
    this.name = name;
    this.date = date;
    this.seats = seats;
}

Event.prototype.checkAvailability = function () {
    return this.seats > 0
        ? "Seats Available"
        : "No Seats Available";
};

const event1 = new Event(
    "Community Meetup",
    "15-June-2026",
    25
);

console.log(event1.checkAvailability());

const output = document.getElementById("output");

Object.entries(event1).forEach(([key, value]) => {
    const p = document.createElement("p");
    p.textContent = `${key}: ${value}`;
    output.appendChild(p);
});

const status = document.createElement("p");
status.textContent = event1.checkAvailability();
output.appendChild(status);
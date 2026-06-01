const eventName = "Community Cleanup Drive";
const eventDate = "10-June-2026";

let availableSeats = 50;

const eventInfo = `Event: ${eventName} | Date: ${eventDate}`;

document.getElementById("eventInfo").textContent = eventInfo;

availableSeats++;

document.getElementById("seatInfo").textContent =
    `Available Seats: ${availableSeats}`;

console.log(eventInfo);
console.log("Available Seats:", availableSeats);
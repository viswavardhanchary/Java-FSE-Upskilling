const events = [];

events.push({
    name: "Music Night",
    category: "Music"
});

events.push({
    name: "Workshop on Baking",
    category: "Workshop"
});

events.push({
    name: "Rock Concert",
    category: "Music"
});

const musicEvents = events.filter(
    event => event.category === "Music"
);

console.log("Music Events:", musicEvents);

const formattedCards = events.map(
    event => `Event: ${event.name}`
);

console.log(formattedCards);

const container =
    document.getElementById("musicEvents");

formattedCards.forEach(card => {
    const p = document.createElement("p");
    p.textContent = card;
    container.appendChild(p);
});
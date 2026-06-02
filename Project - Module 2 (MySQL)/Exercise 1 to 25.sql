use world;

create table users (
user_id int primary key auto_increment,
full_name varchar(100) not null,
email varchar(100) not null unique,
city varchar(100) not null,
registration_date Date not null);

create table events (
event_id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(200) NOT NULL,
description TEXT,
city VARCHAR(100) NOT NULL,
start_date DATETIME NOT NULL,
end_date DATETIME NOT NULL,
status ENUM ('upcoming', 'completed', 'cancelled'),
organizer_id int, 
FOREIGN KEY (organizer_id) references users(user_id)
);

create table sessions (
session_id INT PRIMARY KEY AUTO_INCREMENT,
event_id INT,
FOREIGN KEY (event_id) references events(event_id),
title VARCHAR(200) NOT NULL,
speaker_name VARCHAR(100) NOT NULL,
start_time datetime NOT NULL,
end_time DATETIME NOT NULL
);
create table registrations (
registration_id INT PRIMARY KEY AUTO_INCREMENT,
user_id INT,
FOREIGN KEY (user_id) references users(user_id),
event_id INT,
FOREIGN KEY (event_id) references events(event_id),
registration_date DATE NOT NULL
);

create table feedback (
feedback_id INT PRIMARY KEY AUTO_INCREMENT,
user_id INT,
FOREIGN KEY (user_id) references users(user_id),
event_id INT,
FOREIGN KEY (event_id) references events(event_id),
rating INT CHECK (rating BETWEEN 1 AND 5),
comments TEXT,
feedback_date DATE NOT NULL
);

create table resources (
resource_id INT PRIMARY KEY AUTO_INCREMENT,
event_id INT,
FOREIGN KEY  (event_id) references events(event_id),
resource_type ENUM ('pdf', 'image', 'link'),
resource_url VARCHAR(255) not null,
uploaded_at DATETIME NOT NULL
);

INSERT INTO users VALUES
(1, 'Alice Johnson', 'alice@example.com', 'New York', '2024-12-01'),
(2, 'Bob Smith', 'bob@example.com', 'Los Angeles', '2024-12-05'),
(3, 'Charlie Lee', 'charlie@example.com', 'Chicago', '2024-12-10'),
(4, 'Diana King', 'diana@example.com', 'New York', '2025-01-15'),
(5, 'Ethan Hunt', 'ethan@example.com', 'Los Angeles', '2025-02-01');

INSERT INTO events VALUES
(1, 'Tech Innovators Meetup', 'A meetup for tech enthusiasts.', 'New York', '2025-06-10 10:00:00', '2025-06-10 16:00:00', 'upcoming', 1),
(2, 'AI & ML Conference', 'Conference on AI and ML advancements.', 'Chicago', '2025-05-15 09:00:00', '2025-05-15 17:00:00', 'completed', 3),
(3, 'Frontend Development Bootcamp', 'Hands-on training on frontend tech.', 'Los Angeles', '2025-07-01 10:00:00', '2025-07-03 16:00:00', 'upcoming', 2);

INSERT INTO sessions VALUES
(1, 1, 'Opening Keynote', 'Dr. Tech', '2025-06-10 10:00:00', '2025-06-10 11:00:00'),
(2, 1, 'Future of Web Dev', 'Alice Johnson', '2025-06-10 11:15:00', '2025-06-10 12:30:00'),
(3, 2, 'AI in Healthcare', 'Charlie Lee', '2025-05-15 09:30:00', '2025-05-15 11:00:00'),
(4, 3, 'Intro to HTML5', 'Bob Smith', '2025-07-01 10:00:00', '2025-07-01 12:00:00');

INSERT INTO registrations VALUES
(1, 1, 1, '2025-05-01'),
(2, 2, 1, '2025-05-02'),
(3, 3, 2, '2025-04-30'),
(4, 4, 2, '2025-04-28'),
(5, 5, 3, '2025-06-15');

INSERT INTO feedback 
VALUES 
(1, 3, 2, 4, 'Great insights!', '2025-05-16'),
(2, 4, 2, 5, 'Very informative.', '2025-05-16'),
(3, 2, 1, 3, 'Could be better.', '2025-06-11');

INSERT INTO resources VALUES
(1, 1, 'pdf', 'https://portal.com', '2025-05-01 10:00:00'),
(2, 2, 'image', 'https://portal.com/resources/ai_poster.jpg', '2025-04-20 09:00:00'),
(3, 3, 'link', 'https://portal.com/resources/html5_docs', '2025-06-25 15:00:00');




-- Exercise 1
SELECT u.user_id,
       u.full_name,
       e.event_id,
       e.title,
       e.start_date
FROM users u
JOIN registrations r
ON u.user_id = r.user_id
JOIN events e
ON r.event_id = e.event_id
WHERE e.status = 'upcoming'
AND u.city = e.city
ORDER BY e.start_date;


-- Exercise 2
SELECT event_id,
       AVG(rating) AS avg_rating
FROM feedback
GROUP BY event_id
HAVING COUNT(*) >= 10
ORDER BY avg_rating DESC
LIMIT 1;


-- Exercise 3
SELECT *
FROM users u
WHERE NOT EXISTS (
    SELECT 1
    FROM registrations r
    WHERE r.user_id = u.user_id
    AND r.registration_date >= CURDATE() - INTERVAL 90 DAY
);


-- Exercise 4
SELECT event_id,
       COUNT(*) AS session_count
FROM sessions
WHERE TIME(start_time) >= '10:00:00'
AND TIME(end_time) <= '12:00:00'
GROUP BY event_id;


-- Exercise 5
SELECT u.city,
       COUNT(DISTINCT r.registration_id) AS total_registrations
FROM users u
JOIN registrations r
ON u.user_id = r.user_id
GROUP BY u.city
ORDER BY total_registrations DESC
LIMIT 5;


-- Exercise 6
SELECT event_id,
       COUNT(*) AS total_resources
FROM resources
GROUP BY event_id;


-- Exercise 7
SELECT u.full_name,
       f.comments,
       e.title
FROM feedback f
JOIN users u
ON f.user_id = u.user_id
JOIN events e
ON f.event_id = e.event_id
WHERE f.rating < 3;


-- Exercise 8
SELECT e.event_id,
       e.title,
       COUNT(s.session_id) AS total_sessions
FROM events e
LEFT JOIN sessions s
ON e.event_id = s.event_id
WHERE e.status = 'upcoming'
GROUP BY e.event_id, e.title;


-- Exercise 9
SELECT organizer_id,
       status,
       COUNT(*) AS total_events
FROM events
GROUP BY organizer_id, status;


-- Exercise 10
SELECT DISTINCT e.event_id,
                e.title
FROM events e
JOIN registrations r
ON e.event_id = r.event_id
LEFT JOIN feedback f
ON e.event_id = f.event_id
WHERE f.event_id IS NULL;


-- Exercise 11
SELECT registration_date,
       COUNT(*) AS user_count
FROM users
WHERE registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP BY registration_date
ORDER BY registration_date;


-- Exercise 12
SELECT event_id
FROM (
      SELECT event_id,
             DENSE_RANK() OVER(ORDER BY COUNT(*) DESC) AS rnk
      FROM sessions
      GROUP BY event_id
     ) x
WHERE rnk = 1;


-- Exercise 13
SELECT e.city,
       AVG(f.rating) AS avg_rating
FROM events e
LEFT JOIN feedback f
ON e.event_id = f.event_id
GROUP BY e.city;


-- Exercise 14
SELECT event_id,
       total_registrations
FROM (
      SELECT event_id,
             COUNT(*) AS total_registrations,
             DENSE_RANK() OVER(ORDER BY COUNT(*) DESC) AS rnk
      FROM registrations
      GROUP BY event_id
     ) x
WHERE rnk <= 3;


-- Exercise 15
SELECT s1.event_id,
       s1.session_id,
       s2.session_id
FROM sessions s1
JOIN sessions s2
ON s1.event_id = s2.event_id
AND s1.session_id < s2.session_id
AND s1.start_time < s2.end_time
AND s1.end_time > s2.start_time;


-- Exercise 16
SELECT u.*
FROM users u
LEFT JOIN registrations r
ON u.user_id = r.user_id
WHERE u.registration_date >= CURDATE() - INTERVAL 30 DAY
AND r.user_id IS NULL;


-- Exercise 17
SELECT speaker_name,
       COUNT(*) AS total_sessions
FROM sessions
GROUP BY speaker_name
HAVING COUNT(*) > 1;


-- Exercise 18
SELECT e.event_id,
       e.title
FROM events e
LEFT JOIN resources r
ON e.event_id = r.event_id
WHERE r.resource_id IS NULL;


-- Exercise 19
SELECT e.event_id,
       e.title,
       COUNT(DISTINCT r.registration_id) AS total_registrations,
       AVG(f.rating) AS avg_rating
FROM events e
LEFT JOIN registrations r
ON e.event_id = r.event_id
LEFT JOIN feedback f
ON e.event_id = f.event_id
WHERE e.status = 'completed'
GROUP BY e.event_id, e.title;


-- Exercise 20
SELECT u.user_id,
       u.full_name,
       COUNT(DISTINCT r.event_id) AS events_attended,
       COUNT(DISTINCT f.feedback_id) AS feedbacks_submitted
FROM users u
LEFT JOIN registrations r
ON u.user_id = r.user_id
LEFT JOIN feedback f
ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name;


-- Exercise 21
SELECT u.user_id,
       u.full_name,
       COUNT(*) AS feedback_count
FROM users u
JOIN feedback f
ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name
ORDER BY feedback_count DESC
LIMIT 5;


-- Exercise 22
SELECT user_id,
       event_id,
       COUNT(*) AS duplicate_count
FROM registrations
GROUP BY user_id, event_id
HAVING COUNT(*) > 1;


-- Exercise 23
SELECT DATE_FORMAT(registration_date, '%Y-%m') AS month,
       COUNT(*) AS registrations
FROM registrations
WHERE registration_date >= CURDATE() - INTERVAL 12 MONTH
GROUP BY DATE_FORMAT(registration_date, '%Y-%m')
ORDER BY month;


-- Exercise 24
SELECT event_id,
       AVG(
           TIMESTAMPDIFF(
               MINUTE,
               start_time,
               end_time
           )
       ) AS avg_duration_minutes
FROM sessions
GROUP BY event_id;


-- Exercise 25
SELECT e.event_id,
       e.title
FROM events e
LEFT JOIN sessions s
ON e.event_id = s.event_id
WHERE s.session_id IS NULL;
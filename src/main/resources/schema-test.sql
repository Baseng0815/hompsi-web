CREATE TABLE users (
   uid  INT NOT NULL AUTO_INCREMENT,
   registered_at TIMESTAMP WITH TIME ZONE NOT NULL,
   first_name VARCHAR(32),
   last_name VARCHAR(32),
   user_name VARCHAR(32) NOT NULL,

   PRIMARY KEY(uid)
);

INSERT INTO users (registered_at, first_name, last_name, user_name)
VALUES
(CURRENT_TIMESTAMP, 'Peter', 'Pan', 'ppan'),
(CURRENT_TIMESTAMP, 'Michael', 'Bay', 'mbay69'),
(CURRENT_TIMESTAMP, 'Chrono', 'Chad', 'ChronoChad');
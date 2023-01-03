-- TODO remove this in production
DROP TABLE IF EXISTS users;

CREATE TABLE users (
   uid SERIAL,
   registered_at TIMESTAMP WITH TIME ZONE NOT NULL,
   real_name VARCHAR(64),
   user_name VARCHAR(64) UNIQUE NOT NULL,
   mail_address VARCHAR(64) UNIQUE NOT NULL,
   salted_password BYTEA NOT NULL,
   salt BYTEA NOT NULL,

   PRIMARY KEY(uid)
);
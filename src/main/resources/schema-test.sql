CREATE TABLE users (
   uid  INT NOT NULL AUTO_INCREMENT,
   registered_at TIMESTAMP WITH TIME ZONE NOT NULL,
   real_name VARCHAR(32),
   user_name VARCHAR(32) NOT NULL,
   salted_password ARRAY NOT NULL,
   salt ARRAY NOT NULL

   PRIMARY KEY(uid)
);
SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS users (
  id int PRIMARY KEY auto_increment,
  username VARCHAR,
  userlocation VARCHAR,
  usermaxdistance DECIMAL
);

CREATE TABLE IF NOT EXISTS trails (
id int PRIMARY KEY auto_increment,
trailname VARCHAR,
difficulty VARCHAR,
location VARCHAR
latitude DECIMAL,
longitude DECIMAL,
distance DECIMAL
userid int
);

CREATE TABLE IF NOT EXISTS journals (
id int PRIMARY KEY auto_increment,
trailid int,
userid int,
createdat DATE,
bestseason VARCHAR ,
didit VARCHAR,
notes VARCHAR
);




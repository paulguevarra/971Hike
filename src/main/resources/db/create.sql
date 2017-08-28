SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS hiker (
  id int PRIMARY KEY auto_increment,
  hikername VARCHAR,
  location VARCHAR,
  latitude DECIMAL,
  longitude DECIMAL,
  maxDistance DECIMAL
);

CREATE TABLE IF NOT EXISTS trail (
id int PRIMARY KEY auto_increment,
trailname VARCHAR,
difficulty VARCHAR,
location VARCHAR
latitude DECIMAL,
longitude DECIMAL,
maxDistance DECIMAL
hikerid int
);

CREATE TABLE IF NOT EXISTS journal (
id int PRIMARY KEY auto_increment,
trailid int,
hikerid int,
createdAt DATE,
bestSeason VARCHAR ,
didIt VARCHAR,
notes VARCHAR
);




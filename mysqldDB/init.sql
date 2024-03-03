CREATE TABLE users (
  username VARCHAR(100) NOT NULL,
  password VARCHAR(100) NULL DEFAULT NULL,
  data VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (username));
INSERT INTO users (username,password,data) VALUES ('anas','anas',NULL);
INSERT INTO users (username,password,data) VALUES ('ghada','ghada','hamza');
INSERT INTO users (username,password,data) VALUES ('hamza','hamza','hamza');
INSERT INTO users (username,password,data) VALUES ('leen','leen','leen');
INSERT INTO users (username,password,data) VALUES ('mohammad','mohammad','ragad');
INSERT INTO users (username,password,data) VALUES ('osama','osama','ragad');
INSERT INTO users (username,password,data) VALUES ('ragad','ragad','ragad');
INSERT INTO users (username,password,data) VALUES ('yasmeen','yasmeen','ragad');

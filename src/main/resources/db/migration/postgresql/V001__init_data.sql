CREATE TABLE plane
(
  id   SERIAL       NOT NULL,
  dtype VARCHAR(50) NOT NULL,
  description VARCHAR(255) NOT NULL,
  nbr_of_seats INT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE a320 (
  id INT NOT NULL,
  software_version VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES plane(id)
);

INSERT INTO plane (dtype, description, nbr_of_seats) VALUES ('a320', 'Airbus A320', 180);
INSERT INTO a320 (id, software_version) VALUES (1, '1.0');
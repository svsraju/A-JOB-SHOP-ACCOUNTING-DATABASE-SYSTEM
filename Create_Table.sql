
-- Create the table in the specified schema
CREATE TABLE  Performer
(

    pid INT, -- Primary Key column
    pname VARCHAR(20) ,
    years_of_experience INT ,
    age INT,
    PRIMARY KEY (pid)
    -- Specify more columns here
);


-- Create the table in the specified schema

CREATE TABLE Director 
(
    did INT, -- Primary Key column
    dname VARCHAR(20) ,
    earnings DECIMAL(15,3),
    PRIMARY KEY (did)
    -- Specify more columns here
);



CREATE TABLE Movie
(
    mname VARCHAR(20), 
    genre VARCHAR(20) ,
    minutes INT ,
    release_year INT,
    did INT ,
    PRIMARY KEY (mname),
    FOREIGN KEY (did) REFERENCES Director
    -- Specify more columns here
);



CREATE TABLE Acted
(
    pid INT,
    mname VARCHAR(20) ,
    PRIMARY KEY (pid,mname),
    FOREIGN KEY (pid) REFERENCES Performer,
    FOREIGN KEY (mname) REFERENCES Movie,
    -- Specify more columns here
);




-- Insert rows into table 'Performer' in schema '[dbo]'
INSERT INTO Performer
( -- Columns to insert data into
 [pid], [pname], [years_of_experience],[age]
)
VALUES
(1,'Morgan',48,67),
(2,'Cruz',14,28),
(3,'Adams',1,16),
(4,'Perry',18,32),
(5,'Hanks',36,55),
(6,'Hanks',15,24),
(7,'Lewis',13,32);



-- Insert rows into table 'Director' in schema '[dbo]'
INSERT INTO Director
( -- Columns to insert data into
 [did], [dname], [earnings]
)
VALUES
(1,'Parker',580000),
(2,'Black',2500000),
(3,'Black',30000),
(4,'Stone',820000);




-- Insert rows into table 'Movie' in schema '[dbo]'
INSERT INTO Movie
( -- Columns to insert data into
 [mname], [genre], [minutes],[release_year],[did]
)
VALUES
('Jurassic Park','Action',125,1984,2),
('Shawshank Redemption','Drama',105,2001,2),
('Fight Club','Drama',144,2015,2),
('The Departed','Drama',130,1969,3),
('Back to the Future','Comedy',89,2008,3),
('The Lion King','Animation',97,1990,1),
('Alien','Sci-Fi',115,2006,3),
('Toy Story','Animation',104,1978,1),
('Scarface','Drama',124,2003,1),
('Up','Animation',111,1999,4);




-- Insert rows into table 'Acted' in schema '[dbo]'
INSERT INTO Acted
( -- Columns to insert data into
 [pid], [mname]
)
VALUES
(4,'Fight Club'),
(5,'Fight Club'),
(6,'Shawshank Redemption'),
(4,'Up'),
(5,'Shawshank Redemption'),
(1,'The Departed'),
(2,'Fight Club'),
(3,'Fight Club'),
(4,'Alien');
-- Add more rows here

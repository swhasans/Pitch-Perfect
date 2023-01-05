CREATE TABLE Users(
    user_id BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL,
    user_name CHAR(50) NOT NULL,
    user_email VARCHAR (200) NOT NULL,
    user_password VARCHAR (100) NOT NULL,
    user_date_created DATE,
    PRIMARY KEY (user_id)
);

CREATE TABLE SportsVenue( 
    SV_id BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL,
    SV_name CHAR(100) NOT NULL,
    SV_rating VARCHAR (50),
    SV_user_comment VARCHAR (200) NOT NULL,
    SV_date_created DATE,
    user_id BIGINT,
    PRIMARY KEY (SV_id),
    FOREIGN KEY (user_id) REFERENCES Users (user_id)
);
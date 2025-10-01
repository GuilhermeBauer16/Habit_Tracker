CREATE TABLE habits
(
    id             CHAR(36)  NOT NULL PRIMARY KEY,
    name           VARCHAR(255) NOT NULL,
    description    TEXT,
    start_date     DATE,
    end_date       DATE,
    frequency_type VARCHAR(50),
    active         BOOLEAN      NOT NULL
);
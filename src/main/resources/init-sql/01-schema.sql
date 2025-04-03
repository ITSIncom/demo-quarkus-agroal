DROP TABLE IF EXISTS Course;

CREATE TABLE Course
(
    Code        int primary key identity(84921,99),
    name        varchar(100) not null,
    description varchar(255) not null,
    date_start  date         not null,
    date_end    date         not null,
    total_hour  int          not null
);

INSERT INTO Course(name, description, date_start, date_end, total_hour)
VALUES ('Java', 'Corso JAVA', CONVERT(date, '2024-09-01', 126), CONVERT(date, '2025-07-31', 126), 300);

INSERT INTO Course(name, description, date_start, date_end, total_hour)
VALUES ('Java', 'Corso JAVA v2', CONVERT(date, '2023-09-01', 126), CONVERT(date, '2024-07-31', 126), 300);

INSERT INTO Course(name, description, date_start, date_end, total_hour)
VALUES ('DB', 'Basi di Dati', CONVERT(date, '2025-04-01', 126), CONVERT(date, '2025-07-31', 126), 100);
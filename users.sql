create table users
(
    id    int         not null
        primary key,
    name  varchar(40) null,
    pwd   varchar(40) null
);

INSERT INTO users (id, name, pwd) VALUES (5, 'admin', 'fsrfw2020');
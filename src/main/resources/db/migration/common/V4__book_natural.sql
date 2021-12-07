drop table if exists book_natural;

create table book_natural
(
    title     varchar(255) not null primary key,
    isbn      varchar(255),
    publisher varchar(255)
) engine = InnoDB;
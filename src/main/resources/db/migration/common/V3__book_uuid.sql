drop table if exists book_uuid;

create table book_uuid  
(
    id        varbinary(16) not null primary key,
    isbn      varchar(255),
    publisher varchar(255),
    title     varchar(255)
) engine = InnoDB;

insert into book_uuid (id, isbn, publisher, title) values
(UUID_TO_BIN(UUID()), '5675', 'Walls', 'A walk in the Country'),
(UUID_TO_BIN(UUID()), '7786', 'Evans', 'A walk in the City');
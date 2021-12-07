drop table if exists author_uuid;

create table author_uuid
(
    id         varchar(36) not null primary key,
    first_name varchar(255),
    last_name  varchar(255)
) engine = InnoDB;

insert into author_uuid (id, first_name, last_name) values
(UUID(), 'Craig', 'Walls'),
(UUID(), 'Eric', 'Evans');
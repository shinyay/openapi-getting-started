create table employee if not exists (
    id bigint not null,
    first_name varchar(50),
    last_name varchar(50),
    role varchar(25),
    primary key (id)
)
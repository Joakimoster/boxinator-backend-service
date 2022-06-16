create table if not exists box
(
    id           int auto_increment
        primary key,
    name         varchar(500) not null,
    weight       float        not null,
    color        varchar(500) not null,
    shippingCost float        not null,
    country      varchar(500) null
);
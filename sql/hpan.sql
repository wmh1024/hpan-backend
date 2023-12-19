create table admin
(
    id            bigint auto_increment
        primary key,
    username      varchar(255) null,
    user_password varchar(255) null,
    constraint id
        unique (id)
);

create table download
(
    id           bigint auto_increment
        primary key,
    type         int                                 null,
    is_enable    tinyint   default 1                 not null,
    item_name    varchar(255)                        null,
    channel0     varchar(255)                        null,
    channel1     varchar(255)                        null,
    channel0_url varchar(500)                        null,
    channel1_url varchar(500)                        null,
    createdtime  timestamp default CURRENT_TIMESTAMP not null,
    is_deleted   tinyint   default 0                 not null,
    img          varchar(255)                        null,
    des          varchar(255)                        null,
    constraint id
        unique (id)
);

create table type
(
    id          int auto_increment
        primary key,
    type_name   varchar(255)                        null,
    createdtime timestamp default CURRENT_TIMESTAMP not null,
    is_deleted  tinyint   default 0                 not null,
    constraint id
        unique (id)
);


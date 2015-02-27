
    create table test.Requirement1 (
        no bigint not null auto_increment,
        id vachar not null unique,
        title varchar(250) not null,
        request text,
        answer text,
        source varchar(50),
        significanceCode varchar(10),
        hardnessCode varchar(10),
        statusCode varchar(10),
        requestedDate datetime,
        primary key (no)
    );

    create index idx_requirement1_1 on test.Requirement1 (id);

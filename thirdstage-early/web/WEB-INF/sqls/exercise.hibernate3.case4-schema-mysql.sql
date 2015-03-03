
    create table Employee4 (
        id bigint not null auto_increment,
        taxfileNumber varchar(20),
        firstName varchar(255),
        initial varchar(255),
        lastName varchar(255),
        primary key (id)
    );

    create table Employer4 (
        id bigint not null auto_increment,
        name varchar(60),
        primary key (id)
    );

    create table Employment4 (
        id bigint not null auto_increment,
        startDate datetime,
        endDate datetime,
        employerId bigint not null,
        employeeId bigint not null,
        hourlyamount double precision,
        hourlycurrency varchar(255),
        primary key (id)
    );

    alter table Employment4 
        add index fk_employment_2 (employeeId), 
        add constraint fk_employment_2 
        foreign key (employeeId) 
        references Employee4 (id);

    alter table Employment4 
        add index fk_employment_1 (employerId), 
        add constraint fk_employment_1 
        foreign key (employerId) 
        references Employer4 (id);

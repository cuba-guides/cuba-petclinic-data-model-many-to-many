create table PETCLINIC_INSURANCE_MEMBERSHIP (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PET_ID varchar(36) not null,
    INSURANCE_COMPANY_ID varchar(36) not null,
    VALID_FROM date not null,
    VALID_UNTIL date,
    --
    primary key (ID)
);
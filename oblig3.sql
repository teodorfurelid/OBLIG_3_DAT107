-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;

--drop table oblig3.AVDELING;

-- Avdeling-tabell
create table oblig3.AVDELING (
    avdelingNr serial,
    navn varchar(90) not null,
    sjef int, -- Fremmednøkkel til Ansatt, settes senere
    constraint avdeling_pk primary key (avdelingNr)
);

-- Prosjekt-tabell
create table oblig3.PROSJEKT (
    prosjektId serial,
    prosjektNavn varchar(30) not null,
    prosjektBeskrivelse varchar(90),
    constraint prosjekt_pk primary key (prosjektId)
);

-- Ansatt-tabell
create table oblig3.ANSATT (
    ansattId serial,
    brukernavn varchar(4) unique not null,
    fornavn varchar(30) not null ,
    etternavn varchar(30) not null ,
    ansettelsesDato date not null,
    stilling varchar(30),
    lonnManed numeric,

    avdeling int not null,
    constraint ansatt_pk primary key (ansattId),

    constraint avdeling_fk foreign key (avdeling)
            references AVDELING(avdelingNr)
                on delete restrict

);

-- Legg til sjef-fremmednøkkel i AVDELING (må gjøres etter ansatt er oppretta)
alter table oblig3.AVDELING
add constraint sjef_fk foreign key (sjef)
    references ANSATT(ansattId)
    on delete restrict;


-- Koblingstabell for ANSATT-PROSJEKT (mange til mange med rolle og timer)
create table oblig3.PROSJEKT_DELTAGELSE (
    ansattId int not null,
    prosjekId int not null,
    rolle varchar(50) not null,
    antallTimer numeric default 0,

    constraint deltagelse_pk primary key (ansattId, prosjekId),
    constraint deltagelse_ansatt_fk foreign key (ansattId)
                                        references ANSATT(ansattId)
                                        on delete restrict,
    constraint deltagelse_prosjekt_fk foreign key (prosjekId)
                                        references PROSJEKT(prosjektId)
                                        on delete restrict

);

insert into AVDELING(navn)
values
    ('PROGRAMERING'),
    ('REVISOR'),
    ('TESTER'),
    ('REDAKTØR'),
    ('LONNING'),
    ('KJOKKEN');

insert into PROSJEKT(prosjektNavn, prosjektBeskrivelse)
values ('PROG1', 'Teste programmer i fase 1'),
       ('PROG2', 'Teste programmer i fase 2'),
       ('PROG3', 'Teste programmer i fase 3'),
       ('PROG4', 'Teste programmer i fase 4');


insert into ANSATT(brukernavn, fornavn, etternavn, ansettelsesDato, stilling, lonnManed, avdeling)
values
    ('THF', 'Teodor', 'Furelid', '16.04.2016', 'PROGRAMERER', 120_000, 1),
    ('JOH', 'Johanne', 'Berg', '2022-03-15', 'SYSTEMUTVIKLER', 95_000, 1),  -- PROGRAMERING
    ('KRN', 'Karine', 'Nilsen', '2023-01-10', 'UX-DESIGNER', 88_000, 1),   -- PROGRAMERING
    ('PET', 'Petter', 'Ås', '2021-08-22', 'TESTLEDER', 92_000, 3),         -- TESTER
    ('MAL', 'Malin', 'Lunde', '2022-11-01', 'TESTTEKNIKER', 78_000, 3),    -- TESTER
    ('SIG', 'Sigrid', 'Haugen', '2020-05-18', 'REVISOR', 110_000, 2),      -- REVISOR
    ('HAA', 'Håkon', 'Vik', '2023-06-12', 'REVISORASSISTENT', 72_000, 2),  -- REVISOR
    ('IDA', 'Ida', 'Solberg', '2021-02-28', 'REDAKTØR', 98_000, 4),        -- REDAKTØR
    ('SIM', 'Simon', 'Dahl', '2022-09-05', 'JOURNALIST', 85_000, 4),       -- REDAKTØR
    ('MAR', 'Marte', 'Kvam', '2020-10-14', 'LØNNSMEDARBEIDER', 82_000, 5), -- LONNING
    ('ARE', 'Are', 'Sæther', '2023-04-03', 'KJØKKENSJEF', 105_000, 6);     -- KJOKKEN


-- Oppdater sjefer for hver avdeling (må gjøres etter at alle ansatte er lagt inn)
update AVDELING set sjef = 2 where avdelingNr = 1;  -- Johanne Berg er sjef for PROGRAMERING
update AVDELING set sjef = 6 where avdelingNr = 2;  -- Sigrid Haugen er sjef for REVISOR
update AVDELING set sjef = 4 where avdelingNr = 3;  -- Petter Ås er sjef for TESTER
update AVDELING set sjef = 8 where avdelingNr = 4;  -- Ida Solberg er sjef for REDAKTØR
update AVDELING set sjef = 10 where avdelingNr = 5; -- Marte Kvam er sjef for LONNING
update AVDELING set sjef = 11 where avdelingNr = 6; -- Are Sæther er sjef for KJOKKEN

insert into PROSJEKT_DELTAGELSE (ansattId, prosjekId, rolle, antallTimer)
values (1, 4, 'Prosjektleder', 10),
       (2, 4, 'ProsjektDeltager', 25),
       (3, 4, 'ProsjektDeltager', 8),
       (8, 4, 'ProsjektDeltager', 22);
insert into appuser
values(1001,'john', '$2a$04$T1hiIHQ2QsW/TsgfR8A.fuLyWrR1Ej4S8us4.3mUIlpOtivGzN9S.');

insert into approle
values(2001, 'ADMIN');
insert into approle
values(2002, 'USER');

insert into users_roles
values(1001, 2001);
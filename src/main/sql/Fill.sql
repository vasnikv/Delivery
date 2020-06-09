/*
для создания таблиц запустить 1 раз с
spring.jpa.hibernate.ddl-auto=create в application.properties
а потом выполнить заросы ниже.
обычно на время разработки стоит
spring.jpa.hibernate.ddl-auto=update
 */

insert into public.positions (id, name, short_name) values (1, 'Директор','Д');

insert into public.positions (id, name, short_name) values (2, 'Заместитель директора','ЗД');

insert into public.genders (id, name, short_name) values (1, 'Мужской','М');

insert into public.genders (id, name, short_name) values (2, 'Женский','Ж');

insert into public.persons (id, first_name, middle_name, last_name, gender_id, birth_date, position_id, empl_date) values (1, 'Ivan','Ivanovich', 'Ivanov', 1, '1980-01-01', 1, '2000-01-01');
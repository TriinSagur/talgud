-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-05-01 11:36:21.52
-- This file is automatically ran via docker-compose.yml to initialize database

-- tables
-- Table: contact
CREATE TABLE IF NOT EXISTS contact (
                                       id serial  NOT NULL,
                                       user_id int  NOT NULL,
                                       first_name varchar(255)  NOT NULL,
                                       last_name varchar(255)  NOT NULL,
                                       telephone varchar(50)  NOT NULL,
                                       email varchar(255)  NOT NULL,
                                       CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: picture
CREATE TABLE IF NOT EXISTS picture (
                                       id serial  NOT NULL,
                                       project_id int  NOT NULL,
                                       data bytea  NOT NULL,
                                       CONSTRAINT picture_pk PRIMARY KEY (id)
);

-- Table: project
CREATE TABLE IF NOT EXISTS project (
                                       id serial  NOT NULL,
                                       name varchar(255)  NOT NULL,
                                       address varchar(255)  NOT NULL,
                                       start_time timestamp  NOT NULL,
                                       end_time timestamp  NOT NULL,
                                       longitude decimal(8,6)  NULL,
                                       latitude decimal(8,6)  NULL,
                                       CONSTRAINT project_pk PRIMARY KEY (id)
);

-- Table: project_user
CREATE TABLE IF NOT EXISTS project_user (
                                            id serial  NOT NULL,
                                            project_id int  NOT NULL,
                                            user_id int  NOT NULL,
                                            is_moderator boolean  NOT NULL DEFAULT false,
                                            CONSTRAINT project_user_pk PRIMARY KEY (id)
);

-- Table: resource
CREATE TABLE IF NOT EXISTS resource (
                                        id serial  NOT NULL,
                                        project_id int  NOT NULL,
                                        user_id int  NULL,
                                        name varchar(255)  NOT NULL,
                                        CONSTRAINT resource_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE IF NOT EXISTS role (
                                    id serial  NOT NULL,
                                    name varchar(255)  NOT NULL,
                                    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: task
CREATE TABLE IF NOT EXISTS task (
                                    id serial  NOT NULL,
                                    project_id int  NOT NULL,
                                    user_id int  NULL,
                                    name varchar(255)  NOT NULL,
                                    CONSTRAINT task_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE IF NOT EXISTS "user" (
                                      id serial  NOT NULL,
                                      username varchar(255)  NOT NULL,
                                      password varchar(255)  NOT NULL,
                                      CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: user_role
CREATE TABLE IF NOT EXISTS user_role (
                                         id serial  NOT NULL,
                                         role_id int  NOT NULL,
                                         user_id int  NOT NULL,
                                         CONSTRAINT user_role_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: contact_user (table: contact)
ALTER TABLE contact DROP CONSTRAINT IF EXISTS contact_user;
ALTER TABLE contact ADD CONSTRAINT contact_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: picture_project (table: picture)
ALTER TABLE picture DROP CONSTRAINT IF EXISTS picture_project;
ALTER TABLE picture ADD CONSTRAINT picture_project
    FOREIGN KEY (project_id)
        REFERENCES project (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: project_user_project (table: project_user)
ALTER TABLE project_user DROP CONSTRAINT IF EXISTS project_user_project;
ALTER TABLE project_user ADD CONSTRAINT project_user_project
    FOREIGN KEY (project_id)
        REFERENCES project (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: project_user_user (table: project_user)
ALTER TABLE project_user DROP CONSTRAINT IF EXISTS  project_user_user;
ALTER TABLE project_user ADD CONSTRAINT project_user_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: resource_project (table: resource)
ALTER TABLE resource DROP CONSTRAINT IF EXISTS  resource_project;
ALTER TABLE resource ADD CONSTRAINT resource_project
    FOREIGN KEY (project_id)
        REFERENCES project (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: resource_user (table: resource)
ALTER TABLE resource DROP CONSTRAINT IF EXISTS  resource_user;
ALTER TABLE resource ADD CONSTRAINT resource_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: task_project (table: task)
ALTER TABLE task DROP CONSTRAINT IF EXISTS task_project;
ALTER TABLE task ADD CONSTRAINT task_project
    FOREIGN KEY (project_id)
        REFERENCES project (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: task_user (table: task)
ALTER TABLE task DROP CONSTRAINT IF EXISTS task_user;
ALTER TABLE task ADD CONSTRAINT task_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role_role (table: user_role)
ALTER TABLE user_role DROP CONSTRAINT IF EXISTS user_role_role;
ALTER TABLE user_role ADD CONSTRAINT user_role_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role_user (table: user_role)
ALTER TABLE user_role DROP CONSTRAINT IF EXISTS user_role_user;
ALTER TABLE user_role ADD CONSTRAINT user_role_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

INSERT INTO public."user" (id, username, password) VALUES (DEFAULT, 'Triin123', 'student123');
INSERT INTO public."user" (id, username, password) VALUES (DEFAULT, 'priitrs', 'student123');
INSERT INTO public."user" (id, username, password) VALUES (DEFAULT, 'lauris', 'student123');
INSERT INTO public.project (id, name, address, start_time, end_time, longitude, latitude) VALUES (DEFAULT, 'IT-talgud', 'Uus 12, Tallinn', '2022-06-01 09:00:00.000000', '2022-06-01 16:30:00.000000', 59.437782, 24.750038);
INSERT INTO public.project (id, name, address, start_time, end_time, longitude, latitude) VALUES (DEFAULT, 'Laste mängumaja talgud', 'Ansi talu, Tartumaa ', '2022-06-24 10:00:00.000000', '2022-06-26 18:00:00.000000', 58.275331, 27.058979);
INSERT INTO public.project (id, name, address, start_time, end_time, longitude, latitude) VALUES (DEFAULT, 'Teeme ära talgud', 'Lihula', '2021-05-01 12:00:00.000000', '2021-05-01 18:00:00.000000', 58.690203, 23.819705);
INSERT INTO public.project (id, name, address, start_time, end_time, longitude, latitude) VALUES (DEFAULT, 'Kanali puhastamine', 'Piirissaare', '2021-08-27 10:00:00.000000', '2021-08-27 17:00:00.000000', 58.376747, 27.510993);
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'administrator');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'user');
INSERT INTO public.user_role (id, role_id, user_id) VALUES (DEFAULT, 1, 2);
INSERT INTO public.user_role (id, role_id, user_id) VALUES (DEFAULT, 2, 1);
INSERT INTO public.user_role (id, role_id, user_id) VALUES (DEFAULT, 2, 3);
INSERT INTO public.contact (id, user_id, first_name, last_name, telephone, email) VALUES (DEFAULT, 1, 'Triin', 'Sagur', '1234567', 'triin@internet.ee');
INSERT INTO public.contact (id, user_id, first_name, last_name, telephone, email) VALUES (DEFAULT, 2, 'Priit', 'Roosmäe', '2345678', 'priit@kodu.com');
INSERT INTO public.contact (id, user_id, first_name, last_name, telephone, email) VALUES (DEFAULT, 3, 'Lauri', 'Sõõro', '3456789', 'lauri@majataga.du');
INSERT INTO public.project_user (id, project_id, user_id, is_moderator) VALUES (DEFAULT, 1, 3, true);
INSERT INTO public.project_user (id, project_id, user_id, is_moderator) VALUES (DEFAULT, 1, 2, false);
INSERT INTO public.project_user (id, project_id, user_id, is_moderator) VALUES (DEFAULT, 2, 1, true);
INSERT INTO public.project_user (id, project_id, user_id, is_moderator) VALUES (DEFAULT, 2, 3, false);
INSERT INTO public.project_user (id, project_id, user_id, is_moderator) VALUES (DEFAULT, 2, 2, false);
INSERT INTO public.project_user (id, project_id, user_id, is_moderator) VALUES (DEFAULT, 1, 1, false);
INSERT INTO public.project_user (id, project_id, user_id, is_moderator) VALUES (DEFAULT, 3, 1, true);
INSERT INTO public.project_user (id, project_id, user_id, is_moderator) VALUES (DEFAULT, 4, 3, true);
INSERT INTO public.project_user (id, project_id, user_id, is_moderator) VALUES (DEFAULT, 3, 2, false);
INSERT INTO public.task (id, project_id, user_id, name) VALUES (DEFAULT, 1, null, 'nina nokkimine');
INSERT INTO public.task (id, project_id, user_id, name) VALUES (DEFAULT, 2, null, 'rehvi pumpamine');
INSERT INTO public.task (id, project_id, user_id, name) VALUES (DEFAULT, 3, null, 'lohe lennutamine');
INSERT INTO public.task (id, project_id, user_id, name) VALUES (DEFAULT, 4, null, 'päevitamine');
INSERT INTO public.resource (id, project_id, user_id, name) VALUES (DEFAULT, 1, null, 'Järelkäru');
INSERT INTO public.resource (id, project_id, user_id, name) VALUES (DEFAULT, 2, null, 'Luuad');
INSERT INTO public.resource (id, project_id, user_id, name) VALUES (DEFAULT, 3, null, 'Kõblas');
INSERT INTO public.resource (id, project_id, user_id, name) VALUES (DEFAULT, 4, null, 'Saunalina')



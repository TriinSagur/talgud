-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-04-27 10:49:41.639

-- tables
-- Table: contact
CREATE TABLE contact (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    first_name varchar(255)  NOT NULL,
    last_name varchar(255)  NOT NULL,
    telephone varchar(50)  NOT NULL,
    email varchar(255)  NOT NULL,
    CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: picture
CREATE TABLE picture (
    id serial  NOT NULL,
    project_id int  NOT NULL,
    data bytea  NOT NULL,
    CONSTRAINT picture_pk PRIMARY KEY (id)
);

-- Table: project
CREATE TABLE project (
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
CREATE TABLE project_user (
    id serial  NOT NULL,
    project_id int  NOT NULL,
    user_id int  NOT NULL,
    is_moderator boolean  NOT NULL DEFAULT false,
    is_participant boolean  NOT NULL DEFAULT false,
    CONSTRAINT project_user_pk PRIMARY KEY (id)
);

-- Table: resource
CREATE TABLE resource (
    id serial  NOT NULL,
    project_id int  NOT NULL,
    responsible_user_id int  NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT resource_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: task
CREATE TABLE task (
    id serial  NOT NULL,
    project_id int  NOT NULL,
    responsible_user_id int  NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT task_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    username varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: user_role
CREATE TABLE user_role (
    id serial  NOT NULL,
    role_id int  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT user_role_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: contact_user (table: contact)
ALTER TABLE contact ADD CONSTRAINT contact_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: picture_project (table: picture)
ALTER TABLE picture ADD CONSTRAINT picture_project
    FOREIGN KEY (project_id)
    REFERENCES project (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: project_user_project (table: project_user)
ALTER TABLE project_user ADD CONSTRAINT project_user_project
    FOREIGN KEY (project_id)
    REFERENCES project (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: project_user_user (table: project_user)
ALTER TABLE project_user ADD CONSTRAINT project_user_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: resource_project (table: resource)
ALTER TABLE resource ADD CONSTRAINT resource_project
    FOREIGN KEY (project_id)
    REFERENCES project (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: resource_user (table: resource)
ALTER TABLE resource ADD CONSTRAINT resource_user
    FOREIGN KEY (responsible_user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: task_project (table: task)
ALTER TABLE task ADD CONSTRAINT task_project
    FOREIGN KEY (project_id)
    REFERENCES project (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: task_user (table: task)
ALTER TABLE task ADD CONSTRAINT task_user
    FOREIGN KEY (responsible_user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role_role (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role_user (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.


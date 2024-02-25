CREATE TABLE administration.users (
                              id int8 NOT NULL,
                              created_by_user varchar(255) NULL,
                              created_date timestamp(6) NULL,
                              modified_by_user varchar(255) NULL,
                              modified_date timestamp(6) NULL,
                              is_deleted int4 NOT NULL,
                              "password" varchar(255) NULL,
                              user_name varchar(255) NULL,
                              CONSTRAINT users_pkey PRIMARY KEY (id)
);
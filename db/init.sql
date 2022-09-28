DROP SCHEMA IF EXISTS gbuilder;

CREATE SCHEMA gbuilder;

USE gbuilder;

CREATE TABLE user
(
    id        BIGINT AUTO_INCREMENT
        PRIMARY KEY
        UNIQUE,
    nickname  TEXT                   NOT NULL
        UNIQUE,
    email     TEXT                   NULL,
    website   TEXT                   NULL,
    motto     TEXT                   NULL,
    location  TEXT                   NULL,
    motd      TEXT                   NULL,
    createdAt DATETIME DEFAULT NOW() NOT NULL,
    updatedAt DATETIME DEFAULT NOW() NULL
);

CREATE INDEX user_id_index
    ON user (id DESC);

CREATE INDEX user_nickname_index
    ON user (nickname DESC);

CREATE TABLE repo
(
    id          BIGINT AUTO_INCREMENT
        PRIMARY KEY
        UNIQUE,
    name        TEXT   NOT NULL,
    byuser      BIGINT NULL,
    description TEXT   NULL,
    location    TEXT   NULL,
    CONSTRAINT repo_user_id_fk
        FOREIGN KEY (byuser) REFERENCES user (id)
);

CREATE INDEX repo_id_index
    ON repo (id DESC);

CREATE INDEX repo_nickname_index
    ON repo (name DESC);

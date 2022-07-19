DROP TABLE IF EXISTS literature;

CREATE TABLE literature (
                      isbn        VARCHAR(255) NOT NULL PRIMARY KEY,
                      author      VARCHAR(255) NOT NULL,
                      title       VARCHAR(255) NOT NULL,
                      description VARCHAR(255) NULL,
                      num         INTEGER      NOT NULL DEFAULT 1,
                      image       VARCHAR(255) NULL,
                      created     VARCHAR(255) NULL,
                      updated     VARCHAR(255) NULL,
                      deleted     VARCHAR(255) NULL
);
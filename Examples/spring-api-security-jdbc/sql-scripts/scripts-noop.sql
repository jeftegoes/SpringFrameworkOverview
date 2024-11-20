USE school;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `school`.`users` (
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `enabled` TINYINT NOT NULL,
  PRIMARY KEY (`username`));

CREATE TABLE `school`.`authorities` (
  `username` VARCHAR(50) NOT NULL,
  `authority` VARCHAR(50) NOT NULL,
  UNIQUE INDEX `authorities_UNIQUE` (`username`,  `authority`),
  CONSTRAINT `username_fk`
    FOREIGN KEY (`username`)
    REFERENCES `school`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


INSERT INTO `users`
VALUES
('brenno', '{noop}master@123', 1),
('barbara', '{noop}master@123', 1),
('jefte', '{noop}master@123', 1);

INSERT INTO `authorities`
VALUES
('brenno', 'ROLE_TEACHER'),
('barbara', 'ROLE_TEACHER'),
('barbara', 'ROLE_COORDINATOR'),
('jefte', 'ROLE_TEACHER'),
('jefte', 'ROLE_COORDINATOR'),
('jefte', 'ROLE_ADMIN');
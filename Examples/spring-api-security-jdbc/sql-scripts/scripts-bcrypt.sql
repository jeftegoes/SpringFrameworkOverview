USE school;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `school`.`users` (
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
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
('brenno', '{bcrypt}$2a$10$a2eZLPE1rSQ7ZIqnD2IxPOoBedWMBgNpU.s14k7IPq6EsDixn/5SC', 1),
('barbara', '{bcrypt}$2a$10$KQsIaTz9PeTB9kb3S05dhec6qhsCFjjIU/0kecWapur5V3B98vNDy', 1),
('jefte', '{bcrypt}$2a$10$pexiL67R6kwy/rHOSClyZO3ZIh/uPuDoFd3EQB0WS42l1q2BDOTVm', 1);

INSERT INTO `authorities`
VALUES
('brenno', 'ROLE_TEACHER'),
('barbara', 'ROLE_TEACHER'),
('barbara', 'ROLE_COORDINATOR'),
('jefte', 'ROLE_TEACHER'),
('jefte', 'ROLE_COORDINATOR'),
('jefte', 'ROLE_ADMIN');
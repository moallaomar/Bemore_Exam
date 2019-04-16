INSERT INTO `db_users`.`quiz` (`id`, `description`, `name`) VALUES ('1', 'JAVA', 'JAVA');


INSERT INTO `db_users`.`question` (`id`, `content`,`quiz_id`) VALUES ('1', 'POO','1');
INSERT INTO `db_users`.`question` (`id`, `content`,`quiz_id`) VALUES ('2', 'JVM','1');


INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (1, 'Prog orienté objet ', b'1', 1);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (2, 'prog orienté o', b'0', 1);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (3, 'prog orienté objectif', b'0', 1);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (4, 'prog orienté office', b'0', 1);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (5, 'Java virtual machine', b'1', 2);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (6, 'Ja Va machine', b'0', 2);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (7, 'Java va machine', b'0', 2);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (8, 'java volume machine', b'0',2);

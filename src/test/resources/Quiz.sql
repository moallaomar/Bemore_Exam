INSERT INTO  `quiz` (`id`, `description`, `name`) VALUES ('1', 'Oracle', 'Java');
INSERT INTO  `quiz` (`id`, `description`, `name`) VALUES ('2', 'Google', 'Angular');


INSERT INTO  `question` (`id`, `content`,`content_fr`,`quiz_id`) VALUES ('1', 'Whats POO','Definir La POO','1');
INSERT INTO  `question` (`id`, `content`,`content_fr`,`quiz_id`) VALUES ('2', 'Whats JVM ?','Definir La JVM','1');
INSERT INTO  `question` (`id`, `content`,`content_fr`,`quiz_id`) VALUES
('3', 'Which of the following lines will compile without warning or error?','Laquelle des lignes suivantes compilera sans avertissement ni erreur?','1');
INSERT INTO  `question` (`id`, `content`,`content_fr`,`quiz_id`) VALUES ('4', 'Which of the following annotation of JAX RS API binds the parameter passed to method to a value in path?','Laquelle des annotations suivantes de l''API JAX RS lie le paramètre transmis à method à une valeur dans path?','1');






INSERT INTO  `answer` (`id`, `content`, `correct`, `question_id`) VALUES (1, 'Prog orienté objet ', true, 1);
INSERT INTO  `answer` (`id`, `content`, `correct`, `question_id`) VALUES (2, 'prog orienté o', false, 1);
INSERT INTO  `answer` (`id`, `content`, `correct`, `question_id`) VALUES (3, 'prog orienté objectif', false, 1);
INSERT INTO  `answer` (`id`, `content`, `correct`, `question_id`) VALUES (4, 'prog orienté office', false, 1);


INSERT INTO  `answer` (`id`, `content`, `correct`, `question_id`) VALUES (5, 'Java virtual machine',true, 2);
INSERT INTO  `answer` (`id`, `content`, `correct`, `question_id`) VALUES (6, 'Ja Va machine',false, 2);
INSERT INTO  `answer` (`id`, `content`, `correct`, `question_id`) VALUES (7, 'Java va machine',false, 2);
INSERT INTO  `answer` (`id`, `content`, `correct`, `question_id`) VALUES (8, 'java volume machine',false,2);



INSERT INTO  `answer` (`id`, `content`, `correct`, `question_id`) VALUES (9, 'char d="d";',false,3);
INSERT INTO  `answer` (`id`, `content`, `correct`, `question_id`) VALUES (10, 'float f=3.1415;',false,3);
INSERT INTO  `answer` (`id`, `content`, `correct`, `question_id`) VALUES (11, 'int i=34;',true,3);
INSERT INTO  `answer` (`id`, `content`, `correct`, `question_id`) VALUES (12, 'boolean isPresent=true;',true,3);


INSERT INTO  `answer` (`id`, `content`, `correct`, `question_id`) VALUES (13, '@PathVariable',false,4);
INSERT INTO  `answer` (`id`, `content`, `correct`, `question_id`) VALUES (14, '@HeaderParam',false,4);
INSERT INTO  `answer` (`id`, `content`, `correct`, `question_id`) VALUES (15, '@QueryParam',false,4);
INSERT INTO  `answer` (`id`, `content`, `correct`, `question_id`) VALUES (16, '@PathParam',true,4);



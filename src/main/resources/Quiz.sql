INSERT INTO `db_users`.`quiz` (`id`, `description`, `name`) VALUES ('1', 'Oracle', 'JAVA');
INSERT INTO `db_users`.`quiz` (`id`, `description`, `name`) VALUES ('2', 'Microsoft', '.net');
INSERT INTO `db_users`.`quiz` (`id`, `description`, `name`) VALUES ('3', 'google', 'Angular');


INSERT INTO `db_users`.`question` (`id`, `content`,`quiz_id`) VALUES ('1', 'POO','1');
INSERT INTO `db_users`.`question` (`id`, `content`,`quiz_id`) VALUES ('2', 'JVM','1');
INSERT INTO `db_users`.`question` (`id`, `content`,`quiz_id`) VALUES ('3', 'Which of the following lines will compile without warning or error?','1');
INSERT INTO `db_users`.`question` (`id`, `content`,`quiz_id`) VALUES ('4', 'Which of the following annotation of JAX RS API binds the parameter passed to method to a value in path?','1');
INSERT INTO `db_users`.`question` (`id`, `content`,`quiz_id`) VALUES ('5', 'Which statement will display each element of the array? \n int myArray[] = {1,2,3,4,5}; ','1');
INSERT INTO `db_users`.`question` (`id`, `content`,`quiz_id`) VALUES ('6', 'Which of the following declares an array that supports two rows and a variable number of columns?','1');
INSERT INTO `db_users`.`question` (`id`, `content`,`quiz_id`) VALUES ('7', 'Which of the following modules is not used in Spring?','1');
INSERT INTO `db_users`.`question` (`id`, `content`,`quiz_id`) VALUES ('8', 'Which of the following has the default scope in Spring?','1');
INSERT INTO `db_users`.`question` (`id`, `content`,`quiz_id`) VALUES ('9', 'What is the Life Cycle Of A Jpa Entity?','1');
INSERT INTO `db_users`.`question` (`id`, `content`,`quiz_id`) VALUES ('10', 'What is TRUE about the cascading and cascade mode attributes in Entity Beans?','1');
INSERT INTO `db_users`.`question` (`id`, `content`,`quiz_id`) VALUES ('11', 'Which of the following statements can be used to determine if cat can be found in the list? ArrayList<String> list = new ArrayList<>(); \n list.add("dog"); \n list.add("cat"); \n    list.add("frog"); \n ','1');











INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (1, 'Prog orienté objet ', b'1', 1);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (2, 'prog orienté o', b'0', 1);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (3, 'prog orienté objectif', b'0', 1);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (4, 'prog orienté office', b'0', 1);


INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (5, 'Java virtual machine', b'1', 2);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (6, 'Ja Va machine', b'0', 2);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (7, 'Java va machine', b'0', 2);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (8, 'java volume machine', b'0',2);



INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (9, 'char d="d";', b'0',3);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (10, 'float f=3.1415;', b'0',3);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (11, 'int i=34;', b'1',3);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (12, 'boolean isPresent=true;', b'1',3);


INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (13, '@PathVariable', b'0',4);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (14, '@HeaderParam', b'0',4);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (15, '@QueryParam', b'0',4);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (16, '@PathParam', b'1',4);


INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (17, 'for(int n : myArray[]) { System.out.println(n); }', b'0',5);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (18, 'for(int n : myArray) { System.out.println(n); }', b'1',5);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (19, 'for(int n=1; n < 5; n++) { System.out.println(myArray[n]); }', b'0',5);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (20, 'for(int n=1; n <= 4; n++) { System.out.println(myArray[n]); }', b'0',5);



INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (21, 'int myArray[][] = new int[2][3];', b'0',6);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (22, 'int myArray[][] = new int[][];', b'0',6);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (23, 'int myArray[][] = new int[2][];', b'1',6);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (24, 'int myArray[][] = new int[][3];', b'0',6);



INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (25, 'Application module', b'1',7);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (26, 'DAO module', b'0',7);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (27, 'MVC module', b'0',7);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (28, 'Web module', b'0',7);


INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (29, 'Session', b'0',8);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (30, 'Request', b'0',8);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (31, 'Production', b'0',8);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (32, 'Singleton', b'1',8);

INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (33, 'New / Transient', b'0',9);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (34, 'Managed / Persisted', b'0',9);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (35, 'Detached', b'0',9);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (36, 'All of the above', b'1',9);


INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (37, 'Cascade mode attributes can be specified for the association annotaions (like @OneToMany) in an entity bean', b'1',10);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (38, 'Refresh cascade causes to refresh the target entities of a relationship when refresh is invoked on the source entity of the relationship', b'0',10);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (39, 'The cascading direction is from the target entity to the source entity', b'0',10);
INSERT INTO `db_users`.`answer` (`id`, `content`, `correct`, `question_id`) VALUES (40, 'PERSIST, DELETE and REFRESH are cascading mode attributes', b'0',10);


INSERT INTO `db_users`.`answer` (`id`,`content`, `correct`, `question_id`) VALUES (41,'list.indexOf(\"cat\")', b'1', '11');
INSERT INTO `db_users`.`answer` (`id`,`content`, `correct`, `question_id`) VALUES (42,'list.indexOf(1)', b'0', '11');
INSERT INTO `db_users`.`answer` (`id`,`content`, `correct`, `question_id`) VALUES (43,'list.toString()', b'0', '11');
INSERT INTO `db_users`.`answer` (`id`,`content`, `correct`, `question_id`) VALUES (44,'list.reverse', b'0', '11');

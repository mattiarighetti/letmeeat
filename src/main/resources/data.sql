--RESTAURANTS
INSERT INTO RESTAURANTS (RESTAURANT_ID, NAME, CATEGORY, IMAGE_URL) VALUES ('1', 'Hamburgherello', 'hamburger', 'https://media.timeout.com/images/105187765/image.jpg');
INSERT INTO RESTAURANTS (RESTAURANT_ID, NAME, CATEGORY, IMAGE_URL) VALUES ('2', 'Er fusillo', 'pasta', 'https://assets.suitcasemag.com/images/landscape/198751-pasta-table-spread.jpg');
INSERT INTO RESTAURANTS (RESTAURANT_ID, NAME, CATEGORY, IMAGE_URL) VALUES ('3', 'Da Gino', 'pizza', 'https://lh5.googleusercontent.com/p/AF1QipObQc9QrNuvVNnm35xYjz7GJforL0REpY8e0D6r=w408-h268-k-no');
INSERT INTO RESTAURANTS (RESTAURANT_ID, NAME, CATEGORY, IMAGE_URL) VALUES ('4', 'Drinkesso', 'drinks', 'https://images.unsplash.com/photo-1600891964599-f61ba0e24092?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8cmVzdGF1cmFudCUyMGZvb2R8ZW58MHx8MHx8&w=1000&q=80');
INSERT INTO RESTAURANTS (RESTAURANT_ID, NAME, CATEGORY, IMAGE_URL) VALUES ('5', 'Night shade', 'drinks', 'https://picjumbo.com/wp-content/uploads/glasses-with-champagne-nye-party-celebration-night-drinks-free-photo-2210x1473.jpg');

--MENUS
INSERT INTO MENUS (MENU_ID, NAME, RESTAURANT_ID) VALUES ('1', 'Hamburgerini tosti tosti',  '1');
INSERT INTO MENUS (MENU_ID, NAME, RESTAURANT_ID) VALUES ('2', 'Pasta elicoidalissima',  '2');
INSERT INTO MENUS (MENU_ID, NAME, RESTAURANT_ID) VALUES ('3', 'Pizzette',  '3');
--INSERT INTO MENUS (MENU_ID, NAME, RESTAURANT_ID) VALUES ('4', 'Pizzone',  '3');
INSERT INTO MENUS (MENU_ID, NAME, RESTAURANT_ID) VALUES ('5', 'Gin tonic',  '4');
--INSERT INTO MENUS (MENU_ID, NAME, RESTAURANT_ID) VALUES ('6', 'Grappe & polente',  '4');
INSERT INTO MENUS (MENU_ID, NAME, RESTAURANT_ID) VALUES ('7', 'Long drinks', '5');
--INSERT INTO MENUS (MENU_ID, NAME, RESTAURANT_ID) VALUES ('8', 'Short drinks',  '5');

--DISHES
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, MENU_ID) VALUES ('1', 'Hamburger Vegano', 'Molto buono e consigliato.', 'https://www.my-personaltrainer.it/2020/09/07/hamburger_900x760.jpeg', 23.99, '1');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, MENU_ID) VALUES ('2', 'Hamburger Anoveg', 'Puzza un po ma è il formaggio.', 'https://s7d1.scene7.com/is/image/mcdonalds/DC_202006_0001_Hamburger_Alt_832x472:1-3-product-tile-desktop?wid=765&hei=472&dpr=off', 19.99, '1');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, MENU_ID) VALUES ('3', 'Pasta con le eliche che girano', 'vroom vroom', 'https://www.budgetbytes.com/wp-content/uploads/2013/07/Creamy-Spinach-Tomato-Pasta-bowl-500x500.jpg', 12.74, '2');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, MENU_ID) VALUES ('4', 'Pasta con muzzarella', 'gnam gnam', 'https://www.thechunkychef.com/wp-content/uploads/2017/08/One-Pot-Chicken-Parmesan-Pasta-feat-500x450.jpg', 12.99, '2');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, MENU_ID) VALUES ('5', 'Pizza ca a pummarola ncopp', 'Aumm aumm magnamm', 'https://madensverden.dk/wp-content/uploads/2021/06/hjemmelavet-pizza-500x375.jpg', 11.90, '3');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, MENU_ID) VALUES ('6', 'Pizza wurstel e patatine', 'Attenzione potrebbe essere surgelata', 'https://www.my-personaltrainer.it/2020/10/13/pizza_900x760.jpeg', 1.12, '3');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, MENU_ID) VALUES ('7', 'Gin Tonic Henriks', 'Gin tonic con jimmy hendrix', 'https://madensverden.dk/wp-content/uploads/2017/10/gin-and-tonic-drink.jpg', 22.65, '5');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, MENU_ID) VALUES ('8', 'Solo GIN', 'Pesa un po alito.', 'https://tendercrate.com/wp-content/uploads/2019/03/GinTonic002.jpg', 12.12, '5');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, MENU_ID) VALUES ('9', 'Solo tonic', 'E Uma Turman ti fa ciao ciao', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRceDkJIuEiuN4g_E1e_4vReJmZVRf4m26dEg&usqp=CAU', 11.19, '5');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, MENU_ID) VALUES ('10', 'Polenta', 'O forse grappa?', 'https://www.wine-searcher.com/images/labels/60/57/11116057.jpg', 15.98, '5');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, MENU_ID) VALUES ('11', 'Grappa', 'O forse polenta?', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Ffrescolat.it%2Fricetta-polenta-funghi-e-bastardo-del-grappa%2F&psig=AOvVaw0EgxY4kT9bcpwtkAc7mTty&ust=1683910095391000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCOjZv4rc7f4CFQAAAAAdAAAAABAF', 12.94, '5');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, MENU_ID) VALUES ('12', 'Drink molto lungo', 'Lunghissimoooooo', 'https://offloadmedia.feverup.com/secretmanchester.com/wp-content/uploads/2021/07/28060328/119597072_3771976242831917_2956277655473670217_n.jpeg', 11.11, '7');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, MENU_ID) VALUES ('13', 'Drink poco corto', 'Non disseta verametne', 'https://image.cnbcfm.com/api/v1/image/106490814-1587005939408margaritafromkate.jpg?v=1587006608', 0.98, '7');

--TABLES
INSERT INTO TABLES VALUES (1,'A01',1,1),(2,'B02',1,1),(3,'A02',1,1),(4,'B03',1,1),(5,'A03',1,1),(6,'B04',1,1),(7,'A04',1,1),(8,'B05',1,1),(9,'A05',1,1),(10,'B06',1,1),(11,'A06',1,1),(12,'C01',1,1),(13,'A07',1,1),(14,'C02',1,1),(15,'A08',1,1),(16,'C03',1,1),(17,'A09',1,1),(18,'D09',1,1),(19,'A07',1,1),(20,'C02',1,1),(21,'A08',1,1),(22,'C03',1,1),(23,'A09',1,1),(24,'C04',1,1),(25,'A10',1,1),(26,'D10',1,1),(27,'A08',1,1),(28,'C03',1,1),(29,'A09',1,1),(30,'C04',1,1),(31,'A10',1,1),(32,'C05',1,1),(33,'A11',1,1),(34,'D11',1,1),(35,'A09',1,1),(36,'C04',1,1),(37,'A10',1,5),(38,'C05',1,5),(39,'A11',1,5),(40,'C06',1,5),(41,'A12',1,5),(42,'D12',1,5),(43,'A10',1,5),(44,'C05',1,5),(45,'A11',1,5),(46,'C06',1,5),(47,'A12',1,5),(48,'C07',1,5),(49,'A13',1,5),(50,'D13',1,5),(51,'A11',1,5),(52,'C06',1,5),(53,'A12',1,5),(54,'C07',1,5),(55,'A13',1,1),(56,'C08',1,1),(57,'A14',1,1),(58,'D14',1,1),(59,'A12',1,1),(60,'C07',1,1),(61,'A13',1,1),(62,'C08',1,1),(63,'A14',1,1),(64,'C09',1,1),(65,'A15',1,1),(66,'D15',1,1),(67,'A13',1,1),(68,'C08',1,1),(69,'A14',1,1),(70,'C09',1,1),(71,'A15',1,2),(72,'C10',1,2),(73,'A16',1,2),(74,'D16',1,2),(75,'A14',1,2),(76,'C09',1,2),(77,'A15',1,2),(78,'C10',1,4),(79,'A16',1,4),(80,'C11',1,4),(81,'A17',1,4),(82,'D17',1,4),(83,'A15',1,2),(84,'C10',1,2),(85,'A16',1,2),(86,'C11',1,2),(87,'A17',1,2),(88,'C12',1,2),(89,'A18',1,2),(90,'D18',1,2),(91,'A16',1,2),(92,'C11',1,2),(93,'A17',1,2),(94,'C12',1,2),(95,'A18',1,2),(96,'C13',1,2),(97,'A19',1,2),(98,'D19',1,2),(99,'A17',1,2),(100,'C12',1,2),(101,'A18',1,2),(102,'C13',1,2),(103,'A19',1,2),(104,'C14',1,2),(105,'A20',1,2),(106,'D20',1,2),(107,'A18',1,2),(108,'C13',1,2),(109,'A19',1,2),(110,'C14',1,2),(111,'A20',1,2),(112,'C15',1,2),(113,'A21',1,2),(114,'D21',1,2),(115,'A19',1,2),(116,'C14',1,2),(117,'A20',1,2),(118,'C15',1,2),(119,'A21',1,2),(120,'C16',1,2),(121,'A22',1,2),(122,'D22',1,2),(123,'A20',1,2),(124,'C15',1,2),(125,'A21',1,2),(126,'C16',1,2),(127,'A22',1,2),(128,'C17',1,2),(129,'A23',1,2),(130,'D23',1,2),(131,'A21',1,2),(132,'C16',1,2),(133,'A22',1,2),(134,'C17',1,2),(135,'A23',1,2),(136,'C18',1,2),(137,'A24',1,2),(138,'D24',1,2),(139,'A22',1,2),(140,'C17',1,2),(141,'A23',1,2),(142,'C18',1,2),(143,'A24',1,2),(144,'C19',1,2),(145,'A25',1,2),(146,'D25',1,2),(147,'A23',1,2),(148,'C18',1,2),(149,'A24',1,2),(150,'C19',1,2),(151,'A25',1,2),(152,'C20',1,2),(153,'A26',1,2),(154,'D26',1,2),(155,'A24',1,2),(156,'C19',1,2),(157,'A25',1,2),(158,'C20',1,2),(159,'A26',1,2),(160,'C21',1,2),(161,'A27',1,2),(162,'D27',1,4),(163,'A25',1,4),(164,'C20',1,4),(165,'A26',1,4),(166,'C21',1,2),(167,'A27',1,2),(168,'C22',1,2),(169,'A28',1,2),(170,'D28',1,2),(171,'A26',1,2),(172,'C21',1,2),(173,'A27',1,2),(174,'C22',1,2),(175,'A28',1,2),(176,'C23',1,2),(177,'A29',1,2),(178,'D29',1,2),(179,'A27',1,2),(180,'C22',1,2),(181,'A28',1,2),(182,'C23',1,2),(183,'A29',1,3),(184,'C24',1,3),(185,'A30',1,3),(186,'D30',1,3),(187,'A28',1,3),(188,'C23',1,3),(189,'A29',1,3),(190,'C24',1,4);

--SEATS
INSERT INTO SEATS VALUES (1,'P1',1),(2,'P2',2),(3,'P3',3),(4,'P4',4),(5,'P5',5),(6,'P6',6),(7,'P7',7),(8,'P8',8),(9,'P9',9),(10,'P10',10),(11,'P11',11),(12,'P12',12),(13,'P13',13),(14,'P14',14),(15,'P15',15),(16,'P16',16),(17,'P17',17),(18,'P18',18),(19,'P19',19),(20,'P20',20),(21,'P21',21),(22,'P22',22),(23,'P23',23),(24,'P24',24),(25,'P25',25),(26,'P26',26),(27,'P27',27),(28,'P28',28),(29,'P29',29),(30,'P30',30),(31,'P31',31),(32,'P32',32),(33,'P33',33),(34,'P34',34),(35,'P35',35),(36,'P36',36),(37,'P37',37),(38,'P38',38),(39,'P39',39),(40,'P40',40),(41,'P41',41),(42,'P42',42),(43,'P43',43),(44,'P44',44),(45,'P45',45),(46,'P46',46),(47,'P47',47),(48,'P48',48),(49,'P49',49),(50,'P50',50),(51,'P51',51),(52,'P52',52),(53,'P53',53),(54,'P54',54),(55,'P55',55),(56,'P56',56),(57,'P57',57),(58,'P58',58),(59,'P59',59),(60,'P60',60),(61,'P61',61),(62,'P62',62),(63,'P63',63),(64,'P64',64),(65,'P65',65),(66,'P66',66),(67,'P67',67),(68,'P68',68),(69,'P69',69),(70,'P70',70),(71,'P71',71),(72,'P72',72),(73,'P73',73),(74,'P74',74),(75,'P75',75),(76,'P76',76),(77,'P77',77),(78,'P78',78),(79,'P79',79),(80,'P80',80),(81,'P81',81),(82,'P82',82),(83,'P83',83),(84,'P84',84),(85,'P85',85),(86,'P86',86),(87,'P87',87),(88,'P88',88),(89,'P89',89),(90,'P90',90),(91,'P91',91),(92,'P92',92),(93,'P93',93),(94,'P94',94),(95,'P95',95),(96,'P96',96),(97,'P97',97),(98,'P98',98),(99,'P99',99),(100,'P100',100),(101,'P101',101),(102,'P102',102),(103,'P103',103),(104,'P104',104),(105,'P105',105),(106,'P106',106),(107,'P107',107),(108,'P108',108),(109,'P109',109),(110,'P110',110),(111,'P111',111),(112,'P112',112),(113,'P113',113),(114,'P114',114),(115,'P115',115),(116,'P116',116),(117,'P117',117),(118,'P118',118),(119,'P119',119),(120,'P120',120),(121,'P121',121),(122,'P122',122),(123,'P123',123),(124,'P124',124),(125,'P125',125),(126,'P126',126),(127,'P127',127),(128,'P128',128),(129,'P129',129),(130,'P130',130),(131,'P131',131),(132,'P132',132),(133,'P133',133),(134,'P134',134),(135,'P135',135),(136,'P136',136),(137,'P137',137),(138,'P138',138),(139,'P139',139),(140,'P140',140),(141,'P141',141),(142,'P142',142),(143,'P143',143),(144,'P144',144),(145,'P145',145),(146,'P146',146),(147,'P147',147),(148,'P148',148),(149,'P149',149),(150,'P150',150),(151,'P151',151),(152,'P152',152),(153,'P153',153),(154,'P154',154),(155,'P155',155),(156,'P156',156),(157,'P157',157),(158,'P158',158),(159,'P159',159),(160,'P160',160),(161,'P161',161),(162,'P162',162),(163,'P163',163),(164,'P164',164),(165,'P165',165),(166,'P166',166),(167,'P167',167),(168,'P168',168),(169,'P169',169),(170,'P170',170),(171,'P171',171),(172,'P172',172),(173,'P173',173),(174,'P174',174),(175,'P175',175),(176,'P176',176),(177,'P177',177),(178,'P178',178),(179,'P179',179),(180,'P180',180),(181,'P181',181),(182,'P182',182),(183,'P183',183),(184,'P184',184),(185,'P185',185),(186,'P186',186),(187,'P187',187),(188,'P188',188),(189,'P189',189),(190,'P190',190),(200,'PO1',1),(201,'PO2',2),(202,'P3',3),(203,'P4',4),(204,'P5',5),(205,'P6',6),(206,'P7',7),(207,'P8',8),(208,'P9',9),(209,'P10',10),(210,'P11',11),(211,'P12',12),(212,'P13',13),(213,'P14',14),(214,'P15',15),(215,'P16',16),(216,'P17',17),(217,'P18',18),(218,'P19',19),(219,'P20',20),(220,'P21',21),(221,'P22',22),(222,'P23',23),(223,'P24',24),(224,'P25',25),(225,'P26',26),(226,'P27',27),(227,'P28',28),(228,'P29',29),(229,'P30',30),(230,'P31',31),(231,'P32',32),(232,'P33',33),(233,'P34',34),(234,'P35',35),(235,'P36',36),(236,'P37',37),(237,'P38',38),(238,'P39',39),(239,'P40',40),(240,'P41',41),(241,'P42',42),(242,'P43',43),(243,'P44',44),(244,'P45',45),(245,'P46',46),(246,'P47',47),(247,'P48',48),(248,'P49',49),(249,'P50',50),(250,'P51',51),(251,'P52',52),(252,'P53',53),(253,'P54',54),(254,'P55',55),(255,'P56',56),(256,'P57',57),(257,'P58',58),(258,'P59',59),(259,'P60',60),(260,'P61',61),(261,'P62',62),(262,'P63',63),(263,'P64',64),(264,'P65',65),(265,'P66',66),(266,'P67',67),(267,'P68',68),(268,'P69',69),(269,'P70',70),(270,'P71',71),(271,'P72',72),(272,'P73',73),(273,'P74',74),(274,'P75',75),(275,'P76',76),(276,'P77',77),(277,'P78',78),(278,'P79',79),(279,'P80',80),(280,'P81',81),(281,'P82',82),(282,'P83',83),(283,'P84',84),(284,'P85',85),(285,'P86',86),(286,'P87',87),(287,'P88',88),(288,'P89',89),(289,'P90',90),(290,'P91',91),(291,'P92',92),(292,'P93',93),(293,'P94',94),(294,'P95',95),(295,'P96',96),(296,'P97',97),(297,'P98',98),(298,'P99',99),(299,'P100',100),(300,'P101',101),(301,'P102',102),(302,'P103',103),(303,'P104',104),(304,'P105',105),(305,'P106',106),(306,'P107',107),(307,'P108',108),(308,'P109',109),(309,'P110',110),(310,'P111',111),(311,'P112',112),(312,'P113',113),(313,'P114',114),(314,'P115',115),(315,'P116',116),(316,'P117',117),(317,'P118',118),(318,'P119',119),(319,'P120',120),(320,'P121',121),(321,'P122',122),(322,'P123',123),(323,'P124',124),(324,'P125',125),(325,'P126',126),(326,'P127',127),(327,'P128',128),(328,'P129',129),(329,'P130',130),(330,'P131',131),(331,'P132',132),(332,'P133',133),(333,'P134',134),(334,'P135',135),(335,'P136',136),(336,'P137',137),(337,'P138',138),(338,'P139',139),(339,'P140',140),(340,'P141',141),(341,'P142',142),(342,'P143',143),(343,'P144',144),(344,'P145',145),(345,'P146',146),(346,'P147',147),(347,'P148',148),(348,'P149',149),(349,'P150',150),(350,'P151',151),(351,'P152',152),(352,'P153',153),(353,'P154',154),(354,'P155',155),(355,'P156',156),(356,'P157',157),(357,'P158',158),(358,'P159',159),(359,'P160',160),(360,'P161',161),(361,'P162',162),(362,'P163',163),(363,'P164',164),(364,'P165',165),(365,'P166',166),(366,'P167',167),(367,'P168',168),(368,'P169',169),(369,'P170',170),(370,'P171',171),(371,'P172',172),(372,'P173',173),(373,'P174',174),(374,'P175',175),(375,'P176',176),(376,'P177',177),(377,'P178',178),(378,'P179',179),(379,'P180',180),(380,'P181',181),(381,'P182',182),(382,'P183',183),(383,'P184',184),(384,'P185',185),(385,'P186',186),(386,'P187',187),(387,'P188',188),(388,'P189',189),(389,'P190',190);

--USERS
INSERT INTO USERS (USER_ID, NAME, SURNAME, EMAIL) VALUES ('1', 'ciao', 'iuser', 'ciao@iuser.fl');
INSERT INTO USERS (USER_ID, NAME, SURNAME, EMAIL) VALUES ('2', 'sanna', 'marin', 'senna@marin.com');
INSERT INTO USERS (USER_ID, NAME, SURNAME, EMAIL) VALUES ('3', 'gira', 'volta', 'altra@volta.it');
INSERT INTO USERS (USER_ID, NAME, SURNAME, EMAIL) VALUES ('4', 'licia', 'colo', 'liciacolo@rai.tv');


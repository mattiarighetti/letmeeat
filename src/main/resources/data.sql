--RESTAURANTS
INSERT INTO RESTAURANTS (RESTAURANT_ID, NAME, CATEGORY, IMAGE_URL) VALUES ('1', 'Hamburgherello', 'hamburger', 'https://media.timeout.com/images/105187765/image.jpg');
INSERT INTO RESTAURANTS (RESTAURANT_ID, NAME, CATEGORY, IMAGE_URL) VALUES ('2', 'Er fusillo', 'pasta', 'https://assets.suitcasemag.com/images/landscape/198751-pasta-table-spread.jpg');
INSERT INTO RESTAURANTS (RESTAURANT_ID, NAME, CATEGORY, IMAGE_URL) VALUES ('3', 'Da Gino', 'pizza', 'https://lh5.googleusercontent.com/p/AF1QipObQc9QrNuvVNnm35xYjz7GJforL0REpY8e0D6r=w408-h268-k-no');
INSERT INTO RESTAURANTS (RESTAURANT_ID, NAME, CATEGORY, IMAGE_URL) VALUES ('4', 'Drinkesso', 'drinks', 'https://images.unsplash.com/photo-1600891964599-f61ba0e24092?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8cmVzdGF1cmFudCUyMGZvb2R8ZW58MHx8MHx8&w=1000&q=80');
INSERT INTO RESTAURANTS (RESTAURANT_ID, NAME, CATEGORY, IMAGE_URL) VALUES ('5', 'Night shade', 'drinks', 'https://picjumbo.com/wp-content/uploads/glasses-with-champagne-nye-party-celebration-night-drinks-free-photo-2210x1473.jpg');

--MENUS
INSERT INTO MENUS (MENU_ID, NAME, AVAILABLE, RESTAURANT_ID) VALUES ('1', 'Hamburgerini tosti tosti', '1', '1');
INSERT INTO MENUS (MENU_ID, NAME, AVAILABLE, RESTAURANT_ID) VALUES ('2', 'Pasta elicoidalissima', '1', '2');
INSERT INTO MENUS (MENU_ID, NAME, AVAILABLE, RESTAURANT_ID) VALUES ('3', 'Pizzette', '1', '3');
INSERT INTO MENUS (MENU_ID, NAME, AVAILABLE, RESTAURANT_ID) VALUES ('4', 'Pizzone', '1', '3');
INSERT INTO MENUS (MENU_ID, NAME, AVAILABLE, RESTAURANT_ID) VALUES ('5', 'Gin tonic', '1', '4');
INSERT INTO MENUS (MENU_ID, NAME, AVAILABLE, RESTAURANT_ID) VALUES ('6', 'Grappe & polente', '1', '4');
INSERT INTO MENUS (MENU_ID, NAME, RESTAURANT_ID) VALUES ('7', 'Long drinks', '5');
INSERT INTO MENUS (MENU_ID, NAME, AVAILABLE, RESTAURANT_ID) VALUES ('8', 'Short drinks', '1', '5');

--DISHES
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, AVAILABLE, MENU_ID) VALUES ('1', 'Hamburger Vegano', 'Molto buono e consigliato.', 'https://www.my-personaltrainer.it/2020/09/07/hamburger_900x760.jpeg', '23.99', '1', '1');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, AVAILABLE, MENU_ID) VALUES ('2', 'Hamburger Anoveg', 'Puzza un po ma è il formaggio.', 'https://s7d1.scene7.com/is/image/mcdonalds/DC_202006_0001_Hamburger_Alt_832x472:1-3-product-tile-desktop?wid=765&hei=472&dpr=off', '19.99', '1', '1');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, AVAILABLE, MENU_ID) VALUES ('3', 'Pasta con le eliche che girano', 'vroom vroom', 'https://www.budgetbytes.com/wp-content/uploads/2013/07/Creamy-Spinach-Tomato-Pasta-bowl-500x500.jpg', '12.74', '1', '2');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, AVAILABLE, MENU_ID) VALUES ('4', 'Pasta con muzzarella', 'gnam gnam', 'https://www.thechunkychef.com/wp-content/uploads/2017/08/One-Pot-Chicken-Parmesan-Pasta-feat-500x450.jpg', '12.99', '1', '2');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, AVAILABLE, MENU_ID) VALUES ('5', 'Pizza ca a pummarola ncopp', 'Aumm aumm magnamm', 'https://madensverden.dk/wp-content/uploads/2021/06/hjemmelavet-pizza-500x375.jpg', '11.90', '1', '3');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, AVAILABLE, MENU_ID) VALUES ('6', 'Pizza wurstel e patatine', 'Attenzione potrebbe essere surgelata', 'https://www.my-personaltrainer.it/2020/10/13/pizza_900x760.jpeg', '1.12', '1', '4');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, AVAILABLE, MENU_ID) VALUES ('7', 'Gin Tonic Henriks', 'Gin tonic con jimmy hendrix', 'https://madensverden.dk/wp-content/uploads/2017/10/gin-and-tonic-drink.jpg', '22.65', '1', '5');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, AVAILABLE, MENU_ID) VALUES ('8', 'Solo GIN', 'Pesa un po alito.', 'https://tendercrate.com/wp-content/uploads/2019/03/GinTonic002.jpg', '12.12', '1', '5');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, AVAILABLE, MENU_ID) VALUES ('9', 'Solo tonic', 'E Uma Turman ti fa ciao ciao', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRceDkJIuEiuN4g_E1e_4vReJmZVRf4m26dEg&usqp=CAU', '11.19', '1', '5');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, AVAILABLE, MENU_ID) VALUES ('10', 'Polenta', 'O forse grappa?', 'https://www.wine-searcher.com/images/labels/60/57/11116057.jpg', '15.98', '1', '6');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, AVAILABLE, MENU_ID) VALUES ('11', 'Grappa', 'O forse polenta?', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Ffrescolat.it%2Fricetta-polenta-funghi-e-bastardo-del-grappa%2F&psig=AOvVaw0EgxY4kT9bcpwtkAc7mTty&ust=1683910095391000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCOjZv4rc7f4CFQAAAAAdAAAAABAF', '12.94', '1', '6');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, AVAILABLE, MENU_ID) VALUES ('12', 'Drink molto lungo', 'Lunghissimoooooo', 'https://offloadmedia.feverup.com/secretmanchester.com/wp-content/uploads/2021/07/28060328/119597072_3771976242831917_2956277655473670217_n.jpeg', '11.11', '1', '7');
INSERT INTO DISHES (DISH_ID, NAME, DESCRIPTION, IMAGE_URL, PRICE, AVAILABLE, MENU_ID) VALUES ('13', 'Drink poco corto', 'Non disseta verametne', 'https://image.cnbcfm.com/api/v1/image/106490814-1587005939408margaritafromkate.jpg?v=1587006608', '0.98', '1', '7');

--TABLES

--SEATS


/*========================*/
/* CREACION USUARIOS SQL  */
/*  FECHA NOVIEMBRE 2023  */
/*   GRUPO QUATROSPHERE   */
/*========================*/

CREATE USER 'auth-microservice' IDENTIFIED BY 'auTh-m1sv3_Db';
CREATE DATABASE IF NOT EXISTS `authentication_db`;
GRANT ALL PRIVILEGES ON `authentication_db`.* TO 'auth-microservice';

CREATE USER 'store-microservice' IDENTIFIED BY 'sT0r3-m1sv3_Db';
CREATE DATABASE IF NOT EXISTS `store_db`;
GRANT ALL PRIVILEGES ON `store_db`.* TO 'store-microservice';

FLUSH PRIVILEGES;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS authentication_db.`company`;
DROP TABLE IF EXISTS authentication_db.`client`;
DROP TABLE IF EXISTS store_db.`productos`;
DROP TABLE IF EXISTS store_db.`ventas_comercio`;
DROP TABLE IF EXISTS store_db.`inventory_store`;
DROP TABLE IF EXISTS store_db.`deta_vta_comercio`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE store_db.`productos` (
  `id_producto` bigint NOT NULL AUTO_INCREMENT,
  `codigo_barra` bigint DEFAULT NULL,
  `desripcion_producto` varchar(255) DEFAULT NULL,
  `nombre_producto` varchar(255) DEFAULT NULL,
  `nombre_proveedor` varchar(255) DEFAULT NULL,
  `peso_neto` int DEFAULT NULL,
  `tipo_producto` varchar(255) DEFAULT NULL,
  `unidad_peso_neto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE store_db.`ventas_comercio` (
  `id_sale` bigint NOT NULL AUTO_INCREMENT,
  `tot_prods` bigint DEFAULT NULL,
  `total_price_sale` bigint DEFAULT NULL,
  PRIMARY KEY (`id_sale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE store_db.`inventory_store` (
  `id_inv` bigint NOT NULL AUTO_INCREMENT,
  `barcode` bigint DEFAULT NULL,
  `id_company` bigint DEFAULT NULL,
  `id_prod` bigint DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `net_weight` int DEFAULT NULL,
  `quantity_prods` bigint DEFAULT NULL,
  `product_type` varchar(255) DEFAULT NULL,
  `net_weight_unit` varchar(255) DEFAULT NULL,
  `unit_price_prod` bigint DEFAULT NULL,
  PRIMARY KEY (`id_inv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE store_db.`deta_vta_comercio` (
  `id_detalle` bigint NOT NULL AUTO_INCREMENT,
  `quantity_prods` int DEFAULT NULL,
  `total_price` bigint DEFAULT NULL,
  `id_inv` bigint DEFAULT NULL,
  `id_sale` bigint DEFAULT NULL,
  PRIMARY KEY (`id_detalle`),
  KEY `FKtqci1pvdv0le4ahnumccpsiek` (`id_inv`),
  KEY `FKjd7vxqfrpn0xcgn0lvt3e900v` (`id_sale`),
  CONSTRAINT `FKjd7vxqfrpn0xcgn0lvt3e900v` FOREIGN KEY (`id_sale`) REFERENCES `ventas_comercio` (`id_sale`),
  CONSTRAINT `FKtqci1pvdv0le4ahnumccpsiek` FOREIGN KEY (`id_inv`) REFERENCES `inventory_store` (`id_inv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE authentication_db.`company` (
  `id_company` bigint NOT NULL AUTO_INCREMENT,
  `direction_company` varchar(255) DEFAULT NULL,
  `phone_company` bigint DEFAULT NULL,
  `name_company` varchar(255) DEFAULT NULL,
  `rut_company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_company`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE authentication_db.`client` (
  `id_client` bigint NOT NULL AUTO_INCREMENT,
  `email_client` varchar(255) DEFAULT NULL,
  `firstname_client` varchar(255) DEFAULT NULL,
  `lastname_client` varchar(255) DEFAULT NULL,
  `password_client` varchar(255) DEFAULT NULL,
  `token_auth` varchar(255) DEFAULT NULL,
  `id_company` bigint DEFAULT NULL,
  PRIMARY KEY (`id_client`),
  KEY `FK7uj0kwhxaa9rqs9agvtp9341h` (`id_company`),
  CONSTRAINT `FK7uj0kwhxaa9rqs9agvtp9341h` FOREIGN KEY (`id_company`) REFERENCES `company` (`id_company`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO store_db.productos(id_producto,nombre_producto,nombre_proveedor,codigo_barra,tipo_producto,peso_neto,unidad_peso_neto,desripcion_producto) VALUES (1,'Oreo','Mondelez',7622201693091, 'Galletas', 108, 'Gramos', 'Doble galleta sabor chocolate a chocolate con crema sabor a vainilla');
INSERT INTO store_db.productos(id_producto,nombre_producto,nombre_proveedor,codigo_barra,tipo_producto,peso_neto,unidad_peso_neto,desripcion_producto) VALUES (2,'Maravilla','Mackay',7613039496275, 'Galletas', 120, 'Gramos', 'Galleta sabor vainilla');
INSERT INTO store_db.productos(id_producto,nombre_producto,nombre_proveedor,codigo_barra,tipo_producto,peso_neto,unidad_peso_neto,desripcion_producto) VALUES (3,'Pepsi','CCU',7801620017552, 'Bebidas', 3, 'Litros', 'Bebida fantasia');
INSERT INTO store_db.productos(id_producto,nombre_producto,nombre_proveedor,codigo_barra,tipo_producto,peso_neto,unidad_peso_neto,desripcion_producto) VALUES (4,'Benedictino sin gas','Coca Cola',782820443301, 'Bebidas', 3, 'Litros', 'Agua natural sin gas');
INSERT INTO store_db.productos(id_producto,nombre_producto,nombre_proveedor,codigo_barra,tipo_producto,peso_neto,unidad_peso_neto,desripcion_producto) VALUES (5,'Benedictino gasificada','Coca Cola',7802820443356, 'Bebidas', 3, 'Litros', 'Agua natural gasificada');
INSERT INTO store_db.productos(id_producto,nombre_producto,nombre_proveedor,codigo_barra,tipo_producto,peso_neto,unidad_peso_neto,desripcion_producto) VALUES (6,'Ron Dominicano','Barceló',7461323129503, 'Alcoholes', 1, 'Litros', 'Ron Añejado');
INSERT INTO store_db.productos(id_producto,nombre_producto,nombre_proveedor,codigo_barra,tipo_producto,peso_neto,unidad_peso_neto,desripcion_producto) VALUES (7,'Jabon Liquido Aceite Coco y Jazmin','Ballerina',7804920003065, 'Jabones', 750, 'Mililitros', 'Jabon Liquido');
INSERT INTO store_db.productos(id_producto,nombre_producto,nombre_proveedor,codigo_barra,tipo_producto,peso_neto,unidad_peso_neto,desripcion_producto) VALUES (8,'Jabon Liquido Humectante Yoghurt Arandonos','Ballerina',7804920012166, 'Jabones', 750, 'Mililitros', 'Jabon Liquido');
INSERT INTO store_db.productos(id_producto,nombre_producto,nombre_proveedor,codigo_barra,tipo_producto,peso_neto,unidad_peso_neto,desripcion_producto) VALUES (9,'Porotitos de Caramelo','Merello',7802247530356, 'Caramelos', 90, 'Gramos', 'Porotitos de caramelo');
INSERT INTO store_db.productos(id_producto,nombre_producto,nombre_proveedor,codigo_barra,tipo_producto,peso_neto,unidad_peso_neto,desripcion_producto) VALUES (10,'Limpiado Multiusos','Homecare',7807910029946, 'Limpieza', 500, 'Mililitros', 'Limpiador multiuso');
INSERT INTO store_db.productos(id_producto,nombre_producto,nombre_proveedor,codigo_barra,tipo_producto,peso_neto,unidad_peso_neto,desripcion_producto) VALUES (11,'Durazno en cubitos','Huasil',7801305002057, 'Comida', 380, 'Gramos', 'Postre durazno en cubitos');
INSERT INTO store_db.productos(id_producto,nombre_producto,nombre_proveedor,codigo_barra,tipo_producto,peso_neto,unidad_peso_neto,desripcion_producto) VALUES (12,'Limpiador multiespacios','Homecare',7807910029847, 'Limpieza', 1800, 'Mililitros', 'Limpiador de pisos aromaticos');
INSERT INTO store_db.productos(id_producto,nombre_producto,nombre_proveedor,codigo_barra,tipo_producto,peso_neto,unidad_peso_neto,desripcion_producto) VALUES (13,'Insectisida Mata arañas','Raid Max',7790520009234, 'Insectisidas', 339, 'Gramos', 'Insectisida multiuso');
INSERT INTO store_db.productos(id_producto,nombre_producto,nombre_proveedor,codigo_barra,tipo_producto,peso_neto,unidad_peso_neto,desripcion_producto) VALUES (14,'Vino Reserva Merlot','Carmen', 7804335002646, 'Alcoholes', 750, 'Mililitros', 'Alcoholes Vino');

INSERT INTO store_db.inventory_store(id_inv, quantity_prods, unit_price_prod, id_prod, product_name, barcode, product_type, net_weight, net_weight_unit, id_company) VALUES (1, 15, 430, 1, 'Oreo', 7622201693091, 'Galletas', 108, 'Gramos', 1);
INSERT INTO store_db.inventory_store(id_inv, quantity_prods, unit_price_prod, id_prod, product_name, barcode, product_type, net_weight, net_weight_unit, id_company) VALUES (3, 6, 3100, 3, 'Pepsi', 7801620017552, 'Bebidas', 3, 'Litros', 1);
INSERT INTO store_db.inventory_store(id_inv, quantity_prods, unit_price_prod, id_prod, product_name, barcode, product_type, net_weight, net_weight_unit, id_company) VALUES (4, 9, 2099, 4, 'Benedictino sin gas', 782820443301, 'Bebidas', 3, 'Litros', 1);
INSERT INTO store_db.inventory_store(id_inv, quantity_prods, unit_price_prod, id_prod, product_name, barcode, product_type, net_weight, net_weight_unit, id_company) VALUES (7, 4, 1780, 7, 'Jabon Liquido Aceite Coco y Jazmin', 7804920003065, 'Jabones', 750, 'Mililitros', 1);
INSERT INTO store_db.inventory_store(id_inv, quantity_prods, unit_price_prod, id_prod, product_name, barcode, product_type, net_weight, net_weight_unit, id_company) VALUES (11, 7, 690, 11, 'Durazno en cubitos', 7801305002057, 'Comida', 380, 'Gramos', 1);

INSERT INTO authentication_db.company(id_company, rut_company, name_company, direction_company, phone_company) VALUES (1, '18.221.431-5', 'QuatroSphere', 'Avenida siempre viva 123', 967453291);

INSERT INTO authentication_db.client(id_client, email_client, firstname_client, lastname_client, id_company, password_client) VALUES (1, 'Nicolas', 'Caviedes', 'ni.caviedes@duocuc.cl', 1, '$2a$10$Zq4AAp1FSEMIwb6blVO8bOWjEow9pPvSdAQhTDZrwd6c9IkGbhFOW');
INSERT INTO authentication_db.client(id_client, email_client, firstname_client, lastname_client, id_company, password_client) VALUES (2, 'David', 'Rubio', 'dav.rubio@duocuc.cl', 1, '$2a$10$Zq4AAp1FSEMIwb6blVO8bOWjEow9pPvSdAQhTDZrwd6c9IkGbhFOW');
INSERT INTO authentication_db.client(id_client, email_client, firstname_client, lastname_client, password_client) VALUES (3, 'Sergio', 'Plaza', 's.plazae@duocuc.cl', '$2a$10$Zq4AAp1FSEMIwb6blVO8bOWjEow9pPvSdAQhTDZrwd6c9IkGbhFOW');
INSERT INTO authentication_db.client(id_client, email_client, firstname_client, lastname_client, password_client) VALUES (4, 'Jorge', 'Escobar', 'j.escobar@duocuc.cl', '$2a$10$Zq4AAp1FSEMIwb6blVO8bOWjEow9pPvSdAQhTDZrwd6c9IkGbhFOW');

COMMIT;
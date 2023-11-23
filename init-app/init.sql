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
DROP TABLE IF EXISTS store_db.`empresa`;
DROP TABLE IF EXISTS store_db.`productos`;
DROP TABLE IF EXISTS store_db.`ventas_comercio`;
DROP TABLE IF EXISTS store_db.`inventario_comercios`;
DROP TABLE IF EXISTS store_db.`usuario`;
DROP TABLE IF EXISTS store_db.`deta_vta_comercio`;
DROP TABLE IF EXISTS store_db.`productos_seq`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE store_db.`empresa` (
  `id_empresa` bigint NOT NULL,
  `direccion_empresa` varchar(255) DEFAULT NULL,
  `fono_empresa` bigint DEFAULT NULL,
  `nombre_empresa` varchar(255) DEFAULT NULL,
  `rut_empresa` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE store_db.`productos` (
  `id_producto` bigint NOT NULL,
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
  `id_sale` bigint NOT NULL,
  `tot_prods` bigint DEFAULT NULL,
  `total_price_sale` bigint DEFAULT NULL,
  PRIMARY KEY (`id_sale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE store_db.`inventario_comercios` (
  `id_inv` bigint NOT NULL,
  `codigo_barra` bigint DEFAULT NULL,
  `id_empresa` bigint DEFAULT NULL,
  `id_prod` bigint DEFAULT NULL,
  `nombre_producto` varchar(255) DEFAULT NULL,
  `peso_neto` int DEFAULT NULL,
  `quantity_prods` bigint DEFAULT NULL,
  `tipo_producto` varchar(255) DEFAULT NULL,
  `unidad_peso_neto` varchar(255) DEFAULT NULL,
  `unit_price_prod` bigint DEFAULT NULL,
  PRIMARY KEY (`id_inv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE store_db.`usuario` (
  `id_user` bigint NOT NULL,
  `email_user` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `id_empresa` bigint DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `FKi6afn0oum3c6ejol9ahlluox2` (`id_empresa`),
  CONSTRAINT `FKi6afn0oum3c6ejol9ahlluox2` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE store_db.`deta_vta_comercio` (
  `id_detalle` bigint NOT NULL,
  `quantity_prods` int DEFAULT NULL,
  `total_price` bigint DEFAULT NULL,
  `id_inv` bigint DEFAULT NULL,
  `id_sale` bigint DEFAULT NULL,
  PRIMARY KEY (`id_detalle`),
  KEY `FKhf72w97yju9no3fnjbrt0f195` (`id_inv`),
  KEY `FKiqs4i8yw5utuwak2umkxycxm3` (`id_sale`),
  CONSTRAINT `FKhf72w97yju9no3fnjbrt0f195` FOREIGN KEY (`id_inv`) REFERENCES `inventario_comercios` (`id_inv`),
  CONSTRAINT `FKiqs4i8yw5utuwak2umkxycxm3` FOREIGN KEY (`id_sale`) REFERENCES `ventas_comercio` (`id_sale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE store_db.`productos_seq` (
  `next_val` bigint DEFAULT NULL
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

INSERT INTO store_db.empresa(id_empresa, rut_empresa, nombre_empresa, direccion_empresa, fono_empresa) VALUES (1, '18.221.431-5', 'QuatroSphere', 'Avenida siempre viva 123', 967453291);

INSERT INTO store_db.usuario(id_user, email_user, password, id_empresa) VALUES (2,'dav.rubio@duocuc.cl', 'hola123', 1);
INSERT INTO store_db.usuario(id_user, email_user, password) VALUES (3,'s.plazae@duocuc.cl', 'hola123');
INSERT INTO store_db.usuario(id_user, email_user, password, id_empresa) VALUES (1,'ni.caviedes@duocuc.cl', 'hola123', 1);
INSERT INTO store_db.usuario(id_user, email_user, password) VALUES (4,'j.escobar@duocuc.cl', 'hola123');

INSERT INTO store_db.inventario_comercios(id_inv, quantity_prods, unit_price_prod, id_prod, nombre_producto, codigo_barra, tipo_producto, peso_neto, unidad_peso_neto, id_empresa) VALUES (1, 15, 430, 1, 'Oreo', 7622201693091, 'Galletas', 108, 'Gramos', 1);
INSERT INTO store_db.inventario_comercios(id_inv, quantity_prods, unit_price_prod, id_prod, nombre_producto, codigo_barra, tipo_producto, peso_neto, unidad_peso_neto, id_empresa) VALUES (3, 6, 3100, 3, 'Pepsi', 7801620017552, 'Bebidas', 3, 'Litros', 1);
INSERT INTO store_db.inventario_comercios(id_inv, quantity_prods, unit_price_prod, id_prod, nombre_producto, codigo_barra, tipo_producto, peso_neto, unidad_peso_neto, id_empresa) VALUES (4, 9, 2099, 4, 'Benedictino sin gas', 782820443301, 'Bebidas', 3, 'Litros', 1);
INSERT INTO store_db.inventario_comercios(id_inv, quantity_prods, unit_price_prod, id_prod, nombre_producto, codigo_barra, tipo_producto, peso_neto, unidad_peso_neto, id_empresa) VALUES (7, 4, 1780, 7, 'Jabon Liquido Aceite Coco y Jazmin', 7804920003065, 'Jabones', 750, 'Mililitros', 1);
INSERT INTO store_db.inventario_comercios(id_inv, quantity_prods, unit_price_prod, id_prod, nombre_producto, codigo_barra, tipo_producto, peso_neto, unidad_peso_neto, id_empresa) VALUES (11, 7, 690, 11, 'Durazno en cubitos', 7801305002057, 'Comida', 380, 'Gramos', 1);
COMMIT;
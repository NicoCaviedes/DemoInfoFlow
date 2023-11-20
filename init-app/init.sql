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
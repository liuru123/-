-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: rentcar
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `Cus_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Cus_Password` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Cus_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Cus_Nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Cus_Company` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Cus_IdNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Cus_Sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Cus_Tel` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Cus_DriLicense_Id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Cus_Address` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`Cus_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (2,'666','k','ad','','612731','','','',''),(3,'123',NULL,'us',NULL,'123456',NULL,NULL,NULL,NULL),(4,'123','段雪','段雪','嗒嗒','11','女','11','11','菜单'),(5,'666',NULL,'us1',NULL,'123456',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-23 20:59:29

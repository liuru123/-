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
-- Table structure for table `rent_record`
--

DROP TABLE IF EXISTS `rent_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rent_record` (
  `Rec_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Car_Id` int(11) DEFAULT NULL,
  `E_Id` int(11) DEFAULT NULL,
  `Cus_IDNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `DesD_Id` int(11) DEFAULT NULL,
  `Car_IsBack` int(11) DEFAULT NULL,
  `Car_RentDate` date DEFAULT NULL,
  `Car_BackDate` date DEFAULT NULL,
  `DesD_Is` int(11) DEFAULT NULL,
  `Car_RentMoney` double DEFAULT NULL,
  `Deposit` double DEFAULT NULL,
  PRIMARY KEY (`Rec_Id`),
  KEY `FK_Reference_4` (`Car_Id`),
  KEY `FK_Reference_5` (`Cus_IDNum`),
  KEY `FK_Reference_6` (`E_Id`),
  KEY `FK_Reference_9` (`DesD_Id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`Car_Id`) REFERENCES `car` (`Car_Id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`Cus_IDNum`) REFERENCES `customers` (`Cus_IdNum`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`E_Id`) REFERENCES `employee` (`E_Id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`DesD_Id`) REFERENCES `desdriver` (`DesD_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent_record`
--

LOCK TABLES `rent_record` WRITE;
/*!40000 ALTER TABLE `rent_record` DISABLE KEYS */;
INSERT INTO `rent_record` VALUES (3,1,1,'610403',1,1,'2016-06-16','2016-06-20',0,800,300);
/*!40000 ALTER TABLE `rent_record` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-16 19:26:54

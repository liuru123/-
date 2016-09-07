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
  `Cus_Id` int(11) DEFAULT NULL,
  `Car_IsBack` int(11) DEFAULT NULL,
  `Car_RentDate` date DEFAULT NULL,
  `Car_BackDate` date DEFAULT NULL,
  `DesD_Is` int(11) DEFAULT NULL,
  `Car_RentMoney` double DEFAULT NULL,
  `Deposit` double DEFAULT NULL,
  PRIMARY KEY (`Rec_Id`),
  KEY `rr_fkey1` (`Cus_Id`),
  CONSTRAINT `rr_fkey1` FOREIGN KEY (`Cus_Id`) REFERENCES `customers` (`Cus_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent_record`
--

LOCK TABLES `rent_record` WRITE;
/*!40000 ALTER TABLE `rent_record` DISABLE KEYS */;
INSERT INTO `rent_record` VALUES (2,1,1,2,1,'2016-02-13','2016-03-01',1,2000,400),(4,9,0,2,1,'2016-06-25','2016-06-30',1,2500,750),(5,9,0,2,1,'2016-12-04','2016-12-10',1,3000,900),(6,1,0,5,1,'2016-06-23','2016-06-28',1,1000,300),(7,2,0,2,1,'2016-06-24','2016-06-30',1,1800,540),(8,8,0,2,1,'2016-06-26','2016-07-01',1,1900,570);
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

-- Dump completed on 2016-06-23 20:59:30

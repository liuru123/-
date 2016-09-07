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
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `Car_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Car_Type` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Car_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Car_Count` int(11) DEFAULT NULL,
  `Car_Door` int(11) DEFAULT NULL,
  `Car_Window` int(11) DEFAULT NULL,
  `Car_GPS` int(11) DEFAULT NULL,
  `Car_Oil` int(11) DEFAULT NULL,
  `Car_Gasbag` int(11) DEFAULT NULL,
  `Car_Color` varchar(5) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Car_Image` varchar(80) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Car_IsUseful` int(11) DEFAULT NULL,
  `Car_Description` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`Car_Id`),
  KEY `FK_Reference_7` (`Car_Type`,`Car_Name`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`Car_Type`, `Car_Name`) REFERENCES `car_type` (`Car_Type`, `Car_Name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,'suv','瑞风s3',5,4,1,1,50,1,'白',NULL,1,'全新'),(2,'小型','起亚k2',4,4,1,1,40,1,'白',NULL,1,'全新'),(8,'中型','宝马3系',4,4,1,1,50,1,'黑',NULL,1,'全新'),(9,'跑车','保时捷918',4,4,1,1,70,2,'黑',NULL,1,'全新');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
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

CREATE DATABASE  IF NOT EXISTS `cardealershipsrestapi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cardealershipsrestapi`;
-- MySQL dump 10.13  Distrib 8.4.2, for Win64 (x86_64)
--
-- Host: localhost    Database: cardealershipsrestapi
-- ------------------------------------------------------
-- Server version	8.4.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sale_contract`
--

DROP TABLE IF EXISTS `sale_contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale_contract` (
  `date` date DEFAULT NULL,
  `dealership_id` int DEFAULT NULL,
  `sale_id` int NOT NULL AUTO_INCREMENT,
  `sale_price` double DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `vin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sale_id`),
  KEY `FKlxnj8e6xyutpq9bckdm65ir4m` (`dealership_id`),
  KEY `FKasmsnptpwv6v1ffryykp0btm9` (`vin`),
  CONSTRAINT `FKasmsnptpwv6v1ffryykp0btm9` FOREIGN KEY (`vin`) REFERENCES `vehicle` (`vin`),
  CONSTRAINT `FKlxnj8e6xyutpq9bckdm65ir4m` FOREIGN KEY (`dealership_id`) REFERENCES `dealership` (`dealership_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_contract`
--

LOCK TABLES `sale_contract` WRITE;
/*!40000 ALTER TABLE `sale_contract` DISABLE KEYS */;
INSERT INTO `sale_contract` VALUES ('2024-01-15',1,1,25000,'John Doe','1A2B3C4D5E6F7G8H9I0K'),('2024-02-20',2,2,22000,'Jane Smith','1A2B3C4D5E6F7G8H9I0N');
/*!40000 ALTER TABLE `sale_contract` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-13 11:40:49

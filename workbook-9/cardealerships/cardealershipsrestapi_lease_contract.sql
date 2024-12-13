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
-- Table structure for table `lease_contract`
--

DROP TABLE IF EXISTS `lease_contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lease_contract` (
  `dealership_id` int DEFAULT NULL,
  `lease_end_date` date DEFAULT NULL,
  `lease_id` int NOT NULL AUTO_INCREMENT,
  `lease_price` double DEFAULT NULL,
  `lease_start_date` date DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `vehicle_vin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`lease_id`),
  KEY `FKeao0ia3ys6mhvavfylg82fme8` (`dealership_id`),
  KEY `FKi4g87sin9b86ta5huf37c18yt` (`vehicle_vin`),
  CONSTRAINT `FKeao0ia3ys6mhvavfylg82fme8` FOREIGN KEY (`dealership_id`) REFERENCES `dealership` (`dealership_id`),
  CONSTRAINT `FKi4g87sin9b86ta5huf37c18yt` FOREIGN KEY (`vehicle_vin`) REFERENCES `vehicle` (`vin`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lease_contract`
--

LOCK TABLES `lease_contract` WRITE;
/*!40000 ALTER TABLE `lease_contract` DISABLE KEYS */;
INSERT INTO `lease_contract` VALUES (1,'2027-03-01',1,350,'2024-03-01','Michael Brown','1A2B3C4D5E6F7G8H9I0J'),(4,'2027-04-15',2,450,'2024-04-15','Sarah Johnson','1A2B3C4D5E6F7G8H9I0M');
/*!40000 ALTER TABLE `lease_contract` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-13 11:40:50

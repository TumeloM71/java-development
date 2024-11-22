CREATE DATABASE  IF NOT EXISTS `car dealerships` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `car dealerships`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: car dealerships
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
-- Table structure for table `dealerships`
--

DROP TABLE IF EXISTS `dealerships`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dealerships` (
  `dealership_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`dealership_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dealerships`
--

LOCK TABLES `dealerships` WRITE;
/*!40000 ALTER TABLE `dealerships` DISABLE KEYS */;
INSERT INTO `dealerships` VALUES (1,'Best Auto Deals','123 Main St, Garland, TX','555-1234'),(2,'Super Cars Inc.','456 Elm St, Plano, TX','444-5678'),(3,'Luxury Motors','789 Oak St, Dallas, TX','555-8765');
/*!40000 ALTER TABLE `dealerships` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `dealership_id` int NOT NULL,
  `VIN` varchar(50) NOT NULL,
  PRIMARY KEY (`dealership_id`,`VIN`),
  KEY `inventory_ibfk_2` (`VIN`),
  CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`dealership_id`) REFERENCES `dealerships` (`dealership_id`),
  CONSTRAINT `inventory_ibfk_2` FOREIGN KEY (`VIN`) REFERENCES `vehicles` (`VIN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (1,'1A2B3C4D5E6F7G8H9I0J'),(1,'1A2B3C4D5E6F7G8H9I0K'),(2,'1A2B3C4D5E6F7G8H9I0L'),(3,'1A2B3C4D5E6F7G8H9I0M'),(2,'1A2B3C4D5E6F7G8H9I0N');
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lease_contracts`
--

DROP TABLE IF EXISTS `lease_contracts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lease_contracts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `VIN` varchar(50) DEFAULT NULL,
  `dealership_id` int DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `lease_price` decimal(10,2) DEFAULT NULL,
  `lease_start_date` date DEFAULT NULL,
  `lease_end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dealership_id` (`dealership_id`),
  KEY `lease_contracts_ibfk_1` (`VIN`),
  CONSTRAINT `lease_contracts_ibfk_1` FOREIGN KEY (`VIN`) REFERENCES `vehicles` (`VIN`),
  CONSTRAINT `lease_contracts_ibfk_2` FOREIGN KEY (`dealership_id`) REFERENCES `dealerships` (`dealership_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lease_contracts`
--

LOCK TABLES `lease_contracts` WRITE;
/*!40000 ALTER TABLE `lease_contracts` DISABLE KEYS */;
INSERT INTO `lease_contracts` VALUES (1,'1A2B3C4D5E6F7G8H9I0J',1,'Michael Brown',350.00,'2024-03-01','2027-03-01'),(2,'1A2B3C4D5E6F7G8H9I0M',3,'Sarah Johnson',450.00,'2024-04-15','2027-04-15');
/*!40000 ALTER TABLE `lease_contracts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_contracts`
--

DROP TABLE IF EXISTS `sales_contracts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_contracts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `VIN` varchar(50) DEFAULT NULL,
  `dealership_id` int DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `sale_price` decimal(10,2) DEFAULT NULL,
  `sale_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dealership_id` (`dealership_id`),
  KEY `sales_contracts_ibfk_1` (`VIN`),
  CONSTRAINT `sales_contracts_ibfk_1` FOREIGN KEY (`VIN`) REFERENCES `vehicles` (`VIN`),
  CONSTRAINT `sales_contracts_ibfk_2` FOREIGN KEY (`dealership_id`) REFERENCES `dealerships` (`dealership_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_contracts`
--

LOCK TABLES `sales_contracts` WRITE;
/*!40000 ALTER TABLE `sales_contracts` DISABLE KEYS */;
INSERT INTO `sales_contracts` VALUES (1,'1A2B3C4D5E6F7G8H9I0K',1,'John Doe',25000.00,'2024-01-15'),(2,'1A2B3C4D5E6F7G8H9I0N',2,'Jane Smith',22000.00,'2024-02-20');
/*!40000 ALTER TABLE `sales_contracts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicles` (
  `VIN` varchar(50) NOT NULL,
  `Make` varchar(50) NOT NULL,
  `Model` varchar(50) DEFAULT NULL,
  `Year` int NOT NULL,
  `Mileage` int DEFAULT NULL,
  `Price` float NOT NULL,
  `Sold` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`VIN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicles`
--

LOCK TABLES `vehicles` WRITE;
/*!40000 ALTER TABLE `vehicles` DISABLE KEYS */;
INSERT INTO `vehicles` VALUES ('1A2B3C4D5E6F7G8H9I0J','Toyota','Camry',2023,15000,25000,0),('1A2B3C4D5E6F7G8H9I0K','Honda','Accord',2022,18000,22000,1),('1A2B3C4D5E6F7G8H9I0L','BMW','X5',2023,10000,55000,0),('1A2B3C4D5E6F7G8H9I0M','Ford','Mustang',2024,5000,35000,0),('1A2B3C4D5E6F7G8H9I0N','Chevrolet','Malibu',2023,12000,23000,1);
/*!40000 ALTER TABLE `vehicles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-22 11:16:14

-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: cis175.c9w2omv3kack.us-east-2.rds.amazonaws.com    Database: sports
-- ------------------------------------------------------
-- Server version	5.7.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `soccer_players`
--

DROP TABLE IF EXISTS `soccer_players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `soccer_players` (
  `PLAYER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PLAYER_NAME` varchar(30) NOT NULL,
  `PLAYER_NUMBER` int(11) NOT NULL,
  `TEAM_ID` int(11) NOT NULL,
  PRIMARY KEY (`PLAYER_ID`),
  KEY `TEAM_ID` (`TEAM_ID`),
  CONSTRAINT `soccer_players_ibfk_1` FOREIGN KEY (`TEAM_ID`) REFERENCES `soccer_teams` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soccer_players`
--

LOCK TABLES `soccer_players` WRITE;
/*!40000 ALTER TABLE `soccer_players` DISABLE KEYS */;
INSERT INTO `soccer_players` VALUES (9,'Sam',19,7),(16,'Abbie',18,7),(18,'Amanda',15,2),(20,'Christian Pulisic',22,15);
/*!40000 ALTER TABLE `soccer_players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soccer_teams`
--

DROP TABLE IF EXISTS `soccer_teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `soccer_teams` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CITY` varchar(30) NOT NULL,
  `NICKNAME` varchar(30) NOT NULL,
  `NUM_OF_PLAYERS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soccer_teams`
--

LOCK TABLES `soccer_teams` WRITE;
/*!40000 ALTER TABLE `soccer_teams` DISABLE KEYS */;
INSERT INTO `soccer_teams` VALUES (2,'Leicester City','The Foxes',23),(7,'Borussia Dortmund','The Black and Yellows',20),(15,'Liverpool','The Reds',28);
/*!40000 ALTER TABLE `soccer_teams` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-03 21:55:41

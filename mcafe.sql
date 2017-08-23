-- MySQL dump 10.13  Distrib 5.7.15, for Win64 (x86_64)
--
-- Host: localhost    Database: mcafe
-- ------------------------------------------------------
-- Server version	5.1.73-community

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
-- Current Database: `mcafe`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `mcafe` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mcafe`;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accounts` (
  `account_number` varchar(12) NOT NULL DEFAULT '',
  `id` varchar(45) NOT NULL DEFAULT '',
  `account_label` varchar(45) NOT NULL DEFAULT '',
  `account_type` varchar(10) NOT NULL DEFAULT '',
  `IBAN` varchar(34) NOT NULL DEFAULT '',
  `swift_bic` varchar(45) NOT NULL DEFAULT '',
  `banking_id` varchar(45) NOT NULL DEFAULT '',
  `account_balance` double NOT NULL DEFAULT '0',
  `currency` varchar(4) NOT NULL DEFAULT '',
  `userId` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`account_number`),
  KEY `FK_accounts_1` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES ('123456789012','savings-rbs','savings account','savings','IBAN12345678','swift1234567','bank12345678',1234.56,'USD','9200028920'),('123456789013','current-rbs','savings account','current','IBAN12345678','swift1234567','bank12345678',1234.56,'USD','9200028920'),('201703070001','c046a450-8dfb-424b-8ce0-dad0b28eb5bf','savings-personal','savings','IBAN123456789','swift0001234','BANK00001234',1048271.16,'INR','9200028920'),('201703070002','647d14ac-16ef-489a-8538-769eef43a7df','savings-personal','savings','IBAN123456789','swift0001234','BANK00001234',1233454.56,'INR','9200028920'),('201703070003','ce34a5be-e393-4385-bf56-29363a2ed371','savings-personal','savings','IBAN123456789','swift0001234','BANK00001234',1233454.56,'INR','9200028920'),('201703070004','677f0edb-3406-4ca5-bb29-d44ab5094bf7','savings-personal','savings','IBAN123456789','swift0001234','BANK00001234',1418637.96,'INR','9200888689');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` varchar(10) NOT NULL DEFAULT '',
  `customer_name` varchar(50) NOT NULL DEFAULT '',
  `customer_email` varchar(30) NOT NULL DEFAULT '',
  `customer_password` varchar(100) NOT NULL DEFAULT '',
  `mobile` varchar(10) NOT NULL DEFAULT '',
  `dob` varchar(10) NOT NULL DEFAULT '',
  `enabled` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('9200028920','Akash Singh','akki1495@gmail.com','$2a$10$3zIkq/ST2sj0f1ckoAPyOe8Oq9Dbcb.TjBiETZEW4aCfxCndhdPU2','9200028920','14/03/1995',1),('9200888689','Alok Singh','alok1495@gmail.com','$2a$10$vzRu491y5HEpOAy43qKqmeBd5jxxlsKXSD1ktZzCn/gCzQWSyVAie','9200888689','07/06/2007',1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sample_account`
--

DROP TABLE IF EXISTS `sample_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sample_account` (
  `idsample_account` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account_number` varchar(45) NOT NULL DEFAULT '',
  `balance_amount` double NOT NULL DEFAULT '0',
  `currency` varchar(5) NOT NULL DEFAULT '',
  PRIMARY KEY (`idsample_account`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sample_account`
--

LOCK TABLES `sample_account` WRITE;
/*!40000 ALTER TABLE `sample_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `sample_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactions` (
  `id` varchar(50) NOT NULL DEFAULT '',
  `this_account` varchar(12) NOT NULL DEFAULT '',
  `other_account` varchar(12) NOT NULL DEFAULT '',
  `posted_date` varchar(20) NOT NULL DEFAULT '',
  `complete_date` varchar(20) NOT NULL DEFAULT '',
  `amount` double NOT NULL DEFAULT '0',
  `type` varchar(15) NOT NULL DEFAULT '',
  `description` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `FK_transactions_1` (`this_account`),
  KEY `FK_transactions_2` (`other_account`),
  CONSTRAINT `FK_transactions_1` FOREIGN KEY (`this_account`) REFERENCES `accounts` (`account_number`),
  CONSTRAINT `FK_transactions_2` FOREIGN KEY (`other_account`) REFERENCES `accounts` (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES ('020bf5ce-6ac6-4085-ac3a-b095522de6fd','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('04e8ce7a-4d49-4414-995d-35dbdaffb724','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('06aae33e-df15-4f0e-a413-580753e10d6a','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('2239914f-7499-4c69-9240-6d2e2c45cef9','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('6c40c9e0-b96b-443a-930b-b4e3f4e61d5e','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('72644757-6b96-45cc-b844-8b22c61963de','201703070001','201703070002','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('77ea55b1-c2f3-4c9c-b516-8359f8a54254','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('79edac8f-77f7-4bd3-ae0a-0460775efd38','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('81212545-72c9-4edb-90c0-30093cab9a31','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('8c796102-64ed-4d76-8b9c-2e18d16958f8','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('a60acf8e-3d68-417f-b911-6d11a28534f1','201703070004','201703070001','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',1048271,'debit','uweif wjhfjfh jsd fhjks dk'),('b3563cb6-d08d-48d9-a564-a881416f1927','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('bc201e36-80f3-4ac8-b3ee-a1b1b9cb3315','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('ca9d855a-186f-4d88-8223-f07ede2e7768','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('df179132-adfd-4237-8fb4-8a5a67ad9fc0','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('ecdbbb46-409d-4cf3-a27b-91d7f28a4eb3','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('ed630e20-d195-43d1-86c9-881773d050f0','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('f6f08661-1635-4095-8ea3-42cf8c593826','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',12345.56,'debit','uweif wjhfjfh jsd fhjks dk'),('fc7c3688-ae2f-46e6-ba5c-ba50a9f540b5','201703070001','201703070004','2017-01-08T08:00:08Z','2017-01-09T08:00:08Z',1048271,'debit','uweif wjhfjfh jsd fhjks dk'),('transac123','123456789012','123456789013','2017-01-22T08:00:08Z','2017=01-22T08:02:07Z',10,'NEFT','successful'),('transac1244','123456789012','123456789013','2017-03-22T08:00:08Z','2017-03-22T08:02:07Z',12,'NEFT','successful'),('transac1245','123456789012','123456789013','2017-02-22T08:00:08Z','2017-02-22T08:02:07Z',12,'NEFT','successful');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-25 11:09:10

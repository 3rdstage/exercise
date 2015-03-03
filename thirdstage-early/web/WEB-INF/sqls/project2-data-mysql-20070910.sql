-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	4.1.21-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema project2
--

CREATE DATABASE IF NOT EXISTS project2;
USE project2;

--
-- Definition of table `process`
--

DROP TABLE IF EXISTS `process`;
CREATE TABLE `process` (
  `id` bigint(20) NOT NULL auto_increment,
  `extId` varchar(50) NOT NULL default '',
  `name` varchar(200) NOT NULL default '',
  `createdDate` datetime default NULL,
  `parentProcessId` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `extId` (`extId`),
  KEY `idx_process_1` (`extId`),
  KEY `idx_process_2` (`name`),
  KEY `fk_process_1` (`parentProcessId`),
  CONSTRAINT `fk_process_1` FOREIGN KEY (`parentProcessId`) REFERENCES `process` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `process`
--

/*!40000 ALTER TABLE `process` DISABLE KEYS */;
/*!40000 ALTER TABLE `process` ENABLE KEYS */;


--
-- Definition of table `requirement`
--

DROP TABLE IF EXISTS `requirement`;
CREATE TABLE `requirement` (
  `id` varchar(16) NOT NULL default '',
  `title` varchar(255) default NULL,
  `request` text,
  `response` text,
  `requestedDate` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `requirement`
--

/*!40000 ALTER TABLE `requirement` DISABLE KEYS */;
INSERT INTO `requirement` (`id`,`title`,`request`,`response`,`requestedDate`) VALUES 
 ('FRQ-ORDER-0001','View Orders','...','...','2007-04-09 00:00:00'),
 ('FRQ-ORDER-0002','Create Orders','...','...','2007-04-09 00:00:00'),
 ('FRQ-ORDER-0003','Cancle Orders','...','...','2007-04-09 00:00:00');
/*!40000 ALTER TABLE `requirement` ENABLE KEYS */;


--
-- Definition of table `requirement2`
--

DROP TABLE IF EXISTS `requirement2`;
CREATE TABLE `requirement2` (
  `no` bigint(20) NOT NULL auto_increment,
  `id` varchar(32) NOT NULL default '',
  `title` varchar(100) NOT NULL default '',
  `request` text,
  `response` text,
  `requestedDate` datetime default NULL,
  PRIMARY KEY  (`no`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `requirement2`
--

/*!40000 ALTER TABLE `requirement2` DISABLE KEYS */;
INSERT INTO `requirement2` (`no`,`id`,`title`,`request`,`response`,`requestedDate`) VALUES 
 (53,'FRQ-ORDER-0001','View Orders','...','...','2007-04-09 00:00:00'),
 (54,'FRQ-ORDER-0002','Create Order','...','...','2007-04-09 00:00:00'),
 (55,'FRQ-ORDER-0003','Cancle Order','...','...','2007-04-09 00:00:00');
/*!40000 ALTER TABLE `requirement2` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

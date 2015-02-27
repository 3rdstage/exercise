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
-- Create schema sample
--

CREATE DATABASE IF NOT EXISTS sample;
USE sample;

--
-- Definition of table `corporation`
--

DROP TABLE IF EXISTS `corporation`;
CREATE TABLE `corporation` (
  `id` varchar(32) NOT NULL default '',
  `name` varchar(45) NOT NULL default '',
  `reg_no` varchar(11) default NULL,
  PRIMARY KEY  (`id`),
  CONSTRAINT `fk_corporation_1` FOREIGN KEY (`id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `corporation`
--

/*!40000 ALTER TABLE `corporation` DISABLE KEYS */;
/*!40000 ALTER TABLE `corporation` ENABLE KEYS */;


--
-- Definition of table `individual`
--

DROP TABLE IF EXISTS `individual`;
CREATE TABLE `individual` (
  `id` varchar(32) NOT NULL default '',
  `first_name` varchar(45) default NULL,
  `last_name` varchar(45) default NULL,
  PRIMARY KEY  (`id`),
  CONSTRAINT `fk_Individual_1` FOREIGN KEY (`id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `individual`
--

/*!40000 ALTER TABLE `individual` DISABLE KEYS */;
INSERT INTO `individual` (`id`,`first_name`,`last_name`) VALUES 
 ('1','Tom','Hankers'),
 ('2','Russel','Crow'),
 ('3','Drew','Berrymoar');
/*!40000 ALTER TABLE `individual` ENABLE KEYS */;


--
-- Definition of table `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` varchar(32) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `person`
--

/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`id`) VALUES 
 ('1'),
 ('2'),
 ('3');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

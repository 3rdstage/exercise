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
-- Create schema thirdstage
--

CREATE DATABASE IF NOT EXISTS thirdstage;
USE thirdstage;

--
-- Definition of table `roletb`
--

DROP TABLE IF EXISTS `roletb`;
CREATE TABLE `roletb` (
  `id` varchar(16) NOT NULL default '',
  `name` varchar(40) NOT NULL default '',
  `description` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `roletb`
--

/*!40000 ALTER TABLE `roletb` DISABLE KEYS */;
INSERT INTO `roletb` (`id`,`name`,`description`) VALUES 
 ('1','power user','who is he?'),
 ('2','user','평범한 사용자'),
 ('3','guest','손님');
/*!40000 ALTER TABLE `roletb` ENABLE KEYS */;


--
-- Definition of table `term`
--

DROP TABLE IF EXISTS `term`;
CREATE TABLE `term` (
  `id` varchar(32) NOT NULL default '',
  `name` varchar(40) NOT NULL default '',
  `nameInEng` varchar(40) default NULL,
  `description` varchar(200) default NULL,
  PRIMARY KEY  (`id`),
  KEY `idx_term_1` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `term`
--

/*!40000 ALTER TABLE `term` DISABLE KEYS */;
/*!40000 ALTER TABLE `term` ENABLE KEYS */;


--
-- Definition of table `usertb`
--

DROP TABLE IF EXISTS `usertb`;
CREATE TABLE `usertb` (
  `id` varchar(32) NOT NULL default '',
  `roleId` varchar(16) default NULL,
  `passwd` varchar(16) default NULL,
  `passwdHash` varchar(60) default NULL,
  `name` varchar(40) NOT NULL default '',
  `rrn` varchar(13) default NULL,
  PRIMARY KEY  (`id`),
  KEY `fk_usertb_1` (`roleId`),
  CONSTRAINT `fk_usertb_1` FOREIGN KEY (`roleId`) REFERENCES `roletb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usertb`
--

/*!40000 ALTER TABLE `usertb` DISABLE KEYS */;
/*!40000 ALTER TABLE `usertb` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

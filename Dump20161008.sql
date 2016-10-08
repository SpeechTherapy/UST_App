CREATE DATABASE  IF NOT EXISTS `ust-db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ust-db`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: ust-db
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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `Admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `Admin_UserId` int(11) NOT NULL,
  PRIMARY KEY (`Admin_id`),
  KEY `Userid_idx` (`Admin_UserId`),
  CONSTRAINT `Admin_User` FOREIGN KEY (`Admin_UserId`) REFERENCES `user` (`User_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,57);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assigned_chapter_therapist`
--

DROP TABLE IF EXISTS `assigned_chapter_therapist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assigned_chapter_therapist` (
  `Assigned_Chapter_id` int(11) NOT NULL AUTO_INCREMENT,
  `Patient_id` int(11) NOT NULL,
  `Lesson_id` int(11) NOT NULL,
  `Status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Assigned_Chapter_id`),
  KEY `PPatient_id_idx` (`Patient_id`),
  KEY `CChapter_id_idx` (`Lesson_id`),
  CONSTRAINT `CChapter_id` FOREIGN KEY (`Lesson_id`) REFERENCES `lesson` (`Lesson_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `PPatient_id` FOREIGN KEY (`Patient_id`) REFERENCES `patient` (`Patient_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assigned_chapter_therapist`
--

LOCK TABLES `assigned_chapter_therapist` WRITE;
/*!40000 ALTER TABLE `assigned_chapter_therapist` DISABLE KEYS */;
/*!40000 ALTER TABLE `assigned_chapter_therapist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `City_id` int(11) NOT NULL AUTO_INCREMENT,
  `City_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`City_id`)
) ENGINE=InnoDB AUTO_INCREMENT=266 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Gultari'),(2,'Gupi'),(3,'Nagar'),(4,'Sumo'),(5,'Asqurdas'),(6,'Makhan Pura'),(7,'Shingar'),(8,'Ghangche'),(9,'Skardu'),(10,'Gilgit'),(11,'Muzaffarabad'),(12,'Mirpur'),(13,'Bhimber'),(14,'Kotli'),(15,'Rawlakot'),(16,'Bagh'),(17,'Wana'),(18,'Sadda'),(19,'Razmak'),(20,'Parachinar'),(21,'Miranshah'),(22,'MirAli'),(23,'Makeen'),(24,'Laskathan'),(25,'Landi Kotal'),(26,'Khaar'),(27,'Jamrud'),(28,'Ghulam Khan Mehrabpur'),(29,'Darra Adam Khel'),(30,'Bara'),(31,'Alizai'),(32,'Quetta'),(33,'Khuzdar'),(34,'Turbat'),(35,'Chaman'),(36,'Hub'),(37,'Sibi'),(38,'Zhob'),(39,'Gwadar'),(40,'Dera Murad Jamali'),(41,'Dera Allah Yar'),(42,'Usta Mohammad'),(43,'Loralai'),(44,'Pasni'),(45,'Kharan'),(46,'Mastung'),(47,'Nushki'),(48,'Kalat'),(49,'Abbotabad'),(50,'Adezai'),(51,'Alpuri'),(52,'Akora Khattak'),(53,'Ayubia'),(54,'Banda Daud Shah'),(55,'Bannu'),(56,'Bathela'),(57,'Battagram'),(58,'Birote'),(59,'Chakdara'),(60,'Charsadda'),(61,'Chitral'),(62,'Daggar'),(63,'Dargai'),(64,'Dera Ismail Khan'),(65,'Nowshera'),(66,'Paharpur'),(67,'Pabbi'),(68,'Peshawar'),(69,'Saidu Sharif'),(70,'Swabi'),(71,'Swat'),(72,'Tang'),(73,'Tank'),(74,'Thall'),(75,'Timergara'),(76,'Tordher'),(77,'Cherat'),(78,'Risalpur'),(79,'Mingora'),(80,'Mastuj'),(81,'Mardan'),(82,'Mansehra'),(83,'Madyan'),(84,'Latamber'),(85,'Lakki Marwat'),(86,'Kulachi'),(87,'Kohat'),(88,'Karak'),(89,'Haripur'),(90,'Hangu'),(91,'Drosh'),(92,'Dir'),(93,'Doaba'),(94,'Zafarwal'),(95,'Yazman'),(96,'Wazirabad'),(97,'Wah Cantonment'),(98,'Vehari'),(99,'Toba Tek Singh'),(100,'Taxila'),(101,'Talagang'),(102,'Tandlianwala'),(103,'Siranwala'),(104,'Soianwala'),(105,'Sohawa'),(106,'Sailkot'),(107,'Sheikhpura'),(108,'Shakargarh'),(109,'Sargodha'),(110,'Sarai Alamgir'),(111,'Sangla Hill'),(112,'Samundari'),(113,'Sambrial'),(114,'Sahiwal'),(115,'Safdarabad'),(116,'Sadiqabad'),(117,'Rawalpindi'),(118,'Rahim Yar Khan'),(119,'Rajanpur'),(120,'Raiwind'),(121,'Rabwah'),(122,'Qila Didar Singh'),(123,'Qamipur'),(124,'Pir Mahal'),(125,'Pind Dadan Khan'),(126,'Pindi Bhattian'),(127,'Pattoki'),(128,'Pakpattan'),(129,'Renala Khurd'),(130,'Okara'),(131,'Nakana Sahib'),(132,'Narowal'),(133,'Muzaffaragarh'),(134,'Mianwali Bangla'),(135,'Muridke'),(136,'Muree'),(137,'Multan'),(138,'Mianwali'),(139,'Mian channu'),(140,'Mandi Bahauddin'),(141,'Mailsi'),(142,'Mamoori'),(143,'Malakwal'),(144,'Lodhran'),(145,'Liaquat Pur'),(146,'Layyah'),(147,'Lalamusa'),(148,'Islamabad'),(149,'Lahore'),(150,'Jauharabad'),(151,'Kot Adu'),(152,'Khushab'),(153,'Kharian'),(154,'Khanqah Sharif'),(155,'Khanpur'),(156,'Khanewal'),(157,'Kamoke'),(158,'Kamalia'),(159,'Kasur'),(160,'Karor Lal Esan'),(161,'Kalabagh'),(162,'Jehlum'),(163,'Jhang'),(164,'Jaranwala'),(165,'Haveli Lakha'),(166,'Hasilpur'),(167,'Haroonabad'),(168,'Hafizabad'),(169,'Harappa'),(170,'Gujar Khan'),(171,'Gujrat'),(172,'Gujrawala'),(173,'Gojra'),(174,'Ghakar Mandi'),(175,'Fateh Jang'),(176,'Faislabad'),(177,'Dipalpur'),(178,'Dinga'),(179,'Dina'),(180,'Dhaular'),(181,'Dera ghazi Khan'),(182,'Darya Khan'),(183,'Davispur'),(184,'Daska'),(185,'Dajkot'),(186,'Chunian'),(187,'Chishtian'),(188,'Chiniot'),(189,'Chichawatni'),(190,'Chak Jhumra'),(191,'Chakwal'),(192,'Chillianwala'),(193,'Burewala'),(194,'Bhakkar'),(195,'Bahawlpur'),(196,'Bahawalnagar'),(197,'Bhalwal'),(198,'Behra'),(199,'Attock'),(200,'Arifwala'),(201,'Alipur'),(202,'Ali Khan Abad'),(203,'Ahmed Nager Chatha'),(204,'Ahmadpur East'),(205,'Badin'),(206,'Bhirkan'),(207,'Biria City'),(208,'Bihria Road'),(209,'Rajo Khanani'),(210,'Chak'),(211,'Dadu'),(212,'Digri'),(213,'Diplo'),(214,'Dokri'),(215,'Ghotki'),(216,'Haala'),(217,'Hyderbad'),(218,'Islamkot'),(219,'Jacobabad'),(220,'Jamshoro'),(221,'Jungshahi'),(222,'Kandhkot'),(223,'Kandiaro'),(224,'Karachi'),(225,'Kashmore'),(226,'Ranipur'),(227,'Ratodero'),(228,'Rohri'),(229,'Sakrand'),(230,'Sanghar'),(231,'Shahbandar'),(232,'Shahdadkot'),(233,'Shahdadpur'),(234,'Shahpur Chakar'),(235,'Shikarpaur'),(236,'Sinjhoro'),(237,'Sukkur'),(238,'Tangwani'),(239,'Tando Adam Khan'),(240,'Tando Allahyar'),(241,'Tando Muhammad Khan'),(242,'Thatta'),(243,'Thari Mirwah'),(244,'Umerkot'),(245,'Warah'),(246,'Qasimabad'),(247,'Qambar'),(248,'Nawabsha'),(249,'Naushara'),(250,'Naudhahro Feroze'),(251,'Naudero'),(252,'Nagarparkar'),(253,'Moro'),(254,'Mehrabpur'),(255,'Mithi'),(256,'Mithani'),(257,'Mirpur Khas'),(258,'Mehar'),(259,'Matiari'),(260,'Larkana'),(261,'Kotri'),(262,'Khipro'),(263,'Khairpur'),(264,'Khadro'),(265,'Keti Bandar');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussion`
--

DROP TABLE IF EXISTS `discussion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussion` (
  `Discussion_id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) NOT NULL,
  `User_Type` varchar(45) NOT NULL,
  `Questions` varchar(45) NOT NULL,
  `Timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Discussion_id`),
  KEY `userId_idx` (`UserId`),
  CONSTRAINT `userId` FOREIGN KEY (`UserId`) REFERENCES `user` (`User_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussion`
--

LOCK TABLES `discussion` WRITE;
/*!40000 ALTER TABLE `discussion` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussion_replies`
--

DROP TABLE IF EXISTS `discussion_replies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussion_replies` (
  `Discussion_Replies_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Discussion_Id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL,
  `Replies` varchar(45) NOT NULL,
  `Timestamp` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`Discussion_Replies_Id`),
  KEY `Discussion_idx` (`Discussion_Id`),
  KEY `User_idx` (`User_id`),
  CONSTRAINT `Discussion` FOREIGN KEY (`Discussion_Id`) REFERENCES `discussion` (`Discussion_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `User` FOREIGN KEY (`User_id`) REFERENCES `user` (`User_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussion_replies`
--

LOCK TABLES `discussion_replies` WRITE;
/*!40000 ALTER TABLE `discussion_replies` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussion_replies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `Patient_id` int(11) NOT NULL,
  `Lesson_id` int(11) NOT NULL,
  `Game_id` int(11) NOT NULL AUTO_INCREMENT,
  `Game_name` varchar(45) NOT NULL,
  `Game_score` int(11) NOT NULL,
  `Game_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Game_id`),
  KEY `Patient_id_idx` (`Patient_id`),
  KEY `Chapteeerr_idx` (`Lesson_id`),
  CONSTRAINT `Chapteeerr` FOREIGN KEY (`Lesson_id`) REFERENCES `lesson` (`Lesson_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Patient` FOREIGN KEY (`Patient_id`) REFERENCES `patient` (`Patient_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospital` (
  `Hospital_id` int(11) NOT NULL AUTO_INCREMENT,
  `City_id` int(11) DEFAULT NULL,
  `Hospital_name` varchar(45) DEFAULT NULL,
  `Hospital_address` varchar(405) DEFAULT NULL,
  PRIMARY KEY (`Hospital_id`),
  KEY `Cityy_id_idx` (`City_id`),
  CONSTRAINT `Cityy_id` FOREIGN KEY (`City_id`) REFERENCES `city` (`City_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES (1,259,'Abbasi Shaheed','P-38 / A, 10th Street, Khayaban-e-Rahat, Street # 10, Phase-VI,'),(2,263,'Abbasi Shaheed','P-38 / A, 10th Street, Khayaban-e-Rahat, Street # 10, Phase-VI,'),(3,261,'Abbasi Shaheed','P-38 / A, 10th Street, Khayaban-e-Rahat, Street # 10, Phase-VI,'),(4,246,'Agha Khan','Agha Khan Nazimabad'),(5,262,'Agha Khan','Agha Khan Nazimabad'),(6,261,'Liaquat National','Testing Address'),(7,257,'Liaquat National','Testing Address'),(8,258,'Agha Khan','Agha Khan Address'),(9,256,'Agha Khan','Agha Khan Address'),(10,259,'Agha Khan Hospital','Agha Khan Address'),(11,251,'Agha Khan Hospital','Agha Khan Address'),(12,251,'Agha Khan Hospital','Agha Khan Address'),(13,258,'Abbasi Shaheed','Abbasi Shaheed Address'),(14,258,'Abbasi Shaheed','Abbasi Shaheed Address'),(15,250,'Ziauddin Hospital','Ziauddin Address'),(16,261,'testing','Testing Address'),(17,261,'testing','Testing Address'),(18,258,'Ziauddin Hospital','Ziauddin Address'),(19,259,'Ziauddin Hospital','Ziauddin Address');
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson` (
  `Lesson_id` int(11) NOT NULL AUTO_INCREMENT,
  `Lesson` varchar(45) NOT NULL,
  `Video_Refrence` varchar(45) NOT NULL,
  `LessonPic` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`Lesson_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
INSERT INTO `lesson` VALUES (1,'ب','static-images/-baa.mp4','static-images/-Urdu-Letter.png'),(2,'پ','static-images/-paa.mp4','static-images/-Untitled-3.png'),(3,'ت','https://www.youtube.com/embed/7XSycD_nNbA','resources/uploads/hurf (4).png'),(4,'ٹ','https://www.youtube.com/embed/R74MvCGWNVs','resources/uploads/hurf (5).png'),(5,'ث','https://www.youtube.com/embed/D8FRqwHCpwQ','resources/uploads/hurf (6).png'),(6,'ج','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(7,'چ','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(8,'ح','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(9,'خ','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(10,'د','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(11,'ڈ','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(12,'ذ','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(13,'ر','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(14,'ز','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(15,'ژ','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(16,'س','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(17,'ش','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(18,'ص','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(19,'ض','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(20,'ط','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(21,'ظ','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(22,'ف','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(23,'ک','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(24,'ل','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(25,'م','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(26,'ن','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL),(27,'و','https://www.youtube.com/watch?v=0oKreL1jvkg',NULL);
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media`
--

DROP TABLE IF EXISTS `media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media` (
  `Media_id` int(11) NOT NULL AUTO_INCREMENT,
  `Media_image` varchar(1000) DEFAULT NULL,
  `Media_audio` varchar(1000) NOT NULL,
  PRIMARY KEY (`Media_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media`
--

LOCK TABLES `media` WRITE;
/*!40000 ALTER TABLE `media` DISABLE KEYS */;
INSERT INTO `media` VALUES (39,NULL,'static-images/-boo.mp3'),(40,NULL,'static-images/bee.mp3'),(41,NULL,'static-images/Baaaaa.mp3'),(42,'static-images/1475262326822.jpg','static-images/baja.mp3'),(43,'static-images/PicsArt_09-30-01.24.24.jpg','static-images/bili.mp3'),(44,NULL,'static-images/paa.mp3'),(45,NULL,'static-images/pay.mp3'),(46,NULL,'static-images/Baaayy.mp3'),(47,'static-images/1475316416761.jpg','static-images/paisay.mp3'),(48,'static-images/1475316698068.jpg','static-images/pata.mp3'),(49,NULL,'static-images/پو.mp3'),(50,'static-images/-1475262863403.jpg','static-images/-pani.mp3'),(51,'static-images/PicsArt_10-07-07.10.36.jpg','static-images/bay.mp3'),(52,'static-images/PicsArt_10-07-07.36.55.jpg','static-images/Recording_11.mp3');
/*!40000 ALTER TABLE `media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `Patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `User_id` int(11) NOT NULL,
  `Therapist_id` int(11) DEFAULT NULL,
  `Patient_guardian_name` varchar(45) DEFAULT NULL,
  `Patient_dob` date DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  `patient_createdon` date DEFAULT NULL,
  `patient_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Age` int(11) DEFAULT NULL,
  `Patient_Name` varchar(45) DEFAULT NULL,
  `Contact_no` varchar(45) DEFAULT NULL,
  `Allergies` varchar(45) DEFAULT NULL,
  `Language_Spoken` varchar(45) DEFAULT NULL,
  `PatientUsername` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Patient_id`),
  KEY `Therapist_id_idx` (`Therapist_id`),
  KEY `User_idd_idx` (`User_id`),
  CONSTRAINT `Therapist_id` FOREIGN KEY (`Therapist_id`) REFERENCES `therapist` (`Therapist_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `User_idd` FOREIGN KEY (`User_id`) REFERENCES `user` (`User_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,72,8,'Mansoor Khan',NULL,'male',NULL,'2016-10-04 16:11:45',12,'AbdulRehman Khan','03453999954','None','Urdu',NULL);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_progress_sentences`
--

DROP TABLE IF EXISTS `patient_progress_sentences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient_progress_sentences` (
  `Patient_progress_sentences_id` int(11) NOT NULL AUTO_INCREMENT,
  `Patient_progress_sentences` varchar(45) NOT NULL,
  `Assigned_chapter_therapist` int(11) NOT NULL,
  `Sentences_id` int(11) NOT NULL,
  `recorded_id` int(11) NOT NULL,
  PRIMARY KEY (`Patient_progress_sentences_id`),
  KEY `Asssign_id_idx` (`Assigned_chapter_therapist`),
  KEY `Seentences_idx` (`Sentences_id`),
  KEY `Recordedd_id_idx` (`recorded_id`),
  CONSTRAINT `Asssign_id` FOREIGN KEY (`Assigned_chapter_therapist`) REFERENCES `assigned_chapter_therapist` (`Assigned_Chapter_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Recordedd_id` FOREIGN KEY (`recorded_id`) REFERENCES `recorded_audio` (`Recorded_Audio_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Seentences` FOREIGN KEY (`Sentences_id`) REFERENCES `sentences` (`Sentences_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_progress_sentences`
--

LOCK TABLES `patient_progress_sentences` WRITE;
/*!40000 ALTER TABLE `patient_progress_sentences` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient_progress_sentences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_progress_sounds`
--

DROP TABLE IF EXISTS `patient_progress_sounds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient_progress_sounds` (
  `Patient_progress_sounds_id` int(11) NOT NULL AUTO_INCREMENT,
  `Patient_progress_sounds` varchar(45) NOT NULL,
  `Assigned_chapter_therapist` int(11) NOT NULL,
  `Sounds_id` int(11) NOT NULL,
  `Recorded_id` int(11) NOT NULL,
  PRIMARY KEY (`Patient_progress_sounds_id`),
  KEY `SSoounds_id_idx` (`Sounds_id`),
  KEY `Asssigned_chapter_idx` (`Assigned_chapter_therapist`),
  KEY `Recordded_id_idx` (`Recorded_id`),
  CONSTRAINT `Asssigned_chapter` FOREIGN KEY (`Assigned_chapter_therapist`) REFERENCES `assigned_chapter_therapist` (`Assigned_Chapter_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Recordded_id` FOREIGN KEY (`Recorded_id`) REFERENCES `recorded_audio` (`Recorded_Audio_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SSoounds_id` FOREIGN KEY (`Sounds_id`) REFERENCES `sounds` (`Sounds_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_progress_sounds`
--

LOCK TABLES `patient_progress_sounds` WRITE;
/*!40000 ALTER TABLE `patient_progress_sounds` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient_progress_sounds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients_progess_word`
--

DROP TABLE IF EXISTS `patients_progess_word`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patients_progess_word` (
  `Patients_progess_id` int(11) NOT NULL AUTO_INCREMENT,
  `Patients_progess` varchar(45) NOT NULL,
  `Assigned_Chapter_therapist` int(11) NOT NULL,
  `Word_id` int(11) NOT NULL,
  `Recorded_id` int(11) NOT NULL,
  PRIMARY KEY (`Patients_progess_id`),
  KEY `Assigned_Chhapter_idx` (`Assigned_Chapter_therapist`),
  KEY `Recorded_idd_idx` (`Recorded_id`),
  KEY `wordd_id_idx` (`Word_id`),
  CONSTRAINT `Assigned_Chhapter` FOREIGN KEY (`Assigned_Chapter_therapist`) REFERENCES `assigned_chapter_therapist` (`Assigned_Chapter_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Recorded_idd` FOREIGN KEY (`Recorded_id`) REFERENCES `recorded_audio` (`Recorded_Audio_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `wordd_id` FOREIGN KEY (`Word_id`) REFERENCES `words` (`Words_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients_progess_word`
--

LOCK TABLES `patients_progess_word` WRITE;
/*!40000 ALTER TABLE `patients_progess_word` DISABLE KEYS */;
/*!40000 ALTER TABLE `patients_progess_word` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `Post_id` int(11) NOT NULL AUTO_INCREMENT,
  `Therapist_writer` int(11) NOT NULL,
  `Blog_Heading` varchar(2185) DEFAULT NULL,
  `Blog_Body` varchar(2185) NOT NULL,
  `Timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Status` int(11) NOT NULL DEFAULT '1',
  `Blog_Pic` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Post_id`),
  KEY `Therapist_id_idx` (`Therapist_writer`),
  KEY `TherapistId_idx` (`Therapist_writer`),
  CONSTRAINT `Therapist` FOREIGN KEY (`Therapist_writer`) REFERENCES `therapist` (`Therapist_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,8,'Revitalization of Traditional Systems of Medicine in Rural Rajasthan','Not all forms of effective medical treatment come in a pill bottle or are administered through a sharp injection to the forearm. Despite economic and medical progress in urban India, many rural villages and communities lack access to any form of health care. Access to healthcare in rural areas is an issue that the U.S. and India share, and the impressive medical advancements in cities provide a stark contrast to the impoverished, resource-poor villages and towns where people still die from preventable and curable illnesses.\r\n\r\nIMG_8336\r\nOverlooking fields in the village of Valli\r\n\r\nIt is easy to romanticize village life when you watch it fly past you from the car window. Rural Rajasthan, a northern state of India, becomes a blur of rolling hills of green, cows churning fresh dirt and women�s saris blowing in the wind against misty-blue mountains. It is monsoon season, so everything in this usually dry and arid land is made green and growing. Only 3 months ago, Rajasthan was suffering from a severe drought, where 17,000 villages were facing a water crisis that required government support. In this region, droughts affect water and food supply as well as people�s livelihoods since farming and drinking wells are dependent on a constant supply of rainwater. The life of a farmer is very physically demanding as well, resulting in many health complications later in life; oftentimes, farmers are unable to afford treatment at a hospital or private clinic due to their insufficiently small income. Last year, due to weather-related crop loss, 11 farmers committed suicide in 45 days, a small reflection of the thousands of farmer suicides that occur in India every year.','2016-10-05 16:11:12',1,'static-images/IMG_8336.jpg'),(2,8,'Testing Blog','123 Testing','2016-10-05 16:15:16',0,'static-images/chris_palmer_profile_11.jpg'),(3,8,'Checking Blog Picture','Test\r\n1\r\n1\r\n1\r\n1\r\n2\r\n2\r\n2\r\n3\r\n3\r\n3\r\n3','2016-10-05 16:22:27',1,'static-images/images.jpg'),(4,8,'Articulation','Articulation disorder: A speech disorder involving difficulties in articulating specific types of sounds. Articulation disorders often involve substitution of one sound for another, slurring of speech, or indistinct speech. Treatment is speech therapy.','2016-10-06 15:34:04',1,'static-images/chris_palmer_profile_11.jpg');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recorded_audio`
--

DROP TABLE IF EXISTS `recorded_audio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recorded_audio` (
  `Recorded_Audio_id` int(11) NOT NULL AUTO_INCREMENT,
  `Patient_id` int(11) NOT NULL,
  `Lesson_id` int(11) NOT NULL,
  `Recorded_Audios` varchar(45) NOT NULL,
  `Recorded_Audio_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Record_of` varchar(45) NOT NULL,
  PRIMARY KEY (`Recorded_Audio_id`),
  KEY `Patient_id_idx` (`Patient_id`),
  KEY `Chapterid_idx` (`Lesson_id`),
  CONSTRAINT `Chapterid` FOREIGN KEY (`Lesson_id`) REFERENCES `lesson` (`Lesson_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Patient_id` FOREIGN KEY (`Patient_id`) REFERENCES `patient` (`Patient_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recorded_audio`
--

LOCK TABLES `recorded_audio` WRITE;
/*!40000 ALTER TABLE `recorded_audio` DISABLE KEYS */;
/*!40000 ALTER TABLE `recorded_audio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sentences`
--

DROP TABLE IF EXISTS `sentences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sentences` (
  `Sentences_id` int(11) NOT NULL AUTO_INCREMENT,
  `Lesson_id` int(11) NOT NULL,
  `Sentences` varchar(45) NOT NULL,
  `Sentences_IsActive` int(11) NOT NULL DEFAULT '1',
  `Sentences_MediaID` int(11) NOT NULL,
  PRIMARY KEY (`Sentences_id`),
  KEY `Chapptter_id_idx` (`Lesson_id`),
  KEY `Sentences_MediaID_idx` (`Sentences_MediaID`),
  CONSTRAINT `Chapptter_id` FOREIGN KEY (`Lesson_id`) REFERENCES `lesson` (`Lesson_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Sentences_MediaID` FOREIGN KEY (`Sentences_MediaID`) REFERENCES `media` (`Media_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sentences`
--

LOCK TABLES `sentences` WRITE;
/*!40000 ALTER TABLE `sentences` DISABLE KEYS */;
INSERT INTO `sentences` VALUES (1,1,'بلی نے باجا بجایا',1,51),(2,2,'پپو نے پانی پیا',1,52);
/*!40000 ALTER TABLE `sentences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sounds`
--

DROP TABLE IF EXISTS `sounds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sounds` (
  `Sounds_id` int(11) NOT NULL AUTO_INCREMENT,
  `Lesson_id` int(11) NOT NULL,
  `Sound` varchar(45) NOT NULL,
  `Sound_isActive` int(11) NOT NULL DEFAULT '1',
  `Sound_MediaId` int(11) NOT NULL,
  PRIMARY KEY (`Sounds_id`),
  KEY `Chapptererrr_iddd_idx` (`Lesson_id`),
  KEY `Sound_MediaId_idx` (`Sound_MediaId`),
  CONSTRAINT `Chapptererrr_iddd` FOREIGN KEY (`Lesson_id`) REFERENCES `lesson` (`Lesson_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `MediaSoundId` FOREIGN KEY (`Sound_MediaId`) REFERENCES `media` (`Media_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sounds`
--

LOCK TABLES `sounds` WRITE;
/*!40000 ALTER TABLE `sounds` DISABLE KEYS */;
INSERT INTO `sounds` VALUES (1,1,'بو',1,39),(2,1,'بی',1,40),(3,1,'با',1,41),(4,2,'پا',1,44),(5,2,'پے',1,45),(6,1,'بے',1,46),(7,2,'پو',0,49);
/*!40000 ALTER TABLE `sounds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `therapist`
--

DROP TABLE IF EXISTS `therapist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `therapist` (
  `Therapist_id` int(11) NOT NULL AUTO_INCREMENT,
  `User_id` int(11) DEFAULT NULL,
  `Hospital_id` int(11) DEFAULT NULL,
  `Therapist_contactno` varchar(45) DEFAULT NULL,
  `Therapist_timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Created_on` date DEFAULT NULL,
  `Therapist_gender` varchar(45) DEFAULT NULL,
  `Therapist_Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Therapist_id`),
  KEY `User_id_idx` (`User_id`),
  KEY `Hospital_id_idx` (`Hospital_id`),
  CONSTRAINT `Hospital_id` FOREIGN KEY (`Hospital_id`) REFERENCES `hospital` (`Hospital_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `User_id` FOREIGN KEY (`User_id`) REFERENCES `user` (`User_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `therapist`
--

LOCK TABLES `therapist` WRITE;
/*!40000 ALTER TABLE `therapist` DISABLE KEYS */;
INSERT INTO `therapist` VALUES (6,69,12,'03359202074','2016-10-04 15:46:06','2016-01-04','male','Habib Khan Shahani'),(7,70,14,'03332289981','2016-10-04 16:03:11','2016-01-04','female','Dr.Bushra Bhatti'),(8,71,19,'7667676','2016-10-08 04:29:33','2016-01-08','male','Dr.Shahid Masood');
/*!40000 ALTER TABLE `therapist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `User_id` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(45) DEFAULT NULL,
  `Username` varchar(45) NOT NULL,
  `User_password` varchar(45) NOT NULL,
  `Reset_Password` varchar(45) DEFAULT '0',
  `User_pic` varchar(1000) DEFAULT NULL,
  `User_Status` tinyint(4) NOT NULL DEFAULT '0' COMMENT 'This feild is for verification',
  `User_isActive` varchar(45) DEFAULT '1' COMMENT 'This feild shows that the user is active or not',
  PRIMARY KEY (`User_id`),
  UNIQUE KEY `Username_UNIQUE` (`Username`),
  UNIQUE KEY `Email_UNIQUE` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (57,'speechtherapy49@gmail.com','speech49','123','1',NULL,0,'1'),(69,'shah_aqua18@hotmail.com','HabibK','1234','1','static-images/_MG_0182lklklk.jpg',0,'1'),(70,'shanzakhan.sks@gmail.com','sshanza','123','1','static-images/profile2.jpg',0,'1'),(71,'shanzakhan70@yahoo.com','shahid','111','1','static-images/dasdasa.png',0,'1'),(72,'abdulrehmank57s@gmail.com','abdulrehman','123','0','static-images/-IMG_9577.JPG',0,'1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `words`
--

DROP TABLE IF EXISTS `words`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `words` (
  `Words_id` int(11) NOT NULL AUTO_INCREMENT,
  `Lesson_id` int(11) NOT NULL,
  `words` varchar(45) NOT NULL,
  `Word_IsActive` int(11) NOT NULL DEFAULT '1',
  `Words_MediaId` int(11) NOT NULL,
  PRIMARY KEY (`Words_id`),
  KEY `Chappter_idd_idx` (`Lesson_id`),
  KEY `Words_MediaId_idx` (`Words_MediaId`),
  CONSTRAINT `Chappter_idd` FOREIGN KEY (`Lesson_id`) REFERENCES `lesson` (`Lesson_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Words_MediaId` FOREIGN KEY (`Words_MediaId`) REFERENCES `media` (`Media_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `words`
--

LOCK TABLES `words` WRITE;
/*!40000 ALTER TABLE `words` DISABLE KEYS */;
INSERT INTO `words` VALUES (1,1,'باجا',1,42),(2,1,'بلی',1,43),(3,2,'پیسے',1,47),(4,2,'پتہ',1,48),(5,2,'پانی',1,50);
/*!40000 ALTER TABLE `words` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-08 10:26:10

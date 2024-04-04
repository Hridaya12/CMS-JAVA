-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 09, 2023 at 06:06 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coursemgmt`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `username` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `acc_type` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`username`, `name`, `password`, `acc_type`) VALUES
('admin', 'hridaya', 'admin', 'Admin'),
('Hridayab', 'Hridaya Bhattarai', 'hridaya123', 'Student'),
('Pradeep', 'Pradeep Mani Dixit', 'pradeep', 'Instructor'),
('AagyaS', 'Aagya Sharma', 'aagya', 'Instructor'),
('Subash', 'Subash Bista', 'subash', 'Instructor');

-- --------------------------------------------------------

--
-- Table structure for table `bibm`
--

CREATE TABLE `bibm` (
  `student_id` int(11) DEFAULT NULL,
  `student_name` varchar(25) NOT NULL,
  `level` int(11) DEFAULT NULL,
  `21st Century Management` int(100) DEFAULT NULL,
  `Preparing Success at University` int(100) DEFAULT NULL,
  `Principles of Business` int(100) DEFAULT NULL,
  `Project Based Learning` int(100) DEFAULT NULL,
  `Responsible Business` int(100) DEFAULT NULL,
  `Sustainable Business` int(100) DEFAULT NULL,
  `Innovative Business` int(100) DEFAULT NULL,
  `Digital Business` int(100) DEFAULT NULL,
  `Contemporary Issues in International Business` int(100) DEFAULT NULL,
  `International HR Professional` int(100) DEFAULT NULL,
  `Operation and Project Planning` int(100) DEFAULT NULL,
  `Managing Finance and Accounts` int(100) DEFAULT NULL,
  `Strategic Business` int(100) DEFAULT NULL,
  `Global Context for Multinational Enterprises` int(100) DEFAULT NULL,
  `Professional Project` int(100) DEFAULT NULL,
  `Marketing Consultant` int(100) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bibm`
--

INSERT INTO `bibm` (`student_id`, `student_name`, `level`, `21st Century Management`, `Preparing Success at University`, `Principles of Business`, `Project Based Learning`, `Responsible Business`, `Sustainable Business`, `Innovative Business`, `Digital Business`, `Contemporary Issues in International Business`, `International HR Professional`, `Operation and Project Planning`, `Managing Finance and Accounts`, `Strategic Business`, `Global Context for Multinational Enterprises`, `Professional Project`, `Marketing Consultant`, `status`) VALUES
(102, 'Sakar Gautam', 4, 78, 45, 12, 65, 75, 65, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Fail'),
(104, 'Samir Chaulagai', 5, NULL, NULL, NULL, NULL, NULL, NULL, 75, 85, 95, 10, 45, 66, NULL, NULL, NULL, NULL, 'Pass'),
(105, 'Sandip Khadka', 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(107, 'David Ghimire', 6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 75, 55, 66, 12, 'Pass'),
(106, 'Saurav Niraula', 5, 78, 44, 5, 6, 6, 4, 5, 5, 2, 2, 2, 5, NULL, NULL, NULL, NULL, 'Pass');

-- --------------------------------------------------------

--
-- Table structure for table `bibmmodule`
--

CREATE TABLE `bibmmodule` (
  `id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `level` varchar(20) NOT NULL,
  `tutor` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bibmmodule`
--

INSERT INTO `bibmmodule` (`id`, `name`, `level`, `tutor`) VALUES
(101, 'Professional Project', '6', 'Prabin Sapkota'),
(102, 'Innovative Business', '5', 'Ram '),
(103, 'Concepts and Technologies of AI', '5', 'Siman Giri');

-- --------------------------------------------------------

--
-- Table structure for table `bscit`
--

CREATE TABLE `bscit` (
  `student_id` int(11) NOT NULL,
  `student_name` varchar(25) NOT NULL,
  `level` varchar(10) DEFAULT NULL,
  `Introductory Programming` int(100) DEFAULT NULL,
  `Academic Skills` int(100) DEFAULT NULL,
  `Fundamentals of Computing` int(100) DEFAULT NULL,
  `Embedded Systems Programming` int(100) DEFAULT NULL,
  `Internet Software` int(100) DEFAULT NULL,
  `Computational Mathematics` int(100) DEFAULT NULL,
  `Concepts and Technologies of AI` int(100) DEFAULT NULL,
  `Object-Oriented Design and Programming` int(100) DEFAULT NULL,
  `Numerical Methods and Concurrency` int(100) DEFAULT NULL,
  `Distributed and Cloud System Programming` int(100) DEFAULT NULL,
  `Collaborative Development` int(100) DEFAULT NULL,
  `Human Computer Interaction` int(100) DEFAULT NULL,
  `Complex System` int(100) DEFAULT NULL,
  `High Performance Computing` int(100) DEFAULT NULL,
  `Project and Professionalism` int(100) DEFAULT NULL,
  `Artificial Intelligence and Machine Learning` int(100) DEFAULT NULL,
  `Big Data` int(100) DEFAULT NULL,
  `Optional Subject` int(100) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bscit`
--

INSERT INTO `bscit` (`student_id`, `student_name`, `level`, `Introductory Programming`, `Academic Skills`, `Fundamentals of Computing`, `Embedded Systems Programming`, `Internet Software`, `Computational Mathematics`, `Concepts and Technologies of AI`, `Object-Oriented Design and Programming`, `Numerical Methods and Concurrency`, `Distributed and Cloud System Programming`, `Collaborative Development`, `Human Computer Interaction`, `Complex System`, `High Performance Computing`, `Project and Professionalism`, `Artificial Intelligence and Machine Learning`, `Big Data`, `Optional Subject`, `status`) VALUES
(101, 'Hridaya Bhattarai', '4', 70, 95, 77, 78, 91, 75, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Pass'),
(103, 'Biwas Pudasaini', '5', NULL, NULL, NULL, NULL, NULL, NULL, 45, 65, 75, 10, 55, 60, NULL, NULL, NULL, NULL, NULL, NULL, 'Fail');

-- --------------------------------------------------------

--
-- Table structure for table `bscmodule`
--

CREATE TABLE `bscmodule` (
  `id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `level` varchar(20) NOT NULL,
  `tutor` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bscmodule`
--

INSERT INTO `bscmodule` (`id`, `name`, `level`, `tutor`) VALUES
(101, 'Concepts and Technologies of AI', '5', 'Prashant Shrestha'),
(102, 'Fundamentals of Computing', '5', 'Sujan Shrestha'),
(103, 'Human Computer Interaction', '5', 'Aayush Shakya');

-- --------------------------------------------------------

--
-- Table structure for table `coursedb`
--

CREATE TABLE `coursedb` (
  `course_id` int(11) NOT NULL,
  `course_name` varchar(25) NOT NULL,
  `status` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `coursedb`
--

INSERT INTO `coursedb` (`course_id`, `course_name`, `status`) VALUES
(101, 'bibm', 'Active'),
(556, 'bscit', 'Active'),
(102, 'BHM', 'Cancelled');

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

CREATE TABLE `instructor` (
  `instructor_id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `faculty` varchar(25) NOT NULL,
  `semester` varchar(25) NOT NULL,
  `module` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`instructor_id`, `name`, `faculty`, `semester`, `module`) VALUES
(103, 'Rukesh', 'BscIT', '5', 'Collaborative Development'),
(500, 'Saurav Gautam', 'BscIT', '4', 'Introductory Programming'),
(1002, 'Rukesh Shrestha', 'BBIM', '5', 'NM'),
(5776, 'Anmol Adhikari', 'BscIT', '4th', 'AI'),
(6886, 'Subash Bista', 'BscIT', '1st', 'OODP');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `course` varchar(25) NOT NULL,
  `level` varchar(11) NOT NULL,
  `semester` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `name`, `course`, `level`, `semester`) VALUES
(101, 'Hridaya Bhattarai', 'BscIT', '4', 'First'),
(102, 'Sakar Gautam', 'BIBM', '4', 'First'),
(103, 'Biwas Pudasaini', 'BscIT', '5', 'Third'),
(104, 'Samir Chaulagai', 'BIBM', '5', 'First'),
(105, 'Sandip Khadka', 'BIBM', '5', 'Third'),
(106, 'Saurav Niraula', 'BIBM', '5', 'First'),
(107, 'David Ghimire', 'BIBM', '6', 'Third');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bibmmodule`
--
ALTER TABLE `bibmmodule`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bscmodule`
--
ALTER TABLE `bscmodule`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `instructor`
--
ALTER TABLE `instructor`
  ADD PRIMARY KEY (`instructor_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

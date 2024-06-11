-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 09, 2024 at 05:45 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

Create Database library;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `edition` varchar(255) DEFAULT NULL,
  `pages` varchar(10) DEFAULT NULL,
  `price` varchar(20) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `selected` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `name`, `edition`, `pages`, `price`, `publisher`, `selected`) VALUES
(118, 'To Kill a Mockingbird', '2nd edition', '281', '15', 'Publisher2', 'not available'),
(119, '1984', '3rd edition', '328', '20', 'Publisher3', 'available'),
(120, 'Pride and Prejudice', '4th edition', '279', '12', 'Publisher4', 'not available'),
(121, 'The Catcher in the Rye', '5th edition', '214', '18', 'Publisher5', 'available'),
(122, 'Moby Dick', '1st edition', '635', '22', 'Publisher6', 'available'),
(123, 'War and Peace', '5th edition', '12', '300', 'subash', 'available'),
(124, 'The Odyssey', '3rd edition', '374', '25', 'Publisher8', 'available'),
(125, 'The Iliad', '4th edition', '543', '17', 'Publisher9', 'not available'),
(126, 'Crime and Punishment', '5th edition', '671', '19', 'Publisher10', 'not available'),
(127, 'The Great Gatsby', '1st edition', '180', '10', 'Publisher1', 'available'),
(128, 'To Kill a Mockingbird', '2nd edition', '281', '15', 'Publisher2', 'not available'),
(130, 'Pride and Prejudice', '4th edition', '279', '12', 'Publisher4', 'not available'),
(131, 'The Catcher in the Rye', '5th edition', '214', '18', 'Publisher5', 'available');

-- --------------------------------------------------------

--
-- Table structure for table `book_loans`
--

CREATE TABLE `book_loans` (
  `id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `member_Name` varchar(50) NOT NULL,
  `employee_name` varchar(50) NOT NULL,
  `loan_date` varchar(50) NOT NULL,
  `due_date` varchar(50) NOT NULL,
  `rutern_date` varchar(50) DEFAULT 'not returned',
  `email` varchar(50) NOT NULL,
  `book_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book_loans`
--

INSERT INTO `book_loans` (`id`, `book_id`, `member_Name`, `employee_name`, `loan_date`, `due_date`, `rutern_date`, `email`, `book_name`) VALUES
(15, 117, 'subash', 'Olivia', '14 Jun 2024', '22 Jun 2024', '21 Jun 2024', 'subash@gmail.com', 'The Great Gatsby'),
(16, 124, 'sunddar', 'Ethan', '14 Jun 2024', '29 Jun 2024', 'not returned', 'sundar2gmail.com', 'The Odyssey'),
(17, 126, 'sanam', 'Sophia', '13 Jun 2024', '28 Jun 2024', '27 Jun 2024', 'sanam@gmail.com', 'Crime and Punishment'),
(18, 131, 'sahan', 'Ethan', '07 Jun 2024', '28 Jun 2024', 'not returned', 'sahan@gmail.com', 'The Catcher in the Rye'),
(19, 131, 'undar', 'Olivia', '13 Jun 2024', '21 Jun 2024', 'not returned', 'undar@gmail.com', 'The Catcher in the Rye'),
(20, 127, 'supun', 'Ethan', '14 Jun 2024', '28 Jun 2024', '29 Jun 2024', 'supun@gmail.com', 'The Great Gatsby');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `first_name`, `last_name`, `email`, `phone_number`, `salary`) VALUES
(15, 'Ethan', 'Metthews', 'Ethen@gmail.com', '298173728', 20000.00),
(19, 'sundar', 'mhrxn', 'sundar@gmail.co', '38472834', 23432.00),
(20, 'subash', 'mhrxn', 'subash@gmail.co', '08472834', 23432.00);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `email` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`email`, `name`, `password`) VALUES
('Shrestha@gamail.com', 'shrestha', 'Shrestha'),
('shrestha@gmail.com', 'shrestha', 'shrestha');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book_loans`
--
ALTER TABLE `book_loans`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=132;

--
-- AUTO_INCREMENT for table `book_loans`
--
ALTER TABLE `book_loans`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

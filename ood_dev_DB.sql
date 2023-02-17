-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 24, 2022 at 08:06 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ood_dev_DB`
--

-- --------------------------------------------------------

--
-- Table structure for table `artists`
--

CREATE TABLE `artists` (
  `artist_id` int(11) NOT NULL,
  `artist_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `artists`
--

INSERT INTO `artists` (`artist_id`, `artist_name`) VALUES
(1, 'Metallica'),
(2, 'Guns N\' Roses'),
(3, 'The Beatles'),
(4, 'The Who'),
(5, 'Queen'),
(6, 'The Rolling Stones'),
(7, 'Pink Floyd');

-- --------------------------------------------------------

--
-- Table structure for table `ordered_songs`
--

CREATE TABLE `ordered_songs` (
  `order_id` int(11) NOT NULL,
  `song_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `songs`
--

CREATE TABLE `songs` (
  `songs_id` int(11) NOT NULL,
  `artist_id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `price` float DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `quantity` int(11) DEFAULT 100
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `songs`
--

INSERT INTO `songs` (`songs_id`, `artist_id`, `title`, `price`, `url`, `quantity`) VALUES
(1, 1, 'The Unforgiven I', 1.5, '/img/unforgiven1.jpg', 100),
(2, 1, 'Whiskey in the Jar', 1, '/img/wiskey_jar.jpg', 100),
(3, 1, 'Enter Sandman', 1.2, '/img/enter_sadman.jpg', 100),
(4, 2, 'Sweet Child O\' Mine', 1.3, '/img/sweet.jpg', 100),
(5, 2, 'Knockin\' On Heaven\'s Door', 1.2, '/img/knocking.jpg', 100),
(6, 2, 'Welcome To The Jungle', 1.1, '/img/jungle.jpg', 2),
(7, 1, 'The Unforgiven II', 2, '/img/unforgiven2.jpg', 100);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `email` varchar(35) NOT NULL,
  `pass` varchar(35) NOT NULL,
  `isAdmin` tinyint(1) DEFAULT 0,
  `balance` double DEFAULT 100
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `full_name`, `email`, `pass`, `isAdmin`, `balance`) VALUES
(1000, 'Test User', 'test@solent.ac.uk', '12345', 0, 100),
(1001, 'Erika Miranda', 'erika@solent.ac.uk', '12345', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_orders`
--

CREATE TABLE `user_orders` (
  `order_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `order_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artists`
--
ALTER TABLE `artists`
  ADD PRIMARY KEY (`artist_id`);

--
-- Indexes for table `ordered_songs`
--
ALTER TABLE `ordered_songs`
  ADD PRIMARY KEY (`order_id`,`song_id`),
  ADD KEY `ordered_songs_song_fk` (`song_id`);

--
-- Indexes for table `songs`
--
ALTER TABLE `songs`
  ADD PRIMARY KEY (`songs_id`),
  ADD KEY `artists_fk` (`artist_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_orders`
--
ALTER TABLE `user_orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `user_orders_users_fk` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artists`
--
ALTER TABLE `artists`
  MODIFY `artist_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `songs`
--
ALTER TABLE `songs`
  MODIFY `songs_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1002;

--
-- AUTO_INCREMENT for table `user_orders`
--
ALTER TABLE `user_orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ordered_songs`
--
ALTER TABLE `ordered_songs`
  ADD CONSTRAINT `ordered_songs_order_fk` FOREIGN KEY (`order_id`) REFERENCES `user_orders` (`order_id`),
  ADD CONSTRAINT `ordered_songs_song_fk` FOREIGN KEY (`song_id`) REFERENCES `songs` (`songs_id`);

--
-- Constraints for table `songs`
--
ALTER TABLE `songs`
  ADD CONSTRAINT `artists_fk` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`artist_id`);

--
-- Constraints for table `user_orders`
--
ALTER TABLE `user_orders`
  ADD CONSTRAINT `user_orders_users_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

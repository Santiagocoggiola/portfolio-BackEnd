-- phpMyAdmin SQL Dump
-- version 5.3.0-dev+20220722.bbf4e29d52
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:9999:9999
-- Tiempo de generación: 25-07-2022 a las 02:56:15
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.0.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `portfolio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `about`
--

CREATE TABLE `about` (
  `id` int(11) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `photo_path` varchar(255) DEFAULT NULL,
  `text` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `about`
--

INSERT INTO `about` (`id`, `is_active`, `photo_path`, `text`) VALUES
(7, b'1', 'Santi2.png', 'I\'m Santiago Coggiola, I\'m a web developer that can work with multiple technologies, make beautiful dynamic websites. After finishing my elementary studies, I started to study programming, which is my passion. I\'m a proactive person, that want to learn more and overcome in various skills.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `banner`
--

CREATE TABLE `banner` (
  `id` int(11) NOT NULL,
  `img_path` varchar(255) DEFAULT NULL,
  `is_active` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `banner`
--

INSERT INTO `banner` (`id`, `img_path`, `is_active`) VALUES
(8, 'Banner.png', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `education`
--

CREATE TABLE `education` (
  `id` int(11) NOT NULL,
  `career` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `logo_path` varchar(255) DEFAULT NULL,
  `university` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `education`
--

INSERT INTO `education` (`id`, `career`, `date`, `logo_path`, `university`) VALUES
(9, 'Computer Engineering', '2013-2015', 'logo-ubp.png', 'Universidad Blas Pascal'),
(10, 'Video Game Developer', '2015-2018', 'logo-ies.png', 'Colegio Universitario IES XXI'),
(11, 'Bachelor\'s Degree In Computer Science', '2020-Present', 'logoFaMAF.png', 'FAMAF');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `experience`
--

CREATE TABLE `experience` (
  `id` int(11) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `logo_path` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `experience`
--

INSERT INTO `experience` (`id`, `date`, `logo_path`, `place`, `position`) VALUES
(12, '2022-Present', 'Fullstack.png', 'Freelancer', 'FullStack Developer');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `user_token` varchar(500) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`user_token`, `password`, `user_name`) VALUES
('eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJTYW50aWFnb0NvZ2dpb2xhIiwiZXhwIjoxNjU4NTI5ODMxLCJpYXQiOjE2NTg1MTE4MzF9.hm_1NQltspHEA4CZaGswpY1zVmwjHJQEGdK-GkCg3qisvEo38UchWPVt8bh5yFy-ZRbZa_9th54sC6FCAXKMsw', 'daniel8264', 'SantiagoCoggiola');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `projects`
--

CREATE TABLE `projects` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `id_project` bigint(20) NOT NULL,
  `img_path` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `projects`
--

INSERT INTO `projects` (`id`, `description`, `id_project`, `img_path`, `name`) VALUES
(1, 'Some Description', 1, 'Frame.png', 'Name of the project'),
(2, 'Some Description', 1, 'Frame.png', 'Another page of project 1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `skills`
--

CREATE TABLE `skills` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `percentage` float NOT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `skills`
--

INSERT INTO `skills` (`id`, `name`, `percentage`, `type`) VALUES
(1, 'Teamwork', 80, 'Soft'),
(3, 'Time Management', 70, 'Soft'),
(10, 'Response Capability', 80, 'Soft'),
(13, 'Javascript', 80, 'Hard'),
(14, 'Angular', 70, 'Hard'),
(15, 'MySql', 90, 'Hard'),
(16, 'Spring Boot', 70, 'Hard'),
(17, 'CSS', 65, 'Hard'),
(18, 'HTML', 70, 'Hard'),
(19, 'Typescript', 80, 'Hard'),
(20, 'Spanish', 100, 'Lenguage'),
(21, 'English', 70, 'Lenguages');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnologies`
--

CREATE TABLE `tecnologies` (
  `id` int(11) NOT NULL,
  `row` int(11) NOT NULL,
  `logo_path1` varchar(255) DEFAULT NULL,
  `logo_path2` varchar(255) DEFAULT NULL,
  `logo_path3` varchar(255) DEFAULT NULL,
  `logo_path4` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tecnologies`
--

INSERT INTO `tecnologies` (`id`, `row`, `logo_path1`, `logo_path2`, `logo_path3`, `logo_path4`) VALUES
(1, 1, 'Angular.png', 'C.png', 'C-sharp.png', 'Typescript.png'),
(3, 1, 'MySql.png', 'HtmlCssJs.png', 'SpringBoot.png', 'MySql.png');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `about`
--
ALTER TABLE `about`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `banner`
--
ALTER TABLE `banner`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `education`
--
ALTER TABLE `education`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `experience`
--
ALTER TABLE `experience`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`user_token`);

--
-- Indices de la tabla `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `skills`
--
ALTER TABLE `skills`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tecnologies`
--
ALTER TABLE `tecnologies`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `about`
--
ALTER TABLE `about`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `banner`
--
ALTER TABLE `banner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `education`
--
ALTER TABLE `education`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `experience`
--
ALTER TABLE `experience`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `projects`
--
ALTER TABLE `projects`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `skills`
--
ALTER TABLE `skills`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `tecnologies`
--
ALTER TABLE `tecnologies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

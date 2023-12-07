-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 11-08-2017 a las 22:52:39
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `territorio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ccaa`
--

CREATE TABLE IF NOT EXISTS `ccaa` (
  `id` int(2) NOT NULL,
  `nombre` varchar(25) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ccaa`
--

INSERT INTO `ccaa` (`id`, `nombre`) VALUES
(1, 'Andalucía'),
(2, 'Aragón'),
(3, 'Cantabria'),
(4, 'Castilla y León'),
(5, 'Castilla-La Mancha'),
(6, 'Cataluña\r\n'),
(7, 'Ceuta\r\n'),
(8, 'Comunidad de Madrid'),
(9, 'Comunidad Valenciana'),
(10, 'Extremadura'),
(11, 'Galicia'),
(12, 'Illes Balears'),
(13, 'Islas Canarias'),
(14, 'La Rioja'),
(15, 'Melilla'),
(16, 'Navarra'),
(17, 'País Vasco'),
(18, 'Principado de Asturias'),
(19, 'Región de Murcia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `municipio`
--

CREATE TABLE IF NOT EXISTS `municipio` (
  `id` int(2) NOT NULL,
  `id_provincia` int(2) NOT NULL,
  `nombre` varchar(25) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `municipio`
--

INSERT INTO `municipio` (`id`, `id_provincia`, `nombre`) VALUES
(1, 1, 'Abla'),
(2, 1, 'Abrucena'),
(3, 1, 'Adra'),
(4, 1, 'Alblánchez'),
(32, 8, 'xxxxx'),
(33, 9, 'Abiego'),
(45, 12, 'Alfoz de Lloredo '),
(46, 12, 'Ampuero '),
(47, 12, 'Anievas'),
(48, 12, 'Arenas de Iguña');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

CREATE TABLE IF NOT EXISTS `provincia` (
  `id` int(2) NOT NULL,
  `id_ccaa` int(2) NOT NULL,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `provincia`
--

INSERT INTO `provincia` (`id`, `id_ccaa`, `nombre`) VALUES
(1, 1, 'Almeria'),
(2, 1, 'Cádiz'),
(3, 1, 'Cordoba'),
(4, 1, 'Granada'),
(5, 1, 'Huelva'),
(6, 1, 'Jaen'),
(7, 1, 'Málaga'),
(8, 1, 'Sevilla'),
(9, 2, 'Huesca'),
(10, 2, 'Teruel'),
(11, 2, 'Zaragoza'),
(12, 3, 'Cantabria'),
(13, 4, 'Ávila'),
(14, 4, 'Burgos'),
(15, 4, 'León'),
(16, 4, 'Palencia'),
(17, 4, 'Salamanca'),
(18, 4, 'Segovia'),
(19, 4, 'Soria'),
(20, 4, 'Valladolid'),
(21, 4, 'Zamora'),
(22, 5, 'Albacete'),
(23, 5, 'Ciudad Real'),
(24, 5, 'Cuenca'),
(25, 5, 'Guadalajara'),
(26, 5, 'Toledo'),
(27, 6, 'Barcelona'),
(28, 6, 'Girona'),
(29, 6, 'Lleida'),
(30, 6, 'Tarragona'),
(31, 7, 'Ceuta'),
(32, 8, 'Madrid');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 05-06-2017 a las 20:31:25
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `universidad`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_agregarAlumno`(IN `pdni` CHAR(8), IN `pnombre` VARCHAR(45), IN `papellidos` VARCHAR(45), IN `pfechaN` VARCHAR(45), IN `pdireccion` VARCHAR(45))
BEGIN
insert into alumnos(dni,nombre,apellidos,fechaN,direccion)
values (pdni,pnombre,papellidos,pfechaN,pdireccion);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscaPxApellidos`(IN `papellidos` VARCHAR(45))
BEGIN
select * from alumnos where apellidos like  concat(papellidos,'%');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_deleteAlumno`(IN `pdni` CHAR(8))
BEGIN
delete from  alumnos where dni = pdni;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editAlumno`(IN `pdni` CHAR(8), IN `pnombre` VARCHAR(45), IN `papellidos` VARCHAR(45), IN `pfechaN` DATE, IN `pdireccion` VARCHAR(45))
BEGIN
update alumnos set nombre= pnombre, apellidos = papellidos, fechaN=fechaN, direccion=direccion
where dni = pdni;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE IF NOT EXISTS `alumnos` (
  `dni` varchar(9) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `fechaN` date NOT NULL,
  `direccion` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`dni`, `nombre`, `apellidos`, `fechaN`, `direccion`) VALUES
('6666', 'jj', 'jj', '2017-05-06', 'jjj'),
('88', 'uiui', 'uiui', '2017-05-05', 'ssdfsdf'),
('6767', 'ddd', 'dd', '2017-05-04', 'ddd'),
('345345', 'ert', 'ert', '2017-05-13', 'etr'),
('7878', 'fgfg', 'fgfg', '2017-05-04', 'fgfgfg'),
('567', 'jku', 'hjgjh', '2017-05-04', 'sghgfh'),
('343453', 'ete', 'etet', '2017-05-11', 'etretr'),
('6666', 'jj', 'jj', '2017-05-06', 'jjj'),
('88', 'uiui', 'uiui', '2017-05-05', 'ssdfsdf'),
('6767', 'ddd', 'dd', '2017-05-04', 'ddd'),
('345345', 'ert', 'ert', '2017-05-13', 'etr'),
('7878', 'fgfg', 'fgfg', '2017-05-04', 'fgfgfg'),
('567', 'jku', 'hjgjh', '2017-05-04', 'sghgfh'),
('343453', 'ete', 'etet', '2017-05-11', 'etretr');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE IF NOT EXISTS `profesores` (
  `dni` varchar(9) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `fechaN` date NOT NULL,
  `direccion` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`dni`, `nombre`, `apellidos`, `fechaN`, `direccion`) VALUES
('1234', 'toni', 'rivero', '2017-06-02', 'unaaaaa');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

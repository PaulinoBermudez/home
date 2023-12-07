-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 11-03-2015 a las 16:37:02
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `bd_persona`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscaPxApellidos`(
papellidos varchar(45))
BEGIN
select * from persona where apellidos like  concat(papellidos,'%');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_deletePersona`(
pdni char(8))
BEGIN
delete from  persona where dni = pdni;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editPersona`(
pdni char(8),
papellidos varchar(45),
pnombres varchar(45),
pfecha date,
plugar varchar(45))
BEGIN
update persona set apellidos = papellidos, nombres= pnombres, fechaNacimiento=pfecha, lugarNacimiento=plugar
where dni = pdni;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertPersona`(
pdni char(8),
papellidos varchar(45),
pnombres varchar(45),
pfechas varchar(45),
plugar varchar(45))
BEGIN
insert into persona(dni,apellidos,nombres,fechaNacimiento,lugarNacimiento)
values (pdni,papellidos,pnombres,pfechas,plugar);

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `dni` char(8) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `lugarNacimiento` varchar(45) NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`dni`, `apellidos`, `nombres`, `fechaNacimiento`, `lugarNacimiento`) VALUES
('19532112', 'Ruiz Benites', 'Sheymi', '1985-07-15', 'Lima'),
('34573423', 'Jimenes Montoya', 'Carlos', '2005-03-11', 'Trujillo'),
('39854312', 'Rodriguez Burgos', 'Dayana', '1994-10-17', 'Cliclayo'),
('46099060', 'Ruiz Benites', 'Ricardo', '1989-12-10', 'Trujillo'),
('87654567', 'Lopez Lopez', 'Angela', '1991-01-16', 'Trujillo');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

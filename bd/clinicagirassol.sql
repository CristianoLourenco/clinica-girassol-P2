-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 02, 2024 at 07:05 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clinicagirassol`
--

-- --------------------------------------------------------

--
-- Table structure for table `consulta`
--

CREATE TABLE `consulta` (
  `id` int(11) NOT NULL,
  `pacienteId` int(11) NOT NULL,
  `dataConsulta` date NOT NULL,
  `horario` time NOT NULL,
  `medicoId` int(11) NOT NULL,
  `especialidadeId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `especialidade`
--

CREATE TABLE `especialidade` (
  `id` int(11) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `descricao` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `especialidade`
--

INSERT INTO `especialidade` (`id`, `nome`, `descricao`) VALUES
(1, 'primeira', 'p1'),
(2, 'Pediatria ', 'Tratamento de Criancas'),
(3, 'Oftamologia ', 'Tratamento dos Olhos'),
(4, 'Ortopedria', 'Nao sei');

-- --------------------------------------------------------

--
-- Table structure for table `factura`
--

CREATE TABLE `factura` (
  `id` int(11) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `idConsulta` int(11) NOT NULL,
  `idMedicamento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `funcionario`
--

CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `bi` varchar(14) NOT NULL,
  `telefone` varchar(9) NOT NULL,
  `morada` text NOT NULL,
  `genero` enum('M','F') NOT NULL,
  `data_nascimento` date NOT NULL,
  `cargo` varchar(150) NOT NULL,
  `funcao` enum('Atendente','Medico','Enfermeiro','') NOT NULL,
  `salario` double NOT NULL,
  `data_contrato` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `funcionario`
--

INSERT INTO `funcionario` (`id`, `nome`, `bi`, `telefone`, `morada`, `genero`, `data_nascimento`, `cargo`, `funcao`, `salario`, `data_contrato`) VALUES
(1, 'Joel Silva', '00232LS3443', '933203433', 'Luanda', 'M', '1989-09-23', 'Gerente Chefe', 'Atendente', 1000000, '2010-06-29'),
(2, 'Miguel Lucas', '00232LS3443', '933203433', 'Malanje', 'M', '2000-09-23', 'Operacional junior', 'Atendente', 1980000, '2020-08-01'),
(3, 'Mariano Carlos', '009433KA343', '933342211', 'Luanda', 'M', '2000-09-23', 'Chefe de Plantao', 'Medico', 2000000, '2020-08-01'),
(4, 'Jojo Marontini', '034DDKS', '93343412', 'Viana', 'F', '1987-10-25', 'Sirurgia chefe', 'Medico', 29300043, '2014-04-28'),
(5, 'Garcia Lucas', '0034jjdfd', '293923', 'Luanda', 'M', '1990-08-22', 'Chefe', 'Medico', 1923883, '2018-12-03'),
(6, 'Karlos Martinho', '8883444', '99340003', 'Kilamba', 'M', '1982-11-09', 'Junior', 'Medico', 92022330, '2018-10-23'),
(7, 'Karlinhos Gomes', '8342', '9230030', 'Kilamba', 'M', '1988-07-22', 'Interno', 'Medico', 829920000, '2010-10-05'),
(8, 'Joao De almeida', '00237LA774898', '933442244', 'Luanda, Angola', 'M', '1982-10-29', 'Chefe de sirurgia', 'Medico', 9110000, '2017-06-29'),
(9, 'Antonia Silvana', '0023KA344388', '990223388', 'Lisboa', 'F', '1982-10-23', 'Sirurgiia chefe', 'Medico', 992388888, '2011-09-27'),
(10, 'Jonas', '00349', '99343', 'Luanda', 'M', '1980-02-05', 'Cheffe', 'Medico', 930004394, '2001-01-20'),
(11, 'Karlinhos', '3949342', '93443322', 'Camama', 'M', '1979-05-10', 'Chefe', 'Medico', 2999932, '2001-02-02'),
(12, 'Kikio Shinomia', '2993LA8434', '932283322', 'Kilamba', 'F', '1995-10-05', 'Adjunta', 'Medico', 9990432, '2017-06-29'),
(13, 'Jorje Garcia', '003298834', '993203288', 'Sao Paulo', 'M', '1980-02-23', 'Auxiliar', 'Medico', 9232312321, '2022-10-05'),
(14, 'Josh', '0223392KA', '922113344', 'Japão', 'M', '1988-09-11', 'Chefe', 'Medico', 198000, '2010-10-02'),
(15, 'Jonas Savios', '0099388823', '922110022', 'Benguela', 'M', '1979-09-12', 'Auxiliar ', 'Medico', 19988222, '2009-11-29'),
(16, 'Carlos Silva', '0027732888', '9223322', 'Luanda', 'M', '1989-03-01', 'Medico Junior', 'Medico', 1920000, '2018-11-03'),
(17, 'Catarino Silva', '002931LA9343', '921332244', 'Luanda', 'M', '1987-05-12', 'Che=fe', 'Medico', 1920000232, '2000-10-23'),
(18, 'Janaina Belo', '002932321KAS', '923388221', 'Kikuxi', 'F', '2000-02-20', 'Chefe de Sirurgia', 'Medico', 99910000, '2024-03-02'),
(19, 'Kaslka', '893492', '983429', 'KLsA', 'M', '2000-10-02', 'jfdkfds', 'Medico', 89343243, '2010-12-03'),
(20, 'dfff', '34243', '324324', 'fdsfds', 'M', '1999-10-22', 'dsfsfsd', 'Medico', 34324324324, '1922-02-11'),
(21, 'gfgfd', '4545', '454354', 'fdgfdg', 'M', '1111-11-11', 'ffgdf', 'Medico', 44333, '1111-11-11'),
(22, 'dffds', '43423', '33432', 'dffds', 'M', '1111-11-11', 'fsdf', 'Medico', 432432, '1111-11-11'),
(23, 'ffdsfds', '3434', '2434', 'erwere', 'M', '1111-11-11', 'fsfsd', 'Medico', 434243, '1111-11-11'),
(24, 'sadsad', '4343', '34243', 'dsadad', 'F', '1111-11-11', 'dfdsf', 'Medico', 34434, '1111-11-11'),
(25, 'gfdgdf', '324234', '43432', 'fdgdfgf3', 'M', '1111-11-11', 'dfsfd', 'Medico', 3423432, '1111-11-11'),
(26, 'Cdsadsd', 'dfs', '343', 'dsdsd', 'F', '1111-11-11', 'dfdsf', 'Medico', 342432, '1111-11-11');

-- --------------------------------------------------------

--
-- Table structure for table `medicamento`
--

CREATE TABLE `medicamento` (
  `id` int(11) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `dosagem` int(11) NOT NULL,
  `dataFabrico` date NOT NULL,
  `dataExpiracao` date NOT NULL,
  `instrucaoDeUso` varchar(150) NOT NULL,
  `consultaId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `medico`
--

CREATE TABLE `medico` (
  `id` int(11) NOT NULL,
  `numero_ordem` int(11) NOT NULL,
  `especialidade_id` int(11) NOT NULL,
  `funcionario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `medico`
--

INSERT INTO `medico` (`id`, `numero_ordem`, `especialidade_id`, `funcionario_id`) VALUES
(2, 23, 4, 14),
(4, 34545, 4, 26);

-- --------------------------------------------------------

--
-- Table structure for table `paciente`
--

CREATE TABLE `paciente` (
  `id` int(11) NOT NULL,
  `Nome` varchar(150) NOT NULL,
  `bi` varchar(14) NOT NULL,
  `data_nascimento` varchar(70) NOT NULL,
  `endereco` varchar(150) NOT NULL,
  `telefone` int(9) NOT NULL,
  `genero` enum('M','F') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `paciente`
--

INSERT INTO `paciente` (`id`, `Nome`, `bi`, `data_nascimento`, `endereco`, `telefone`, `genero`) VALUES
(1, 'Jaime da Cruz', '007643329LA044', '2024-06-01', 'viana', 238348, 'M'),
(2, 'Jaime da Cruz', '007643329LA044', '2024-06-01', 'viana', 238348, 'M'),
(3, 'Mriana Silva', 'Lisbia', '2024-06-19', '00389283', 921332288, 'M'),
(4, 'Joana Silva', 'Talatona', '2024-06-19', '489549898DS', 923823222, 'M'),
(5, 'Antonio Dunda', 'CaUIge', '2002-10-20', '9934888JA', 934832211, 'M'),
(6, 'Joao Lauriel', 'Viana', '2000-10-05', '02392AS3943', 92331102, 'M');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `especialidade`
--
ALTER TABLE `especialidade`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `medicamento`
--
ALTER TABLE `medicamento`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `numero_ordem` (`numero_ordem`),
  ADD KEY `medico_ibfk_1` (`especialidade_id`),
  ADD KEY `medico_ibfk_2` (`funcionario_id`);

--
-- Indexes for table `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `consulta`
--
ALTER TABLE `consulta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `especialidade`
--
ALTER TABLE `especialidade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `factura`
--
ALTER TABLE `factura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `medicamento`
--
ALTER TABLE `medicamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `medico`
--
ALTER TABLE `medico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `paciente`
--
ALTER TABLE `paciente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `medico_ibfk_1` FOREIGN KEY (`especialidade_id`) REFERENCES `especialidade` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `medico_ibfk_2` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

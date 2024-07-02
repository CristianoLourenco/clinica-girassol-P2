-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 30, 2024 at 08:37 PM
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
  `morada` text NOT NULL,
  `cargo` varchar(150) NOT NULL,
  `genero` enum('M','F') NOT NULL,
  `funcao` enum('Atendente','Medico','Enfermeiro','') NOT NULL,
  `telefone` varchar(9) NOT NULL,
  `salario` double NOT NULL,
  `data_nascimento` date NOT NULL,
  `data_contrato` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `funcionario`
--

INSERT INTO `funcionario` (`id`, `nome`, `bi`, `morada`, `cargo`, `genero`, `funcao`, `telefone`, `salario`, `data_nascimento`, `data_contrato`) VALUES
(1, 'Joel Silva', '00232LS3443', 'Luanda', 'Gerente Chefe', 'M', 'Atendente', '933203433', 1000000, '1989-09-23', '2010-06-29'),
(2, 'Miguel Lucas', '00232LS3443', 'Malanje', 'Operacional junior', 'M', 'Atendente', '933203433', 1980000, '2000-09-23', '2020-08-01'),
(3, 'Mariano Carlos', '009433KA343', 'Luanda', 'Chefe de Plantao', 'M', 'Medico', '933342211', 2000000, '2000-09-23', '2020-08-01'),
(4, 'Jojo Marontini', '034DDKS', 'Viana', 'Sirurgia chefe', 'F', 'Medico', '93343412', 29300043, '1987-10-25', '2014-04-28'),
(5, 'Garcia Lucas', '0034jjdfd', 'Luanda', 'Chefe', 'M', 'Medico', '293923', 1923883, '1990-08-22', '2018-12-03'),
(6, 'Karlos Martinho', '8883444', 'Kilamba', 'Junior', 'M', 'Medico', '99340003', 92022330, '1982-11-09', '2018-10-23'),
(7, 'Karlinhos Gomes', '8342', 'Kilamba', 'Interno', 'M', 'Medico', '9230030', 829920000, '1988-07-22', '2010-10-05');

-- --------------------------------------------------------

--
-- Table structure for table `funcionario_medico`
--

CREATE TABLE `funcionario_medico` (
  `id` int(11) NOT NULL,
  `id_medico` int(11) NOT NULL,
  `id_funcionario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

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
  `numeroDaOrdem` int(11) NOT NULL,
  `especialidadeId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `medico`
--

INSERT INTO `medico` (`numeroDaOrdem`, `especialidadeId`) VALUES
(9000, 1);

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
-- Indexes for table `funcionario_medico`
--
ALTER TABLE `funcionario_medico`
  ADD PRIMARY KEY (`id`),
  ADD KEY `funcionario_medico_fkfuncionario` (`id_funcionario`),
  ADD KEY `funcionario_medico_fkmedico` (`id_medico`);

--
-- Indexes for table `medicamento`
--
ALTER TABLE `medicamento`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`numeroDaOrdem`),
  ADD KEY `especialidadeId` (`especialidadeId`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `funcionario_medico`
--
ALTER TABLE `funcionario_medico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `medicamento`
--
ALTER TABLE `medicamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `paciente`
--
ALTER TABLE `paciente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `funcionario_medico`
--
ALTER TABLE `funcionario_medico`
  ADD CONSTRAINT `funcionario_medico_fkfuncionario` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `funcionario_medico_fkmedico` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`numeroDaOrdem`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `medico_ibfk_1` FOREIGN KEY (`especialidadeId`) REFERENCES `especialidade` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

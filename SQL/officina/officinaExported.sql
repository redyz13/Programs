-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Feb 10, 2021 alle 17:45
-- Versione del server: 10.4.17-MariaDB
-- Versione PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `officina`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `effettua`
--

CREATE TABLE `effettua` (
  `codiceTecnico` smallint(6) NOT NULL,
  `codiceManutenzione` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `manutenzione`
--

CREATE TABLE `manutenzione` (
  `codiceManutenzione` smallint(6) NOT NULL,
  `tipo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `pezzoricambio`
--

CREATE TABLE `pezzoricambio` (
  `codicePezzoRicambio` smallint(6) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `quantità` smallint(6) NOT NULL,
  `descrizione` varchar(20) NOT NULL,
  `codiceManutenzione` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `proprietario`
--

CREATE TABLE `proprietario` (
  `codiceProprietario` smallint(6) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `codiceFiscale` char(16) NOT NULL,
  `indirizzo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `ripara`
--

CREATE TABLE `ripara` (
  `codiceTecnico` smallint(6) NOT NULL,
  `codiceVeicolo` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `tecnico`
--

CREATE TABLE `tecnico` (
  `codiceTecnico` smallint(6) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `codiceFiscale` char(16) NOT NULL,
  `indirizzo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `tipologia`
--

CREATE TABLE `tipologia` (
  `codiceTipologia` smallint(6) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `tariffaOraria` smallint(6) NOT NULL,
  `codiceVeicolo` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `veicolo`
--

CREATE TABLE `veicolo` (
  `codiceVeicolo` smallint(6) NOT NULL,
  `numeroTarga` varchar(20) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `modello` varchar(20) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `cilindrata` varchar(20) NOT NULL,
  `tipoMotore` varchar(20) NOT NULL,
  `codiceProprietario` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `effettua`
--
ALTER TABLE `effettua`
  ADD KEY `codiceTecnico` (`codiceTecnico`),
  ADD KEY `codiceManutenzione` (`codiceManutenzione`);

--
-- Indici per le tabelle `manutenzione`
--
ALTER TABLE `manutenzione`
  ADD PRIMARY KEY (`codiceManutenzione`);

--
-- Indici per le tabelle `pezzoricambio`
--
ALTER TABLE `pezzoricambio`
  ADD PRIMARY KEY (`codicePezzoRicambio`),
  ADD KEY `codiceManutenzione` (`codiceManutenzione`);

--
-- Indici per le tabelle `proprietario`
--
ALTER TABLE `proprietario`
  ADD PRIMARY KEY (`codiceProprietario`);

--
-- Indici per le tabelle `ripara`
--
ALTER TABLE `ripara`
  ADD KEY `codiceTecnico` (`codiceTecnico`),
  ADD KEY `codiceVeicolo` (`codiceVeicolo`);

--
-- Indici per le tabelle `tecnico`
--
ALTER TABLE `tecnico`
  ADD PRIMARY KEY (`codiceTecnico`);

--
-- Indici per le tabelle `tipologia`
--
ALTER TABLE `tipologia`
  ADD PRIMARY KEY (`codiceTipologia`),
  ADD KEY `codiceVeicolo` (`codiceVeicolo`);

--
-- Indici per le tabelle `veicolo`
--
ALTER TABLE `veicolo`
  ADD PRIMARY KEY (`codiceVeicolo`),
  ADD KEY `codiceProprietario` (`codiceProprietario`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `effettua`
--
ALTER TABLE `effettua`
  ADD CONSTRAINT `effettua_ibfk_1` FOREIGN KEY (`codiceTecnico`) REFERENCES `tecnico` (`codiceTecnico`),
  ADD CONSTRAINT `effettua_ibfk_2` FOREIGN KEY (`codiceManutenzione`) REFERENCES `manutenzione` (`codiceManutenzione`);

--
-- Limiti per la tabella `pezzoricambio`
--
ALTER TABLE `pezzoricambio`
  ADD CONSTRAINT `pezzoricambio_ibfk_1` FOREIGN KEY (`codiceManutenzione`) REFERENCES `manutenzione` (`codiceManutenzione`);

--
-- Limiti per la tabella `ripara`
--
ALTER TABLE `ripara`
  ADD CONSTRAINT `ripara_ibfk_1` FOREIGN KEY (`codiceTecnico`) REFERENCES `tecnico` (`codiceTecnico`),
  ADD CONSTRAINT `ripara_ibfk_2` FOREIGN KEY (`codiceVeicolo`) REFERENCES `veicolo` (`codiceVeicolo`);

--
-- Limiti per la tabella `tipologia`
--
ALTER TABLE `tipologia`
  ADD CONSTRAINT `tipologia_ibfk_1` FOREIGN KEY (`codiceVeicolo`) REFERENCES `veicolo` (`codiceVeicolo`);

--
-- Limiti per la tabella `veicolo`
--
ALTER TABLE `veicolo`
  ADD CONSTRAINT `veicolo_ibfk_1` FOREIGN KEY (`codiceProprietario`) REFERENCES `proprietario` (`codiceProprietario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

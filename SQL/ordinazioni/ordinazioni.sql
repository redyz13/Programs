-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Feb 11, 2021 alle 16:15
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
-- Database: `ordinazioni`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `cameriere`
--

CREATE TABLE `cameriere` (
  `codiceCameriere` smallint(6) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `codiceFiscale` char(16) NOT NULL,
  `indirizzo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `comprende`
--

CREATE TABLE `comprende` (
  `codiceOrdinazione` smallint(6) NOT NULL,
  `codiceProdotto` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `ordinazione`
--

CREATE TABLE `ordinazione` (
  `codiceOrdinazione` smallint(6) NOT NULL,
  `stato` varchar(20) NOT NULL,
  `descrizione` varchar(20) NOT NULL,
  `codiceCameriere` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotto`
--

CREATE TABLE `prodotto` (
  `codiceProdotto` smallint(6) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `quantità` smallint(6) NOT NULL,
  `prezzo` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `tavolo`
--

CREATE TABLE `tavolo` (
  `codiceTavolo` smallint(6) NOT NULL,
  `numero` smallint(6) NOT NULL,
  `posti` smallint(6) NOT NULL,
  `codiceCameriere` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `cameriere`
--
ALTER TABLE `cameriere`
  ADD PRIMARY KEY (`codiceCameriere`);

--
-- Indici per le tabelle `comprende`
--
ALTER TABLE `comprende`
  ADD KEY `codiceOrdinazione` (`codiceOrdinazione`),
  ADD KEY `codiceProdotto` (`codiceProdotto`);

--
-- Indici per le tabelle `ordinazione`
--
ALTER TABLE `ordinazione`
  ADD PRIMARY KEY (`codiceOrdinazione`),
  ADD KEY `codiceCameriere` (`codiceCameriere`);

--
-- Indici per le tabelle `prodotto`
--
ALTER TABLE `prodotto`
  ADD PRIMARY KEY (`codiceProdotto`);

--
-- Indici per le tabelle `tavolo`
--
ALTER TABLE `tavolo`
  ADD PRIMARY KEY (`codiceTavolo`),
  ADD KEY `codiceCameriere` (`codiceCameriere`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `comprende`
--
ALTER TABLE `comprende`
  ADD CONSTRAINT `comprende_ibfk_1` FOREIGN KEY (`codiceOrdinazione`) REFERENCES `ordinazione` (`codiceOrdinazione`),
  ADD CONSTRAINT `comprende_ibfk_2` FOREIGN KEY (`codiceProdotto`) REFERENCES `prodotto` (`codiceProdotto`);

--
-- Limiti per la tabella `ordinazione`
--
ALTER TABLE `ordinazione`
  ADD CONSTRAINT `ordinazione_ibfk_1` FOREIGN KEY (`codiceCameriere`) REFERENCES `cameriere` (`codiceCameriere`);

--
-- Limiti per la tabella `tavolo`
--
ALTER TABLE `tavolo`
  ADD CONSTRAINT `tavolo_ibfk_1` FOREIGN KEY (`codiceCameriere`) REFERENCES `cameriere` (`codiceCameriere`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

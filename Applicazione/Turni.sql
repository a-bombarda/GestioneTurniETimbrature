-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Set 03, 2018 alle 16:34
-- Versione del server: 10.1.32-MariaDB
-- Versione PHP: 5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

CREATE DATABASE Turni;

USE Turni;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Turni`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `AssegnazioneTurno`
--

CREATE TABLE `AssegnazioneTurno` (
  `IDBadge` varchar(10) NOT NULL,
  `IDTurno` int(11) NOT NULL,
  `Data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Attività`
--

CREATE TABLE `Attività` (
  `IDAttività` int(11) NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `Descrizione` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Attività`
--

INSERT INTO `Attività` (`IDAttività`, `Nome`, `Descrizione`) VALUES
(1, 'MNT-ELT', 'Montaggio parti elettriche'),
(2, 'MNT-MEC', 'Montaggio parti meccaniche'),
(3, 'TEST', 'Test prodotti');

-- --------------------------------------------------------

--
-- Struttura della tabella `Dipendente`
--

CREATE TABLE `Dipendente` (
  `IDBadge` varchar(10) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Cognome` varchar(50) NOT NULL,
  `DataNascita` date NOT NULL,
  `PagaBaseOraria` double(10,0) NOT NULL,
  `OreContrattuali_Settimana` int(11) NOT NULL,
  `EMailAziendale` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Dipendente`
--

INSERT INTO `Dipendente` (`IDBadge`, `Nome`, `Cognome`, `DataNascita`, `PagaBaseOraria`, `OreContrattuali_Settimana`, `EMailAziendale`) VALUES
('00001', 'Paolo', 'Rossi', '2010-10-10', 8, 40, 'paolo.rossi@prova.it'),
('00002', 'Marco', 'Bianchi', '2001-01-01', 8, 40, 'marco.bianchi@prova.it'),
('00003', 'Bruno', 'Neri', '2002-02-02', 8, 40, 'bruno.neri@prova.it'),
('00004', 'Giulio', 'Verdi', '2014-04-04', 8, 40, 'giulio.verdi@prova.it'),
('00005', 'Andrea', 'Bombarda', '1994-04-10', 8, 40, 'a.bombarda@studenti.unibg.it'),
('00006', 'Federica', 'Paravisi', '1994-07-19', 8, 40, 'f.paravisi@studenti.unibg.it'),
('00007', 'Majid', 'Arif', '1993-11-08', 8, 40, 'a.arif@studenti.unibg.it'),
('00008', 'A', 'B', '2018-01-01', 8, 40, 'a.b@prova.it'),
('00009', 'C', 'D', '2018-01-01', 8, 40, 'c.d@prova.it'),
('00010', 'E', 'F', '2018-01-01', 8, 40, 'e.f@prova.it'),
('00011', 'G', 'H', '2018-01-01', 8, 40, 'g.h@prova.it'),
('00012', 'I', 'L', '2018-01-01', 8, 40, 'i.l@prova.it'),
('00013', 'M', 'N', '2018-01-01', 8, 40, 'm.n@prova.it');

-- --------------------------------------------------------

--
-- Struttura della tabella `Fabbisogno_Dipendenti`
--

CREATE TABLE `Fabbisogno_Dipendenti` (
  `IDAttività` int(11) NOT NULL,
  `IDTurno` int(11) NOT NULL,
  `Data` date NOT NULL,
  `N_Dipendenti` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Fabbisogno_Dipendenti`
--

INSERT INTO `Fabbisogno_Dipendenti` (`IDAttività`, `IDTurno`, `Data`, `N_Dipendenti`) VALUES
(1, 1, '2018-01-01', 1),
(1, 1, '2018-01-02', 1),
(1, 1, '2018-01-03', 1),
(1, 1, '2018-01-04', 1),
(1, 1, '2018-01-05', 1),
(1, 1, '2018-01-06', 1),
(1, 1, '2018-01-07', 1),
(1, 2, '2018-01-01', 1),
(1, 2, '2018-01-03', 1),
(1, 2, '2018-01-04', 1),
(1, 2, '2018-01-06', 1),
(1, 2, '2018-01-07', 1),
(1, 2, '2018-04-02', 1),
(1, 2, '2018-04-05', 1),
(1, 3, '2018-01-01', 1),
(1, 3, '2018-01-02', 1),
(1, 3, '2018-01-03', 1),
(1, 3, '2018-01-04', 1),
(1, 3, '2018-01-05', 1),
(1, 3, '2018-01-06', 1),
(1, 3, '2018-01-07', 1),
(2, 1, '2018-01-01', 1),
(2, 1, '2018-01-02', 1),
(2, 1, '2018-01-03', 1),
(2, 1, '2018-01-04', 1),
(2, 1, '2018-01-05', 1),
(2, 1, '2018-01-06', 1),
(2, 1, '2018-01-07', 1),
(2, 2, '2018-01-01', 1),
(2, 2, '2018-01-03', 1),
(2, 2, '2018-01-04', 1),
(2, 2, '2018-01-06', 1),
(2, 2, '2018-01-07', 1),
(2, 2, '2018-04-02', 1),
(2, 2, '2018-04-05', 1),
(2, 3, '2018-01-01', 1),
(2, 3, '2018-01-02', 1),
(2, 3, '2018-01-03', 1),
(2, 3, '2018-01-04', 1),
(2, 3, '2018-01-05', 1),
(2, 3, '2018-01-06', 1),
(2, 3, '2018-01-07', 1),
(3, 1, '2018-01-01', 1),
(3, 1, '2018-01-02', 1),
(3, 1, '2018-01-03', 1),
(3, 1, '2018-01-04', 1),
(3, 1, '2018-01-05', 1),
(3, 1, '2018-01-06', 1),
(3, 1, '2018-01-07', 1),
(3, 2, '2018-01-01', 1),
(3, 2, '2018-01-03', 1),
(3, 2, '2018-01-04', 1),
(3, 2, '2018-01-06', 1),
(3, 2, '2018-01-07', 1),
(3, 2, '2018-04-02', 1),
(3, 2, '2018-04-05', 1),
(3, 3, '2018-01-01', 1),
(3, 3, '2018-01-02', 1),
(3, 3, '2018-01-03', 1),
(3, 3, '2018-01-04', 1),
(3, 3, '2018-01-05', 1),
(3, 3, '2018-01-06', 1),
(3, 3, '2018-01-07', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `Orario`
--

CREATE TABLE `Orario` (
  `IDOrario` int(11) NOT NULL,
  `IDBadge` varchar(10) NOT NULL,
  `Data` date NOT NULL,
  `Ingresso1` time DEFAULT NULL,
  `Uscita1` time DEFAULT NULL,
  `Ingresso2` time DEFAULT NULL,
  `Uscita2` time DEFAULT NULL,
  `Malattia` tinyint(1) DEFAULT NULL,
  `Ferie` tinyint(1) DEFAULT NULL,
  `Ore_Ordinario` double(10,0) DEFAULT NULL,
  `Ore_Straordinario` double(10,0) DEFAULT NULL,
  `Ore_FeriePermessi` double(10,0) DEFAULT NULL,
  `Ore_Malattia` double(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `PrenotazioneStraordinario`
--

CREATE TABLE `PrenotazioneStraordinario` (
  `IDBadge` varchar(10) NOT NULL,
  `IDStraordinario` int(11) NOT NULL,
  `N_Ore` double(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Ruolo`
--

CREATE TABLE `Ruolo` (
  `IDBadge` varchar(10) NOT NULL,
  `IDAttività` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Ruolo`
--

INSERT INTO `Ruolo` (`IDBadge`, `IDAttività`) VALUES
('00001', 1),
('00001', 2),
('00002', 2),
('00002', 3),
('00003', 1),
('00004', 1),
('00004', 3),
('00005', 1),
('00006', 2),
('00007', 3),
('00008', 1),
('00008', 2),
('00009', 3),
('00010', 3),
('00011', 1),
('00011', 2),
('00011', 3),
('00012', 3),
('00013', 1),
('00013', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `Straordinario`
--

CREATE TABLE `Straordinario` (
  `IDStraordinario` int(11) NOT NULL,
  `Data` date NOT NULL,
  `IDAttività` int(11) NOT NULL,
  `N_Ore` double(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Timbratura`
--

CREATE TABLE `Timbratura` (
  `IDTimbratura` int(11) NOT NULL,
  `Data` date NOT NULL,
  `Tipo` varchar(3) NOT NULL,
  `Ora` time NOT NULL,
  `IDBadge` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Turno`
--

CREATE TABLE `Turno` (
  `IDTurno` int(11) NOT NULL,
  `Descrizione` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Turno`
--

INSERT INTO `Turno` (`IDTurno`, `Descrizione`) VALUES
(1, '00-08'),
(2, '08-16'),
(3, '16-24');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `AssegnazioneTurno`
--
ALTER TABLE `AssegnazioneTurno`
  ADD PRIMARY KEY (`IDBadge`,`IDTurno`,`Data`),
  ADD KEY `Turno_AssegnazioneTurno` (`IDTurno`);

--
-- Indici per le tabelle `Attività`
--
ALTER TABLE `Attività`
  ADD PRIMARY KEY (`IDAttività`);

--
-- Indici per le tabelle `Dipendente`
--
ALTER TABLE `Dipendente`
  ADD PRIMARY KEY (`IDBadge`);

--
-- Indici per le tabelle `Fabbisogno_Dipendenti`
--
ALTER TABLE `Fabbisogno_Dipendenti`
  ADD PRIMARY KEY (`IDAttività`,`IDTurno`,`Data`),
  ADD KEY `Fabbisogno_Dipendenti_Turno` (`IDTurno`);

--
-- Indici per le tabelle `Orario`
--
ALTER TABLE `Orario`
  ADD PRIMARY KEY (`IDOrario`),
  ADD KEY `Dipendente_Timbratura` (`IDBadge`);

--
-- Indici per le tabelle `PrenotazioneStraordinario`
--
ALTER TABLE `PrenotazioneStraordinario`
  ADD PRIMARY KEY (`IDBadge`,`IDStraordinario`),
  ADD KEY `PrenotazioneStraordinario_Straordinario` (`IDStraordinario`);

--
-- Indici per le tabelle `Ruolo`
--
ALTER TABLE `Ruolo`
  ADD PRIMARY KEY (`IDBadge`,`IDAttività`),
  ADD KEY `Attività_Ruolo` (`IDAttività`);

--
-- Indici per le tabelle `Straordinario`
--
ALTER TABLE `Straordinario`
  ADD PRIMARY KEY (`IDStraordinario`),
  ADD UNIQUE KEY `UniqueStraordinarioAttività` (`Data`,`IDAttività`),
  ADD KEY `Attività_Straordinario` (`IDAttività`);

--
-- Indici per le tabelle `Timbratura`
--
ALTER TABLE `Timbratura`
  ADD PRIMARY KEY (`IDTimbratura`),
  ADD KEY `Timbratura_Dipendente` (`IDBadge`);

--
-- Indici per le tabelle `Turno`
--
ALTER TABLE `Turno`
  ADD PRIMARY KEY (`IDTurno`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `Attività`
--
ALTER TABLE `Attività`
  MODIFY `IDAttività` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `Orario`
--
ALTER TABLE `Orario`
  MODIFY `IDOrario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4753;

--
-- AUTO_INCREMENT per la tabella `Straordinario`
--
ALTER TABLE `Straordinario`
  MODIFY `IDStraordinario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `Timbratura`
--
ALTER TABLE `Timbratura`
  MODIFY `IDTimbratura` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `Turno`
--
ALTER TABLE `Turno`
  MODIFY `IDTurno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `AssegnazioneTurno`
--
ALTER TABLE `AssegnazioneTurno`
  ADD CONSTRAINT `AssegnazioneTurno_Dipendente` FOREIGN KEY (`IDBadge`) REFERENCES `Dipendente` (`IDBadge`),
  ADD CONSTRAINT `Turno_AssegnazioneTurno` FOREIGN KEY (`IDTurno`) REFERENCES `Turno` (`IDTurno`);

--
-- Limiti per la tabella `Fabbisogno_Dipendenti`
--
ALTER TABLE `Fabbisogno_Dipendenti`
  ADD CONSTRAINT `Fabbisogno_Dipendenti_Attività` FOREIGN KEY (`IDAttività`) REFERENCES `Attività` (`IDAttività`),
  ADD CONSTRAINT `Fabbisogno_Dipendenti_Turno` FOREIGN KEY (`IDTurno`) REFERENCES `Turno` (`IDTurno`);

--
-- Limiti per la tabella `Orario`
--
ALTER TABLE `Orario`
  ADD CONSTRAINT `Dipendente_Timbratura` FOREIGN KEY (`IDBadge`) REFERENCES `Dipendente` (`IDBadge`);

--
-- Limiti per la tabella `PrenotazioneStraordinario`
--
ALTER TABLE `PrenotazioneStraordinario`
  ADD CONSTRAINT `PrenotazioneStraordinario_Dipendente` FOREIGN KEY (`IDBadge`) REFERENCES `Dipendente` (`IDBadge`),
  ADD CONSTRAINT `PrenotazioneStraordinario_Straordinario` FOREIGN KEY (`IDStraordinario`) REFERENCES `Straordinario` (`IDStraordinario`);

--
-- Limiti per la tabella `Ruolo`
--
ALTER TABLE `Ruolo`
  ADD CONSTRAINT `Attività_Ruolo` FOREIGN KEY (`IDAttività`) REFERENCES `Attività` (`IDAttività`),
  ADD CONSTRAINT `Ruolo_Dipendente` FOREIGN KEY (`IDBadge`) REFERENCES `Dipendente` (`IDBadge`);

--
-- Limiti per la tabella `Straordinario`
--
ALTER TABLE `Straordinario`
  ADD CONSTRAINT `Attività_Straordinario` FOREIGN KEY (`IDAttività`) REFERENCES `Attività` (`IDAttività`);

--
-- Limiti per la tabella `Timbratura`
--
ALTER TABLE `Timbratura`
  ADD CONSTRAINT `Timbratura_Dipendente` FOREIGN KEY (`IDBadge`) REFERENCES `Dipendente` (`IDBadge`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

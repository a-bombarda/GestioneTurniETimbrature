-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-05-08 19:36:54.366

-- tables
-- Table: AssegnazioneTurno
CREATE TABLE AssegnazioneTurno (
    IDBadge varchar(10) NOT NULL,
    IDTurno int NOT NULL,
    Data date NOT NULL,
    CONSTRAINT AssegnazioneTurno_pk PRIMARY KEY (IDBadge,IDTurno,Data)
);

-- Table: Dipendente
CREATE TABLE Dipendente (
    IDBadge varchar(10) NOT NULL,
    Nome varchar(50) NOT NULL,
    Cognome varchar(50) NOT NULL,
    DataNascita date NOT NULL,
    PagaBaseOraria double(10,0) NOT NULL,
    OreContrattuali_Settimana int NOT NULL,
    EMailAziendale varchar(80) NOT NULL,
    CONSTRAINT Dipendente_pk PRIMARY KEY (IDBadge)
);

-- Table: Fabbisogno_Dipendenti
CREATE TABLE Fabbisogno_Dipendenti (
    IDAttività int NOT NULL,
    IDTurno int NOT NULL,
    Data date NOT NULL,
    N_Dipendenti int NOT NULL,
    CONSTRAINT Fabbisogno_Dipendenti_pk PRIMARY KEY (IDAttività,IDTurno,Data)
);

-- Table: Attività
CREATE TABLE Attività (
    IDAttività int NOT NULL AUTO_INCREMENT,
    Nome varchar(100) NOT NULL,
    Descrizione text NOT NULL,
    CONSTRAINT Attività_pk PRIMARY KEY (IDAttività)
);

-- Table: Orario
CREATE TABLE Orario (
    IDOrario int NOT NULL AUTO_INCREMENT,
    IDBadge varchar(10) NOT NULL,
    Data date NOT NULL,
    Ingresso1 time,
    Uscita1 time,
    Ingresso2 time,
    Uscita2 time,
    Malattia bool,
    Ferie bool,
    Ore_Ordinario real(10,0),
    Ore_Straordinario real(10,0),
    Ore_FeriePermessi real(10,0),
    Ore_Malattia real(10,0),
    CONSTRAINT Orario_pk PRIMARY KEY (IDOrario)
);

-- Table: PrenotazioneStraordinario
CREATE TABLE PrenotazioneStraordinario (
    IDBadge varchar(10) NOT NULL,
    IDStraordinario int NOT NULL,
    N_Ore real(10,0) NOT NULL,
    CONSTRAINT PrenotazioneStraordinario_pk PRIMARY KEY (IDBadge,IDStraordinario)
);

-- Table: Ruolo
CREATE TABLE Ruolo (
    IDBadge varchar(10) NOT NULL,
    IDAttività int NOT NULL,
    CONSTRAINT Ruolo_pk PRIMARY KEY (IDBadge, IDAttività)
);

-- Table: Straordinario
CREATE TABLE Straordinario (
    IDStraordinario int NOT NULL AUTO_INCREMENT,
    Data date NOT NULL,
    IDAttività int NOT NULL,
    N_Ore real(10,0) NOT NULL,
    UNIQUE INDEX UniqueStraordinarioAttività (Data, IDAttività),
    CONSTRAINT Straordinario_pk PRIMARY KEY (IDStraordinario)
);

-- Table: Timbratura
CREATE TABLE Timbratura (
    IDTimbratura int NOT NULL AUTO_INCREMENT,
    Data date NOT NULL,
    Tipo varchar(3) NOT NULL,
    Ora time NOT NULL,
    IDBadge varchar(10) NOT NULL,
    CONSTRAINT Timbratura_pk PRIMARY KEY (IDTimbratura)
);

-- Table: Turno
CREATE TABLE Turno (
    IDTurno int NOT NULL AUTO_INCREMENT,
    Descrizione varchar(50) NOT NULL,
    CONSTRAINT Turno_pk PRIMARY KEY (IDTurno)
);

-- foreign keys
-- Reference: AssegnazioneTurno_Dipendente (table: AssegnazioneTurno)
ALTER TABLE AssegnazioneTurno ADD CONSTRAINT AssegnazioneTurno_Dipendente FOREIGN KEY AssegnazioneTurno_Dipendente (IDBadge)
    REFERENCES Dipendente (IDBadge);

-- Reference: Dipendente_Timbratura (table: Orario)
ALTER TABLE Orario ADD CONSTRAINT Dipendente_Timbratura FOREIGN KEY Dipendente_Timbratura (IDBadge)
    REFERENCES Dipendente (IDBadge);

-- Reference: Fabbisogno_Dipendenti_Attività (table: Fabbisogno_Dipendenti)
ALTER TABLE Fabbisogno_Dipendenti ADD CONSTRAINT Fabbisogno_Dipendenti_Attività FOREIGN KEY Fabbisogno_Dipendenti_Attività (IDAttività)
    REFERENCES Attività (IDAttività);

-- Reference: Fabbisogno_Dipendenti_Turno (table: Fabbisogno_Dipendenti)
ALTER TABLE Fabbisogno_Dipendenti ADD CONSTRAINT Fabbisogno_Dipendenti_Turno FOREIGN KEY Fabbisogno_Dipendenti_Turno (IDTurno)
    REFERENCES Turno (IDTurno);

-- Reference: Attività_Ruolo (table: Ruolo)
ALTER TABLE Ruolo ADD CONSTRAINT Attività_Ruolo FOREIGN KEY Attività_Ruolo (IDAttività)
    REFERENCES Attività (IDAttività);

-- Reference: Attività_Straordinario (table: Straordinario)
ALTER TABLE Straordinario ADD CONSTRAINT Attività_Straordinario FOREIGN KEY Attività_Straordinario (IDAttività)
    REFERENCES Attività (IDAttività);

-- Reference: PrenotazioneStraordinario_Dipendente (table: PrenotazioneStraordinario)
ALTER TABLE PrenotazioneStraordinario ADD CONSTRAINT PrenotazioneStraordinario_Dipendente FOREIGN KEY PrenotazioneStraordinario_Dipendente (IDBadge)
    REFERENCES Dipendente (IDBadge);

-- Reference: PrenotazioneStraordinario_Straordinario (table: PrenotazioneStraordinario)
ALTER TABLE PrenotazioneStraordinario ADD CONSTRAINT PrenotazioneStraordinario_Straordinario FOREIGN KEY PrenotazioneStraordinario_Straordinario (IDStraordinario)
    REFERENCES Straordinario (IDStraordinario);

-- Reference: Ruolo_Dipendente (table: Ruolo)
ALTER TABLE Ruolo ADD CONSTRAINT Ruolo_Dipendente FOREIGN KEY Ruolo_Dipendente (IDBadge)
    REFERENCES Dipendente (IDBadge);

-- Reference: Timbratura_Dipendente (table: Timbratura)
ALTER TABLE Timbratura ADD CONSTRAINT Timbratura_Dipendente FOREIGN KEY Timbratura_Dipendente (IDBadge)
    REFERENCES Dipendente (IDBadge);

-- Reference: Turno_AssegnazioneTurno (table: AssegnazioneTurno)
ALTER TABLE AssegnazioneTurno ADD CONSTRAINT Turno_AssegnazioneTurno FOREIGN KEY Turno_AssegnazioneTurno (IDTurno)
    REFERENCES Turno (IDTurno);

-- End of file.


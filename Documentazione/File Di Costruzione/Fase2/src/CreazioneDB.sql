CREATE DATABASE Turni;

USE Turni;

CREATE TABLE AssegnazioneTurno (
    IDBadge varchar(10) NOT NULL,
    IDTurno int NOT NULL,
    Data date NOT NULL,
    CONSTRAINT AssegnazioneTurno_pk PRIMARY KEY (IDBadge,IDTurno,Data)
);

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

CREATE TABLE Fabbisogno_Dipendenti (
    IDAttivita int NOT NULL,
    IDTurno int NOT NULL,
    Data date NOT NULL,
    N_Dipendenti int NOT NULL,
    CONSTRAINT Fabbisogno_Dipendenti_pk PRIMARY KEY (IDAttivita,IDTurno,Data)
);

CREATE TABLE Attivita (
    IDAttivita int NOT NULL AUTO_INCREMENT,
    Nome varchar(100) NOT NULL,
    Descrizione text NOT NULL,
    CONSTRAINT Attivita_pk PRIMARY KEY (IDAttivita)
);

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

CREATE TABLE PrenotazioneStraordinario (
    IDBadge varchar(10) NOT NULL,
    IDStraordinario int NOT NULL,
    N_Ore real(10,0) NOT NULL,
    CONSTRAINT PrenotazioneStraordinario_pk PRIMARY KEY (IDBadge,IDStraordinario)
);

CREATE TABLE Ruolo (
    IDBadge varchar(10) NOT NULL,
    IDAttivita int NOT NULL,
    CONSTRAINT Ruolo_pk PRIMARY KEY (IDBadge, IDAttivita)
);

CREATE TABLE Straordinario (
    IDStraordinario int NOT NULL AUTO_INCREMENT,
    Data date NOT NULL,
    IDAttivita int NOT NULL,
    N_Ore real(10,0) NOT NULL,
    UNIQUE INDEX UniqueStraordinarioAttivita (Data, IDAttivita),
    CONSTRAINT Straordinario_pk PRIMARY KEY (IDStraordinario)
);

CREATE TABLE Timbratura (
    IDTimbratura int NOT NULL AUTO_INCREMENT,
    Data date NOT NULL,
    Tipo varchar(3) NOT NULL,
    Ora time NOT NULL,
    IDBadge varchar(10) NOT NULL,
    CONSTRAINT Timbratura_pk PRIMARY KEY (IDTimbratura)
);

CREATE TABLE Turno (
    IDTurno int NOT NULL AUTO_INCREMENT,
    Descrizione varchar(50) NOT NULL,
    CONSTRAINT Turno_pk PRIMARY KEY (IDTurno)
);


ALTER TABLE AssegnazioneTurno ADD CONSTRAINT AssegnazioneTurno_Dipendente FOREIGN KEY AssegnazioneTurno_Dipendente (IDBadge)
    REFERENCES Dipendente (IDBadge);

ALTER TABLE Orario ADD CONSTRAINT Dipendente_Timbratura FOREIGN KEY Dipendente_Timbratura (IDBadge)
    REFERENCES Dipendente (IDBadge);

ALTER TABLE Fabbisogno_Dipendenti ADD CONSTRAINT Fabbisogno_Dipendenti_Attivita FOREIGN KEY Fabbisogno_Dipendenti_Attivita (IDAttivita)
    REFERENCES Attivita (IDAttivita);

ALTER TABLE Fabbisogno_Dipendenti ADD CONSTRAINT Fabbisogno_Dipendenti_Turno FOREIGN KEY Fabbisogno_Dipendenti_Turno (IDTurno)
    REFERENCES Turno (IDTurno);

ALTER TABLE Ruolo ADD CONSTRAINT Attivita_Ruolo FOREIGN KEY Attivita_Ruolo (IDAttivita)
    REFERENCES Attivita (IDAttivita);

ALTER TABLE Straordinario ADD CONSTRAINT Attivita_Straordinario FOREIGN KEY Attivita_Straordinario (IDAttivita)
    REFERENCES Attivita (IDAttivita);

ALTER TABLE PrenotazioneStraordinario ADD CONSTRAINT PrenotazioneStraordinario_Dipendente FOREIGN KEY PrenotazioneStraordinario_Dipendente (IDBadge)
    REFERENCES Dipendente (IDBadge);

ALTER TABLE PrenotazioneStraordinario ADD CONSTRAINT PrenotazioneStraordinario_Straordinario FOREIGN KEY PrenotazioneStraordinario_Straordinario (IDStraordinario)
    REFERENCES Straordinario (IDStraordinario);

ALTER TABLE Ruolo ADD CONSTRAINT Ruolo_Dipendente FOREIGN KEY Ruolo_Dipendente (IDBadge)
    REFERENCES Dipendente (IDBadge);

ALTER TABLE Timbratura ADD CONSTRAINT Timbratura_Dipendente FOREIGN KEY Timbratura_Dipendente (IDBadge)
    REFERENCES Dipendente (IDBadge);

ALTER TABLE AssegnazioneTurno ADD CONSTRAINT Turno_AssegnazioneTurno FOREIGN KEY Turno_AssegnazioneTurno (IDTurno)
    REFERENCES Turno (IDTurno);


DROP SCHEMA IF EXISTS oblig4;
CREATE SCHEMA oblig4;
SET search_path TO oblig4;

CREATE TABLE KUNDE_NY(
	
	knr INTEGER PRIMARY KEY
	kunde_xml xml
	
); 

INSERT INTO kunde_ny(knr, kunde_xml)
SELECT knr, xmlelement
(NAME kunde, xmlforest(
	fornavn AS fornavn,
	etternavn AS etternavn,
	adresse AS adresse,
	postnr AS postnr))
	AS kunde_xml
	FROM KUNDE;
	
	-- xmlelement = selve elementet
	-- xmlforest = underelementer/atrbiutter under elementet
	-- NAME  = navnet til tabellen kunden er i


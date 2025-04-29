
SET SEARCH_PATH TO oblig4;

SELECT json_build_object(
	'knr', k.knr,
	'fornavn', k.fornavn,
	'etternavn', k.etternavn,
	'adresse', k.adresse,
	'postnr', k.postnr,
	'adresse', k.adresse	
) AS json_kunde

FROM kunde k

JOIN poststed p ON k.postnr= p.postnr;
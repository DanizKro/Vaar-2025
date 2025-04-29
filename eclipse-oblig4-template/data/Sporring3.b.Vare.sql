SET SEARCH_PATH TO oblig4;

SELECT json_build_object(
	'vnr', v.vnr,
	'betegnelse', v.betegnelse,
	'pris', v.pris,
	'kategori',json_build_object(
		'katnr',k.katnr,
		'navn', k.navn
	),
	'antall', v.antall,
	'hylle', v.hylle
) AS vare_json
FROM vare v
LEFT JOIN kategori k ON v.katnr = k.katnr;

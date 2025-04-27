SELECT 
	json_build_object(
		'ordrenr', o.ordrenr,
		'ordredato', o.ordredato,
		'betaltdato', o.betaltdato,
		'knr', o.knr,
		'ordrelinjer', json_agg(			
			json_build_object(
				'vnr', ol.vnr,
				'prisprenhet', ol.prisprenhet,
				'antall', ol.antall
			)
		)
	) AS ordre_json
FROM ORDRE o
LEFT JOIN ordrelinje ol ON o.ordrenr = ol.ordrenr 
GROUP BY o.ordrenr, o.ordredato, o.sendtdato, o.betaltdato, o.knr;
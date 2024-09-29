SELECT 
    FI.ID,
    FN.FISH_NAME,
    FI.LENGTH
FROM 
    FISH_INFO FI
JOIN 
    FISH_NAME_INFO FN
ON 
    FI.FISH_TYPE = FN.FISH_TYPE
WHERE 
    (FI.FISH_TYPE, FI.LENGTH) IN (
        SELECT 
            FISH_TYPE, MAX(LENGTH)
        FROM 
            FISH_INFO
        WHERE 
            LENGTH IS NOT NULL
        GROUP BY 
            FISH_TYPE
    )
ORDER BY 
    FI.ID;

-- PROCEDIMIENTO PARA ACTUALIZAR TABACO
DELIMITER |
CREATE PROCEDURE spActualizarTabaco(
IDENTIFICADOR int(11),
idMarca_mod int(11),
idSabor_mod int (11),
Gramos_mod int(11),
Precio_mod int(11),
Unidades_mod int (11)
)
BEGIN
UPDATE tabacosdecachimba SET
idTabacosdecachimba=IDENTIFICADOR,
idMarca=idMarca_mod,
idSabor=idSabor_mod,
Gramos=Gramos_mod,
Precio=Precio_mod,
Unidades=Unidades_mod
	WHERE IDENTIFICADOR=idTabacosdecachimba;
    END |
DELIMITER ;

-- PROCEDIMIENTO PARA AÑADIR TABACO 
DELIMITER |
CREATE PROCEDURE spTabacoNuevo(
idTabacosdecachimba int (11),
idMarca int (11),
idSabor int (11),
Gramos int (11),
Precio int (11),
Unidades int (11)
)
BEGIN
	INSERT INTO tabacosdecachimba (idTabacosdecachimba,idMarca,idSabor,Gramos,Precio,Unidades)
				VALUES (idTabacosdecachimba,idMarca,idSabor,Gramos,Precio,Unidades);
                
    END |
DELIMITER ;
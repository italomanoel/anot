DECLARE @numedido INT;
SET @numedido = 5; --colocar a quantidade atualizadas.

IF (SELECT COUNT(coluna_exemplo) FROM tabela_exemplo) != @numedido
BEGIN
TRUNCATE TABLE tabela_exemplo 
SET IDENTITY_INSERT [dbo].[tabela_exemplo] ON 
INSERT tabela_exemplo (coluna_exemplo) value (1)
SET IDENTITY_INSERT [dbo].[tabela_exemplo] OFF
END
ELSE SELECT COUNT(coluna_exemplo) as quantidade from tabela_exemplo;

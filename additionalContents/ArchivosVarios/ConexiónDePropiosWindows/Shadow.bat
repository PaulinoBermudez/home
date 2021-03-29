@echo off
 set /P rhost="Introduce Nombre o IP del Host: "
 query session /server:%rhost%
 set /P rid="Introduce el RDP de la ID de Usuario: "
 start mstsc /shadow:%rid% /v:%rhost% /control
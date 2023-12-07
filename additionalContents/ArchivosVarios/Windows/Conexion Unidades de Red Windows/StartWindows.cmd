Rem +----------------------------------------------------------------------------------------+ 
Rem + ECHO: Mostrará mensajes en la pantalla, podemos activar o desactivar command-echoing.  +
Rem + Desactivaremos con Echo off.                                                           +
Rem +----------------------------------------------------------------------------------------+

Echo Off

Rem +----------------------------------------------------------------------------------------+
Rem + En primer lugar conectaremos las unidades de red que sean genéricas                    +
Rem + para todos los usuarios del dominio.                                                   +
Rem + En nuestro ejemplo conectaremos las unidades de usuario y usaremos la variable         +
Rem + de entorno %username% en lugar de escribir el nombre del usuario directamente,         +
Rem + como las carpetas compartidas tienen el mismo nombre que los usuarios se               +
Rem + conectarán sin problemas.                                                              +
Rem +----------------------------------------------------------------------------------------+

Rem + UNIDAD U - Unidad para cada usuario del dominio
Net Use U: \\EMPRESA-NAME\%username% /Persistent:Yes
Rem + UNIDAD N - Unidad de almacenamiento en el servidor
net use N: \\SERVER-NAME-2\usuarios\%username% /Persistent:Yes
REM + UNIDAD S - Unidad para Escaner de impresora
Net Use S: \\SERVER-NAME-1\EMPRESA-NAME\PUBLICAS\scaner\%username%

Rem +----------------------------------------------------------------------------------------+
Rem - Ejecutamos las condiciones, si el contenido de la variable %usename% es igual al       +  
Rem - Nombre del usuario saltaremos a la etiqueta donde conectaremos                         + 
Rem - las unidades personalizadas del cliente.                                               + 
Rem +----------------------------------------------------------------------------------------+

If %username% == srivera Goto Etiqueta-Usuario01
If %username% == pesteban Goto Etiqueta-Usuario02
If %username% == fjardon Goto Etiqueta-Usuario03
Goto Fin

Rem +----------------------------------------------------------------------------------------+
Rem + Conectaremos las unidades de red especificas de cada usuario.                          +
Rem + Finalizada la configuración saltaremos a la etiqueta Fin para terminar.                +
Rem +----------------------------------------------------------------------------------------+

:Etiqueta-Usuario01
Net Use M: \\SERVER-NAME-1\EMPRESA-NAME\DEPARTAMENTOS\DPTO-CALIDAD /Y
Net Use O: \\SERVER-NAME-1\EMPRESA-NAME\DEPARTAMENTOS /Y
Net Use P: \\SERVER-NAME-1\EMPRESA-NAME\PUBLICAS /Y
Net Use V: \\SERVER-NAME-2\PUBLICAS /Y
Net Use W: \\SERVER-NAME-1\EMPRESA-NAME\DEPARTAMENTOS\Humedad Compra /Y
Net Use X: \\pcrecla\trazab /Y
Net Use Y: \\pcrecla\total /Y
Net Use Z: \\SERVER-NAME-1\DEPARTAMENTOS\LOGISTICA /Y
Goto Fin

:Etiqueta-Usuario02
Net Use M: \\SERVER-NAME-BACKUP\BACKUP INFORMATICA /Y 
Goto Fin

:Etiqueta-Usuario03
Net Use M: \\SERVER-NAME-2\DEPARTAMENTOS /Y
Net Use O: \\SERVER-NAME-1\PUBLICAS\COMUN_RRHH /Y
Net Use P: \\SERVER-NAME-2\PUBLICAS /Y
Net Use Z: \\SERVER-NAME-1\EMPRESA-NAME\USUARIOS\usuario_especifico /Y
Goto Fin

:Fin
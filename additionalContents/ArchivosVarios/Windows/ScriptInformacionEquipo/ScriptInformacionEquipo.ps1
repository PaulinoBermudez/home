# Variables del SO.
$instanciaP = Get-CimInstance -ClassName Win32_Processor
$instanciaB = Get-CimInstance -ClassName Win32_BIOS
$instanciaR = Get-WmiObject Win32_PhysicalMemory
$instanciaD = Get-Disk
$instanciaL = Get-NetAdapter -Physical | Format-Table Name, Status 
$instanciaL2 = Get-WmiObject Win32_NetworkAdapterConfiguration | Format-Table DHCPEnabled, IPAddress, DNSDomain

# Variables del Script.
$escritorio = $instanciaP.caption
$usuarios = $instanciaP | Select-Object -Property *user*
$procesador = ($instanciaP.name).split("@")[1]
$ram = $instanciaR | Select-Object Name, Model, Manufacturer, MemoryType, Speed, ConfiguredVoltage,  BankLabel, @{Name = "Capacity, GB"; Expression = {$ _. Capacity / 1GB}}
$ramMax = wmic memphysical | Select-Object Name, MaxCapacity, MemoryDevices, SerialNumber, Status
$disco = $instanciaD | Format-Table Number, Friendly Name, Total Size, Partition Style
$bios = $instanciaB
$placa = (Get-WmiObject Win32_BaseBoard).Manufacturer
$modelo = (Get-WmiObject Win32_SystemEnclosure).SerialNumber
$actualizacion = Get-CimInstance -ClassName Win32_QuickFixEngineering -Property HotFixId | Select-Object -Property HotFixId | Format-Table 
$listaProgramas = Get-WmiObject Win32_Product | Sort-Object Name | Format-Table Name, Version, Vendor


# Script - Información del equipo.
Write-Host "---------------------------------" -ForegroundColor DarkYellow
Write-Host " INFORMACIÓN GENERAL DEL EQUIPO."  -BackgroundColor Cyan
Write-Host "---------------------------------" -ForegroundColor DarkYellow

# _____________________________________________________________________
Write-Host "Informacion de escritorio."
$escritorio
# _____________________________________________________________________
Write-Host "--"
Write-Host " Usuarios locales y propietario " -BackgroundColor Green
$usuarios
# _____________________________________________________________________
Write-Host "--"
Write-Host " BIOS. " -BackgroundColor Green
$bios
# _____________________________________________________________________
Write-Host "--"
Write-Host " Procesador. " -BackgroundColor Green
$procesador
# _____________________________________________________________________
Write-Host "--"
Write-Host " RAM " -BackgroundColor Green
$ram
$ramMax
# _____________________________________________________________________
Write-Host "--"
Write-Host " Disco duro " -BackgroundColor Green
$disco
# _____________________________________________________________________

Write-Host "--"
Write-Host " Enumerar modelo y fabricante del equipo. " -BackgroundColor Green
$placa
$modelo
# _____________________________________________________________________
Write-Host "--"
Write-Host " Última actualización instalada. " -BackgroundColor Green
$actualizacion


Write-Host "--"
Write-Host "  " -BackgroundColor Green


Write-Host "--"
Write-Host " Programas instalados. " -BackgroundColor Green


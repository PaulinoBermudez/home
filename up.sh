#!/bin/bash
echo "Subida con script"
git pull
git add additionalContents/*
git nota "Contenidos"
# New line

git add assets/*
git nota "Configuraciones y estilos"
# New line

git audio/*
git nota "Audio"
# New line

git add css/*
git nota "css bootstrap"
# New line

git add images/* 
git nota "Imagenes de contenido"
# New line

git add index.html
git nota "Home page"
# New line

git add js/*
git nota "JavaScript sheet of paper"
# New line 

git add errores/* 
git nota "Error pages"
# New line

git add mantenimiento.html
git nota "Pagina de mantenimiento"
# New line

git add index-mantenimiento.html
git nota "Pagina de mantenimiento"
# New line

git add sitemap.xml
git nota "sitemap del sitio registrado en GoogleAds."
git add robots.txt
git nota "Configuración de los Bots de indexación de Google"
# New line

git add noscript.css 
git nota "noscript of css"
# New line

git add favicon.ico
git nota "Favicon image"
# New line

git add up.sh 
git nota "Auto-eject system script -> GitHub"
# New line 

git add * 
git nota "Other folderes"
# New line
git sube 

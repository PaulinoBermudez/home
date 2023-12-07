#pragma once

typedef struct almacenes { // Estructura para guardar datos de pedido.

    void altaAlmacen();

    int codigo;
    char calle[50];
    char municipio[50];
    char provincia[20];
    char descripcion[50];

};

int almacen, longitud, o;
char almacenN, datoscorrectos;
int contadoralmacen = 1;
typedef almacenes Talmecen[10];
Talmacen almacen;
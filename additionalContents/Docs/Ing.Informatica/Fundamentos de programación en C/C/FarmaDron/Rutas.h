#pragma once

typedef struct rutas
{
    void programarRutas();
    void dibujarRutas();
    int numRutas;
    int pesoTotalPedidoR;
};

int i,j,k,array[20], peso, distance, anguloIni, aux, ps, distRuta, maxDist, maxPeso, pesoMaxRuta, distMaxRuta, anguloFin, vector, u, l;
float w;
char nombre[20];

typedef rutas CRutas[5];
CRutas ruta;
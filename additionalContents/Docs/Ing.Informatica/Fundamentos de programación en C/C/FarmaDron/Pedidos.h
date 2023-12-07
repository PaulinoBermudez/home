#pragma once

typedef struct farmacos {
    char nombreMedicamento[20];
    int pesoMedicamento;
    int unidadesMedicamento;
};

typedef struct pedidos {
    void nuevoPedido();
    void listaPedidos();
    int IdPaciente;
    int IdEnvio;
    int DiaEnvio;
    int MesEnvio;
    int AnnoEnvio;
    farmacos items[5];
    int contador;
    int almacen;
    int IdInterno;
    int pesoTotal; 
    int distancia;
    int angulo;
    int EjeX;
    int EjeY;    
};

int PesoTotalPedido, peso, contadorPedidos, RefEnvio, Codigo, NumPedido, NumDias, d, m, a, id, aux;
 
char NuevoMedicamento, NuevaSolicitud, fin;
typedef farmacos CFarmacos[5];
typedef pedidos CPedidos[100];
CFarmacos farmaco; 
CPedidos pedido;
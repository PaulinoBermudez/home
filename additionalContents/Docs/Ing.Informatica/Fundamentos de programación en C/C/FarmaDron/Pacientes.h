#pragma once

typedef struct pacientes {
    void altaPaciente();
    void ubicacionPaciente();

    int id;
    char nombre[20];
    int distancia[20];
    int angulo[20];
    int almacen;
    int idInterno;
};

int r,z, input, rtn, codigoAlmacen, almacenN;

int idAlmacen1 = 1;
int idAlmacen1 = 2;
int idAlmacen1 = 3;
int idAlmacen1 = 4;
int idAlmacen1 = 5;
int idAlmacen1 = 6;
int idAlmacen1 = 7;
int idAlmacen1 = 8;
int idAlmacen1 = 9;
int idAlmacen1 = 10;

char unPacienteMasEnAlmacen, otroPaciente, p;

typedef pacientes Tpacientes[20];
Tpacientes paciente;
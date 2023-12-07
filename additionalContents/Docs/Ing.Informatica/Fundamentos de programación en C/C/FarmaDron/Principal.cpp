#include "Almacenes.cpp"
#include "Calendario.cpp"
#include "Iniciargestion.cpp"
#include "Pacientes.cpp"
#include "Pedidos.cpp"
#include "Rutas.cpp"
#include <math.h>

char Entrada;
float cant;
int main() {
    pedidos ped; 
    paciente pac;
    calendario cal;
    iniciargestion ini;
    almacenes alm;
    rutas rut;
    do
    {
        printf("    GESTION DE FARMADRON. Distribucion de farmacos. \n");
        printf(" 1- Iniciar gestion. (Pulse I). \n");
        printf(" 2- Alta almacen. (Pulse M)\n");
        printf(" 3- Alta paciente almacen                (Pulsar A)\n");
        printf(" 4-Ubicar pacientes                     (Pulsar U)\n");
        printf(" 5-Nuevo Pedido                         (Pulsar N)\n");
        printf(" 6-Lista Diaria de pedidos              (Pulsar L)\n");
        printf(" 7-Programar rutas diarias del dron     (Pulsar P)\n");
        printf(" 8-Representar rutas diarias del dron   (Pulsar R)\n");
        printf(" 9-Calendario mensual de pedidos        (Pulsar C)\n");
        printf(" 0-Salir                                (Pulsar S)\n");

          printf("Teclear una opci%cn v%clida (I|M|A|U|N|L|P|R|C|S)?\n", 162, 160);

        scanf(" %[^\n]c", &Entrada);
        if (Entrada == 'A' || Entrada == 'a') {
            Entrada = 'A';
        } else if (Entrada == 'U' || Entrada == 'u') {
            Entrada = 'U';
        } else if (Entrada == 'N' || Entrada == 'n') {
            Entrada = 'N';
        } else if (Entrada == 'L' || Entrada == 'l') {
            Entrada = 'L';
        } else if (Entrada == 'C' || Entrada == 'c') {
            Entrada = 'C';
        } else if (Entrada == 'S' || Entrada == 's') {
            Entrada = 'S';
        } else if (Entrada == 'I' || Entrada == 'i') {
            Entrada = 'I';
        } else if (Entrada == 'M' || Entrada == 'm') {
            Entrada = 'M';
        } else if (Entrada == 'P' || Entrada == 'p') {
            Entrada = 'P';
        } else if (Entrada == 'R' || Entrada == 'r') {
            Entrada = 'R';
        }
        switch (Entrada) {
            case 'A': pac.altaPaciente(); break;
            case 'U': pac.ubicarPaciente(); break;
            case 'N': ped.nuevoPedido(); break;
            case 'L': ped.listarPedidos(); break;
            case 'I': ini.iniciarGestion(); break;
            case 'M': alm.altaAlmacen(); break;
            case 'P': rut.programarRutas(); break;
            case 'R': rut.dibujarRutas(); break;
            case 'C': cal.calendarioMensual(); break;
            case 'S': printf("FIN DEL PROGRAMA. \n"); break;
        }

    } while (Entrada != 'S');
    printf("\n\n");
}
#include <stdio.h>
#include "Iniciargestion.h"
#include "Pedidos.h"
#include "Almacenes.h"

void iniciargestion::inigiarGestion(){
    if ( check == 0){
        contadorpaciente = 0;
        
        almacen[contadoralmacen].codigo = 1;
        almacen[contadoralmacen+1].codigo = 2;
        almacen[contadoralmacen+2].codigo = 3;
        almacen[contadoralmacen+3].codigo = 4;
        almacen[contadoralmacen+4].codigo = 5;
        
        strcpy(almacen[contadoralmacen].calle, "C/ Coronel 5");
        strcpy(almacen[contadoralmacen+1].calle, "Avda Caceres 29");
        strcpy(almacen[contadoralmacen+2].calle, "C/ Vigo, 12");
        strcpy(almacen[contadoralmacen+3].calle, "C/ Castellana 50");
        strcpy(almacen[contadoralmacen+4].calle, "Urbanizacion 12, Val");

        strcpy(almacen[contadoralmacen].municipio, "Cáceres");
        strcpy(almacen[contadoralmacen+1].municipio, "Cáceres");
        strcpy(almacen[contadoralmacen+2].municipio, "Cáceres");
        strcpy(almacen[contadoralmacen+3].municipio, "Cáceres");
        strcpy(almacen[contadoralmacen+4].municipio, "Cáceres");
        
        strcpy(almacen[contadoralmacen+4].provincia, "Extremadura");
        strcpy(almacen[contadoralmacen+4].provincia, "Extremadura");
        strcpy(almacen[contadoralmacen+4].provincia, "Extremadura");
        strcpy(almacen[contadoralmacen+4].provincia, "Extremadura");
        strcpy(almacen[contadoralmacen+4].provincia, "Extremadura");
        
        strcpy(almacen[contadoralmacen+4].municipio, "Almacén central de Calle Coronel, Caceres");
        strcpy(almacen[contadoralmacen+4].municipio, "Almacén central de Avenida Caceres, Caceres");
        strcpy(almacen[contadoralmacen+4].municipio, "Almacén central de Calle Vigo, Caceres");
        strcpy(almacen[contadoralmacen+4].municipio, "Almacén central de Calle Castellana, Caceres");
        strcpy(almacen[contadoralmacen+4].municipio, "Almacén central de urbanizaciones las nieves. Caceres");
        
        contadoralmacen += 5;

        /* Paciente 1. Almacen 1 */
        strcpy(paciente[contadorpaciente].nombre, "Steven Gonzales");
        paciente[contadorpaciente].distancia = 2030;
        paciente[contadorpaciente].angulo = 280;
        paciente[contadorpaciente].almacen = 1;
        paciente[contadorpaciente].IdInterno = Idalmacen1;
        paciente[contadorpaciente].Id = contadorpaciente+1;
        contadorId++;
        Idalmacen1++;
        contadorpaciente++;
        /* Paciente 2. - Almacen 1 */
        strcpy(paciente[contadorpaciente].nombre, "Hugo Martinez");
        paciente[contadorpaciente].distancia = 3200;
        paciente[contadorpaciente].angulo = 1200;
        paciente[contadorpaciente].almacen = 1;
        paciente[contadorpaciente].IdInterno = Idalmacen1;
        paciente[contadorpaciente].Id = contadorpaciente+1;
        contadorId++;
        Idalmacen1++;
        contadorpaciente++;
        /* Paciente 1. Almacen 2*/
        strcpy(paciente[contadorpaciente].nombre, "India Nunez");
        paciente[contadorpaciente].distancia = 8800;
        paciente[contadorpaciente].angulo = 10;
        paciente[contadorpaciente].almacen = 2;
        paciente[contadorpaciente].IdInterno = Idalmacen2;
        paciente[contadorpaciente].Id = contadorpaciente+1;
        contadorId++;
        Idalmacen1++;
        contadorpaciente++;
        /* Paciente 2. Almacen 2*/
        strcpy(paciente[contadorpaciente].nombre, "Javier Rodriguez");
        paciente[contadorpaciente].distancia = 999;
        paciente[contadorpaciente].angulo = 999;
        paciente[contadorpaciente].almacen = 2;
        paciente[contadorpaciente].IdInterno = Idalmacen2;
        paciente[contadorpaciente].Id = contadorpaciente+1;
        contadorId++;
        Idalmacen1++;
        contadorpaciente++;
        /* Paciente 1. Almacen 3*/
        strcpy(paciente[contadorpaciente].nombre, "Paquita Lopez");
        paciente[contadorpaciente].distancia = 2193;
        paciente[contadorpaciente].angulo = 2134;
        paciente[contadorpaciente].almacen = 3;
        paciente[contadorpaciente].IdInterno = Idalmacen3;
        paciente[contadorpaciente].Id = contadorpaciente+1;
        contadorId++;
        Idalmacen1++;
        contadorpaciente++;
        /* Paciente 2. Almacen 3*/
        strcpy(paciente[contadorpaciente].nombre, "Daniela Suarez");
        paciente[contadorpaciente].distancia = 1265;
        paciente[contadorpaciente].angulo = 478;
        paciente[contadorpaciente].almacen = 3;
        paciente[contadorpaciente].IdInterno = Idalmacen3;
        paciente[contadorpaciente].Id = contadorpaciente+1;
        contadorId++;
        Idalmacen1++;
        contadorpaciente++;

        // Contador de dias de envio de un pedido
        pedido[contadorpedidos].DiaEnvio = 1;
        pedido[contadorpedidos+1].DiaEnvio = 12;
        pedido[contadorpedidos+2].DiaEnvio = 4;
        pedido[contadorpedidos+3].DiaEnvio = 10;
        pedido[contadorpedidos+4].DiaEnvio = 12;
        pedido[contadorpedidos+5].DiaEnvio = 11;
        pedido[contadorpedidos+6].DiaEnvio = 20;
        pedido[contadorpedidos+7].DiaEnvio = 17;
        pedido[contadorpedidos+8].DiaEnvio = 6;
        pedido[contadorpedidos+9].DiaEnvio = 21;
        pedido[contadorpedidos+10].DiaEnvio = 7;
        pedido[contadorpedidos+11].DiaEnvio = 18;

        // contador de mes de envio de pedido        
        pedido[contadorpedidos].MesEnvio = 12;
        pedido[contadorpedidos+1].DiaEnvio = 2;
        pedido[contadorpedidos+2].DiaEnvio = 1;
        pedido[contadorpedidos+3].DiaEnvio = 1;
        pedido[contadorpedidos+4].DiaEnvio = 2;
        pedido[contadorpedidos+5].DiaEnvio = 4;
        pedido[contadorpedidos+6].DiaEnvio = 4;
        pedido[contadorpedidos+7].DiaEnvio = 3;
        pedido[contadorpedidos+8].DiaEnvio = 3;
        pedido[contadorpedidos+9].DiaEnvio = 1;
        pedido[contadorpedidos+10].DiaEnvio = 2;
        pedido[contadorpedidos+11].DiaEnvio = 2;

        // Contador del año de envio de un pedido
        pedido[contadorpedidos].DiaEnvio = 2021;
        pedido[contadorpedidos+1].DiaEnvio = 2021;
        pedido[contadorpedidos+2].DiaEnvio = 2021;
        pedido[contadorpedidos+3].DiaEnvio = 2021;
        pedido[contadorpedidos+4].DiaEnvio = 2021;
        pedido[contadorpedidos+5].DiaEnvio = 2021;
        pedido[contadorpedidos+6].DiaEnvio = 2021;
        pedido[contadorpedidos+7].DiaEnvio = 2021;
        pedido[contadorpedidos+8].DiaEnvio = 2021;
        pedido[contadorpedidos+9].DiaEnvio = 2021;
        pedido[contadorpedidos+10].DiaEnvio = 2021;
        pedido[contadorpedidos+11].DiaEnvio = 2021;

        // Numero de envio del pedido
        pedido[contadorpedidos].NumeroEnvio = 1;
        pedido[contadorpedidos+1].NumeroEnvio = 1;
        pedido[contadorpedidos+2].NumeroEnvio = 1;
        pedido[contadorpedidos+3].NumeroEnvio = 1;
        pedido[contadorpedidos+4].NumeroEnvio = 1;
        pedido[contadorpedidos+5].NumeroEnvio = 1;
        pedido[contadorpedidos+6].NumeroEnvio = 1;
        pedido[contadorpedidos+7].NumeroEnvio = 1;
        pedido[contadorpedidos+8].NumeroEnvio = 1;
        pedido[contadorpedidos+9].NumeroEnvio = 1;
        pedido[contadorpedidos+10].NumeroEnvio = 1;
        pedido[contadorpedidos+11].NumeroEnvio = 1;

        // Numero de identificador de cada paciente en funcion de su Id.
        pedido[contadorpedidos].IdPaciente = 1;
        pedido[contadorpedidos+1].IdPaciente = 2;
        pedido[contadorpedidos+2].IdPaciente = 3;
        pedido[contadorpedidos+3].IdPaciente = 4;
        pedido[contadorpedidos+4].IdPaciente = 5;
        pedido[contadorpedidos+5].IdPaciente = 6;
        pedido[contadorpedidos+6].IdPaciente = 1;
        pedido[contadorpedidos+7].IdPaciente = 4;
        pedido[contadorpedidos+8].IdPaciente = 6;
        pedido[contadorpedidos+9].IdPaciente = 2;
        pedido[contadorpedidos+10].IdPaciente = 3;
        pedido[contadorpedidos+11].IdPaciente = 1;
        
        // Relacion de pedido con almacen.
        pedido[contadorpedidos].almacen = paciente[0].almacen;
        pedido[contadorpedidos+1].almacen = paciente[1].almacen;
        pedido[contadorpedidos+2].almacen = paciente[2].almacen;
        pedido[contadorpedidos+3].almacen = paciente[3].almacen;
        pedido[contadorpedidos+4].almacen = paciente[4].almacen;
        pedido[contadorpedidos+5].almacen = paciente[5].almacen;
        pedido[contadorpedidos+6].almacen = paciente[6].almacen;
        pedido[contadorpedidos+7].almacen = paciente[2].almacen;
        pedido[contadorpedidos+8].almacen = paciente[4].almacen;
        pedido[contadorpedidos+9].almacen = paciente[6].almacen;
        pedido[contadorpedidos+10].almacen = paciente[1].almacen;
        pedido[contadorpedidos+11].almacen = paciente[3].almacen;

        // relacion de pedido con Id interno.
        pedido[contadorpedidos].IdInterno = paciente[0].IdInterno;
        pedido[contadorpedidos+1].IdInterno = paciente[1].IdInterno;
        pedido[contadorpedidos+2].IdInterno = paciente[2].IdInterno;
        pedido[contadorpedidos+3].IdInterno = paciente[3].IdInterno;
        pedido[contadorpedidos+4].IdInterno = paciente[4].IdInterno;
        pedido[contadorpedidos+5].IdInterno = paciente[5].IdInterno;
        pedido[contadorpedidos+6].IdInterno = paciente[6].IdInterno;
        pedido[contadorpedidos+7].IdInterno = paciente[2].IdInterno;
        pedido[contadorpedidos+8].IdInterno = paciente[4].IdInterno;
        pedido[contadorpedidos+9].IdInterno = paciente[6].IdInterno;
        pedido[contadorpedidos+10].IdInterno = paciente[1].IdInterno;
        pedido[contadorpedidos+11].IdInterno = paciente[3].IdInterno;
        
        for (int i = 0; i < 12; i++)
        {
            if (i == 0 || i == 4 || i == 7 || i == 9 || i == 12) {
                strcpy(pedido[i].items[0].nombrefarmaco, "Ibuprofeno 500mg");
                pedido[i].items[0].pesofarmaco = 0.5;
                pedido[i].items[0].unidadesfarmaco = 10;
                strcpy(pedido[i].items[1].nombrefarmaco, "Paracetamol 1g");
                pedido[i].items[1].pesofarmaco = 1;
                pedido[i].items[1].unidadesfarmaco = 20;
            } else if ( i == 1 || i == 3 || i == 5 || i == 10) {                
                strcpy(pedido[i].items[0].nombrefarmaco, "Nolotil 500mg");
                pedido[i].items[0].pesofarmaco = 0.5;
                pedido[i].items[0].unidadesfarmaco = 50;
                strcpy(pedido[i].items[1].nombrefarmaco, "Aspirina 100mg");
                pedido[i].items[1].pesofarmaco = 0.1;
                pedido[i].items[1].unidadesfarmaco = 100;
                strcpy(pedido[i].items[2].nombrefarmaco, "Lorazepam 200mg");
                pedido[i].items[2].pesofarmaco = 0.2;
                pedido[i].items[2].unidadesfarmaco = 100;
            } else if ( i == 2 || i == 6 || i == 8 || i == 11) {
                strcpy(pedido[i].items[0].nombrefarmaco, "Focalin 50mg");
                pedido[i].items[0].pesofarmaco = 0.05;
                pedido[i].items[0].unidadesfarmaco = 150;
                strcpy(pedido[i].items[1].nombrefarmaco, "Enantyum 500mg");
                pedido[i].items[1].pesofarmaco = 0.5;
                pedido[i].items[1].unidadesfarmaco = 200;
                strcpy(pedido[i].items[2].nombrefarmaco, "Orfidal 1mg");
                pedido[i].items[2].pesofarmaco = 0.01;
                pedido[i].items[2].unidadesfarmaco = 1000;
            }            
        }                  
    }
    printf("\n Listado gestión de medicamentos.\n");
    for (int i = 1; i < contadoralmacen; i++){
        printf("\n Almacen %i - %s - %s - %s \n     Descripcion: %s\n\n", almacen[i].codigo, almacen[i].calle, almacen[i].municipio, almacen[i].provincia, almacen[i].descripcion);
        printf("    Clientes.\n\n");
        printf("    ID.     Ident/Ref.      Distancia       Angulo\n\n");
        for (int j = 0; j < contadorpaciente; j++)
        {
            if (paciente[j].almacen == i)
            {
                printf("    %2i     %s", paciente[j].IdInterno, paciente[j].nombre);
                longitud = strlen(paciente[j].nombre);
                for (int k = longitud; k < 24; k++)
                {
                    printf(" ");
                }
                printf("%5i     %4i\n", paciente[j].distancia, paciente[j].angulo);                
            }            
        }
        printf("\n Pedidos\n\n  Cliente Fecha   Medicamento Peso    Unidades\n\n");
        for (int k = 0; k < 100; k++)
        {
            if (pedido[k].almacen == i && pedido[k].IdPaciente > 0 )
            {
                if (pedido[k].IdPaciente < 100)
                {
                    printf("\n      %2i     %2i/%i/%4i      %s",  pedido[k].IdInterno, pedido[k].DiaEnvio, pedido[k].MesEnvio, pedido[k].AnnoEnvio, pedido[k].items[0].nombrefarmaco);
                    longitud = strlen(pedido[k].items[0].nombrefarmaco);
                    for (int l = longitud; l < 16; l++)
                    {
                        printf(" ");
                    }
                    printf("%4i     %3i", pedido[k].items[0].pesofarmaco, pedido[k].items[0].unidadesfarmaco);
                }                                
            }            
        }
        printf("\n");
        contadorpedidos = 14;

        for (int i = 0; i < 14; i++)
        {
            pedido[i].pesoTotal = (pedido[i].items[0].pesofarmaco * pedido[i].items[0].unidadesfarmaco + 
                pedido[i].items[1].pesofarmaco * pedido[i].items[1].unidadesfarmaco + 
                pedido[i].items[2].pesofarmaco * pedido[i].items[2].unidadesfarmaco +
                pedido[i].items[3].pesofarmaco * pedido[i].items[3].unidadesfarmaco +
                pedido[i].items[4].pesofarmaco * pedido[i].items[4].unidadesfarmaco +
                pedido[i].items[5].pesofarmaco * pedido[i].items[5].unidadesfarmaco
                );
        }
        
    }
    check = 1;
}
#include <stdio.h>
#include <string.h>
#include "Almacenes.h"
#include "Pacientes.h"
#include "Pedidos.h"
#include "IniciarGestion.h"

void empt_stdin(void) {
    int c = getchar();
    while ( c != '\n' && c != EOF) {
        c = getchar();
    }
}

void almacenes::altaAlmacen(){
    printf("Alta nuevo almacén.\n")
    if (contadoralmacen > 10) {
        do{
            if(almacene == '.'){
                printf("    Sí-S / No-N");
            }
            printf("    ¿Desea borrar un almacén? (S/N) ")
            scanf("%c", &almacene);
            if (almacene == 'N' || almacene == 'n'){
                almacene = 'N';
                printf("Ha seleccionado que no ... Volvemos al inicio.");
            } 
            if (almacene == 'S' || almacene == 's'){
                almacene = 'S';
                printf("Ha seleccionado que sí, procedemos a ver los almacenes que puede borrar.");
            }
            // Valores no válidos evaluados a continuacion --- ??¿?¿?¿? válido?
            if ( almacene != 'S' || almacene != 's' || almacene != 'N' || almacene != 'n' ){
                printf("Ha introducido un caracter NO válido, vuelva a intentarlo de nuevo.");
            } else {
                almacene = '.';
            }
        } while (almacene != 'S' && almacene != 'N');

        if (almacene == 'S' || almacene == 's'){
            for(;;){
                printf("¿Que almacen desea borrar? (Num: 0-10). ");
                rtn = scanf("%d", &input);
                if (rtn == 0){

                    fputs(" Debe introducir un numero entero. \n", stderr);
                    empt_stdin();

                } else if (input < 1 || input > 10){

                    fputs(" Elimine un almacen valido. Entre el 1 y 10. \n", stderr);
                    empt_stdin();

                } else if (input >= 1 || input < contadoralmacen){
                    almacenN = input;
                    empt_stdin();
                    break;
                }
            }
            do {
                do {
                    printf("\n  Direccion almacen? (Entre 1 a 48 caracteres): ");
                    scaf(" %[^\n]s", &almacen[almacenN].calle);
                    longitud = strlen(almacen[almacenN].calle);
                } while (longitud < 1 || longitud > 48);
                do {
                    if ( datoscorrectos == '.') {
                        printf("    Escriba: S o N. \n");
                        scanf(" %[^\n]c", &datoscorrectos);
                    }
                    if (datoscorrectos == 'N' || datoscorrectos == 'n'){
                        datoscorrectos = 'N';
                    }
                    if( datoscorrectos == 'S' || datoscorrectos == 's'){
                        for (int i = 0; i<100; i++){
                            if(pedido[i].almac == almacenN){
                                pedido[i].almac = pedido[contadorpedidos].almac;
                                pedido[i].DiaEnvio = pedido[contadorpedidos].DiaEnvio;
                                pedido[i].MesEnvio = pedido[contadorpedidos].MesEnvio;
                                pedido[i].AnnoEnvio = pedido[contadorpedidos].AnnoEnvio;
                                strcpy(pedido[i].item[0].nombrefarmaco,pedido[contadorpedidos].items[0].nombrefarmaco);
                                strcpy(pedido[i].item[1].nombrefarmaco,pedido[contadorpedidos].items[1].nombrefarmaco);
                                strcpy(pedido[i].item[2].nombrefarmaco,pedido[contadorpedidos].items[2].nombrefarmaco);
                                strcpy(pedido[i].item[3].nombrefarmaco,pedido[contadorpedidos].items[3].nombrefarmaco);
                                strcpy(pedido[i].item[4].nombrefarmaco,pedido[contadorpedidos].items[4].nombrefarmaco);
                                pedido[i].item[0].pesofarmaco = pedido[contadorpedidos].items[0].pesofarmaco;
                                pedido[i].item[1].pesofarmaco = pedido[contadorpedidos].items[1].pesofarmaco;
                                pedido[i].item[2].pesofarmaco = pedido[contadorpedidos].items[2].pesofarmaco;
                                pedido[i].item[3].pesofarmaco = pedido[contadorpedidos].items[3].pesofarmaco;
                                pedido[i].item[4].pesofarmaco = pedido[contadorpedidos].items[4].pesofarmaco;
                                pedido[i].item[0].unidadesfarmaco = pedido[contadorpedidos].items[0].unidadesfarmaco;
                                pedido[i].item[1].unidadesfarmaco = pedido[contadorpedidos].items[1].unidadesfarmaco;
                                pedido[i].item[2].unidadesfarmaco = pedido[contadorpedidos].items[2].unidadesfarmaco;
                                pedido[i].item[3].unidadesfarmaco = pedido[contadorpedidos].items[3].unidadesfarmaco;
                                pedido[i].item[4].unidadesfarmaco = pedido[contadorpedidos].items[4].unidadesfarmaco;
                                pedido[i].almac = pedido[contadorpedidos].refinterno;
                                pedido[i].NuevoEnvio = pedido[contadorpedidos].NuevoEnvio;
                                pedido[i].IdPaciende = pedido[contadorpedidos].IdPaciente;
                                contadorpedidos--;
                            }
                            if(paciente[i].almac == almacenN){
                                paciente[i].id = paciente[contadorpaciente].ref;
                                paciente[i].distancia = paciente[contadorpaciente].distancia;
                                paciente[i].angulo = paciente[contadorpaciente].angulo;
                                paciente[i].almac = paciente[contadorpaciente].almac;
                                paciente[i].refinterno = paciente[contadorpaciente].refinterno;
                                strcpy(paciente[i].nombre, paciente[contadorpaciente].nombre);
                                contadorpaciente--;
                            }
                        }
                        datoscorrectos = 'S';
                    }
                    if (datoscorrectos == 'S' || datoscorrectos == 'N'){}
                    else{
                        datoscorrectos = '.';
                    }
                } while (datoscorrectos != 'S' && datoscorrectos == 'N');
            } while (datoscorrectos != 'S');
            contadoralmacen++;
            datoscorrectos = 'a';
            almacenN = 0;
            if( almacenN < 0 || almacenN > 10 ){
                printf("\n  Tiene que ser un numero entre 0 y 10. Vuelva a intentarlo de nuevo.");
            }else{
                printf("");
            }
        }
    }else{
        do{
            for(;;){
                printf("\n Identificador del almacen. (Num de 1 al 10): ");
                rtn = scanf("%d", &input);
                if(rtn == 0){
                    fputs(" Introduzca un numero entero positivo!\n", stderr);
                    empt_stdin();
                } else if(input < 1 || input > 10){
                    fputs(" Introduzca un numero entero entre 1 y 10.\n", stderr);
                    empt_stdin();
                } else if(almacen[0].codigo == input || almacen[1].codigo == input || almacen[2].codigo == input || almacen[3].codigo == input || almacen[4].codigo == input || almacen[5].codigo == input || almacen[6].codigo == input || almacen[7].codigo == input || almacen[8].codigo == input || almacen[9].codigo == input){
                    fputs(" Este almacen ya existe, pruebe con otro identificador distinto. \n", stderr);
                    empt_stdin();
                } else if(input >= 1 || input < contadoralmacen){
                    almacen[contadoralmacen].codigo = input;
                    empt_stdin();
                    break;
                }
                
            }
            /* Datos de geolocalizacion del almacen logistico */
            // Calle del almacen
            do{
                printf("¿Direccion del almacen? (Entre 1 y 50 caracteres): ");
                scanf(" %[^\n]s", &almacen[contadoralmacen].calle);
                longitud = strlen(almacen[contadoralmacen].calle);
            } while ( longitud < 1 || longitud > 50);
            // Municipio del almacen
            do{
                printf(" ¿Municipio del almacen? (Entre 1 y 50 caracteres): ");
                scanf(" %[^\n]s", &almacen[contadoralmacen].municipio);
                longitud = strlen(almacen[contadoralmacen].municipio);
            } while ( longitud < 1 || longitud > 50);
            // Provincia del almacen
            do{
                printf(" ¿Provincia del almacen? (Entre 1 y 20 caracteres): ");
                scanf(" %[^\n]s", &almacen[contadoralmacen].provincia);
                longitud = strlen(almacen[contadoralmacen].provincia);
            } while ( longitud < 1 || longitud > 20);
            // Descripcion del almacen
            do{
                printf(" Descripcion del almacen? (Entre 1 y 50 caracteres): ");
                scanf(" %[^\n]s", &almacen[contadoralmacen].descripcion);
                longitud = strlen(almacen[contadoralmacen].descripcion);
            } while ( longitud < 1 || longitud > 50);
            do{
                if(datoscorrectos == '.'){
                    printf("Escribe S-(si) o N-(no) si los datos son correctos");
                }
                printf("\n Datos correctos (S/N)? ");
                scanf(" %[^\n]c", &datoscorrectos);
            }
            if (datoscorrectos == 'N' || datoscorrectos = 'n'){
                datoscorrectos = 'N';
                almacen[contadoralmacen].codigo=0;
            }
            if (datoscorrectos == 'S' || datoscorrectos == 's'){
                datoscorrectos = 'S';
            }
            if (datoscorrectos == 'S' || datoscorrectos == 'N'){

            } else {
                datoscorrectos = '.';
            }
        } while (datoscorrectos != 'S' && datoscorrectos != 'N');
    } while (datoscorrectos != 'S');
    contadoralmacen++;
    datoscorrectos = 'a';
    printf("\n\n");
}
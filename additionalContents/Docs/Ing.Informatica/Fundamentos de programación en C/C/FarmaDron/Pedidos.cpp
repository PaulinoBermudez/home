#include <stdio.h>
#include "Pedidos.h"

void em_stdin(void) {
    int x = getch();
    while ( x != '\n' && x != EOF) {
        x = getch();
    }
    
}

void pedidos::nuevoPedido() {
    if (contadoralmacen > 1 && contadorpaciente > 0) {
        /* Bucle para generar un nuevo pedido
         * Condiciones necesarias:
         * - Nº de almacen > 1.
         * - Nº de pacientes > 1.
         */ 
        do { 
            if ( contadorPedidos < 100)
            {
                printf("\n Nuevo Pedido: \n\n");

                for (;;) {
                    printf(" ¿Codigo del almacen? :");
                    rtn = scanf("%d", &input);
                    if (rtn == 0) {
                        fputs (" ERROR EN ENTRADA! - Debe introducir un numero de almacen valido. \n", stderr);
                        em_stdin();
                    } else if ( input < 1 || input > 10) {
                        fputs (" ERROR ENTRADA - Numero de almaceno no valido, debe ser un almacen comprendido entre 1 y 10.  \n", stderr);
                        em_stdin();
                    } else if ( input != almacen[0].codigo && input != almacen[1].codigo && input != almacen[2].codigo && input != almacen[3].codigo && input != almacen[4].codigo && input != almacen[5].codigo && input != almacen[6].codigo && input != almacen[7].codigo && input != almacen[8].codigo && input != almacen[9].codigo) {
                        fputs(" FALLO DE CANTIDAD - Almacen no encontrado. \n ", stderr);
                        em_stdin();
                    } else {
                        pedido[contadorPedidos].almacen = input;
                        emp_stdin();
                        break;
                    } // if-else if - else entrada de dato de nº de almacen 
                } // Bucle FOR de datos de almacen
                for (;;) {
                    printf(" ID de paciente: (entre 1 y 20). ");
                    rtn = scanf("%d", &input);
                    // Condicional de comprobador del identificador de un paciente dado de alta en el sistema.
                    if (rtn == 0) {
                        fputs (" ERROR DE ID! - Introduzca un numero mayor. 0 no es valido. \n", stderr); 
                        em_stdin();
                    } else if (input < 1 || input > 20 ){
                        fputs (" ERROR DE ENTRADA - Introduzca un numero de identificador de paciente valido. Entre 1 y 20.", stderr);
                        em_stdin();
                    } else if ( paciente[0].IdInterno == input && paciente[0].almacen == pedido[contadorPedidos].almacen || paciente[1].IdInterno == input && paciente[1].almacen == pedido[contadorPedidos].almacen ||
                    paciente[2].IdInterno == input && paciente[2].almacen == pedido[contadorPedidos].almacen || paciente[3].IdInterno == input && paciente[3].almacen == pedido[contadorPedidos].almacen ||
                    paciente[4].IdInterno == input && paciente[4].almacen == pedido[contadorPedidos].almacen || paciente[5].IdInterno == input && paciente[5].almacen == pedido[contadorPedidos].almacen ||
                    paciente[6].IdInterno == input && paciente[6].almacen == pedido[contadorPedidos].almacen || paciente[7].IdInterno == input && paciente[7].almacen == pedido[contadorPedidos].almacen ||
                    paciente[8].IdInterno == input && paciente[8].almacen == pedido[contadorPedidos].almacen ||  paciente[9].IdInterno == input && paciente[0].almacen == pedido[contadorPedidos].almacen ||
                    paciente[10].IdInterno == input && paciente[0].almacen == pedido[contadorPedidos].almacen || paciente[11].IdInterno == input && paciente[0].almacen == pedido[contadorPedidos].almacen ||
                    paciente[12].IdInterno == input && paciente[0].almacen == pedido[contadorPedidos].almacen || paciente[13].IdInterno == input && paciente[0].almacen == pedido[contadorPedidos].almacen ||
                    paciente[14].IdInterno == input && paciente[0].almacen == pedido[contadorPedidos].almacen || paciente[15].IdInterno == input && paciente[0].almacen == pedido[contadorPedidos].almacen ||
                    paciente[16].IdInterno == input && paciente[0].almacen == pedido[contadorPedidos].almacen || paciente[17].IdInterno == input && paciente[0].almacen == pedido[contadorPedidos].almacen ||
                    paciente[18].IdInterno == input && paciente[0].almacen == pedido[contadorPedidos].almacen || paciente[19].IdInterno == input && paciente[0].almacen == pedido[contadorPedidos].almacen ){
                        pedido[contadorPedidos].IdInterno = input;
                        em_stdin();
                        break;
                    } else {
                        fputs(" El ID introducido no coincide con ningun paciente existente en el almacen. Compruebe los datos y vuelva a intentarlo de nuevo. \n", stderr);
                        emp_stdin();
                    } // fin condicional ID paciente
                    
                } // Bucle for de datos de paciente
                for (int i = 0; i < 50; i++) {
                    if ( paciente[i].IdInterno == pedido[contadorPedidos].IdInterno) {
                        pedido[contadorPedidos].IdPaciente = paciente[i].Id;
                    }
                }
                for (;;) {
                    printf("    Numero de envio: ");
                    rtn = scanf("%d", &input);
                    if (rtn == 0) {
                        fputs(" ERROR DE ID DE ENVIO - El envio no puede tener un ID = 0. \n", stderr);
                        em_stdin();
                    } else if (input < 1) {
                        fputs(" ERROR de ID DE ENVIO - El envio debe tener un numero ID mayor o igual que 1.", stderr);
                        em_stdin();
                    } else {
                        pedido[contadorPedidos].IdEnvio = input;
                        em_stdin();
                        break;
                    }                    
                }
                if (pedido[contadorPedidos].IdEnvio == 1) {
                    printf("Datos de fecha de envio de paciente. \n");
                    for (;;) {
                        printf("    Dia de envio: ");
                        rtn = scanf("%d", &input);

                        if (rtn == 0) {
                            fputs ("    Introduzca un numero valido para dia, mayor que 0.\n");
                            em_stdin();
                        } else if ( input < 1 || input > 31) {
                            fputs (" Introduzca un numero de dia valido, entre 1 y 31. \n");
                            em_stdin();
                        } else {
                            pedido[contadorPedidos].DiaEnvio == input;
                            em_stdin();
                            break;
                        }                        
                    }
                    for (;;) {
                        printf("    Mes de envio: ");
                        rtn = scanf("%d", &input);

                        if (rtn == 0) {
                            fputs ("    Introduzca un numero valido para mes, mayor que 0.\n");
                            em_stdin();
                        } else if ( input < 1 || input > 12) {
                            fputs (" Introduzca un numero de dia valido, entre 1 y 12. \n");
                            em_stdin();
                        } else {
                            if ((input == 1 || input == 3 || input == 5 || input == 7 || input == 8 || input == 10 || input == 12) && pedido[contadorPedidos].DiaEnvio <= 31 ) {
                                suMes == input;
                                em_stdin();
                                break;
                            } else if ((input == 4 || input == 6 || input == 9 || input == 11) && pedido[contadorPedidos].DiaEnvio <= 30 ) {
                                suMes == input;
                                em_stdin();
                                break;
                            } else if ((input == 2) && pedido[contadorPedidos].DiaEnvio <= 28  && CalBis(input) == false ) {
                                suMes == input;
                                em_stdin();
                                break;
                            }else if ((input == 2) && pedido[contadorPedidos].DiaEnvio <= 29  && CalBis(input) == true ) {
                                suMes == input;
                                em_stdin();
                                break;
                            } else {
                                fputs (" ERROR EN LOS DATOS DE FECHA INTRODUCIDOS - No coincide MES con en numero de DIAS introducido. \n");
                                em_stdin();
                            }                            
                        } // Condicional para compribar la fecha de mes + dia 
                    } // bucle for para introducir el mes
                    for (;;) {
                        printf("    A%co de envio: ",164);
                        rtn = scanf("%d", &input);

                        if (rtn == 0) {
                            fputs ("    Introduzca un numero valido para a%co, mayor que 0.\n",164,stderr);
                            em_stdin();
                        } else if ( input < 2021) {
                            fputs (" A%co no valido. Los pedidos se ven a partir del 2021. \n",164,stderr);
                            em_stdin();
                        } else {
                            suAnno == input;
                            em_stdin();
                            break;
                        } // Condicional de comprobación del año de entrada por teclado.
                    } // Bucle for para introducir el año de envio
                    pidoMedicamento = 100;   
                    for (int k = 0; k < 5; k++) {
                        /* Bucle para crear la lista de medicamentos del pedido. */
                        do {
                            if (pidoMedicamento == 5) {
                                print("\n El nombre del medicamento entre 1 y 20 caracteres. \n");
                            }
                            // Pedimos el nombre del farmaco que vamos a guardar.
                            print(" Escriba el nombre del medicamento: ");
                            print(" %s", &pedido[contadorPedidos].items[k].nombreMedicamento);
                            pidoMedicamento = 5;                            
                        } while (strlen(pedido[contadorPedidos].items[k].nombreMedicamento) < 1 || strlen(pedido[contadorPedidos].items[k].nombreMedicamento) > 20 );
                        pidoMedicamento = 0;
                        /* Bucle para pedir el peso del farmaco */
                        for (;;) {
                            printf(" Peso del medicamento (Max. 3000gr):  ");
                            rtn=scanf("%d", &input);
                            if (rtn == 0) {
                                fputs(" ERROR EN EL PESO -  El medicamento no puede pesar 0 gramos. \n", stderr);
                                em_stdin();
                            } else if ( input < 1 || input > 3000 ) {
                                fputs(" ERROR EN EL PESO - El medicamento no puede tener esa cantidad de peso.\n Peso aceptado entre 1 y 3000 grs. \n", stderr);
                                em_stdin();
                            } else {
                                pedido[contadorPedidos].items[k].pesoMedicamento = input;
                                em_stdin();
                                break;
                            } // Condicional medidor del peso minimo y maximo de los farmacos o medicamentos.                                                        
                        }                        
                        /* Bucle para contar las unidades pedidas del farmaco y añadirlas a la lista de pedido. */
                        for (;;) {
                            printf(" Unidades del medicamento:  ");
                            rtn=scanf("%d", &input);
                            if (rtn == 0) {
                                fputs(" ERROR EN EL CANTIDAD -  El sistema no puede pedir 0 unidades del farmaco. \n", stderr);
                                em_stdin();
                            } else if ( input > 1 && (pesoTotal + input * pedido[contadorPedidos].items[k].pesoMedicamento > 3000)) {
                                pesoSalida = pesoTotal + input * pedido[contadorPedidos].items[k].pesoMedicamento
                                fputs(" ERROR EN EL CANTIDAD - La cantidad sobrepasa el peso maximo del pedido.\n Peso aceptado entre 1 y 3000 grs. \n", stderr);
                                printf(" La cantidad total de farmaco pesa: ", pesoSalida );
                                em_stdin();
                            } else {
                                pedido[contadorPedidos].items[k].unidadesMedicamento = input;
                                em_stdin();
                                break;
                            } // Condicional contador de unidades minima y maxima de los farmacos o medicamentos.                                                        
                        }
                        if (pesoTotal + pedido[contadorPedidos].items[k].pesoMedicamento * pedido[contadorPedidos].items[k].unidadesMedicamento < 3000) {
                            pesoTotal = (pesoTotal + pedido[contadorPedidos].items[k].pesoMedicamento * pedido[contadorPedidos].items[k].unidadesMedicamento);
                            pedido[contadorPedidos].contador++;
                        }
                        pedido[contadorPedidos].PesoTotalPedido = pesoTotal;
                        do {
                            if (NuevoMedicamento == '.') {
                                printf(" Escriba S-si o N-no. \n");
                            }
                            printf(" Pedir nuevo medicamento (S/N): \n");
                            scanf("%[^\n]c",&NuevoMedicamento);

                            if (NuevoMedicamento == 'N' || NuevoMedicamento == 'n') {
                                NuevoMedicamento = 'N';
                                k = 5;
                            } else if ( NuevoMedicamento == 'S' || NuevoMedicamento == 's') {
                                NuevoMedicamento = 'S';
                            } else {
                                NuevoMedicamento = '.';
                            }                            
                        } while (NuevoMedicamento != 'S' && NuevoMedicamento != 'N');                        
                    } // Bucle for para pedir medicamentos y añadirlos a la lista de pedido.                                     
                } // Condicional If de pedidos.
                else if (pedido[contadorPedidos].IdEnvio > 1) {
                    IdEnvio = pedido[contadorPedidos].IdEnvio;
                    for (;;) {
                        printf(" ¿ Cual es el numero de dias entre cada envio. Entre 1 y 15 dias? ");
                        rtn = scanf("%d", &input);
                        if (rtn == 0) {
                            fputs ("    El numero de dias introducido no es valido. 0 dias. \n", stderr);
                            em_stdin();
                        } else if ( input < 1 || input > 15) {
                            fputs (" El numero introducido sale del rango de dias validos. Valores validos entre 1 y 15 dias. \n ", stderr):
                            em_stdin();
                        } else {
                            NumDias = input;
                            em_stdin();
                            break;
                        }                        
                    }
                    for (;;) {
                        printf("    ¿Dia de envio del primer pedido? ");
                        rtn=scanf("%d", &input);
                        if (rtn == 0) {
                            fputs ("El pedido debe tener mas de un dia de envio para ser valido. \n", stderr);
                            em_stdin();
                        } else if (input < 1 || input > 31) {
                            fputs (" Los datos para 'dias de envio del primer pedido' no es valido. \n", stderr);
                            em_stdin();
                        } else {
                            pedido[contadorPedidos].DiaEnvio = input;
                            em_stdin();
                            break;
                        }                        
                    }
                    for (;;) {
                        printf("¿Mes del primer envio? ");
                        rtn = scanf("%d", &input);
                        if (rtn == 0) {
                            fputs (" Mes = 0, no es un mes valido. \n", stderr);
                            em_stdin();
                        } else if ( input < 1 || input > 12) {
                            fputs ("Los valores introducidos para mes, no son validos. \n", stderr);
                            em_stdin();
                        } else {
                            pedido[contadorPedidos].MesEnvio = input;
                            em_stdin();
                            break;
                        }                                                
                    }
                    for (;;) {
                        printf(" A%co del primer envio? ", 164);
                        rtn = scanf("%d", &input);
                        if (rtn == 0) {
                            fputs (" A%co invalido, no puede tener el valor 0. \n", 164,stderr);
                            em_stdin();
                        } else if ( input < 2021 ) {
                            fputs ("El a%co debe ser a partir del 2021. \n", 164, stderr);
                            em_stdin();
                        } else {
                            if (pedido[contadorPedidos].MesEnvio == 2 && pedido[contadorPedidos].DiaEnvio < 29 && CalBis(input) == false) {
                                pedido[contadorPedidos].AnnoEnvio = input;
                                em_stdin();
                                break;
                            } else if (pedido[contadorPedidos].MesEnvio == 2 && pedido[contadorPedidos].DiaEnvio < 28 && CalBis(input) == true) {
                                pedido[contadorPedidos].AnnoEnvio = input;
                                em_stdin();
                                break;
                            } else if(input >= 2021 ) {
                                pedido[contadorPedidos].AnnoEnvio = input;
                                em_stdin();
                                break;
                            }
                        }                    
                    } // Bucle for para el año del primer envio de pedidos
                    printf("\n");
                    // Buble para agregar medicamentos a la lista de pedido[contadorPedidos].items
                    for (int f = 0; f < 5; f++) {
                        do {
                            if (pidoMedicamento == 5){
                                printf (" Nombre de medicamento debe ser de 1 a 20 caracteres. \n ");
                            }
                            printf("¿Nombre de farmaco que quiere a%cadir a la lista?", 164);
                            scanf("%s",&pedido[contadorPedidos].items[f].nombreMedicamento);
                            pidoMedicamento = 5;
                        } while (strlen(pedido[contadorPedidos].items[k].nombreMedicamento < 1 || strlen(pedido[contadorPedidos].items[k].nombreMedicamento > 20)));
                        pidoMedicamento = 0;
                        for (;;) {
                            printf ("¿Peso del farmaco? Max.3000gr ");
                            rtn = scanf("%d", &input);
                            if (rtn == 0) {
                                fputs ("ERROR DE PESO - El medicamento no puede pesar 0 gramos. \n", stderr);
                                em_stdin();
                            } else if ( input < 1 || input > 3000) {
                                fputs ("ERROR DE PESO - El peso introducido no es valido, recuerde, minimo 1 gramo - maximo 3000 gramos. \n", stderr);
                                em_stdin();
                            } else {
                                pedido[contadorPedidos].items[f].pesoMedicamento = input;
                                em_stdin();
                                break;
                            }                            
                        } // for para el peso del medicamento
                        for (;;) {
                            printf ("\n ¿Cuantas unidades del medicamento desea a%cadir? ",164);
                            rtn = scanf("%d", &input);
                            if (rtn == 0) {
                                fputs ("ERROR DE CANTIDAD - El sistema no puede añadir 0 unidades del medicamento. \n", stderr);
                                em_stdin();
                            } else if ( input > 1 && (pesoTotal + input * pedido[contadorPedidos].items[f] = input)) {
                                fputs ("    ERROR DE CANTIDAD - Ha sobrepasado el peso maximo que el dron puede llevar. \n",stderr);
                                em_stdin();
                            } else {
                                pedido[contadorPedidos].items[f].unidadesMedicamento = input;
                                em_stdin();
                                break;                                
                            }                                                    
                        } // for para las unidades de medicamento
                        // Condicional que verifica que el peso de los medicamentos solocitados no exceda la cantidad maxima que puede llevar el drone, una vez verificada la cantidad, la añade a la lista de pedido.
                        if (pesoTotal + pedido[contadorPedidos].items[f].pesoMedicamento * pedido[contadorPedidos].items[f].unidadesMedicamento < 3000) {
                            pesoTotal = (pesoTotal + pedido[contadorPedidos].items[f].pesoMedicamento * pedido[contadorPedidos].items[f].unidadesMedicamento);
                            pedido[contadorPedidos].contador++;
                        }
                        pedido[contadorPedidos].pesoTotalPedido = pesoTotal;
                        do
                        {
                            if (NuevoMedicamento == '.') {
                                printf(" Introduzca S-si o N-no: ");                                
                            }
                            printf(" A%cadir otro farmaco a la lista (S/N): ",164);
                            scanf("%[^\n]",&NuevoMedicamento);
                            if (NuevoMedicamento == 'S' || NuevoMedicamento == 's' ) {
                                NuevoMedicamento == 'S';
                            } else if ( NuevoMedicamento == 'N' || NuevoMedicamento == 'n') {
                                NuevoMedicamento == 'N';
                                f = 5;
                            } else if ( NuevoMedicamento == 'S' || NuevoMedicamento == 'N') { 
                            } else {
                                NuevoMedicamento = '.';
                            }
                        } while (NuevoMedicamento != 'S' && NuevoMedicamento != 'N');                                       
                    } // bucle for para la lista de pedidos
                    pedido[contadorPedidos].pesoTotalPedido = pesoTotal;
                    contadorPedidos++;
                    /* Código de creación de envios recurrentes. */
                    for (int i = 0; i < IdEnvio - 1 ; i++)
                    {
                        pedido[contadorPedidos].IdPaciente = pedido[contadorPedidos-1].IdPaciente;
                        pedido[contadorPedidos].IdInterno = pedido[contadorPedidos-1].IdInterno;
                        pedido[contadorPedidos].almacen = pedido[contadorPedidos-1].almacen;
                        pedido[contadorPedidos].DiaEnvio = (pedido[contadorPedidos-1].DiaEnvio+NumDias);
                        pedido[contadorPedidos].MesEnvio = pedido[contadorPedidos-1].MesEnvio;
                        pedido[contadorPedidos].AnnoEnvio = pedido[contadorPedidos-1].AnnoEnvio;
                        if (pedido[contadorPedidos].DiaEnvio > 28 && (pedido[contadorPedidos].MesEnvio == 2 && CalBis(pedido[contadorPedidos].AnnoEnvio) == false)) {
                            pedido[contadorPedidos].DiaEnvio = pedido[contadorPedidos].DiaEnvio - 28;
                            pedido[contadorPedidos].MesEnvio = pedido[contadorPedidos].MesEnvio + 1;
                        } else if(pedido[contadorPedidos].DiaEnvio > 29 && (pedido[contadorPedidos].MesEnvio == 2 && CalBis(pedido[contadorPedidos].AnnoEnvio) == true)) {
                            pedido[contadorPedidos].DiaEnvio = pedido[contadorPedidos].DiaEnvio - 29;
                            pedido[contadorPedidos].MesEnvio = pedido[contadorPedidos].MesEnvio + 1;
                        } else if (pedido[contadorPedidos].DiaEnvio > 30 && (pedido[contadorPedidos].MesEnvio == 4 || pedido[contadorPedidos].MesEnvio == 6 || pedido[contadorPedidos].MesEnvio == 9 || pedido[contadorPedidos].MesEnvio == 11)) {
                            pedido[contadorPedidos].DiaEnvio = pedido[contadorPedidos].DiaEnvio - 30;
                            pedido[contadorPedidos].MesEnvio = pedido[contadorPedidos].MesEnvio + 1;
                        } else if (pedido[contadorPedidos].DiaEnvio > 31 && (pedido[contadorPedidos].MesEnvio == 1 || pedido[contadorPedidos].MesEnvio == 3 || pedido[contadorPedidos].MesEnvio == 5 || pedido[contadorPedidos].MesEnvio == 7 || pedido[contadorPedidos].MesEnvio == 8 || pedido[contadorPedidos].MesEnvio == 10)) {
                            pedido[contadorPedidos].DiaEnvio = pedido[contadorPedidos].DiaEnvio - 31;
                            pedido[contadorPedidos].MesEnvio = pedido[contadorPedidos].MesEnvio + 1;
                        } else if (pedido[contadorPedidos].DiaEnvio > 31  && pedido[contadorPedidos].mesEnvio == 12 ) {
                            pedido[contadorPedidos].DiaEnvio = pedido[contadorPedidos].DiaEnvio - 31;
                            pedido[contadorPedidos].MesEnvio = pedido[contadorPedidos].AnnoEnvio + 1;
                        }
                        for (int z = 0; z < 5; z++) {
                            strcpy (pedido[contadorPedidos].items[z].nombreMedicamento, pedido[contadorPedidos -1 ].items[z].nombreMedicamento);
                            pedido[contadorPedidos].items[z].pesoMedicamento = pedido[contadorPedidos -1 ].items[z].pesoMedicamento;
                            pedido[contadorPedidos].items[z].unidadesMedicamento = pedido[contadorPedidos -1 ].items[z].unidadesMedicamento;
                        }
                        pedido[contadorPedidos].pesoTotalPedido = pedido[contadorPedidos -1 ].pesoTotalPedido;
                        contadorPedido++;
                    } // Añadir +1 nuevo pedido de medicamentos - pedido recurrente.                    
                } // Else-if de pedido[contadorPedidos].idenvio > 1                
            } // IF ContadorPedidos
           contadorPedidos++;
           pesoTotal = 0;
           do {
                if (NuevaSolicitud == '.') {
                    printf(" Escriba S-si o N-no. \n");
                }
                printf(" ¿Desea hacer otro pedido? (S/N): ");
                scanf("%[^\n]c",&NuevaSolicitud);
                if (NuevaSolicitud == 'S' || NuevaSolicitud == 's') {
                    NuevaSolicitud = 'S';
                } else if (NuevaSolicitud == 'N' || NuevaSolicitud == 'n') {
                    NuevaSolicitud = 'N';
                } else if (NuevaSolicitud == 'S' || NuevaSolicitud == 'N') {                  
                } else {
                    NuevaSolicitud = '.';
                }               
           } while (NuevaSolicitud != 'S' && NuevaSolicitud != 'N');
           
        } while (NuevoPedido == 'S');
        printf("\n\n");
    } // condicional IF
    else {
        printf("\n Cree un almacen y paciente antes de realizar pedidos. \n");
    }    
} // llave de cierre del void pedidos

void pedidos:listarPedidos() {
    if (contadoralmacen > 1) {
        for (;;) {
            printf(" Escriba el codigo de almacen: ");
            rtn = scanf("%d", &input);
            if (rtn == 0) {
                fputs("ERROR DE CODIGO - El almacen no puede tener el codigo 0. \n",stderr);
                em_stdin();
            } else if ( input < 1 || input > 10 ) {
                fputs("ERROR DE CODIGO - El codigo de entrada no es valido con los codigos de almacen guardados en sistema. \n", stderr);
                em_stdin();
            } else if ( input != almacen[0].codigo &&  input != almacen[1].codigo &&  input != almacen[2].codigo &&  input != almacen[3].codigo && input != almacen[4].codigo && 
            input != almacen[5].codigo &&  input != almacen[6].codigo &&  input != almacen[7].codigo &&  input != almacen[8].codigo &&   input != almacen[9].codigo ) {
                fputs(" Ese almacen no existe. Introduce un almacen valido. \n", stderr);
                emp_stdin();
            } else {
                codigo = input;
                emp_stdin();
                break;
            }            
        } // Bucle for para los codigos de almacenes
        for (;;) {
            printf("\n  ¿Dia? ");
            rtn = scanf("%d", &input);
            if (rtn == 0) {
                fputs ("    Introduzca un numero valido para el valor: DIA. \n", stderr);
                em_stdin();
            } else if ( input < 1 || input > 30) {
                fputs ("    Numero fuera de rango. Num. invalido para el valor: DIA. \n", stderr);
                em_stdin();
            } else {
                suDia = input;
                em_stdin();
                break;
            }            
        } // Dia
        for (;;) {
            printf("\n ¿Mes? ");
             rtn = scanf("%d", &input);
            if (rtn == 0) {
                fputs ("    Introduzca un numero valido para el valor: MES. \n", stderr);
                em_stdin();
            } else if ( input < 1 || input > 12) {
                if ( (input == 1 || input == 3 || input == 5 || input == 7 || input == 8 || input == 10 || input == 12) && pedido[contadorPedidos].DiaEnvio > 31) ) {
                    fputs ("    Numero fuera de rango. Num. invalido para el valor: MES. \n", stderr);
                    em_stdin();
                } else if ((input == 4 || input == 6 || input == 7 || input == 9 || input == 11) && pedido[contadorPedidos].DiaEnvio > 30) {
                    fputs ("    Numero fuera de rango. Num. invalido para el valor: MES. \n", stderr);
                    em_stdin();
                } else {
                    suMes = input;
                    em_stdin();
                    break;
                }
            } else {
                suDia = input;
                em_stdin();
                break;
            } 
        } // Mes
        for (;;) {
            printf("\n  ¿A%co? ",164);
            rtn = scanf("%d", &input);
            if (rtn == 0) {
                fputs ("    Introduzca un numero valido para el valor: A%co. \n",164,stderr);
                em_stdin();
            } else if ( input < 2021) {
                fputs ("   El a%co tiene que ser a partir del 2021. \n",164,stderr);
                em_stdin();
            } else {
                fputs (" ERROR DESCONOCIDO VERIFIQUE LOS DATOS  VUELVA A INTENTARLO DE NUEVO ... ")
                em_stdin();                
            } 
        } // Año
        for (int i = 0; i < 100; i++) {
            if (pedido[i].DiaEnvio == suDia && pedido[i].MesEnvio == suMes && pedido[i].AnnoEnvio == codigo) {
                z = 2;
            }            
        } // Bucle para 100 pedidos
        if (z != 2) {
            printf("\n No se han encontrado pedidos ese dia. \n");
        }
        numeroDePedido = 1;
        for (int i = 0; i < 100; i++) {
            id = pedidos[i].IdPaciente;
            if (pedidos[i].DiaEnvio == suDia && pedidos[i].MesEnvio == suMes && pedidos[i].AnnoEnvio == suAnno && pedidos[i].almacen == codigo) {
                z = 1;
                printf("Pedido almacen : %s \n", almacen[codigo].calle);
                for (int j = contadorPedidos; j < 100; j++) {
                    if (pedido[i].DiaEnvio == suDia && pedido[i].MesEnvio == suMes && pedido[i].AnnoEnvio == suAnno && pedidos[i].almacen == codigo) {
                        printf("    Pedido %i. \n", NumPedido);
                        NumPedido++;
                        printf("    Destino pedido: Distancia: %i & Angulo: %i. \n",paciente[id -1].distancia, paciente[id -1].angulo);
                        for (int k = 0; k < 5; k++) {
                            if (pedido[i].items[j].unidadesMedicamento > 0) {
                                printf("%2i Unidades    %s", pedido[i].items[k].unidadesMedicamento, pedido[i].items[k].nombreMedicamento);
                                longitud = strlen(pedido[i].items[k].nombreMedicamento);
                                for (int j = longitud; j < 20; j++) {
                                    printf(" ");
                                }
                                printf("    Peso: 4%i gramos\n",pedido[i].items[k].pesoMedicamento);
                                peso = (pedido[i].items[k].pesoMedicamento * pedido[i].items[k].unidadesMedicamento);
                                PesoTotalPedido = PesoTotalPedido + peso;
                            }
                        } // for de k
                        printf("    Peso total del pedido: %4i gramos.\n", pedido[n].PesoTotalPedido);
                    } // if de configuracion dia,mes, año y codigo de almacen
                    PesoTotalPedido = 0;
                    i++;
                } // for de contador de pedidos < 100
            } // if de configuracion dia,mes, año y codigo de almacen
        } // bucle for hasta 100
        z = 0;
    } // condicional de contadoralmacen    
    else {
        printf("    No hay almacenes creados para ver pedidos. \n");
    }
}
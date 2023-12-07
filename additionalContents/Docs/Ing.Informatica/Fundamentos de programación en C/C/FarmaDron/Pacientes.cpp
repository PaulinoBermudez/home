#include <stdio.h> 
#include "Pacientes.h"
#include "Pedidos.h"

void empty_stdin(void){
    int p = getchar();
    while ( p != '\n' && p != EOF) {
        p = getchar();
    }
}

void pacientes::altaPaciente() {

    input = 0,
    rtn = 0;

    if ( contadorAlmacen > 1) { // CONDICIONAL DE PACIENTES MAYOR QUE 1.
        if (contadorPaciente < 20 ) { // contador de pacientes máximo = 20.
            do { // Dar de alta a otro paciente
                do { // Bucle anidado para el alta de pacientes.
                    do { // Ver si los datos son correctos.
                        if (unPacienteMasEnAlmacen < 50 && (datoscorrectos != 'S' || datoscorrectos != 's')) { // Maximo 50 pacientes por almacen
                            if (unPacienteMasEnAlmacen != 'S') {
                                // Alta pacientes
                                printf("\n Alta nuevo paciente.\n\n");
                                for (;;) {
                                    printf ("       Codigo Almacen (1-10): ");
                                    rtn = scanf("%d", &input);
                                    if (rtn == 0) {
                                        fputs("       Introduzca un numero entero positivo, por favor.\n", stderr);
                                        empty_stdin();
                                    } else if ( input < 1 || input >= contadorAlmacen) {
                                        fputs("       ALMACEN NO EXISTE! - Vuelva a probar con otro.\n", stderr);
                                        empty_stdin();
                                    } else if (input > 1 || input < contadorAlmacen) {
                                        paciente[contadorPaciente].almacen = input;
                                        empty_stdin();
                                        break;
                                    }               
                                }
                                almacenN = paciente[contadorpaciente].almacen;
                                print("\n Datos de paciente:\n");
                            }
                            do {
                                if (unPacienteMasEnAlmacen == 'S') {
                                    paciente[contadorPaciente].almacen = almacenN;
                                    printf("\n");
                                }
                                if (z == 5) {
                                    // Nombre del paciente.
                                    printf("\n Introduzca un nombre (1 - 20 caracteres): \n");
                                }
                                printf("    Nombre paciente (Entre 1 - 20 caracteres): ")
                                scanf(" %[^\n]s", &paciente[contadorpaciente].nombre); // guardamos datos de entrada - Nombre nuevo paciente.
                                longitud = strlen(paciente[contadorpaciente].nombre); // comprobamos la longitud del nombre del nuevo paciente dado de alta.
                                z=5;                            
                            } while ( longitud < 1 || longitud > 20); // bucle do-while para dar de alta un nuevo usuario.
                            z = 0;
                            for (;;)
                            {
                                /* Distancia desde el almacen a la casa del cliente.
                                * Sirve para saber al dron las coordenadas que debe recorrer de ida y calcular la vuelta.
                                * además, de para su representación, la almacenaremos como coordenadas del eje X.
                                * 
                                * La distancia máxima recorrida es de 10 km para que tenga autonomía suficiente para volver a la base del almacen.
                                */ 
                                printf("    Exscriba la distancia (10000 metros máximo): ");
                                rtn = scanf("%d", &input);
                                // Comprobamos la distancia introducida por teclado.
                                if (rtn == 0) {
                                    fputs("       INTRODUZCA UN NUMERO ENTERO POSITIVO >1. \n", stderr);
                                    empty_stdin();
                                } else if ( input < 1 || input > 10000) {
                                    fputs(" ERROR DE DISTANCIA - La distancia debe estar comprendida entre 1 y 10000 metros. \n", stderr);
                                    empty_stdin();
                                } else if ( input > 1 || input < 10000) {
                                    // Almacenamos los datos de distancia del paciente.
                                    paciente[contadorpaciente].distancia = input;
                                    empty_stdin();
                                    break;
                                }                            
                            }
                            for (;;) {
                                /* Angulo.
                                * 
                                *           A      |       B
                                *                  |
                                *      ------------+------------
                                *                  |
                                *           C      |       D
                                * 
                                * 
                                * Nos indica la inclinación en línea recta que tomará el dron para llegar a las coordenadas del paciente.
                                * El dron, realiza una trayectoria en línea recta, pero al abarcar los cuatro ejes del eje cartesiano, se usan la transformación en Pi radianes 
                                * que indiquen el cuadrante al que debe ir el dron (A,B,C o D).
                                */
                                printf("    Escriba el angulo de distancia con el paciente (entre 0 y 2000 milesimas de PI radianes): ");
                                rtn = scanf(" %d", &input);
                                // Comprobamos la medida introducida por teclado.
                                if (rtn == 0) {
                                    fputs("       INTRODUZCA UN NUMERO ENTERO. \n", stderr);
                                    empty_stdin();
                                } else if ( input < 0 || input > 2000) { // No son válidos valores menores de 0 y mayores a 2000 milesimas de PI radianes.
                                    fputs(" ERROR DE ANGULO - El angulo debe estar comprendido entre 0 y 2000. \n", stderr);
                                    empty_stdin();
                                } else if ( input > 0 || input <= 2000) {
                                    // almacenamos el angulo introducido.
                                    paciente[contadorpaciente].angulo = input;
                                    empty_stdin();
                                    break;
                                }                            
                            }
                            do {
                                // Comprobación de los datos introducidos son correctos.
                                if (datoscorrectos == '.') {
                                    printf("    Escriba S-(si) o N-(no) \n");
                                }
                                printf("\n Datos correctos? (S/N): ");
                                scanf("%[^\n]c",&datoscorrectos);
                                // No son correctos
                                if (datoscorrectos == 'n' || datoscorrectos == 'N') {
                                    datoscorrectos = 'N';
                                }
                                // Los datos con correctos
                                if ( datoscorrectos == 's' || datoscorrectos == 'S') {
                                    datoscorrectos = 'S';
                                }
                                // OK
                                if ( datoscorrectos == 'S' || datoscorrectos == 'N') {                                
                                }
                                // Otro tipo de caracter es inválido
                                if ( datoscorrectos != 'N' || datoscorrectos != 'S') {
                                    datoscorrectos = '.';
                                    fputs("Introduzca un valor valido! Este caracter no lo conozco ... \n", stderr);
                                }
                            } while (datoscorrectos != 'S' && datoscorrectos != 'N');                        
                        } // Bucle de datos de paciente. - Nombre, distancia, angulo.                    
                    } while ( datoscorrectos == 'N' || datoscorrectos == 'n'); // Los datos son incorrectos, vuelve a solicitarlos
                    // Contador de identificadores de almacen de pacientes.
                    if (paciente[contadorpaciente].almacen == 1) {
                        paciente[contadorpaciente].IdInterno = idAlmacen1;
                        idAlmacen1++;
                    } else if ( paciente[contadorpaciente].almacen == 2) {
                        paciente[contadorpaciente].idInterno = idAlmacen2;
                        idAlmacen2++;
                    } else if ( paciente[contadorpaciente].almacen == 3) {
                        paciente[contadorpaciente].idInterno = idAlmacen3;
                        idAlmacen3++;
                    } else if ( paciente[contadorpaciente].almacen == 4) {
                        paciente[contadorpaciente].idInterno = idAlmacen4;
                        idAlmacen4++;
                    } else if ( paciente[contadorpaciente].almacen == 5) {
                        paciente[contadorpaciente].idInterno = idAlmacen5;
                        idAlmacen5++;
                    } else if ( paciente[contadorpaciente].almacen == 5) {
                        paciente[contadorpaciente].idInterno = idAlmacen5;
                        idAlmacen5++;
                    } else if ( paciente[contadorpaciente].almacen == 6) {
                        paciente[contadorpaciente].idInterno = idAlmacen6;
                        idAlmacen6++;
                    } else if ( paciente[contadorpaciente].almacen == 7) {
                        paciente[contadorpaciente].idInterno = idAlmacen7;
                        idAlmacen7++;
                    } else if ( paciente[contadorpaciente].almacen == 8) {
                        paciente[contadorpaciente].idInterno = idAlmacen8;
                        idAlmacen8++;
                    } else if ( paciente[contadorpaciente].almacen == 9) {
                        paciente[contadorpaciente].idInterno = idAlmacen9;
                        idAlmacen9++;
                    } else if ( paciente[contadorpaciente].almacen == 10) {
                        paciente[contadorpaciente].idInterno = idAlmacen10;
                        idAlmacen10++;
                    } else {
                        printf("No puedo guardar más almacenes en el sistema. Max: 10. \n");
                    }
                    /* Incrementamos en una unidad la cantidad de los pacientes registrados del sistema. */
                    paciente[contadorpaciente].Id = contadorpaciente+1;
                    contadorpaciente++;
                    do { 
                        if (unPacienteMasEnAlmacen == '.') {
                            printf("Escriba S-Si o N-No \n");
                        }
                        printf("¿Desea registrar otro paciente en el almacen? (S/N): ");
                        scanf(" %s",&unPacienteMasEnAlmacen);
                        if (unPacienteMasEnAlmacen == 'n' || unPacienteMasEnAlmacen == 'N') {
                            unPacienteMasEnAlmacen == 'N';
                        }
                        if ( unPacienteMasEnAlmacen == 's' || unPacienteMasEnAlmacen == 'S') {
                            unPacienteMasEnAlmacen == 'S';
                        }
                        if (unPacienteMasEnAlmacen == 'S' || unPacienteMasEnAlmacen == 'N') {                          
                        } else {
                            unPacienteMasEnAlmacen = '.';
                        }                      
                    } while (unPacienteMasEnAlmacen != 'S' && unPacienteMasEnAlmacen != 'N'); // bucle do-while de registro de nuevos pacientes, despues de otro ya recién registrado
                } while (unPacienteMasEnAlmacen == 'S'); // Cierre de bucle de alta de pacientes.
                do { // do-while  para dar de alta otro paciente.
                    if (unPacienteMasEnAlmacen == '.') {
                        printf("    Escriba S-Si o N-No. \n");
                    }
                    printf("¿Desea registrar otro paciente en el almacen? (S/N): ")
                    scanf("%s", &unPacienteMasEnAlmacen);
                    if ( unPacienteMasEnAlmacen == 'n' || unPacienteMasEnAlmacen == 'N') {
                        unPacienteMasEnAlmacen = 'N';
                    }
                    if (unPacienteMasEnAlmacen == 's' || unPacienteMasEnAlmacen == 'S') {
                        unPacienteMasEnAlmacen = 'S';
                    }
                    if (unPacienteMasEnAlmacen 'S' || unPacienteMasEnAlmacen == 'N') {                          
                    }
                    else {
                        unPacienteMasEnAlmacen = '.';
                    }                      
                } while (unPacienteMasEnAlmacen != 'S' && unPacienteMasEnAlmacen != 'N');
                datoscorrectos = ' '; // Limpiamos el valor de la variable para preguntar si damos de alta a otro paciente.
            } while ((unPacienteMasEnAlmacen == 'S' || unPacienteMasEnAlmacen == 's') && contadorpaciente < 20); // Registramos un máximo 20 pacientes, siempre que nos digan un sí
            printf("\n");
        } // y Máximo de pacientes dados de alta: 20.
    } else { // No se han encontrado dados de alta ningun dato de pacientes.
        printf("\n ------------------------------------------------------------ \n");
        printf("   >  No hay dados de alta ningun almacen en el sistema.");
        printf("\n ------------------------------------------------------------ \n");
    }    
} // VOID PACIENTES::ALTAPACIENTES

void pacientes::ubicacionPaciente() {
    if (contadorAlmacen > 1) { // Comprobador de existencia de almacenes en el sistema.
        printf("\n Lista de pacientes y sus ubicaciones. \n");
        /* Contador de pacientes según los almacenes del sistema.
         * Este bucle recorre las listas con los datos de pacientes guardadas  bajo el Id de un almacén.
         * En el recorrido del bucle se recogen los siguientes datos:
         * - Id de almacen.
         * - 
         * 
         */
        // Comprobar si el almacen es valido.
        for (;;) {            
            printf("    Id de almacen: ");
            rtn = scanf("%d",&input);
            // Validación del identificador de almacen.                
            if (rtn == 0) {
                // No puede tener ID = 0.
                fputs(" ERROR! - Introduzca un numero de almacen valido. Mayor que 0. \n",stderr);
                empty_stdin();
            } else if ( input < 1 || input >= contadorAlmacen) {
                fputs(" ERROR! - Introduzca un almacen existente. El almacen introducido no se encuentra en el sistema.\n", stderr);
                empty_stdin();
            } else if ( input > 1 || input < contadorAlmacen) {
                codigoAlmacen = input;
                empty_stdin();
                break;
            }

        }
        z = 0;
        // Cabecera del listado de pacientes dados de alta.
        printf("\n  ID.     Nombre      Distancia       Angulo\n\n");
        for (int i = 0; i < contadorPaciente; i++) {
            if (paciente[i].almacen == codigoAlmacen) {
                printf("    %2i     %s", paciente[i].idInterno, paciente[i].nombre);
                longitud = strlen(paciente[i].nombre);
                // Recorremos la longitud de la lista.
                for (int k = longitud; k < 24; k++) {
                    printf(" ");
                }
                printf("%5i     %4i \n",paciente[i].distancia, paciente[i].angulo);
            }            
        }
        printf("\n");
    } /* if de contadorAlmacen */ else {
        printf("\n DATA NULL - No datos guardados en el sistema. \n\n");
    }    
} // ubicacion pacientes
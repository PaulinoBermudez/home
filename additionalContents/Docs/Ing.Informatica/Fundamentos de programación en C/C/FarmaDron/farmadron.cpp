#include <stdio.h>
#include "Pacientes.h"
#include "Pedidos.h"

void empty_stdin(void)
{
    int c = getchar();

    while (c != '\n' && c != EOF)
        c = getchar();
}

void pacientes::altaPaciente()
{

    input = 0,
    rtn = 0;

    if (contadoralmacen > 1 ) { // CONDIIONAL DE PACIENTES MAYOR QUE 1.
        if (contadorpaciente < 20) { // CONDICIONAL DE PACIENTES NO MAYOR QUE 20.
            do { // BUCLE PARA OTROPACIENTE.
                do {
                    do { // BUCLE PARA VER SI DATOS SON CORRECTOS.
                        if (contadorpaciente < 50 && (datoscorrectos != 'S' || datoscorrectos != 's')) {
                            if (otropacientealmacen != 'S') {
                                // ALTA DE PACIENTES
                                printf("\nAlta nuevo paciente\n\n");
                                    for (;;) {
                                        printf("    Codigo almacen? (entre 1-10)?:");
                                        rtn = scanf(" %d", &input);
                                        // Codigo de almacen - CONDICIONES    
                                        if (rtn == 0) {
                                            fputs("      Tiene que introducir un numero entero.\n", stderr);
                                            empty_stdin();
                                        } else if (input < 1 || input >= contadoralmacen) {
                                            fputs("      Tiene que introducir un numero de un almacen que exista.\n", stderr);
                                            empty_stdin();
                                        } else if (input > 1 || input < contadoralmacen) {
                                            paciente[contadorpaciente].almac = input;
                                            empty_stdin();
                                            break;
                                        }
                                    } // bucle for de codigo de almacen
                                mismoalmacen = paciente[contadorpaciente].almac;
                                printf("\nDatos paciente:\n");
                            }
                            do
                            {
                                if (otropacientealmacen == 'S')
                                {
                                    paciente[contadorpaciente].almac = mismoalmacen;
                                    printf("\n");
                                }
                                if (z == 5)
                                {
                                    printf("\n      Introduzca un nombre con entre 1 y 20 caracteres\n");
                                }

                                printf("      Identificador paciente (entre 1 y 20 caracteres)?:"); //PEDIR NOMBRE DEL NUEVO PACIENTE

                                scanf(" %[^\n]s", &paciente[contadorpaciente].nombre); // GUARDAR NOMBRE EN MATRIZ
                                longi = strlen(paciente[contadorpaciente].nombre);
                                z = 5;
                            } while (longi < 1 || longi > 20);
                                z = 0;
                            for (;;)
                            {
                                printf("      Distancia (hasta 10000 metros a plena carga)?:");

                                rtn = scanf(" %d", &input);

                                if (rtn == 0)
                                {
                                    fputs("      Tiene que introducir un numero entero.\n", stderr);
                                    empty_stdin();
                                }
                                else if (input < 1 || input > 10000)
                                {
                                    fputs("      Introduzca una distancia no menor de 1 y no mayor de 10000 metros.\n", stderr);
                                    empty_stdin();
                                }
                                else if (input > 1 || input < 10000)
                                {
                                    paciente[contadorpaciente].distancia = input;
                                    empty_stdin();
                                    break;
                                }
                            }

                            for (;;)
                            {
                                printf("      Angulo (entre 0 y 2000 milesimas de PI radianes)?:");

                                rtn = scanf(" %d", &input);

                                if (rtn == 0)
                                {
                                    fputs("      Tiene que introducir un numero entero.\n", stderr);
                                    empty_stdin();
                                }
                                else if (input < 0 || input > 2000)
                                {
                                    fputs("      Introduzca un angulo no menor de 0 y no mayor de 2000.\n", stderr);
                                    empty_stdin();
                                }
                                else if (input > 0 || input <= 2000)
                                {
                                    paciente[contadorpaciente].angulo = input;
                                    empty_stdin();
                                    break;
                                }
                            }

                            do
                            {
                                if (datoscorrectos == '.')
                                {
                                    printf("      Escribe una S(si) o una N(no)\n");
                                }

                                printf("\nDatos correctos (S/N)?"); // PREGUNTAR SI LOS DATOS SON CORRECTOS

                                scanf(" %[^\n]c", &datoscorrectos); // GUARDAR EL VALOR EN LA VARIABLE datoscorrectos

                                if (datoscorrectos == 'n' || datoscorrectos == 'N')
                                {
                                    datoscorrectos = 'N';
                                }
                                if (datoscorrectos == 's' || datoscorrectos == 'S')
                                {
                                    datoscorrectos = 'S';
                                }
                                if (datoscorrectos == 'S' || datoscorrectos == 'N')
                                {
                                }
                                else
                                {
                                    datoscorrectos = '.';
                                }

                            } while (datoscorrectos != 'S' && datoscorrectos != 'N');
                        }

                    } while (datoscorrectos == 'N' || datoscorrectos == 'n'); // SI LOS DATOS NO SON CORRECTOS VUELVE AL DO
                    if (paciente[contadorpaciente].almac == 1)
                    {
                        paciente[contadorpaciente].refinterno = refalm1;
                        refalm1++;
                    }
                    else if (paciente[contadorpaciente].almac == 2)
                    {
                        paciente[contadorpaciente].refinterno = refalm2;
                        refalm2++;
                    }
                    else if (paciente[contadorpaciente].almac == 3)
                    {
                        paciente[contadorpaciente].refinterno = refalm3;
                        refalm3++;
                    }
                    else if (paciente[contadorpaciente].almac == 4)
                    {
                        paciente[contadorpaciente].refinterno = refalm4;
                        refalm4++;
                    }
                    else if (paciente[contadorpaciente].almac == 5)
                    {
                        paciente[contadorpaciente].refinterno = refalm5;
                        refalm5++;
                    }
                    else if (paciente[contadorpaciente].almac == 6)
                    {
                        paciente[contadorpaciente].refinterno = refalm6;
                        refalm6++;
                    }
                    else if (paciente[contadorpaciente].almac == 7)
                    {
                        paciente[contadorpaciente].refinterno = refalm7;
                        refalm7++;
                    }
                    else if (paciente[contadorpaciente].almac == 8)
                    {
                        paciente[contadorpaciente].refinterno = refalm8;
                        refalm8++;
                    }
                    else if (paciente[contadorpaciente].almac == 9)
                    {
                        paciente[contadorpaciente].refinterno = refalm9;
                        refalm9++;
                    }
                    else if (paciente[contadorpaciente].almac == 10)
                    {
                        paciente[contadorpaciente].refinterno = refalm10;
                        refalm10++;
                    }
                    paciente[contadorpaciente].ref = contadorpaciente+1;
                    contadorpaciente++; // SI LOS DATOS SON CORRECTOS, SUMAMOS 1 AL CONTADOR DE PACIENTES
                    do
                    {
                        if (otropacientealmacen == '.')
                        {
                            printf("      Escribe una S(si) o una N(no)\n");
                        }
                        printf("Otro paciente mismo almacen(S/N)?:");
                        scanf("%s", &otropacientealmacen);
                        if (otropacientealmacen == 'n' || otropacientealmacen == 'N')
                        {
                            otropacientealmacen = 'N';
                        }
                        if (otropacientealmacen == 's' || otropacientealmacen == 'S')
                        {
                            otropacientealmacen = 'S';
                        }
                        if (otropacientealmacen == 'S' || otropacientealmacen == 'N')
                        {
                        }
                        else
                        {
                            otropacientealmacen = '.';
                        }
                    } while (otropacientealmacen != 'S' && otropacientealmacen != 'N');
                } while (otropacientealmacen == 'S');

                do
                {
                    if (otropaciente == '.')
                    {
                        printf("      Escribe una S(si) o una N(no).\n");
                    }
                    printf("Otro paciente (S/N)?:"); // PREGUNTAMOS SI QUEREMOS DAR DE ALTA OTRO PACIENTE
                    scanf(" %s", &otropaciente);    // GUARDAMOS EL VALOR EN LA VARIABLE otropaciente
                    if (otropaciente == 'n' || otropaciente == 'N')
                    {
                        otropaciente = 'N';
                    }
                    if (otropaciente == 's' || otropaciente == 'S')
                    {
                        otropaciente = 'S';
                    }
                    if (otropaciente == 'S' || otropaciente == 'N')
                    {
                    }
                    else
                    {
                        otropaciente = '.';
                    }

                } while (otropaciente != 'S' && otropaciente != 'N');

                datoscorrectos = ' ';                                                        // RESETEAMOS EL VALOR DE datoscorrectos
            } while ((otropaciente == 'S' || otropaciente == 's') && contadorpaciente < 20); // SI otropaciente es SI entonces vuelve a ejecutar el primer DO
            printf("\n");
        }

    }else // contador de pacientes máximo de 20
        {
            printf("\nNo hay almacenes en la base de datos en los cuales dar de alta pacientes.\n\n");
        }

}


void pacientes::ubicarPaciente()
{
    if (contadoralmacen > 1)
    {
        printf("\nLista de pacientes y su ubicaci%cn\n\n", 162); // IMPRIMIR EN PANTALLA

        for (;;)
        {
            printf("       Codigo almacen?:");

            rtn = scanf(" %d", &input);

            if (rtn == 0)
            {
                fputs("       Tiene que introducir un numero entero.\n", stderr);
                empty_stdin();
            }
            else if (input < 1 || input >= contadoralmacen)
            {
                fputs("\n       Tienes que introducir un almacen que exista.\n", stderr);
                empty_stdin();
            }
            else if (input > 1 || input < contadoralmacen)
            {
                codigoalm = input;
                empty_stdin();
                break;
            }
        }
        z = 0;
        printf("\n       Ref.    Identificador       Distancia    %cngulo\n\n", 181); // IMPRIMIR EN PANTALLA
        for (int i = 0; i < contadorpaciente; i++)                                    // BUCLE FOR MEDIANTE EL CUAL SACAMOS UN LISTADO  DE TODOS LOS PACIENTES
        {
            if (paciente[i].almac == codigoalm)
            {
                printf("       %2i      %s", paciente[i].refinterno, paciente[i].nombre);
                longi = strlen(paciente[i].nombre);
                for (int k = longi; k < 24; k++)
                {
                    printf(" ");
                }
                printf("%5i      %4i\n", paciente[i].distancia, paciente[i].angulo);
            }
        }

        printf("\n");
    }
    else
    {
        printf("\nNo hay almacenes en la base de datos de los cuales mostrar pacientes.\n\n");
    }
}
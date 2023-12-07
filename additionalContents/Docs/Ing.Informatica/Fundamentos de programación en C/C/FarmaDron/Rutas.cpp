#include <stdio.h>
#include "Iniciargestion.h"
#include "Pedidos.h"
#include "Rutas.h"
#include <graphics.h>
#include <winbgim.h>
#include <math.h>

void em_stdin(void) {
    int e = getchar();
    while (e != '\n' && e != EOF) {
        e = getchar();
    }
    int x1;
    int y1;
    int x2;
    int y2;
    int enCuadrante() {
        if( (x1 > 500 && x2 > 500 && y1 > 500 && y2 > 500) || (x1 < 500 && x2 < 500 && y1 > 500 && y2 > 500) || (x1 < 500 && x2 < 500 && y1 < 500 && y2 < 500) || (x1 > 500 && x2 > 500 && y1 > 500 && y2 > 500)) {
            return 1;
        } else {
            return 0;
        }
    }
    int distCoordenadas(int a, int b, int c) {
        return int(sqrt((pow((a-c),2)+pow((b-d),2)))*100);        
    }
    int dist_to_center(int a,int b){
        return int(sqrt((pow((a-500),2)+pow((b-500),2)))*100);
    }
}

void rutas::programarRutas() {
    if (contadoralmacen > 1) {
        printf("    Programar rutas diarias del dron. \n");
        for (;;)
        {
            printf("    ¿Codigo? ");
            rtn = scanf("%d",&input);
            if (rtn == 0) {
                fputs(" Error de codigo - El codigo 0 no es valido. \n", stderr);
                em_stdin();
            } else if ( input < 1 || input > 10 ) {
                fputs(" Error de codigo - Codigo fuera de los rangos validos. \n", stderr);
                em_stdin();
            } else if (input != almacen[0].codigo && input != almacen[1].codigo && input != almacen[2].codigo && input != almacen[3].codigo && input != almacen[4].codigo && input != almacen[5].codigo && input != almacen[6].codigo && input != almacen[7].codigo && input != almacen[8].codigo && input != almacen[9].codigo) {
                fputs(" Error de codigo - El almacen no existe en el sistema. \n", stderr);
                em_stdin();
            } else {
                codigo = input; 
                em_stdin();
                break;
            }
        } // bucle for para programar rutas diarias del dron.  
        for (int i = 0; i < 11; i++)
        {
            if (almacen[i].codigo == this.codigo) {
                m = 2;
                n = i;
            }            
        }
        for (;;) {
            printf("Dia: ");
            rtn = scanf("%d",&input);
            if (rtn == 0) {
                fputs(" Error de entrada - Introduzca un numero valido, 0 no es valido para DIA. \n", stderr);
                em_stdin();
            } else if (input < 1 || input > 31) {
                fputs("Error de entrada  - La entrada para DIA no esta entre los parametros validos. \n", stderr);
                em_stdin();
            } else {
                suDia = input;
                em_stdin();
                break;
            }            
        }
        for (;;) {
            printf("Mes: ");
            rtn = scanf("%d",&input);
            if (rtn == 0) {
                fputs ("    Introduzca un numero valido para mes, mayor que 0.\n", stderr);
                em_stdin();
            } else if ( input < 1 || input > 12) {
                fputs (" Introduzca un numero de dia valido, entre 1 y 12. \n", stderr);
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
                } else if ((input == 2) && pedido[contadorPedidos].DiaEnvio <= 29  && CalBis(input) == true ) {
                    suMes == input;
                    em_stdin();
                    break;
                } else {
                    fputs (" ERROR EN LOS DATOS DE FECHA INTRODUCIDOS - No coincide MES con en numero de DIAS introducido. \n", stderr);
                    em_stdin();
                }                            
            } // Condicional para compribar la fecha de mes + dia 
        } // bucle for para mes
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
        for (int i = 0; i < 100; i++) {
            if (pedido[i].almacen == almacen[n].codigo && pedido[i].DiaEnvio == suDia && pedido[i].MesEnvio == suMes && pedido[i].AnnoEnvio == suAnno) {
                array[j] = i;
                j++;
            }            
        }
        // Calculamos las distancias del vector de angulo
        for (int i = 0; i < j; i++) {
            for (int k = 0; k < 100; k++) {
                if (paciente[k].IdInterno == pedido[array[i]].IdInterno && paciente[k].almacen == pedido[array[i]].almacen && paciente[k].distancia > 0) {
                    pedido[array[i]].distance = paciente[k].distancia;
                    pedido[array[i]].anguloFin = paciente[k].angulo;
                    vector = pedido[array[i]].anguloFin;
                    pedido[array[i]].EjeX = int((((cosf(vector/1000.0f*M_PI)*pedido[array[i]].distance))/100+500));
                    pedido[array[i]].EjeY = int((((sinf(vector/1000.0f*M_PI)*pedido[array[i]].distance))/100+500));
                }
            }
        }
        // Ordenar pedidos segun peso, distancia entre ellos y distancia con el almacen base.
        for (int i = 0; i < n; i++) {
            ps = i;
            aux = array[i];
            while (i > 0 && (pedido[array[i]].PesoTotalPedido > pedido[array[i-1]].PesoTotalPedido) && enCuadrante(pedido[array[i-1]].EjeX,pedido[array[i-1]].EjeY,pedido[array[i]].EjeX,pedido[array[i]].EjeY) == 0 ) {
                array[ps] = array[ps-1];
                ps --;
            }
            while (i > 0 && (enCuadrante(pedido[array[i-1]].EjeX, pedido[array[i-1]].EjeY, pedido[array[i]].EjeX, pedido[array[i]].EjeY) == 1) && dist_to_center(pedido[array[i]].EjeX, pedido[array[i]].EjeY) < dist_to_center(pedido[array[i-1]].EjeY))) {
                array[ps] = array[ps-1];
                ps--;                
            }
            array[ps]=aux;
        }
        for (int i = 0; i < n; i++) {            
        }
        // calcular rutas del mismo dia.
        l = 0;
        m = 0;
        for (int i = 0; i < n; i++) {
            pesoMaxRuta = pesoMaxRuta+pedido[array[i]].PesoTotalPedido;
            distMaxRuta = int(distMaxRuta + ((pedido[array[i]].PesoTotalPedido * (5/3000))*1000) + dist_coordenadas(pedido[array[i]].EjeX, pedido[array[i-1]].EjeX, pedido[array[i]].EjeY, pedido[array[i]].EjeY));
            m++;
            if ( n == 1 ) {
                ruta[l].numRutas = 1;
                ruta[l].pesoTotalPedidoR = pedido[array[i]].PesoTotalPedido;
                j++;
            }
            if (pesoMaxRuta > 3000 || distMaxRuta > 25000) {
                ruta[l].numRutas = m;
                ruta[l].pesoTotalPedidoR = pesoMaxRuta - pedido[array[i]].PesoTotalPedido;
                l++;
                m = 0;
                i--;
                pesoMaxRuta = 0;
                distMaxRuta = 0;
                j++;
            }                        
        }
        for (int o = 0; o < j; o++) {
            if (j == 0) {
                printf("\n No hay pedidos. \n");
                break;
            }
            printf("\n  Ruta: %i.\n", j+1);
            // Calcular el peso maximo del pedido
            for (int t = 0; t < j; t++) {
                if (maxPeso > 3000) {
                    maxPeso = maxPeso + pedido[array[t]].PesoTotalPedido;
                }
                if (maxPeso > 3000) {
                    maxPeso = maxPeso - pedido[array[t]].PesoTotalPedido;
                }
            }
            for (int i = 0; i < m; i++) {
                if (i == o)
                {
                    printf("Origen cliente %i   --Distancia recorrida: %5i  Angulo: %4i     --Peso: %4i gramos. \n", pedido[array[i]].IdInterno, pedido[array[i]].distance, pedido[array[i]].angulo, maxPeso);
                    distRuta = pedido[array[i]].distance;
                    peso = maxPeso;
                    maxDist = int(((maxPeso * (5/3000.0f))*1000)+pedido[array[i]].distance);
                } else if (maxDist < 25000 &&  j - i > 0 ) {
                    distance = dist_coordenadas (pedido[array[i]].EjeX, pedido[array[i]].EjeY, pedido[array[i-1]].EjeX, pedido[array[i-1]].EjeY);
                    w = (atan2(pedido[array[i]].EjeY-pedido[array[i-1]],pedido[array[i]].EjeX-pedido[array[i-1]].EjeX));
                    if (w < 0) {
                        angulo = int((w+(2*M_PI))/M_PI*1000.0);
                    } else {
                        angulo = int(w/M_PI*1000.0);
                    }
                    distRuta += distance;
                    peso -= pedido[array[i-1]].PesoTotalPedido;
                    maxDist = (maxDist + ((maxPeso * (5/3000))*1000)+distance);
                    printf("Cliente %i a cliente %i  -- Distancia recorrida: %5i    Angulo: %4i     Peso: %4i gramos.\n", pedido[array[i-1]].IdInterno, pedido[array[i]].IdInterno, distance, angulo, peso);
                }
                if (((maxDist < 25000 &&  i - j == 1) && i != 1) || i == 1) {
                    peso -= pedido[array[j]].PesoTotalPedido;
                    distRuta = distRuta + pedido[array[j]].distance;
                    w = (atan2(500-pedido[array[j]].EjeY, 500-pedido[array[j]].EjeX));
                    if (w < 0) {
                        angulo = int((w+(2*M_PI))/M_PI*1000.0);
                    } else {
                        angulo = int(w/M_PI*1000.0);
                    }
                    printf("Cliente %i a origen.    --Distancia recorrida: %5i      Angulo: %4i     Peso: %4i gramos. \n", pedido[array[j]].IdInterno, pedido[array[j]].distance, angulo, peso);
                }
                if (maxDist > 25000) {
                    maxDist = 0;
                    break;
                }                                                
            }
            maxPeso = 0;
            printf("Disntancia total de la ruta: %i \n", distRuta);
        }        
    } else {
        printf(" No hay almacenes creados. Creelos antes para generar rutas. \n");
    }
    printf("\n\n");
    j = 0;    
}

void rutas::dibujarRutas() {
    if (contadorAlmacen > 1) {
        printf("Representar las rutas diarias del dron. \n");
        for (;;) {
            printf("Codigo: ");
            rtn = scanf("%d",&input);
            if (rtn == 0) {
                fputs("Codigo invalido. \n", stderr);
                em_stdin();
            } else if (input < 1 || input > 10) {
                fputs(" El codigo introducido no es valido, sale del rango del sistema. \n", stderr);
                em_stdin();
            } else if (input != almacen[0].codigo && input != almacen[1].codigo && input != almacen[2].codigo && input != almacen[3].codigo && input != almacen[4].codigo && input != almacen[5].codigo && input != almacen[6].codigo && input != almacen[7].codigo && input != almacen[8].codigo && input != almacen[9].codigo) {
                fputs(" El almacen no existe. \n", stderr);
                em_stdin();
            } else {
                codigo = input;
                em_stdin();
                break;
            }            
        }
        for (int i = 0; i < 11; i++) {
            if (almacen[i].codigo == this.codigo) {
                m = 2;
                n = i;
            }            
        }
        for (;;) {
            printf("Dia: ");
            rtn = scanf("%d",&input);
            if (rtn == 0) {
                fputs(" Error de entrada - Introduzca un numero valido, 0 no es valido para DIA. \n", stderr);
                em_stdin();
            } else if (input < 1 || input > 31) {
                fputs("Error de entrada  - La entrada para DIA no esta entre los parametros validos. \n", stderr);
                em_stdin();
            } else {
                suDia = input;
                em_stdin();
                break;
            }            
        }
        for (;;) {
            printf("Mes: ");
            rtn = scanf("%d",&input);
            if (rtn == 0) {
                fputs ("    Introduzca un numero valido para mes, mayor que 0.\n", stderr);
                em_stdin();
            } else if ( input < 1 || input > 12) {
                fputs (" Introduzca un numero de dia valido, entre 1 y 12. \n", stderr);
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
                } else if ((input == 2) && pedido[contadorPedidos].DiaEnvio <= 29  && CalBis(input) == true ) {
                    suMes == input;
                    em_stdin();
                    break;
                } else {
                    fputs (" ERROR EN LOS DATOS DE FECHA INTRODUCIDOS - No coincide MES con en numero de DIAS introducido. \n", stderr);
                    em_stdin();
                }                            
            } // Condicional para compribar la fecha de mes + dia 
        } // bucle for para mes
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
        for (int i = 0; i < 100; i++) {
            if (pedido[i].almacen == almacen[n].codigo && pedido[i].DiaEnvio == suDia && pedido[i].MesEnvio == suMes && pedido[i].AnnoEnvio == suAnno) {
                array[j] = i;
                j++;
            }            
        }
        for (int i = 0; i < j; i++)
        {
            for (int k = 0; k < 100; k++)
            {
                if (paciente[k].IdInterno == pedido[array[k]].IdInterno && paciente[k].almacen == pedido[array[k]]almacen && paciente[k].distance > 0) {
                    pedido[array[i]].distance = paciente[k].distancia;
                    pedido[array[i]].angulo = paciente[k].angulo;
                }                
            }            
        }
        523
    }
    
}
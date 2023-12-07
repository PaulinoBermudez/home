#include <stdio.h>
#include <conio.h>
#include "Calendario.h"
#include "Pedidos.h"

void emp_stdin(void) {
    int c = getchar();
    while (c != '\n' && c != EOF){
        c = getchar();
    }
}

// Calcular si un año es bisiesto o no.
bool CalBis(int n) {
    if ( n % 4 == 0 && n % 100 != 0){
        return true;
    } else if ( n % 4 == 0 && n % 100 == 0){
        return false;
    } else if ( n % 400 == 0 ){
        return true;
    }
}

int calendario::calendarioMensual(){
    printf('Calemdario mensual de pedidos. \n');
    for(;;){
        printf("Seleccione un mes del a%co: ",164);
    
        if(rtn == 0){
            fputs(" Debe introducir un numero entero.\n", stderr);
            emp_stdin();
        } else if(input > 1 || input < 12){
            mes = input;
            emp_stdin();
            break;
        }
    }
    for(;;){
        printf("Seleccione un a%co: ",164);
        rtn = scanf("%d", &input);
        if ( rtn == 0 ){
            fputs(" Debe introducir un numero entero.\n", stderr);
            emp_stdin();
        } else if (input < 2021){
            fputs(" No puede intriducir un a%co anterior al actual.\n",164 stderr);
            emp_stdin();
        } else if (input >= 2021) {
            anno = input;
            emp_stdin();
            break;
        }
    }
    // Contador de dias todales desde el 1 de enero de 1601 hasta el 1 del mes seleccionado.
    contadorBis = 0;
    contadornBis = 0;

    for ( int i = 0; i < anno - 1601; i++){
        contadorAnno = 1601+i;
        if (contadorAnno % 4 == 0 && contadorAnno % 100 != 0 || contadorAnno % 400 == 0){
            contadorBis++;
        } else {
            contadorBis++;
        }
    }
    DiasBis = contadorBis * 366;
    DiasnBis = contadorBis * 365;
    diasTotales = DiasBis + DiasnBis;

    if ( diasTotales < 0 ){
        return 0;
    }

    // Calcular si el año es bisiesto.
    // sumar dias totales desde el 1 de enero del año de entrada al 1 del mes de entrada.
    if ( mes == 1 ){ diasTotales = diasTotales; }
    if ( mes == 2 ){ diasTotales = (diasTotales + 31);}
    if ( mes == 3 ){ if (CalBis(anno) == true){diasTotales = diasTotales + 60;} else { diasTotales = (diasTotales + 59);};}
    if ( mes == 4 ){ if (CalBis(anno) == true){diasTotales = diasTotales + 91;} else { diasTotales = (diasTotales + 90);};}
    if ( mes == 5 ){ if (CalBis(anno) == true){diasTotales = diasTotales + 121;} else { diasTotales = (diasTotales + 120);};}
    if ( mes == 6 ){ if (CalBis(anno) == true){diasTotales = diasTotales + 152;} else { diasTotales = (diasTotales + 151);};}
    if ( mes == 7 ){ if (CalBis(anno) == true){diasTotales = diasTotales + 182;} else { diasTotales = (diasTotales + 181);};}
    if ( mes == 8 ){ if (CalBis(anno) == true){diasTotales = diasTotales + 213;} else { diasTotales = (diasTotales + 212);};}
    if ( mes == 9 ){ if (CalBis(anno) == true){diasTotales = diasTotales + 244;} else { diasTotales = (diasTotales + 243);};}
    if ( mes == 10 ){ if (CalBis(anno) == true){diasTotales = diasTotales + 274;} else { diasTotales = (diasTotales + 273);};}
    if ( mes == 11 ){ if (CalBis(anno) == true){diasTotales = diasTotales + 305;} else { diasTotales = (diasTotales + 304);};}
    if ( mes == 12 ){ if (CalBis(anno) == true){diasTotales = diasTotales + 335;} else { diasTotales = (diasTotales + 334);};}

    // Calcular dia en que empieza el mes.
    if ( diasTotales % 7 == 0 ){ numerodia = 0;} // Domingo
    if ( diasTotales % 7 == 1 ){ numerodia = 1;} // Lunes 
    if ( diasTotales % 7 == 2 ){ numerodia = 2;} // Martes
    if ( diasTotales % 7 == 3 ){ numerodia = 3;} // Miercoles
    if ( diasTotales % 7 == 4 ){ numerodia = 4;} // Jueves
    if ( diasTotales % 7 == 5 ){ numerodia = 5;} // Viernes
    if ( diasTotales % 7 == 6 ){ numerodia = 6;} // Sabado

    // Crear calendario.
    printf("\n");
    if ( mes == 1 ){ p = 5; printf("ENERO");}
    else if ( mes == 2 ){ p = 7; printf("FEBRERO");}
    else if ( mes == 3 ){ p = 5; printf("MARZO");}
    else if ( mes == 4 ){ p = 5; printf("ABRIL");}
    else if ( mes == 5 ){ p = 4; printf("MAYO");}
    else if ( mes == 6 ){ p = 5; printf("JUNIO");}
    else if ( mes == 7 ){ p = 5; printf("JULIO");}
    else if ( mes == 8 ){ p = 6; printf("AGOSTO");}
    else if ( mes == 9 ){ p = 10; printf("SEPTIEMBRE");}
    else if ( mes == 10 ){ p = 7; printf("OCTUBRE");}
    else if ( mes == 11 ){ p = 9; printf("NOVIEMBRE");}
    else if ( mes == 12 ){ p = 9; printf("DICIEMBRE");}
    
    for ( int i = p; i < 23; i++){
        printf(" ");
    }

    printf("%d\n", anno);
    printf("============================\n");
    printf(" LU  MA  MI  JU  VI | SA  DO\n");
    printf("============================\n");
    
    // Obtener dias que tiene el mens.
    if ( CalBis(anno) == true && mes == 2 ){
        diaMes = 29;
    } 
    if ( mes == 4 || mes == 6 || mes == 9 || mes == 11 ){ 
        diaMes = 30;
    }
    else if ( CalBis(anno) == false && mes == 2 ){ 
        diaMes = 28;
    } else { 
        diaMes = 31
    }
    // Imprimir primeros puntos.
    h = 0;
    for (int k = numerodia; k >= 1 ; k--){
        if ( h % 7 == 5){ printf("| ");}
        if ( h % 7 != 0 && h % 7 != 5){ printf(" ");}
        printf("  ");
        h++;
    }
    for ( int k = 0; k < diaMes; k++){
        for (int j = 0; j < 100; j++){
            if (pedido[j].DiaEnvio == (k+1) && pedido[j].AnnoEnvio == anno && pedido[j].MesEnvio == mes){
                y = pedido[j].DiaEnvio;
            }
        }
        if ( h != 0){
            if ( h % 7 == 0){ 
                printf("\n");
            }
        }
        if ( h % 7 == 5){ 
            printf("| ");
        }
        if ( h % 7 != 0 && h % 7 != 5){ 
            printf(" ");
        }
        if ( y != 0 ){
            printf("%2d", y);
            y = 0;
        } else {
            printf("-- ");
        }
        h++;
    }
    while( h % 7 != 0){
        if ( h % 7 == 5){
            printf("| ");
        }
        if ( h % 7  != 0 && h % 7 != 5){ 
            printf("  ");            
        }
        h++;
    }
    printf("\n\n");
}
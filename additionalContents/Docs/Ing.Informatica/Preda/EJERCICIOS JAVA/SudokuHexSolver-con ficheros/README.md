# 1. SudokuHexSolver

SudokuHexSolver es un software que utiliza técnicas de búsqueda heurística para la resolución de sudokus hexadecimales.

Un sudoku hexadecimal es una variante del sudoku tradicional en la que el tablero es de tamaño 16x16 y está formado por bloques de tamaño 4x4 que se rellenan con dígitos hexadecimales (del 0 al 9 y de la A a la F).


## 2. Algoritmo

### 2.1  Técnicas de propagación de restricciones utilizadas

Para almacenar los posibles valores de cada casilla del tablero he utilizado una matriz de 16x16 enteros, pudiendo representar todos los valores permitidos de una casilla del sudoku con un sólo número entero. Esto lo he conseguido codificando cada valor posible de una casilla como un bit activo en dicho entero. Así si el bit de la posición b está activo en la casilla i,j de la matriz de valores permitidos significa que la casilla i, j del tablero admite a b como posible valor.

Gracias a esta codificación, cada vez que se asigna un valor a una casilla, quitar ese valor como válido para los valores de los pares de la casilla (esto es, los “compañeros” de la casilla en una fila, columna y bloque) es muy simple y eficiente; ya que se hace con operaciones lógicas (a nivel de bits).

Esta codificación también permite de manera muy eficiente (a nivel de bit) consultar el número de valores posibles para una casilla y, si sólo admite un único valor, consultar dicho valor.

Nota: Las casillas que están ocupadas en el tablero tienen establecido a 0 (ningún bit activo, ergo ningún posible valor) su valor correspondiente en la matriz de valores posibles para las casillas.

### 2.2 Técnicas de búsqueda y heurísticas utilizadas	

Mi algoritmo de resolución de sudokus hexadecimales consiste en aplicar iterativamente (y por el orden en el que aparecen) las siguientes técnicas:
	 
I. Rellenar las casillas con un único valor posible en la fila: Consiste en recorrer todas las filas, y encontrar las casillas vacías que, a pesar de tener varios valores posibles que se le pueden asignar, tienen un valor que no está como posible en ninguna otra casilla vacía de su fila (ni tampoco en una ocupada). Entonces se rellenan dichas casillas inequívocamente con su valor correspondiente.

II.  Rellenar las casillas con un único valor posible en la columna: es la misma técnica que la anterior, pero en lugar de por filas por columnas.

III.  Rellenar las casillas con único valor posible: Consiste en recorrer el tablero al completo y buscar todas las casillas vacías que sólo admiten un único valor posible y rellenarlas.

IV. Rellenar las casillas con único valor posible en bloque: Es una variante de las técnicas I y II, pero en este caso por bloques.

Cuando las técnicas anteriores dejan de producir cambios en el tablero (es decir, no consiguen rellenar ninguna casilla más) el algoritmo busca la primera casilla libre del tablero y la rellena con el valor más alto que permita. Esto produce un nuevo tablero sobre el que vuelve a tratar de aplicar las 4 técnicas.

Si este nuevo tablero no se puede rellenar al completo porque el valor elegido impone restricciones imposibles de cumplir (casillas libres con 0 valores permitidos) se “vuelve atrás” probando con el siguiente valor (que sería el segundo mayor posible); y así hasta encontrar el valor idóneo para esa casilla.

El algoritmo finaliza cuando están rellenas las 256 casillas del sudoku hexadecimal y, dado que en todos los pasos han de cumplirse las restricciones, el tablero es una solución válida.

→ En resumen, no se trata de un algoritmo complejo, sino que mediante la aplicación sistemática de reglas lógicas y la propagación de restricciones permite resolver sudokus rápidamente.

Nota: las restricciones del sudoku inicial se computan antes de aplicar estas técnicas y cada vez que se rellena una casilla se actualizan siguiendo las reglas del sudoku.

## 3. Ejecución

### 3.1 Compilar 

<pre>
cd src
javac SudokuHex.java Test.java
</pre>

### 3.2 Ejecutar

<pre>
java Test ../boards/<cualquiera>.txt
</pre>

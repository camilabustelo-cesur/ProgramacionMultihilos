# EJERCICIO 2: Programación multihilo

## SITUACIÓN
Tenemos que resolver los siguientes problemas para la empresa de
programación para la que trabajamos.

## INSTRUCCIONES
Disponemos de una clase denominada VariableCompartida que encapsula
el valor de una variable v de tipo int. La clase VariableCompartida
contiene métodos para establecer(método set), obtener(método get)
o incrementar(método inc) el valor de v.

Realizar un programa en Java que cree 2 hebras compartiendo una
instancia de la clase VariableCompartida e incrementen cada una de
ella 10 veces el valor de v. Mostrar desde la hebra del programa principal
el valor final dev.

### ¿Se obtienen los resultados esperados? 
Aumenta progresivamente el número de incrementos hasta observar algún comportamiento “extraño”. Justifica los resultados obtenidos

Con 10 incrementos por cada hilo se obtiene normalmente el resultado esperado (v = 20). 
Los mensajes mostrados por pantalla aparecen en un orden aparentemente desordenado porque los hilos se ejecutan concurrentemente y 
el sistema operativo decide cuándo se ejecuta cada uno.

Cuando aumentamos la cantidad de inncrementos a valores mas altos, como por ejemplo 100000 por hilo, empiezan a aparecer resultados incorrectos. 
El valor final de la variable compartida puede ser menor al esperado debido a las condiciones de carrera.
No siempre se obtienen los resultados esperados cuando varios hilos acceden y modifican una variable compartida sin mecanismos 
de sincronización. Este comportamiento se hace más evidente cuanto mayor es el número de incrementos realizados.
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

Con 10 incrementos por cada hilo se obtiene siempre el resultado esperado (v = 20), porque un hilo suele
terminar antes de que el otro empiece a trabajar.

Cuando aumentamos la cantidad de incrementos, el resultado deja de ser fiable. Con 1000 por hilo a veces
sale bien (2000) y a veces no (por ejemplo 1906). Con 100000 y 1000000 por hilo falla siempre y el valor
final es mucho menor al esperado (por ejemplo, unos 110000 en lugar de 200000).
El valor final de la variable compartida es menor al esperado debido a las condiciones de carrera: v++ no
es una operación atómica (lee v, suma 1 y escribe), así que si los dos hilos leen el mismo valor a la vez,
uno de los incrementos se pierde. El resultado además cambia en cada ejecución.
No siempre se obtienen los resultados esperados cuando varios hilos acceden y modifican una variable compartida sin mecanismos
de sincronización. Este comportamiento se hace más evidente cuanto mayor es el número de incrementos realizados.
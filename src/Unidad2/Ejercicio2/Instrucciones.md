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

No se obtienen los resultados esperados, ya que se observa que si bien el valor final de v es 20, pero incrementa de manera desordenada, 
es decir, no se incrementa de manera secuencial. Esto se debe a que las hebras están accediendo y modificando la variable compartida v de manera concurrente, lo que provoca condiciones de carrera.
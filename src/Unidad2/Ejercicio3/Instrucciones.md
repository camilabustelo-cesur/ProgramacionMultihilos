# EJERCICIO 3: Programación multihilo

## SITUACIÓN
Tenemos que resolver los siguientes problemas para la empresa de
programación para la que trabajamos.

## INSTRUCCIONES
Utilizando la clase VariableCompartida de la práctica anterior y una
instancia compartida de dicha clase, realizar un programa en Java donde
disponemos de una hebra que modifica los valores de la instancia de
VariableCompartida desde 0 a 99 utilizando el método set.
Disponemos también de otra hebra, que utilizando el método get debe
mostrar por pantalla todos los cambios que se van produciendo en la
instancia de VariableCompartida (sabiendo que se van a generar 100
valores).

#### ¿Se recogen todos los valores?¿Qué ocurre?
No se recogen todos los valores. Esto ocurre porque las hebras acceden a la
instancia de VariableCompartida sin ningún mecanismo de sincronización.
Como consecuencia, algunos valores pueden perderse y otros pueden mostrarse
repetidos. El hilo escritor es mucho más rápido que el lector: en las pruebas
termina de escribir (0 a 99) antes de que el lector empiece a leer, así que el
lector lee 100 veces el valor 99 y solo acierta 1 de los 100 valores esperados
(el último). El resultado no es determinista y puede cambiar entre ejecuciones,
pero en ningún caso se garantiza recoger todos los valores.

#### Intenta solucionar los problemas detectados.
Para solucionar el problema es necesario sincronizar el acceso a la variable compartida.
De esta forma, la hebra escritora no podrá escribir un nuevo valor hasta que la
hebra lectora haya leído el anterior.
Para ello, se usa synchronized, wait() y notifyAll() junto con una bandera
(hayDato): set() espera si el valor anterior aún no se ha leído y get() espera
si todavía no hay un valor nuevo. Así se turnan y el lector recoge los 100 valores.
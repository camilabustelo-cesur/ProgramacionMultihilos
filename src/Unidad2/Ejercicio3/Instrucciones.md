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
repetidos. Al momento de ejecutar, el hilo escritor modifica la variable 
desde 0 hasta 99 tan rápidamente que, cuando el hilo lector comienza a leer 
los valores, la variable ya contiene el valor 99. Por ello, se muestra 
repetidamente dicho valor y no llegan a visualizarse todos los cambios 
producidos en la variable compartida.

#### Intenta solucionar los problemas detectados.
Para solucionar el problema es necesario sincronizar el acceso a la variable compartida. 
De esta forma, la hebra escritora no podrá escribir un nuevo valor hasta que la
hebra lectora haya leído el anterior.
Para ello, se puede usar synchronized, wait() y notify().
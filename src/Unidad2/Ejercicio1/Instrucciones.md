# EJERCICIO 1: Programación multihilo

## SITUACIÓN
Tenemos que resolver los siguientes problemas para la empresa de
programación para la que trabajamos.

## INSTRUCCIONES
Realizar un programa en Java con 3 hebras, cada una de las cuales
escribe por pantalla varias veces (valor pasado como parámetro en el
constructor) el carácter que se le indique (también indicado como
parámetro). 

### ¿Se mezclan las letras? Justifica el comportamiento observado


Las letras se mezclan porque los hilos se ejecutan de manera concurrente, lo que significa que no hay un orden
garantizado en la ejecución de los hilos. 

Cada hilo puede ser interrumpido en cualquier momento por el sistema
operativo para permitir que otro hilo se ejecute. Esto provoca que las salidas de los hilos se entrelacen,
resultando en una mezcla de caracteres en la salida final.

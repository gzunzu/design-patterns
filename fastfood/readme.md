## EJEMPLO DE INYECCIÓN DE DEPENDENCIAS

La clase «temporal.Order» recibe un parámetro de clase «temporal.Channel» que determina las particularidades de atención/envío de cada comanda.

La clase «temporal.Order» se abstrae por completo de los tipos de canal creados, a pesar de encargarse de llevar un contador diferenciado.

La clase «temporal.Channel» y su jerarquía de herencia carecen de acoplamiento con respecto a la clase «temporal.Order».

* Uso de Java **Interface**.
* Principio **Open/Closed** de cara a la implementación de nuevos canales.

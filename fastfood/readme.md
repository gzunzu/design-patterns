## EJEMPLO DE INYECCIÓN DE DEPENDENCIAS

La clase «Order» recibe un parámetro de clase «Channel» que determina las particularidades de atención/envío de cada comanda.

La clase «Order» se abstrae por completo de los tipos de canal creados, a pesar de encargarse de llevar un contador diferenciado.

La clase «Channel» y su jerarquía de herencia carecen de acoplamiento con respecto a la clase «Order».

* Uso de Java **Interface**.
* Principio **Open/Closed** de cara a la implementación de nuevos canales.

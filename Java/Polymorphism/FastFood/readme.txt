Ejemplo de uso de inyección de dependencias. Uso de una Java interface.

El programa contiene una clase que es capaz de gestionar órdenes –pedidos–, con independencia del tipo de canal por el que hayan sido recibidas –teléfono, web, tienda–, aun teniendo en cuenta las particularidades funcionales de cada uno.

Se pretende que el programa gestione pedidos de comida rápida a través de 3 canales.

- Canal Tienda: Toma el nombre del cliente al que atiende para llamarlo al mostrador cuando su pedido esté listo. Canal promocionado.
- Canal Telefónico: Toma el nº de teléfono de la llamada. Canal telemático. 
- Canal Web: Toma la IP desde la que se envía el formulario. Canal telemático. Canal promocionado.

Cuando se recibe un pedido, se da la bienvenida indicando el nº de pedido del día –global– y el número en su canal.
Los canales telemáticos necesitan la ubicación de envío del pedido.
Los canales promocionados disponen de algún tipo de oferta que es anunciada al cliente tras darle la bienvenida.
Todos los canales indican al cliente los datos que han tomado para identificar su pedido: tienda -> nombre, teléfono -> ubicación + nº y web -> ubicación + IP.

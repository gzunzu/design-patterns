Ejemplo práctico de patrón Visitor. Uso de Enum y ArrayList.

Se pretende crear un programa que simula la atención de un/a babysitter a niños de diferentes edades, cuyos atributos y necesidades son distintas.

-Bebés: Tienen semanas de vida. La manera de calmarlos es acunándolos.
-Toddlers: Tienen sus primeros dientes. La manera de calmarlos es darles el chupete.
-Preescolares. Saben contar hasta cierto número. La manera de calmarlos es darles un juguete.

Todos los niños comparten los atributos de nombre y sexo.
Se busca recorrer una colección de niños, visualizando sus datos y haciendo que su babysitter se encargue de las tareas necesarias para calmarlos.
La esencia del ejercicio radica en abstraer a las clases de niños –visitables– entre sí, así como de su padre en la jerarquía y de la clase que 
los gestiona –visitador–.
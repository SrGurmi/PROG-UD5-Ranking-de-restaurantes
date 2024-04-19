## Bienvenidos a UD5-PRO-Restaurantes, una práctica realizada única y exclusivamente por Alejandro Guzmán Pérez del curso 1ºDAM

**ENUNCIADO**

**UD5 -- Práctica 1 -- Ranking de restaurantes**

3. Escribe y depura código, analizando y utilizando las estructuras de control del lenguaje.

d) Se ha escrito código utilizando control de excepciones.

f) Se han probado y depurado los programas.

g) Se ha comentado y documentado el código.

h) Se han creado excepciones.

4. Desarrolla programas organizados en clases analizando y aplicando los principios de la

programación orientada a objetos.

a) Se ha reconocido la sintaxis, estructura y componentes típicos de una clase.

b) Se han definido clases.

c) Se han definido propiedades y métodos.

d) Se han creado constructores.

e) Se han desarrollado programas que instancien y utilicen objetos de las clases creadas anteriormente.

f) Se han utilizado mecanismos para controlar la visibilidad de las clases y de sus miembros.

h) Se han creado y utilizado métodos estáticos.

i) Se han creado y utilizado conjuntos y librerías de clases.

5. Realiza operaciones de entrada y salida de información, utilizando procedimientos específicos

del lenguaje y librerías de clases.

a) Se ha utilizado la consola para realizar operaciones de entrada y salida de información.

b) Se han aplicado formatos en la visualización de la información.

f) Se han utilizado las herramientas del entorno de desarrollo para crear interfaces gráficos de usuario

simples.

h) Se han escrito programas que utilicen interfaces gráficos para la entrada y salida de información.

6. Escribe programas que manipulen información seleccionando y utilizando tipos avanzados de

datos.

c) Se han utilizado listas para almacenar y procesar información.

d) Se han utilizado iteradores para recorrer los elementos de las listas.

g) Se han utilizado expresiones regulares en la búsqueda de patrones en cadenas de texto.

j) Se han utilizado operaciones agregadas para el manejo de información almacenada en colecciones.

Recuerda:

- Sólo se corregirán aquellos trabajos entregados a tiempo.

- Usa un repositorio público de GitHub para la realización de esta práctica y mantén un flujo de

trabajo acorde a lo visto en clase, tanto con ramas como con los mensajes de confirmación.

- El repositorio remoto tendrá un nombre como: "PROG-UD5-NombreProyecto".

- Para corregir esta práctica, se utilizará la rúbrica registrada en la plataforma de elearning.

Requisitos previos:

Para esta práctica, vamos a trabajar todo lo referente a la gestión de proyectos utilizando

Git como sistema de control de versiones y GitHub como servicio para alojar repositorios.

Para asimilar el flujo de trabajo, progresivamente, vamos a meternos en el papel de un

equipo de desarrollo que, efectivamente, tenga que asumir un nuevo proyecto.

Cuando un proyecto comienza desde cero y se nos permite, incluso, seleccionar las

herramientas de trabajo y frameworks que queremos utilizar sin restricciones, decimos

que estamos ante un proyecto "Green Field".

Antes de comenzar, lee con atención todos los requisitos indicados a continuación, es

importante que seas consciente del proceso:

- El proyecto debe recogerse desde su estado inicial en un repositorio público de

Github.

- Cada operación importante de tu proyecto debe estar reflejada en un commit

dentro del repositorio.

- El mensaje de commit debe seguir las pautas del proyecto Karma tal y como

hemos visto en clase. Durante el desarrollo del proyecto, se darán situaciones en

las que tengas que arreglar un error o reestructurar directorios, renombrar clases,

etc... Son oportunidades perfectas para utilizar mensajes de commit descriptivos.

- Cada nueva característica debe desarrollarse en una rama que parta de la rama

development. Una vez terminada una característica, sin borrar la rama, la

combinaremos con la rama development. Recuerda subir todas las ramas al

repositorio de GitHub.

- Cuando hayas terminado de desarrollar todas las características, mergea la rama

development con la rama main.

- La raíz del proyecto debe tener un fichero Readme.md que contenga, empleando la

sintaxis Markdown, los objetivos del proyecto, las descripciones de cada clase

desarrollada y un pequeño manual de usuario. Para reducir el tamaño de este

fichero, se recomienda enlazar las descripciones y el manual de usuario a otros

documentos que se encuentren en una carpeta "docs" del repositorio.

- Recuerda mantener una estructura coherente de paquetes.

- Para realizar la entrega, se indicará el link correspondiente al repositorio en la tarea

de la plataforma virtual.

<h1>Descripción del ejercicio práctico: </h1>

Para esta entrega, nos ha contactado un cliente importantísimo del mundo del ranking de

la hostelería, RipAdbaisor. Esta empresa es pionera en el sector de la información de

cadenas de restauración, compitiendo con la mismísima GulúGulú.

El mayor handicap que presenta este proyecto es que el cliente no está familiarizado con

el sector de la informática y le da pánico la consola, por lo que nos veremos obligados a

informarnos sobre el uso de la librería Swing de Java para la muestra de información y

recogida de datos. Puedes obtener más información haciendo click en los siguientes

enlaces: DDR y CDIW.

La aplicación tendrá las características de un CRUD, es decir, debe permitir crear,

mostrar, editar y eliminar los restaurantes almacenados. La información guardada no debe

almacenarse entre ejecución y ejecución del programa.

Requisitos funcionales:

a) El restaurante almacenará la siguiente información:

- Nombre

- Localización

- Horario

- Puntuación

b) Almacenar los objetos en una lista inteligente, utilizando sus métodos para trabajar con

cada registro.

c) Utilizar la librería java.swing para la recolección y muestra de datos.

d) Utiliza una o varias clases con métodos estáticos para realizar validaciones, conversión

de tipos o solicitud de datos para que el código quede modularizado adecuadamente.

Esto permitirá reutilizar características y funcionalidades sin duplicar código.

e) Mostrar un menú con la siguiente información:

1\. Añadir restaurante. Mostrará uno o varios paneles con los cuadros

necesarios para ingresar la información de un nuevo registro.

2\. Editar restaurante. Mostrará uno o varios paneles y permitirá la edición de la

información de algún registro guardado.

3\. Mostrar restaurantes. Mostrará toda la información de cada restaurante

ordenado por ranking de forma descendente.

4\. Eliminar restaurante. Permitirá eliminar un registro almacenado.

Q. Salir del programa. Terminará la ejecución del programa.

f) Controlar todas las posibles excepciones que puedan romper el programa. La única

manera posible del salir del programa, debe ser a través de la opción del menú.

## DOCUMENTACIÓN

| | | | | | |
|-|-|-|-|-|-|
| Clase Restaurante-Manager| | | | | |
| | | | | | |
|El código define una clase `RestauranteManager` que gestiona una lista de restaurantes. Cada restaurante es una instancia de la clase `Restaurante`.| | | | | |
| | | | | | |
|La clase `RestauranteManager` tiene los siguientes métodos:| | | | | |
| | | | | | |
|- `agregarRestaurante(String nombre| String localizacion| String horario| int puntuacion)`: Crea un nuevo restaurante con los detalles proporcionados y lo agrega a la lista de restaurantes. Luego muestra un mensaje de éxito.| | |
| | | | | | |
|- `mostrarRestaurantes()`: Muestra una lista de todos los restaurantes.| | | | | |
| | | | | | |
|- `editarRestaurante(int indice| String nombre| String localizacion| String horario| int puntuacion)`: Edita los detalles de un restaurante existente en un índice específico. Si el índice es inválido| muestra un mensaje de error.|
| | | | | | |
|- `eliminarRestaurante(int indice)`: Elimina un restaurante en un índice específico. Si el índice es inválido| muestra un mensaje de error.| | | | |
| | | | | | |
|- `getRestaurantes()`: Devuelve la lista de restaurantes.| | | | | |
| | | | | | |
|- `agregarRestaurante(Restaurante restaurante)`: Agrega un restaurante ya existente a la lista de restaurantes y muestra un mensaje de éxito.| | | | | |
| | | | | | |
| | | | | | |
| | | | | | |
| | | | | | |
| | | | | | |
| | | | | | |
| | | | | | |
| | | | | | |
| | | | | | |
| | | | | | |
|Clase Restaurante| | | | | |
|Este código define una clase en Java llamada `Restaurante` en el paquete `com.net.salesianos.menu.restaurante`. Esta clase representa un restaurante con cuatro propiedades: `nombre`| `localizacion`| `horario` y `puntuacion`.| | | |
| | | | | | |
|La clase `Restaurante` tiene un constructor que acepta cuatro parámetros correspondientes a sus cuatro propiedades. La palabra clave `this` se utiliza para referirse a la instancia actual de la clase| distinguiendo los campos de la clase de los parámetros del constructor cuando tienen los mismos nombres.| | | | |
| | | | | | |
|La clase también incluye métodos getter y setter para cada una de sus propiedades. Estos métodos se utilizan para obtener (get) y modificar (set) los valores de las propiedades. Los métodos getter devuelven el valor actual de la propiedad correspondiente| mientras que los métodos setter toman un parámetro y asignan su valor a la propiedad correspondiente.| | | | |
| | | | | | |
|Finalmente| la clase sobrescribe el método `toString` heredado de la clase `Object`. Este método devuelve una representación en cadena del objeto `Restaurante`| que incluye los valores de todas sus propiedades. La anotación `@Override` sobre el método indica que este método tiene la intención de sobrescribir un método en una superclase.| | | |
| | | | | | |
|Clase MenuPrincipal| | | | | |
| | | | | | |
|Este código Java es para una aplicación GUI simple que administra una lista de restaurantes. Utiliza la biblioteca Swing para los componentes de la GUI. La aplicación permite al usuario agregar| editar| mostrar y eliminar restaurantes.| | | |
| | | | | | |
|La clase `MenuPrincipal` es la clase principal de la aplicación. Tiene un objeto `RestauranteManager` como miembro| que se utiliza para administrar la lista de restaurantes. El objeto `RestauranteManager` se pasa al constructor de `MenuPrincipal`.| | | | |
| | | | | | |
|El método `mostrarMenu` crea el menú principal de la aplicación. Crea un `JFrame` (la ventana principal) y un `JPanel` (un contenedor para otros componentes). También crea cinco objetos `JButton` para las diferentes operaciones (agregar| editar| mostrar| eliminar y salir)| y los agrega al panel. Cada botón tiene un `ActionListener` adjunto| que define qué sucede cuando se hace clic en el botón.|
| | | | | | |
|El método `mostrarFormularioAgregarRestaurante` se llama cuando se hace clic en el botón "Agregar Restaurante". Muestra un diálogo con campos para el nombre| la ubicación| el horario y la calificación del restaurante. Si el usuario hace clic en "OK"| crea un nuevo objeto `Restaurante` con los datos ingresados y lo agrega a la lista.| | |
| | | | | | |
|El método `mostrarFormularioEditarRestaurante` es similar| pero primero pide al usuario que seleccione un restaurante de una lista desplegable. Luego| rellena previamente los campos con los datos del restaurante seleccionado. Si el usuario hace clic en "OK"| actualiza los datos del restaurante seleccionado.| | |
| | | | | | |
|El método `mostrarListaRestaurantes` se llama cuando se hace clic en el botón "Mostrar Restaurantes". Crea una cadena con los datos de todos los restaurantes y la muestra en un diálogo.| | | | | |
| | | | | | |
|El método `mostrarFormularioEliminarRestaurante` se llama cuando se hace clic en el botón "Eliminar Restaurante". Pide al usuario que seleccione un restaurante de una lista desplegable. Si el usuario hace clic en "OK"| elimina el restaurante seleccionado de la lista.| | | | |
| | | | | | |
|El método `main` crea un objeto `RestauranteManager`| un objeto `MenuPrincipal` y llama al método `mostrarMenu` para iniciar la aplicación.| | | | |
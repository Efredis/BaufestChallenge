## BaufestAutomation
Las pruebas automatizadas llamadas "BaufestAutomation" realiza el siguiente procedimiento o ejecución de pruebas.

-  Ir a la web: https://www.demoblaze.com/index.html
-  Dar de alta un usuario.
-  Login y logout con el usuario dado de alta.
-  Agregar una laptop al carrito.
-  Comprobar que se agregó al carrito.

###Requisitos del sistema:
####Requerimientos mínimos de hardware y software para configurar entorno.
- SO: Windows 7 ó posterior.
- Procesador: Intel from 1.2 GHz ó equivilent AMD family.
- Memoria: 4 GB de RAM.
- Gráficos: DirectX 9 compatible Tarjeta gráfica card.
- DirectX: Versión 9.0.
- Almacenamiento: 1 GB de espacio disponible.

Para ejecutar las pruebas es necesario configurar un entorno que comprende lo siguiente:

- Se requiere instalar la aplicación Eclipse IDE for Java Developers., lo puede descargar desde la url: https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-12/R/eclipse-java-2020-12-R-win32-x86_64.zip.
- Se requiere instalar el navegador Google Chrome.
-Se requiere descargar el webdriver de chrome según la versión del navegador que se tenga instalado, esto puede hacerlo a través de esta url: https://chromedriver.chromium.org/downloads
- Se requiere descargar e instalar la aplicación Java Platform (JDK) 8u111 / 8u112, desde la web: https://www.oracle.com/technetwork/es/java/javase/downloads/index.html
- Se requiere configurar las variables de entorno, de la siguiente manera:

####Windows 10 y Windows 8
- En Buscar, busque y seleccione: Sistema (Panel de control)
- Haga clic en el enlace Configuración avanzada del sistema.
- Haga clic en Variables de entorno. En la sección Variables del sistema busque la variable de entorno PATH y selecciónela. Haga clic en Editar. Si no existe la variable de entorno PATH haga clic en Nuevo.
- En la ventana Editar la variable del sistema (o Nueva variable del sistema), debe especificar el valor de la variable de entorno PATH, que sería:
Nombre de la Variable: JAVA_HOME
Valor de la Variable: Ruta donde se instaló el java, por ejemplo: C:\Program Files\Java\jdk-15.0.2.
- Haga clic en Aceptar. Cierre todas las demás ventanas haciendo clic en Aceptar.
- Haga click en el boton de inicio, buscar "CMD" y ejecute el comando: "java -version", esto le traerá la versión del java indicando a su vez que está instalado.

####Windows 7
Desde el escritorio, haga clic con el botón derecho del mouse en el icono de la computadora.
Seleccione Propiedades en el menú contextual.
Haga clic en el enlace Configuración avanzada del sistema.
Haga clic en Variables de entorno. En la sección Variables del sistema busque la variable de entorno PATH y selecciónela. Haga clic en Editar. Si no existe la variable de entorno PATH haga clic en Nuevo.
- En la ventana Editar la variable del sistema (o Nueva variable del sistema), debe especificar el valor de la variable de entorno PATH, que sería:
Nombre de la Variable: JAVA_HOME
Valor de la Variable: Ruta donde se instaló el java, por ejemplo: C:\Program Files\Java\jdk-15.0.2.
- Haga clic en Aceptar. Cierre todas las demás ventanas haciendo clic en Aceptar.
- Haga click en el boton de inicio, buscar "CMD" y ejecute el comando: "java -version", esto le traerá la versión del java indicando a su vez que está instalado.

###Ejecutando las pruebas:
Una vez configurado el entorno para las pruebas y descargar el repositorio, se debe realizar lo siguiente para su ejecución: 

- Ejecutamos el eclipse.
- Clic al menu "File".
- Clic en "Open Projects from file system..."
- Clic en Directory y selecionar la carpeta "BaufestAutomation" descargada desde el repositorio.
- Una vez visualizado el proyecto en el explorador de eclipse, seleccionar el proyecto y hacer clic al menú "Run" - "Run As" - "2 JUnit Test".

Luego de todo este procedimiento se ejecutarán las pruebas requeridas.
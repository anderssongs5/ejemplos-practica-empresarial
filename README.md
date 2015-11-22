# Ejemplos Práctica Empresarial
===================
Repositorio donde se encuentran ejemplos a partir de lo realizado durante la práctica empresarial.

Tecnologías, herramientas y configuración Windows:
* Eclipse JEE Mars.1
* Gradle IDE Pack 3.6x + 0.17: IDE de Gradle instalado en Eclipse. Se instaló usando Eclipse Marketplace
* Gradle 1.10: Descargado desde http://gradle.org/gradle-download/. Se debe crear la variable de entorno GRADLE_HOME, en la cual se referencie la carpeta de instalación de Gradle. Posteriormente se debe agregar a la variable Path: %GRADLE_HOME%\bin
* EclEmma Java Code Coverage 2.3.2: plugin para evaluar la cobertura de código instalado desde Eclipse Marketplace
* Java JDK 1.8: Se utiliza la actualización 30 de Java JDK 1.8 y además se crea la variable de entorno JAVA_HOME, la cual hace referencia a la carpeta de instalación del mismo. Posteriormente se agrega a la variable Path: %JAVA_HOME%\bin

Librerías: Todas las librerías utilizadas se obtienen desde el repositiorio Maven usando las dependencias de Gradle: 
* Gson 2.2.2: Tutorial básico -> http://www.adictosaltrabajo.com/tutoriales/gson-java-json/#01
* JUnit 4.+
* Mockito-Core 1.+
* RxJava 1.0.14: Libro recomendado -> Learning Reactive Programming with Java 8

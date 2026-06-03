# GKE-GNP-PLUS-TRAMITES-SIQ

[![Quality Gate Status](http://10.67.0.25:9000/api/project_badges/measure?project=mx.seg.ipn.aplicacion%3AGKE-GNP-PLUS-TRAMITES-SIQ&metric=alert_status)](http://10.67.0.25:9000/dashboard?id=mx.seg.ipn.aplicacion%3AGKE-GNP-PLUS-TRAMITES-SIQ)[![Lines of Code](http://10.67.0.25:9000/api/project_badges/measure?project=mx.seg.ipn.aplicacion%3AGKE-GNP-PLUS-TRAMITES-SIQ&metric=ncloc)](http://10.67.0.25:9000/dashboard?id=mx.seg.ipn.aplicacion%3AGKE-GNP-PLUS-TRAMITES-SIQ)[![Technical Debt](http://10.67.0.25:9000/api/project_badges/measure?project=mx.seg.ipn.aplicacion%3AGKE-GNP-PLUS-TRAMITES-SIQ&metric=sqale_index)](http://10.67.0.25:9000/dashboard?id=mx.seg.ipn.aplicacion%3AGKE-GNP-PLUS-TRAMITES-SIQ)

## Índice

- [Contexto](#contexto-del-proyecto)
  - [Responsabilidades del componente](#responsabilidades-del-componente)
  - [Entidades](#entidades)
- [Estructura](#estructura-del-proyecto)
  - [Estructura de paquetes](#estructura-de-paquetes)
  - [Estructura de capas](#estructura-de-capas)
  - [Estructura de pruebas](#estructura-de-pruebas)
- [Funcionalidad](#funcionalidad)
  - [Entradas](#entradas)
  - [Salidas](#salidas)
- [Configuración](#configuración)
  - [Requerimientos de desarrollo](#requerimientos-de-desarrollo)
  - [Librerías](#librerías)
  - [Variables de entorno](#variables-de-entorno)
  - [Construcción del proyecto](#construcción-del-proyecto)
  - [Despliegue del componente](#despliegue-del-componente)

## Contexto del proyecto

### Responsabilidades del componente

Este componente contiene la funcionalidad relacionada al dominio de negocio de **Módulo** para la aplicación **Aplicación**. Este dominio esta relacionado con la funcionalidad de ...

This is an example!!!

### Entidades

| Entidad | Descripción                                         |
| ------- | ---------------------------------------------------- |
| Entidad | Entidad de ejemplo dentro del dominio del componente |

## Estructura del proyecto

### Estructura de paquetes

```files
mx/com/gnp
└── aplicacion
	├── Application.java	# Main
	├── application.yml	# Archivo de propiedades del proyecto
	├── config				# Configuración general del proyecto
	└── modulo				# Dominio de Módulo
		├── application		# Adaptadores de entradas
		|	├── config		# Configuración de adaptadores 
		|	├── mapper		# Convertidores DTOs / Entities
		|	└── model			# DTOs
		├── domain			# Objectos de negocio
		|	├── core			# DTOs
		|	├── incoming		# Puertos de entrada (Procesos funcionales)
		|	|	├── error		# Errores de lógica de negocio (Excepciones)
		|	|	└── model		# DTOs de los puertos de entrada
		|	└── outgoing		# Puertos de salida
		|		├── error		# Errores de salidas (Excepciones)
		|		└── model		# DTOs de los puertos de salida
		└── infrastructure	# Adaptadores de salidas
			├── config		# Configuración de adaptadores 
			└── model			# DTOs
```

### Estructura de capas

Por cada dominio de negocio, se considera la siguiente estructura de capas funcionales:

- **Application Layer (paquete: *application*)**: Capa de aplicación donde se encuentras las entradas al programa, ejemplo: REST, SOAP, Pub/Sub, Triggers de Firebase, etc. Esta capa solo debe comunicarse con la capa de dominio, solo atravez de los puertos de entrada (paquetes:  *domain.incoming* y *domain*).
- **Domain Layer (paquete: *domain*)**: Capa donde se resuelve la problematica del programa, es decir, donde se encuentra la lógica de negocio involucrada en resolver los Casos de Uso ó Historias de Usuario. Esta capa debe estar aislada y no debe conocer el contenido de ninguna otra capa.
- **Infrastructure Layer (paquete: *infrastructure*)**: Capa donde se conecta la tecnología involucrada en persistir la información o consumir algun servicio informatico. Esta capa solo puede concer la capa de dominio a través de los puertos de salida (paquetes: *domain.outgoing* y *domain*).

### Estructura de pruebas

```files
mx/com/gnp
└── aplicacion
	├── application-test.yml	# Archivo de propiedades para pruebas
	├── config			# Configuración general de pruebas
	└── modulo			# Pruebas del Dominio de Módulo (BDD)
		└── domain
			└── core		# Pruebas de componentes de software (TDD)
```

## Funcionalidad

### Entradas

#### REST

| Método | Path            | Descripción                |
| ------- | --------------- | --------------------------- |
| GET     | /entidades      | Obtiene todas las entidades |
| GET     | /entidades/{id} | Obtiene una entidad         |
| POST    | /entidades      | Agrega una entidad          |
| PUT     | /entidades/{id} | Modifica una entidad        |
| DELETE  | /entidades/{id} | Borra una entidad           |

#### Pub/Sub

| Subscription                       | Descripción                  |
| ---------------------------------- | ----------------------------- |
| entidad-agregada.aplicacion-modulo | Evento de entidad es agregada |

#### Metadata

| Path           | Descripción                              |
| -------------- | ----------------------------------------- |
| /management    | Actuator endpoints                        |
| /api-docs.html | Swagger UI - Documentación de REST       |
| /api-docs      | Documentación Open API v3 (formato JSON) |
| /api-docs.yaml | Documentación Open API v3 (formato YAML) |

### Salidas

#### Base de Datos

| Tablas      | Descripción |
| ----------- | ------------ |
| APP_ENTIDAD | Entidad      |

#### Pub/Sub

| Topic             | Descripción                |
| ----------------- | --------------------------- |
| entidad-eliminada | Evento de entidad eliminada |

#### REST

##### Nofiticador

| Método | Path   | Descripción    |
| ------- | ------ | --------------- |
| POST    | /email | Envía un email |

> **Basepath**: https://api-{env}.gnp.com.mx/notificador

##### Cotizador Autos

| Método | Path     | Descripción            |
| ------- | -------- | ----------------------- |
| POST    | /cotizar | Realiza una cotización |

> **Basepath**: https://api-{env}.gnp.com.mx/autos/cotizador

## Configuración

### Requerimientos de desarrollo

- Eclipse
  - Plugin [Lombok](https://projectlombok.org/setup/eclipse)
  - Plugin STS (Spring Tool Suite)
  - Plugin Gradle
- Java 11
- Gradle 7.5.x (O usar Wrapper)

### Librerías

- Librerías de Spring
  - Spring Boot
  - Spring Data JPA
  - Spring Actuator
  - Spring Docs
- Librerías GNP
  - Manejo de errores ([documentación](http://git.gnp.mx/arquitectura/libs/gnp-starters/gnp-starter-errors))
  - Manejo de JWT Cuentas ([documentación](http://git.gnp.mx/arquitectura/libs/gnp-starters/gnp-starter-jwt-cuentas))

> Las librerías están incluidas en el archivo *build.gradle*

### Variables de entorno

| Varibale         | Descripción                                             |
| ---------------- | -------------------------------------------------------- |
| ACTUATOR_ENABLED | Habilita los endpoints de actuator (default:*false*)   |
| API_DOC_ENABLED  | Habilita la documentación de swagger (default:*true*) |
| LOG_LEVEL        | Nivel de logging para el proyecto (default:*INFO*)     |

### Construcción del proyecto

#### Archivos de construcción

- **build.gradle**: Archivo de configuración de gradle. Se encuentra configuración general y el uso de las dependencias que utiliza el proyecto.
- **checkstyle.xml**: Archivo de configuración de reglas de *checkstyle* basada en la actual configuración de [Sonar](http://sonar.gnp.mx:9000).
- **gradle.properties**: Archivo de propiedades para Gradle. Aquí se encuentra la propiedad que peude cambiar la versión al proyecto si se desea modificar la forma default de asignación de versión en la construcción.
- **publish.gradle**: Archivo con la configuración de construcción del JAR y su publicación en [Nexus](http://nexus.gnp.mx/)
- **quality.gradle**: Archivo de configuración de análisis de calidad del código. Incluye configuración para el Checkstyle, Jacoco y Sonar.
- **settings.gradle**: Archivo donde se configuran los detalles del proyecto como nombre y grupo (Artifact Group & Artifact ID)
- **.gitlab-ci.yml**: Archivo para la construcción automática del componente.

#### Problemas en la construcción

Si al subir el nuevo proyecto, el pipeline falla con el error: *Permission Denied*, ejecutar comando:

```console
git update-index --chmod=+x gradlew 
```

A continuación hacer commit del cambio.

### Despliegue del componente

#### Despliegue Local

Para ejecutarlo desde consola:

```console
$ gradle bootRun
```

Para ejecutarlo con el JAR:

```console
$ gradle build
$ java -jar [nombre jar]
```

Para ejecutarlo en eclipse:

> Clic derecho en la clase **mx.seg.ipn.aplicacion.Application.java** y darle clic en la opción **Run As > Java Application**.

#### Despliegue QA

Utilizar [Harness](https://app.harness.io) para el despliegue automatizado del componente.

1. obtener la siguiente versión disponible del documento
   1. [documento](https://docs.google.com/spreadsheets/d/14qDFnmvZw5DYMR-RxGpk5HuSRB3Wk1PUuAKs4PSEPjI/edit#gid=492689788)
2. ejecutar la tarea bash con la versión
3. actualizar el documento con la siguiente versión disponible
   1. [documento](https://docs.google.com/spreadsheets/d/14qDFnmvZw5DYMR-RxGpk5HuSRB3Wk1PUuAKs4PSEPjI/edit#gid=492689788)

```bash
# usar si la versión del jdk es la misma del path
gradlew clean release -Prelease.releaseVersion=0.0.0

# usar si la versión del jdk es diferente al path
gradlew clean release -Prelease.releaseVersion=0.0.0 -Dorg.gradle.java.home="C:\Program Files\Java\jdk1.8.0_202"
```

#### Despliegue UAT

Solicitar en [Service Now](https://gnpproduction.service-now.com/) el despliegue en ambiente UAT.

#### Despliegue PROD

Solicitar en [Service Now](https://gnpproduction.service-now.com/) el despliegue en ambiente PROD.



<!-- local-development:start -->
# Desarrollo local

Puedes abrir este repositorio en VS Code, Antigravity o Sublime Text. El compilador y los servicios necesarios dependen del componente indicado abajo.

## Java / NetBeans

En NetBeans 25, abre la carpeta que contiene `build.xml` como proyecto Ant. Selecciona un JDK igual o posterior al nivel de fuente del proyecto; las compilaciones de esta revisión usan JDK 24.0.2. El asistente busca NetBeans y el JDK y mantiene la configuración de usuario en `.local-build/`.

```powershell
..\build-local.ps1
.\build-local.ps1 -Project 'GestorDeportivo/build.xml' -Target run
```

Si hay varios proyectos, elige el deseado con `-Project`. Puedes indicar `-JavaHome` y `-NetBeansHome`. `-Target test` ejecuta las pruebas que declare el proyecto; un objetivo de pruebas vacío no acredita cobertura.

## Bases de datos

Revisa los scripts de esquema y crea una base de datos de prueba separada. SSMS 20 y pgAdmin 4 son clientes; SQL Server y PostgreSQL son motores distintos. Los scripts SQL Server no se ejecutan directamente en PostgreSQL. Las restauraciones deben hacerse sobre una base de prueba nueva. PostgreSQL 17 y 18 requieren comprobarse por separado.

## Componentes y validación

Inventario y compilaciones locales del 2026-11-15. Una compilación correcta no acredita todavía interacción, compatibilidad de base de datos, instalador ni despliegue.

| Componente | Tipo / destino | Validación |
| --- | --- | --- |
| [GestorDeportivo/build.xml](<GestorDeportivo/build.xml>) | netbeans-ant / 1.8 | Compila; prueba funcional pendiente |

## Archivos ignorados

`.gitignore` excluye credenciales locales, estado del editor y salidas de las herramientas detectadas. No deja de versionar archivos que ya estaban en Git. Los manifiestos, archivos de bloqueo, recursos fuente y scripts de esquema forman parte del código.
<!-- local-development:end -->

<!-- improvements-20261119:start -->
## Mejoras y verificación funcional (2026-11-19)

- **Mejoras aplicadas:** Driver JDBC PostgreSQL `42.7.14`, clase centralizada `ConexionBD` (`GESTOR_JDBC_URL`/`GESTOR_USER`/`GESTOR_PASSWORD`) integrada en los 22 formularios Swing, corrección del carácter invisible en `frmIndex.java` y actualización de `Script.sql` para PostgreSQL 17/18 (eliminación de `WITH (OIDS=FALSE)`).
- **Pruebas ejecutadas:** Compilación NetBeans/Ant + `GestorDbCheck` verificado contra PostgreSQL 17 y PostgreSQL 18 desechables con SCRAM-SHA-256 (4 aserciones en cada versión).
<!-- improvements-20261119:end -->

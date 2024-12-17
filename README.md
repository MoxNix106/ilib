Explicacion de como se Organiza el Proyecto

1._La carpeta ![image](https://github.com/user-attachments/assets/433b12b1-d998-4f78-b937-b3f6bedf2fea) contiene 
la clase ![image](https://github.com/user-attachments/assets/dd21e743-1696-4ecd-a0d3-bdb33e7f3d8e) que
 facilita la gestión de una conexión a una base de datos PostgreSQL. 
Contiene un método llamado Conectar() que permite establecer la conexión utilizando el driver de PostgreSQL con parámetros como la URL de la base de datos, el usuario y la contraseña.


Al principio se ve una clase llamada TestDatabase como el nombre lo indica esa clase solo existe para que despues de ingresar los datos en database se compurbe si se esta haciendo bien la conexion a la base de datos
![image](https://github.com/user-attachments/assets/3a222f57-a888-411f-8ea6-fceed3cb65d8)

2._La carpeta ![image](https://github.com/user-attachments/assets/2ded8705-8857-4cf7-916f-685a6f9497ed) contiene las clases que tiene como incio DAO con Impl en estas clases
se declaran los metodos que llevara cada una de las clases 
![image](https://github.com/user-attachments/assets/62b9f5ea-fff2-4f31-82fd-cffa2c3e2e41)
![image](https://github.com/user-attachments/assets/a1d97b5e-0e43-40b4-9854-924d7f2ab1a4)
![image](https://github.com/user-attachments/assets/51f3f638-8b53-49eb-8a7d-177ef2d914f9)
![image](https://github.com/user-attachments/assets/07df48bc-0a69-42dd-b59b-5945f55eff6f)
cada calses tiene sus respectivos metodos algunos ejemplos seria que en la clase de books donde se puede moficar, eliminar, registrar, listar los libros o buscar los libros deacuerdo a su titulo
y asi con cada clase.

Dentro de la misma carpeta se encuentra los dos primeros frames dentro del proyecto que serian inicio de sesion y dashboard.
![image](https://github.com/user-attachments/assets/700f0753-90cd-4a0d-a02b-ad52a201cf97)
![image](https://github.com/user-attachments/assets/92a6f20c-36b6-49b6-949b-0cbb5d4342f3)
El frame de inicion de sesion se usa para pedir el usuario y la contrsaeña de los trabajadores o administradores.
El frame de dashboard consiste en 3 paneles el primer panel se usar para mostrar la fecha actual, el segundo tiene tres botones que conectan con otros frame en este caso son 
![image](https://github.com/user-attachments/assets/2fc0b9f7-c182-47eb-8c4f-3b1323ed8307)
![image](https://github.com/user-attachments/assets/9158ea21-7003-4811-8cab-e3d7e70e2781)
![image](https://github.com/user-attachments/assets/f62236b7-8a80-488a-95f5-4b5377c2a787)
y el tercer panel es sobre el que superpone los frame que se llaman con los botones.

3._La carpeta ![image](https://github.com/user-attachments/assets/c8d08bd9-9180-4897-99e4-b23e9378bdd0) contiene las clases DAO, las clases dentro de la carpeta se encargan de llamar los metodos que se guardan dentro de la carpeta ![image](https://github.com/user-attachments/assets/2ded8705-8857-4cf7-916f-685a6f9497ed) y de esa forma se tiene mejor organizado el codigo y te ayuda a saber que metodos tiene cada una de las clases DAO,,,,Impl

4._La carpeta ![image](https://github.com/user-attachments/assets/d1e30c37-4137-4aac-ab33-c549c269d82d) contiene las clases java donde se declaran
Un ejemplo podria ser la clase ![image](https://github.com/user-attachments/assets/477b269a-2a26-4943-8828-8d43e98a9d65), dentro del paquete ![image](https://github.com/user-attachments/assets/d1e30c37-4137-4aac-ab33-c549c269d82d), representa una entidad de libro en el proyecto. Esta clase sirve como un modelo de datos para almacenar información sobre los libros y facilita el acceso y modificación de sus atributos. eso pasa con cada una de las clases dentro de la carpeta
![image](https://github.com/user-attachments/assets/2cea32e6-dbbf-4c3f-b27a-d9fc3ce78786)
![image](https://github.com/user-attachments/assets/a42f6988-46a7-4de5-8843-3199575da7ae)
![image](https://github.com/user-attachments/assets/4324e48a-2e80-4c3a-8998-e763a34994c7)

5._Explicación de la clase ![image](https://github.com/user-attachments/assets/39f19e3d-0886-468e-b253-d45084efa5e5) en el paquete ![image](https://github.com/user-attachments/assets/877aff9d-0d5d-4503-a97d-7f673ff5208f)
La clase ![image](https://github.com/user-attachments/assets/3d01af02-e102-4a15-85f4-2481c8828f77)
 proporciona métodos de utilidad relacionados con validación numérica y manipulación de fechas en Java. Todos los métodos son public y static, lo que permite llamarlos sin necesidad de crear una instancia de la clase.

 6._El paquete ![image](https://github.com/user-attachments/assets/a0330c6c-daaf-4599-a67a-06337068c944)
 organiza las distintas interfaces gráficas del sistema. cada una abre un frame diferente que complementa el proyecto, Aqui es donde se complementan porque los frame llaman a las clases dentro de 
![image](https://github.com/user-attachments/assets/c8d08bd9-9180-4897-99e4-b23e9378bdd0) que se encargan de llamar a los metodos deacuerdo a cual necesita cada frame que se almacenan dentro de la carpeta  ![image](https://github.com/user-attachments/assets/2ded8705-8857-4cf7-916f-685a6f9497ed) los nombres de los frame ayudan a saber que metodos se necesitan llamar.
![image](https://github.com/user-attachments/assets/9ce61477-ff60-450f-b8e2-2eee6f6514d9)
![image](https://github.com/user-attachments/assets/cc5594d8-a78f-426a-a11d-ee7559043153)
![image](https://github.com/user-attachments/assets/a53ffda8-d505-4cc1-bf9d-8bd124dfb1d3)
![image](https://github.com/user-attachments/assets/e9d9d044-546f-47bc-a5cb-1215747d3d32)
![image](https://github.com/user-attachments/assets/e8c0476a-8290-4967-a6f7-aadd43b1a97d)
![image](https://github.com/user-attachments/assets/1556f1a8-6f11-4c5d-8d98-88a81fb6daf5)
![image](https://github.com/user-attachments/assets/8de3fd9f-099a-4863-b52d-e223728fe8f2)
![image](https://github.com/user-attachments/assets/9182b71c-a6af-4c29-bc2e-dd32903c769f)
![image](https://github.com/user-attachments/assets/a8bf293b-1b09-4674-a09f-76a6216c11a9)
![image](https://github.com/user-attachments/assets/2893d74e-cf60-4f10-a4e6-8f7e3af5991b)
![image](https://github.com/user-attachments/assets/ce24ba25-5a9d-4b9e-86df-8b84e37155b6)

7._La carpeta de ![image](https://github.com/user-attachments/assets/4560faf3-0fd1-4b9d-9a0f-edbc75a24ccc) ,incluye  varios archivos .jar. Cada archivo .jar es una biblioteca externa que añade funcionalidades específicas al proyecto.                       
Proporciona soporte para un diseño absoluto en interfaces gráficas. Facilita colocar componentes en posiciones específicas con coordenadas exactas dentro de una ventana o panel.![image](https://github.com/user-attachments/assets/fd1bf34a-e0cb-4ed1-9131-268cde6ca718) 

Es una biblioteca para personalizar la apariencia de la interfaz gráfica. FlatLaf es un "Look and Feel" moderno que proporciona una apariencia plana y limpia para aplicaciones Java Swing.![image](https://github.com/user-attachments/assets/10347af6-c07e-4c4d-83e3-bcaa5359f87e)

Añade temas específicos basados en el estilo de IntelliJ IDEA para la biblioteca FlatLaf. Permite aplicar diferentes temas de apariencia a la interfaz de usuario.![image](https://github.com/user-attachments/assets/375a8b7b-c4e0-4431-9d3b-4bd73edaa023)

Biblioteca para generar y manipular archivos PDF en Java. Facilita la creación de documentos PDF de manera programática.![image](https://github.com/user-attachments/assets/70ed0157-297c-4007-9d11-dafc6b07f93c)

Proporciona soporte para enviar y recibir correos electrónicos a través del protocolo SMTP, POP3 y IMAP. Es parte de la API estándar de JavaMail.
![image](https://github.com/user-attachments/assets/c276b0af-8d23-4eff-b6ad-e87681f6b6c4)

Define las interfaces y clases de la API de JavaMail. Necesaria para trabajar con la biblioteca javax.mail.![image](https://github.com/user-attachments/assets/48df993c-f819-4492-a788-cf227f772b1d)

Conector para permitir la conexión a bases de datos MySQL desde Java. Facilita la interacción con bases de datos MySQL mediante JDBC.![image](https://github.com/user-attachments/assets/881c5142-bc27-4fa6-ae05-f7b02412d400)

Controlador JDBC para bases de datos PostgreSQL. Permite que el proyecto se conecte a una base de datos PostgreSQL y ejecute operaciones SQL.
![image](https://github.com/user-attachments/assets/046dd3de-f01c-45ae-baad-d944680b49cd)

Biblioteca utilizada por javax.mail para manejar tipos de datos MIME. Facilita el acceso a tipos de datos y contenido en correos electrónicos, como adjuntos o imágenes.
![image](https://github.com/user-attachments/assets/7f5eea6d-6c4c-4939-9f47-09c5651c46c4)

8._La carpeta de ![image](https://github.com/user-attachments/assets/a35b9c32-d02b-496c-9aa1-105674c2ca4c) tiene un archivo ![image](https://github.com/user-attachments/assets/b7deb4d7-a647-468a-bc0f-9f3cab87a1e1) para Maven.
Maven es una herramienta de automatización y gestión de proyectos para aplicaciones Java. El archivo pom.xml (Project Object Model) es el corazón de un proyecto Maven y define cómo se debe construir el proyecto, especificando tareas como la compilación, el empaquetado y el despliegue. También gestiona las dependencias necesarias para ejecutar el proyecto, como archivos .jar y bibliotecas externas.


![image](https://github.com/user-attachments/assets/06ad6c94-fcd3-4341-bd6b-11ea9b70a467)

![image](https://github.com/user-attachments/assets/90801fdb-f12a-4fcf-a40c-f2e71dbbc7c6)

![image](https://github.com/user-attachments/assets/28b22226-1809-4652-98c4-b7b2644a3531)

![image](https://github.com/user-attachments/assets/62138910-1723-4e1b-bb3f-afb04b624d8a)

![image](https://github.com/user-attachments/assets/a3d1f3d7-6fa0-468c-80d5-24e27499ff4c)





https://github.com/user-attachments/assets/b169755b-e649-4cd4-ad88-49a4d3806e91






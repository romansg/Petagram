# Petagram

Proyecto final del tercer curso de la especialidad en **Desarrollo de aplicaciones móviles con Android**

## Observaciones

1. En este proyecto utilicé el patrón **Modelo-Vista-Presentador** pero organizando los archivos como en la referencia que se da en la descripción de la tarea: http://antonioleiva.com/mvp-android/. Así, tenemos

* un paquete **main** con la vista y presentador que integran la actividad principal
* un paquete **listado** con la vista y presentador que integran la lista de mascotas
* un paquete **favoritas** con la vista y presentador de las mascotas favoritas
* un paquete **perfil** con la vista y presentador de la actividad que muestra el perfil de una mascota
* un paquete **contacto** con la vista y presentador del formulario de contacto
* un paquete **biografia** con la vista y presentador de la página "Acerca de"

Cada presentador se comunica con la base de datos a través de un interactor común. El interactor y el manejador de la base están en el paquete **db**.

2. Para la base de datos se omitió el uso de una segunda tabla que sólo refleja un muy mal manejo del modelo Entidad-Relación ya que se fuerza una relación 1 a 1 a ser una relación 1 a muchos sin ninguna justificación ya que no es ilustrativo de ningún aspecto del curso. Entonces, el POJO que representa a la mascota quedó así:

```java
public class Mascota {
    private int id;
    private String nombre;
    private int foto;
    private int likes;

    public Mascota() {

    }

    public Mascota(String nombre, int foto, int likes) {
        this.nombre = nombre;
        this.foto = foto;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
```
Y el modelo de la base de datos se reduce a la tabla:

mascota
|---|
id: integer
nombre: text
foto: integer
likes: integer

3. Para el envío de correo en la actividad de **Contacto**, debe configurarse una cuenta de GMail poniendo el usuario y contraseña en la clase MailConf localizada en com.romansg.petagram/pojo/MailConf:

```java
public class MailConf {
    public static String USER = "usuario";
    public static String PASSWORD = "contraseña";
}
```

* Para que el envío funcione, la cuenta de GMail que se utilice debe tener habilitado el [**acceso a aplicaciones menos seguras**](https://myaccount.google.com/lesssecureapps), de lo contrario, GMail rechazará el envío.

## Pantallazos

Fragmento lista de mascotas | Fragmento perfil de mascota
---|---
![Lista de mascotas](/docs/fragment_lista_mascotas.png) | ![Perfil de mascota](/docs/fragment_perfil_mascota.png)

Actividad mascotas favoritas | Menú de opciones |
---|---
![Mascotas favoritas](/docs/activity_mascotas_favoritas.png) | ![Menú de opciones](/docs/menu.png)

Formulario de contacto|Acerca de
-|-
![Formulario de contacto](/docs/activity_contacto.png) | ![Biografía](/docs/activity_biografia.png)

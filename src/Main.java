import java.io.File;

/**
 * 7.- El fichero calificaciones.csv contiene las calificaciones de un curso.
 * Durante el curso se realizaron dos exámenes parciales de teoría y un examen de prácticas.
 *
 * Un método que reciba el fichero de calificaciones y devuelva un HashTree, donde cada elemento contiene
 * como clave los apellidos y el nombre de cada alumno y de valor la asistencia a clase sin el signo de %.
 *
 * Calcula la media de los 2 parciales de los alumnos creando un fichero nuevo donde aparezcan los
 * apellidos y nombre en una columna y la media en otra.
 *
 * Calcula la nota media del Ordinario 1 y Ordinario2 de cada alumno creando un fichero nuevo donde
 * aparezcan los apellidos y nombre en una columna y la media de los ordinarios en otra.
 *
 * Imprime por pantalla la media de asistencia del alumnado.
 *
 * Imprime por pantalla el número de alumnos que han sacado más de un 5 en el parcial 1,
 * parcial 2 y prácticas. Considera que el alumno que no tenga una nota, su valor es 0.
 */
public class Main {
    public static void main(String[] args) {

        File archivo = new File("H:\\Gabriel\\Ies El Rincon\\Programación\\Java\\UT7 Excepciones y ficheros (JAVA)\\Actividad 7.1\\Ejercicio_7\\src\\calificaciones.csv");

        CalificacionesDeAlumnos calificaciones = new CalificacionesDeAlumnos();

        calificaciones.alumnosDatosAsistencia(archivo);
        calificaciones.mediaDeParcialesEnFichero(archivo);
        calificaciones.mediaDeOrdinariosEnFichero(archivo);
        calificaciones.mediaDeAsistenciaPorPantalla(archivo);
        calificaciones.notaMayorCincoEnParcialesPracticas(archivo);





    }
}



/**Iterator<String> miIterator = datosAlumnos.keySet().iterator();
 while (miIterator.hasNext()) {
 String key = (String) miIterator.next();
 String value = datosAlumnos.get(key);
 System.out.println(key + " " + value);
 } */

/**
try {
        HashMap<String, String> datosAlumnos = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String datos = br.readLine();
        datos = br.readLine();
        while (datos != null) {
        String arrayDatos[] = datos.split(";");
        String apellidoNombre = arrayDatos[0] + " " + arrayDatos[1];
        String asistencia = arrayDatos[2].replace("%", "");
        datosAlumnos.put(apellidoNombre, asistencia);
        datos = br.readLine();
        }
        br.close();

        for (String clave : datosAlumnos.keySet()) {
        String valor = datosAlumnos.get(clave);
        System.out.println(clave + " " + valor);
        }

        } catch (Exception e) {
        System.out.println("No se ha encontrado el archivo.");
        }
 */
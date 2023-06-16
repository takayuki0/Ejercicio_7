import java.io.*;
import java.util.HashMap;
import java.util.Objects;

public class CalificacionesDeAlumnos {


    //Un método que reciba el fichero de calificaciones y devuelva un HashTree, donde cada elemento contiene
    //como clave los apellidos y el nombre de cada alumno y de valor la asistencia a clase sin el signo de %.
    public void alumnosDatosAsistencia(File archivo) {
        System.out.println("Asistencia de los Alumnos: \n");
        try {
            HashMap<String, String> datosAlumnos = new HashMap<>();
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String datos = br.readLine();
            datos = br.readLine();
            while (datos != null) {
                String arrayDatos[] = datos.split(";");
                String apellidoNombre = arrayDatos[0] + " " + arrayDatos[1];
                for (int i = apellidoNombre.length(); i < 31; i++) {
                    apellidoNombre += " ";
                }
                String asistencia = arrayDatos[2].replace("%", "");
                datosAlumnos.put(apellidoNombre, asistencia);
                datos = br.readLine();
            }
            br.close();

            for (String key : datosAlumnos.keySet()) {
                String value = datosAlumnos.get(key);
                System.out.println(key + " " + value);
            }

            System.out.println("___________________________________________________________________________");

        } catch (Exception e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }

    //Calcula la media de los 2 parciales de los alumnos creando un fichero nuevo donde aparezcan los
    //apellidos y nombre en una columna y la media en otra.
    public void mediaDeParcialesEnFichero(File archivo) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String datos = br.readLine();
            datos = br.readLine();
            while (datos != null) {
                String arrayDatos[] = datos.split(";");
                String apellidoNombre = arrayDatos[0] + " " + arrayDatos[1];
                for (int i = apellidoNombre.length(); i < 31; i++) {
                    apellidoNombre += " ";
                }
                String parcial1 = arrayDatos[3].replace(",", ".");
                String parcial2 = arrayDatos[4].replace(",", ".");
                double media = (Double.parseDouble(parcial1)) + (Double.parseDouble(parcial2)) / 2;
                BufferedWriter bw = new BufferedWriter(new FileWriter("Media_Parciales.txt", true));
                bw.write(apellidoNombre + media + "\n");
                bw.close();
                datos = br.readLine();
            }
            br.close();

        } catch (Exception e) {
            System.out.println("No se ha encontrado el archivo.");
        }
    }


    //Calcula la nota media del Ordinario 1 y Ordinario2 de cada alumno creando un fichero nuevo donde
    //aparezcan los apellidos y nombre en una columna y la media de los ordinarios en otra.
    public void mediaDeOrdinariosEnFichero(File archivo) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String datos = br.readLine();
            datos = br.readLine();
            while (datos != null) {
                String arrayDatos[] = datos.split(";");
                String apellidoNombre = arrayDatos[0] + " " + arrayDatos[1];
                for (int i = apellidoNombre.length(); i < 31; i++) {
                    apellidoNombre+= " ";
                }
                String ordinario1;
                String ordinario2;
                if (arrayDatos[5].equals("")) {
                    ordinario1 = "0.0";
                } else {
                    ordinario1 = arrayDatos[5].replace(",", ".");
                }
                if (arrayDatos[6].equals("")) {
                    ordinario2 = "0.0";
                } else {
                    ordinario2 = arrayDatos[6].replace(",", ".");
                }
                double media = (Double.parseDouble(ordinario1) + Double.parseDouble(ordinario2)) / 2;
                BufferedWriter bw = new BufferedWriter(new FileWriter("Media_Ordinarios_1_2.txt", true));
                bw.write(apellidoNombre + media + "\n");
                bw.close();
                datos = br.readLine();
            }
            br.close();

        } catch (Exception e) {
            System.out.println("No se ha encontrado el archivo.");
        }
    }


    //Imprime por pantalla la media de asistencia del alumnado.
    public void mediaDeAsistenciaPorPantalla(File archivo) {
        double sum = 0;
        double contador = 0;
        System.out.println("Media de Asistencia: ");
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String dato = br.readLine();
            dato = br.readLine();
            while (dato != null) {
                String arraydatos[] = dato.split(";");
                String asistencia = arraydatos[2].replace("%", "");
                sum += Double.parseDouble(asistencia);
                contador++;
                dato = br.readLine();
            }
            br.close();
            double media = sum / contador;
            System.out.println("La Media de Asistencia del Alumnado es de: " + media + "%");
            System.out.println("___________________________________________________________________________");

        } catch (Exception e) {
            System.out.println("No se ha encontrado el archivo.");
        }


    }


    //Imprime por pantalla el número de alumnos que han sacado más de un 5 en el parcial 1,
    //parcial 2 y prácticas. Considera que el alumno que no tenga una nota, su valor es 0.
    public void notaMayorCincoEnParcialesPracticas(File archivo) {

        try {
            int contador = 0;
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String dato = br.readLine();
            dato = br.readLine();
            while (dato != null) {
                String arrayDatos[] = dato.split(";", -1);
                String parcial1 = arrayDatos[3].replace(",", ".");
                String parcial2 = arrayDatos[4].replace(",", ".");
                String practica;
                if (Objects.equals(arrayDatos[7], "")) {
                    practica = "0.0";
                } else {
                    practica = arrayDatos[7].replace(",", ".");
                }
                if (Double.parseDouble(parcial1) > 5.0 && Double.parseDouble(parcial2) > 5.0 && Double.parseDouble(practica) > 5.0) {
                    contador++;
                }
                dato = br.readLine();
            }
            br.close();
            System.out.println("El Número de Alumnos que han Obtenido una Calificación por encima de\n" +
                    "cinco (5) en el Parcial 1, Parcial 2 y en las Prácticas son: " + contador);
            System.out.println("___________________________________________________________________________");

        } catch (Exception e) {
            System.out.println("El archivo no se ha encontrado.");
        }
    }


}


/**
 * try {
 * BufferedReader br = new BufferedReader(new FileReader(archivo));
 * String datos = br.readLine();
 * datos = br.readLine();
 * while (datos != null) {
 * String arrayDatos[] = datos.split(";");
 * String apellidoNombre = arrayDatos[0] + " " + arrayDatos[1];
 * for (int i = apellidoNombre.length(); i < 31; i++) {
 * apellidoNombre+= " ";
 * }
 * double media = Double.parseDouble(arrayDatos[3]) + Double.parseDouble(arrayDatos[4]) / 2;
 * BufferedWriter bw = new BufferedWriter(new FileWriter("Media_Parciales.txt", true));
 * bw.newLine();
 * datos = br.readLine();
 * }
 * br.close();
 * <p>
 * } catch (Exception e) {
 * System.out.println("No se ha encontrado el archivo.");
 * }
 */
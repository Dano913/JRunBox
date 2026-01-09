package exercises;

import main.App;

public class T11Ejercicio9 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 9 Tema 11 – Analizador de texto");

        // No hay entrada de usuario
        app.setInputPanelVisible(false);

        mostrarResultado(app);
    }

    private static void mostrarResultado(App app) {
        app.limpiarConsola();
        app.setPreguntaLabel("");

        String texto = "Este es un ejemplo de texto con algunas palabras prohibidas como gato y perro";
        String[] palabrasProhibidas = {"gato", "ratón", "perro"};

        app.appendConsola("Texto: " + texto + "\n\n");

        // Contar vocales
        int vocales = contarVocales(texto);
        app.appendConsola("Número de vocales: " + vocales + "\n");

        // Buscar palabras prohibidas
        boolean tieneProhibidas = contienePalabraProhibida(texto, palabrasProhibidas);
        app.appendConsola("Contiene palabra prohibida: " + tieneProhibidas + "\n");

        // Buscar primera palabra larga
        String palabraLarga = primeraPalabraLarga(texto, 6);
        app.appendConsola("Primera palabra con más de 6 letras: " + palabraLarga + "\n");
    }

    private static int contarVocales(String texto) {
        int contador = 0;
        texto = texto.toLowerCase();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if ("aeiou".indexOf(c) == -1) {
                continue; // Saltar consonantes y otros caracteres
            }
            contador++;
        }

        return contador;
    }

    private static boolean contienePalabraProhibida(String texto, String[] palabrasProhibidas) {
        String[] palabras = texto.split(" ");

        for (String palabra : palabras) {
            for (String prohibida : palabrasProhibidas) {
                if (palabra.equalsIgnoreCase(prohibida)) {
                    return true; // Salir inmediatamente al encontrar la palabra
                }
            }
        }

        return false; // No se encontró ninguna palabra prohibida
    }

    private static String primeraPalabraLarga(String texto, int longitudMinima) {
        String[] palabras = texto.split(" ");

        for (String palabra : palabras) {
            if (palabra.length() > longitudMinima) {
                return palabra; // Retorna inmediatamente la primera palabra larga
            }
        }

        return "No hay palabras largas"; // Si no se encontró ninguna
    }
}

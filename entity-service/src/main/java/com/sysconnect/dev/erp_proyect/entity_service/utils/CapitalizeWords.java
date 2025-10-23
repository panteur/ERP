package com.sysconnect.dev.erp_proyect.entity_service.utils;

public class CapitalizeWords {

    public static String capitalize(String cadena) {
        // Convertir toda la cadena a minúsculas
        String cadenaMinuscula = cadena.toLowerCase();

        // Dividir la cadena en palabras utilizando espacios como delimitador
        String[] palabras = cadenaMinuscula.split(" ");

        // Recorrer cada palabra y capitalizar la primera letra
        StringBuilder cadenaCapitalizada = new StringBuilder();
        for (String palabra : palabras) {
            // Si la palabra no está vacía, capitalizar la primera letra
            if (!palabra.isEmpty()) {
                char primeraLetra = Character.toUpperCase(palabra.charAt(0));
                cadenaCapitalizada.append(primeraLetra).append(palabra.substring(1)).append(" ");
            }
        }

        // Eliminar el último espacio extra
        return cadenaCapitalizada.toString().trim();
    }

}

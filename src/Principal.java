import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
             // Crear un mapa que asocia el código de moneda con el nombre del país
        Map<String, String> paises = new HashMap<>();
        // Llenar el mapa con los países y sus códigos de moneda
        paises.put("USD", "Estados Unidos");
        paises.put("AED", "Emiratos Arabes Unidos");
        paises.put("AFN", "Afganistan");
        paises.put("ALL", "Albania");
        paises.put("AMD", "Armenia");
        paises.put("ANG", "Antillas Neerlandesas");
        paises.put("AOA", "Angola");
        paises.put("ARS", "Argentina");
        paises.put("AUD", "Australia");
        paises.put("AWG", "Aruba");
        paises.put("AZN", "Azerbaiyan");
        paises.put("BAM", "Bosnia y Herzegovina");
        paises.put("BBD", "Barbados");
        paises.put("BDT", "Bangladesh");
        paises.put("BGN", "Bulgaria");
        paises.put("BHD", "Barein");
        paises.put("BIF", "Burundi");
        paises.put("BMD", "Bermudas");
        paises.put("BND", "Brunei");
        paises.put("BOB", "Bolivia");
        paises.put("BRL", "Brasil");
        paises.put("BSD", "Bahamas");
        paises.put("BTN", "Butan");
        paises.put("BWP", "Botsuana");
        paises.put("BYN", "Bielorrusia");
        paises.put("BZD", "Belice");
        paises.put("CAD", "Canada");
        paises.put("CDF", "Republica Democratica del Congo");
        paises.put("CHF", "Suiza");
        paises.put("CLP", "Chile");
        paises.put("CNY", "China");
        paises.put("COP", "Colombia");
        paises.put("CRC", "Costa Rica");
        paises.put("CUP", "Cuba");
        paises.put("CVE", "Cabo Verde");
        paises.put("CZK", "Republica Checa");
        paises.put("DJF", "Yibuti");
        paises.put("DKK", "Dinamarca");
        paises.put("DOP", "Republica Dominicana");
        paises.put("DZD", "Argelia");
        paises.put("EGP", "Egipto");
        paises.put("ERN", "Eritrea");
        paises.put("ETB", "Etiopia");
        paises.put("EUR", "Union Europea");
        paises.put("FJD", "Fiyi");
        paises.put("GBP", "Reino Unido");
        paises.put("GEL", "Georgia");
        paises.put("GHS", "Ghana");
        paises.put("GNF", "Guinea");
        paises.put("GTQ", "Guatemala");
        paises.put("GYD", "Guyana");
        paises.put("HKD", "Hong Kong");
        paises.put("HNL", "Honduras");
        paises.put("HRK", "Croacia");
        paises.put("HTG", "Haiti");
        paises.put("HUF", "Hungria");
        paises.put("IDR", "Indonesia");
        paises.put("ILS", "Israel");
        paises.put("INR", "India");
        paises.put("IQD", "Irak");
        paises.put("IRR", "Iran");
        paises.put("ISK", "Islandia");
        paises.put("JPY", "Japon");
        paises.put("KES", "Kenia");
        paises.put("KGS", "Kirguistan");
        paises.put("KHR", "Camboya");
        paises.put("KMF", "Comoras");
        paises.put("KRW", "Corea del Sur");
        paises.put("KWD", "Kuwait");
        paises.put("KYD", "Islas Cayman");
        paises.put("KZT", "Kazajistan");
        paises.put("LAK", "Laos");
        paises.put("LBP", "Libano");
        paises.put("LKR", "Sri Lanka");
        paises.put("LRD", "Liberia");
        paises.put("LSL", "Lesoto");
        paises.put("LYD", "Libia");
        paises.put("MAD", "Marruecos");
        paises.put("MDL", "Moldavia");
        paises.put("MGA", "Madagascar");
        paises.put("MKD", "Macedonia del Norte");
        paises.put("MMK", "Myanmar");
        paises.put("MNT", "Mongolia");
        paises.put("MOP", "Macau");
        paises.put("MRU", "Mauritania");
        paises.put("MUR", "Mauricio");
        paises.put("MWK", "Malawi");
        paises.put("MXN", "Mexico");
        paises.put("MYR", "Malasia");
        paises.put("MZN", "Mozambique");
        paises.put("NAD", "Namibia");
        paises.put("NGN", "Nigeria");
        paises.put("NIO", "Nicaragua");
        paises.put("NOK", "Noruega");
        paises.put("NZD", "Nueva Zelanda");
        paises.put("OMR", "Oman");
        paises.put("PAB", "Panama");
        paises.put("PEN", "Peru");
        paises.put("PHP", "Filipinas");
        paises.put("PKR", "Pakistan");
        paises.put("PLN", "Polonia");
        paises.put("PYG", "Paraguay");
        paises.put("QAR", "Catar");
        paises.put("RON", "Rumania");
        paises.put("RSD", "Serbia");
        paises.put("RUB", "Rusia");
        paises.put("RWF", "Ruanda");
        paises.put("SAR", "Arabia Saudita");
        paises.put("SBD", "Islas Salomon");
        paises.put("SCR", "Seychelles");
        paises.put("SDG", "Sudan");
        paises.put("SEK", "Suecia");
        paises.put("SGD", "Singapur");
        paises.put("SHP", "Santa Elena");
        paises.put("SLE", "Sierra Leona");
        paises.put("SLL", "Leona Sierra");
        paises.put("SOS", "Somalia");
        paises.put("SRD", "Surinam");
        paises.put("SSP", "Sudan del Sur");
        paises.put("STN", "Santo Tome y Principe");
        paises.put("SYP", "Siria");
        paises.put("SZL", "Esuatini");
        paises.put("THB", "Tailandia");
        paises.put("TJS", "Tayikistan");
        paises.put("TMT", "Turkmenistan");
        paises.put("TND", "Tunez");
        paises.put("TOP", "Tonga");
        paises.put("TRY", "Turquia");
        paises.put("TTD", "Trinidad y Tobago");
        paises.put("TVD", "Tuvalu");
        paises.put("TWD", "Taiwan");
        paises.put("TZS", "Tanzania");
        paises.put("UAH", "Ucrania");
        paises.put("UGX", "Uganda");
        paises.put("UYU", "Uruguay");
        paises.put("UZS", "Uzbekistan");
        paises.put("VES", "Venezuela");
        paises.put("VND", "Vietnam");
        paises.put("VUV", "Vanuatu");
        paises.put("WST", "Samoa");
        paises.put("YER", "Yemen");
        paises.put("ZAR", "Sudafrica");
        paises.put("ZMW", "Zambia");
        paises.put("ZWL", "Zimbabue");

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Preguntar al usuario por el nombre de un país
        System.out.println("Ingrese el nombre de un país de origen:");
        String pais = scanner.nextLine().trim();

        // Convertir la entrada a minúsculas y luego capitalizar la primera letra
        pais = pais.toLowerCase();
        pais = pais.substring(0, 1).toUpperCase() + pais.substring(1);


         // Ingresa pais conversion
        System.out.println("Ingrese el nombre de un país de conversion:");
        String paisConversion = scanner.nextLine().trim();

        // Convertir la entrada a minúsculas y luego capitalizar la primera letra
        paisConversion = paisConversion.toLowerCase();
        paisConversion = paisConversion.substring(0, 1).toUpperCase() + paisConversion.substring(1);

       // Solicitar al usuario el valor a convertir
        System.out.println("Ingrese el valor a convertir:");
        double valorConvertir = scanner.nextDouble();


        // Buscar el país en el mapa origen
        String codigoMoneda = null;
        for (Map.Entry<String, String> entry : paises.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(pais)) {
                codigoMoneda = entry.getKey();
                break;
            }
        }



        // Buscar el país en el mapa para el codigo destino
        String codigoMonedaDestino = null;
        for (Map.Entry<String, String> entry : paises.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(paisConversion)) {
                codigoMonedaDestino = entry.getKey();
                break;
            }
        }



        // Cerrar el escáner
        scanner.close();

//Carga los datos del api

        String apiKey = "503a317ec14ae125eea9bb84";
        String direccion = "https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+codigoMoneda;
        //System.out.println(direccion);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        // Capturamos la respuesta en JSON
        String json = response.body();

        // Mostrar la respuesta JSON (solo para verificar)
        //System.out.println(json);

        // Usamos Gson para convertir el JSON a un Map
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        // Accedemos al objeto 'conversion_rates' dentro del JSON
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        // Convertimos el 'conversion_rates' a un Map<String, Double>
        Map<String, Double> ratesMap = gson.fromJson(conversionRates, Map.class);

        // Mostrar el Map con las tasas de cambio
        System.out.println("Tasas de cambio: " + ratesMap);


        // Mostrar el resultado

        System.out.println("Conversion a realizar es de moneda "+pais+" a moneda"+paisConversion);



        if (codigoMoneda != null) {
            System.out.println("El código de la moneda de " + pais + " es: " + codigoMoneda);
        } else {
            System.out.println("El país ingresado no se encontró en la lista.");
        }


        // Mostrar el resultado
        if (codigoMonedaDestino != null) {
            System.out.println("El código de la moneda de " + paisConversion + " es: " + codigoMonedaDestino);
        } else {
            System.out.println("El país ingresado no se encontró en la lista.");
        }


        // Ahora puedes buscar un país específico en el Map
        if (ratesMap.containsKey(codigoMonedaDestino)) {
            // Obtener la tasa de cambio
            Double tasaCambio = ratesMap.get(codigoMonedaDestino);

            // Calcular la cantidad en EUR usando la regla de tres
            double conversionDivisa = valorConvertir * tasaCambio;

            // Imprimir la tasa de cambio
            System.out.println("La tasa de cambio para 1 " + codigoMoneda + " es " + tasaCambio + " " + codigoMonedaDestino);
            System.out.println("La tasa de cambio para  "+ codigoMoneda +"$"+valorConvertir + " es " +codigoMonedaDestino+"$"+ conversionDivisa);
        } else {
            System.out.println("El país no se encuentra en la lista.");
        }
}}

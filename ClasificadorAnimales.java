import java.util.*;

public class ClasificadorAnimales {
    private static Map<String, List<Animal>> clasificacion = new TreeMap<>();
    private static List<Animal> animales = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;
        do {
            System.out.print("Nombre del animal: ");
            String nombre = scanner.nextLine();

            System.out.print("Tipo (terrestre/aéreo/acuático): ");
            String tipo = scanner.nextLine().toLowerCase();

            System.out.print("Género (masculino/femenino): ");
            String genero = scanner.nextLine().toLowerCase();

            Animal animal = new Animal(nombre, tipo, genero);
            animales.add(animal);

            clasificacion.computeIfAbsent(tipo, k -> new ArrayList<>()).add(animal);

            System.out.print("¿Deseas ingresar otro animal? (s/n): ");
            opcion = scanner.nextLine();
        } while (opcion.equalsIgnoreCase("s"));
    }
}

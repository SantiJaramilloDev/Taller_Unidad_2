import java.util.*;
import java.util.stream.*;

public class GestionPersonas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        String continuar;

        do {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = Integer.parseInt(scanner.nextLine());

            System.out.print("Género (M/F): ");
            String genero = scanner.nextLine().toUpperCase();

            System.out.print("Sueldo por hora: ");
            double sueldo = Double.parseDouble(scanner.nextLine());

            System.out.print("Cargo: ");
            String cargo = scanner.nextLine();

            personas.add(new Persona(nombre, apellido, edad, genero, sueldo, cargo));

            System.out.print("¿Deseas agregar otra persona? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        System.out.println("\nCantidad de personas: " + personas.size());

        double promedio = personas.stream()
                .mapToInt(Persona::getEdad)
                .average()
                .orElse(0);
        System.out.println("Promedio de edad: " + promedio);

        long mayores = personas.stream()
                .filter(p -> p.getEdad() >= 18)
                .count();
        System.out.println("Mayores de edad: " + mayores);
    }
}

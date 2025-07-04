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

        System.out.println("Personas con nombre que empieza con A:");
        personas.stream()
                .filter(p -> p.getNombre().startsWith("A"))
                .forEach(p -> System.out.println(p.getNombre()));

        System.out.println("Personas con apellido que contiene 'M':");
        personas.stream()
                .filter(p -> p.getApellido().toUpperCase().contains("M"))
                .forEach(p -> System.out.println(p.getApellido()));

        personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("director") && p.getGenero().equals("M"))
                .map(p -> p.getSueldoHora() * 8)
                .forEach(sueldo -> System.out.println("Sueldo por 8 horas: $" + sueldo));

        personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("director") && p.getGenero().equals("M"))
                .peek(p -> System.out.println("Nombre: " + p.getNombre() + " " + p.getApellido()))
                .map(p -> p.getSueldoHora() * 8)
                .forEach(sueldo -> System.out.println("Sueldo por 8 horas: $" + sueldo));

        Optional<Persona> primera = personas.stream()
                .filter(p -> p.getGenero().equals("F") && p.getCargo().equalsIgnoreCase("desarrollador"))
                .findFirst();
        primera.ifPresent(p -> System.out.println("Primera desarrolladora: " + p.getNombre() + " " + p.getApellido()));

        Optional<Persona> masGana = personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("desarrollador"))
                .max(Comparator.comparingDouble(Persona::getSueldoHora));

        if (masGana.isPresent()) {
            Persona p = masGana.get();
            System.out.println("Desarrollador que más gana: " + p.getNombre() + " $" + p.getSueldoHora());
        }

        System.out.println("Mujeres ordenadas por nombre:");
        personas.stream()
                .filter(p -> p.getGenero().equals("F"))
                .sorted(Comparator.comparing(Persona::getNombre))
                .forEach(p -> System.out.println(p.getNombre() + " " + p.getApellido()));
    }
}

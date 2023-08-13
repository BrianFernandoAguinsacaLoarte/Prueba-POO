import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Registro registro = new Registro();
        Scanner scanner = new Scanner(System.in);

        // Crear y agregar un usuario a la lista (puedes agregar más si lo deseas)
        Usuario usuario1 = new Usuario("Persona1", "morita");
        registro.agregarUsuario(usuario1);

        // Iniciar sesión y realizar registro
        System.out.println("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        if (registro.iniciarSesion(nombreUsuario, contrasena)) {
            System.out.println("¡Sesión iniciada correctamente!");
            registro.realizarRegistro(scanner);
        } else {
            System.out.println("Usuario o contraseña incorrectos. Sesión no iniciada.");
        }
        scanner.close();
    }

}

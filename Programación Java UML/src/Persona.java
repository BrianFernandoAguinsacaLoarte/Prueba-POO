import java.util.Scanner;
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;

    public Persona() {
        nombre = "";
        apellido = "";
        edad = 0;
    }
    public String getNombre() {
        this.nombre = nombre;
        return nombre;
    }
    public void agregarPersona(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la persona: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido de la persona: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la edad de la persona: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String toString( ){
        return "Nombre: "+nombre+" Apellido: "+apellido+" Edad: "+edad;
    }
}

import java.util.ArrayList;

public class Estudiante extends Persona implements MiembroUniversidad{
    private String  carrera,legajo;
    private int promedio; 
    private  ArrayList<Materia> Materias; 
    public Estudiante(String apellido,String nombre,String documento, String carrera,String legajo, int edad, int promedio){
        super(nombre, apellido, documento, edad); // Llama al constructor de Persona
        this.carrera=carrera;
        this.promedio=promedio;
        this.legajo=legajo;
        this.Materias= new ArrayList<>(); // Inicializa el arreglo de materias
    }

   
   public String getCarrera() {
    return this.carrera;
   }
   public String getLegajo() {
    return this.legajo;
   }

   public void setCarrera(String carrera) {
     this.carrera=carrera;
   }

   public int getPromedio() {
    return this.promedio;
   }

   public void setPromedio(int promedio) {
    if(promedio>=0 && promedio<=10){
      this.promedio = promedio;
    }
    else{
    System.out.println("Ingrese un  nombre no vacio ");  
    }
   }


   // Metodo AgregarMateria
   public void agregarMateria(Materia materia) {
        
      Materias.add(materia);
    }
   //Calcular promedio
   public double CalcularPromedio()
    {
      double suma = 0;
      for (int i = 0; i < 3; i++) 
      {
      suma += Materias.get(i).getCalificacion();
      }
      return suma / 3;
    }
    private String obtenerNombresMaterias() 
    {
      if (this.Materias == null) {
          return "Ninguna";
      }

      String lista = "";
      // Usamos .size() para saber el tamaño no es lenght por que es arraylist.
      for (int i = 0; i < this.Materias.size(); i++) 
      {
      // El nombre de cada materia
      lista += "\n   - " + this.Materias.get(i).getNombre();
      }
      return lista;
    }

    public String toString() 
    {
      String info = "Estudiante:\n" +
      "Nombre: " + super.getNombre() +"\n"+
      "Apellido " + super.getApellido() +"\n"+
      "Edad: " + super.getEdad() +"\n" +
      "Documento: " +super.getDocumento() +"\n"+
      "Promedio " +this.promedio+"\n"+
      "Carrera: " +this.carrera+"\n"+
      "Materias en las que esta el alumno :" + obtenerNombresMaterias(); // Llama a una funcion para mostrar todos los nombres de las materias en las que esta el alumno.
        
      return info; // Toda la inforamcion.
    }
    public String obtenerRol()
    {
    String rol="Estudiante";
    return rol;
    }
    public String obtenerInformacionCompleta()
    {
     String info=toString();
      return info;
    }
    public static double calcularPromedioRecursivo(ArrayList<Materia> materias, int indice) 
    {
      if (indice == materias.size()) 
      {
          return 0; // Si no eisten materias  el promedio es 0 y si recorremos todas las materias se rompe la recursividad entregando el resultado al programa principal
      }
      double suma = materias.get(indice).getCalificacion() + calcularPromedioRecursivo(materias, indice + 1);

    // Solo divide cuando vuelve a la primera llamada (indice == 0)
    if (indice == 0) 
    {
        return suma / materias.size();
    }
    return suma; //En cada llamada se va sumando la calificacion de cada materia y se va devolviendo la suma total al programa principal
    }
   
   public double calcularPromedioIterativo(ArrayList<Materia> materias)
   {
    double suma = 0;
    for (int i = 0; i < materias.size(); i++)
    {
       suma = materias.get(i).getCalificacion() + suma; // Se suma la calificacion de cada materia.
    }
    return suma / materias.size(); 
   }
}

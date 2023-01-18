package Modelo;
public class Proveedor {
    private int Id_proveedor;
    private String nombre;
     private String A_paterno;
      private String A_materno;
      

    public int getId_proveedor() {
        return Id_proveedor;
    }

    public void setId_proveedor(int Id_proveedor) {
        this.Id_proveedor = Id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getA_paterno() {
        return A_paterno;
    }

    public void setA_paterno(String A_paterno) {
        this.A_paterno = A_paterno;
    }

    public String getA_materno() {
        return A_materno;
    }

    public void setA_materno(String A_materno) {
        this.A_materno = A_materno;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
       private String Email;
        private int Numero;
         private String Calle;
          private String Colonia;
           private String ciudad;
            private int telefono;
}

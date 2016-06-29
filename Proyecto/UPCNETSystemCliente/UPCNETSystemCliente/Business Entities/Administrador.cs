using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UPCNETSystemCliente.Business_Entities
{
    public class Administrador
    {
        private String IDAdministrador;
        private String Pass;
        private String Nombre;
        private String Apellido;
        private String Correo;
        public Administrador(string IDAdministrador,string Pass,string Nombre,string Apellido,string Correo)
        {
            this.IDAdministrador = IDAdministrador;
            this.Pass = Pass;
            this.Nombre = Nombre;
            this.Apellido = Apellido;
            this.Correo = Correo;
        }
        public string getIDAdministrador() { return this.IDAdministrador; }
        public string getPass() { return this.Pass; }
        public string getNombre() { return this.Nombre; }
        public string getApellido() { return this.Apellido; }
        public string getCorreo() { return this.Correo; }
    }
}
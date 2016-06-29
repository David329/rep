using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UPCNETSystemCliente.UPCNETServiceProfesor;

namespace UPCNETSystemCliente.ViewModel.Panel
{
    public class _AddEditProfesor
    {
        public string Nombre { get; set; }
        public string Apellido { get; set; }
        public string Correo { get; set; }
        public int DNI { get; set; }
        public string Direccion { get; set; }
        public string Password { get; set; }
        public string IDProfesor { get; set; }
        public int Edad { get; set; }
        public double Sueldo { get; set; }
        public string Modo { get; set; }

        public _AddEditProfesor()
        {

        }
        public void Fill(string IDProfesor, string Modo)
        {
            this.IDProfesor = IDProfesor;

            if (IDProfesor != "" && IDProfesor != null)
            {
                UPCNETServiceProfesorClient proxy = new UPCNETServiceProfesorClient();
                UPCNETServiceProfesor.profesor objProfesor = proxy.getProfesorById(IDProfesor);

                this.Nombre = objProfesor.nombre;
                this.Apellido = objProfesor.apellido;
                this.Correo = objProfesor.correo;
                this.DNI = objProfesor.dni;
                this.Password = objProfesor.pass;
                this.Direccion = objProfesor.direccion;
                this.Edad = objProfesor.edad;
                this.Sueldo = objProfesor.sueldo;



            }
            this.Modo = Modo;
        }
    }
}
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

using UPCNETSystemCliente.UPCNETServiceProfesor;

namespace UPCNETSystemCliente.ViewModel.Panel
{
    public class _MantenimientoProfesores
    {
        public List<Profesor> ListObjetos { get; set; }

        public void Procesar(UPCNETServiceProfesor.profesor[] profesor)
        {
           
            ListObjetos = new List<Profesor>();
            if (profesor != null)
            {
                foreach (var item in profesor)
                {
                    Profesor objProfesor = new Profesor();
                    objProfesor.Nombre = item.nombre;
                    objProfesor.Apellido = item.apellido;
                    objProfesor.Correo = item.correo;
                    objProfesor.Password = item.pass;
                    objProfesor.IDProfesor = item.idProfesor;
                    objProfesor.Edad = item.edad;
                    objProfesor.Direccion = item.direccion;
                    objProfesor.DNI = item.dni;
                    objProfesor.Sueldo = item.sueldo;

                    ListObjetos.Add(objProfesor);
                }
            }
        }
    }

    public class Profesor
    {
        public string IDProfesor { get; set; }
        public string Nombre { get; set; }
        public string Apellido { get; set; }
        public int DNI { get; set; }
        public int Edad { get; set; }
        public string Correo { get; set; }
        public string Direccion { get; set; }
        public double Sueldo { get; set; }
        public string Password { get; set; }
    }

}
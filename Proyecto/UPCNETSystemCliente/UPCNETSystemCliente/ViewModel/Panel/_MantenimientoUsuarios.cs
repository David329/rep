using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using UPCNETSystemCliente.UPCNETServiceAlumno;

namespace UPCNETSystemCliente.ViewModel.Panel
{
    public class _MantenimientoUsuarios
    {
        public List<Alumno> ListObjetos { get; set; }

        public void Procesar(UPCNETServiceAlumno.alumno[] alumnos) {
            ListObjetos = new List<Alumno>();
            if (alumnos != null)
            {
                foreach (var item in alumnos)
                {
                    Alumno objAlumno = new Alumno();
                    objAlumno.Nombre = item.nombre;
                    objAlumno.Apellido = item.apellido;
                    objAlumno.Correo = item.correo;
                    objAlumno.Password = item.pass;
                    objAlumno.IDAlumno = item.idAlumno;
                    objAlumno.Edad = item.edad;
                    objAlumno.Direccion = item.direccion;
                    objAlumno.DNI = item.dni;

                    ListObjetos.Add(objAlumno);
                }
            }
        }
    }

    public class Alumno {
        public string Nombre { get; set; }
        public string Apellido { get; set; }
        public string Correo { get; set; }
        public string Password { get; set; }
        public string IDAlumno { get; set; }
        public int DNI { get; set; }
        public string Direccion { get; set; }
        public int Edad { get; set; }
    }
}
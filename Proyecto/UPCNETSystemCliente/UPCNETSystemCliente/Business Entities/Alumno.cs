using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UPCNETSystemCliente.Business_Entities
{
    public class Alumno
    {
        public string IdAlumno { get; set; }
        public string Nombre { get; set; }
        public string Apellido { get; set; }
        public string Codigo { get; set; }
        public string Carrera { get; set; }
        public string DNI { get; set; }
        public string Correo { get; set; }
        public string Fecha { get; set; }
        public string IDCategoria { get; set; }
        public string IDApoderado { get; set; }
        public string Pass { get; set; }
    }
}
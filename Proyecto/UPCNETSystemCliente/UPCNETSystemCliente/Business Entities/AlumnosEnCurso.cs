using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UPCNETSystemCliente.Business_Entities
{
    public class AlumnosEnCurso
    {
        public string IDAlumno { get; set; }
        public string IDCurso { get; set; }
        public string NombreCurso { get; set; }
        public string NombreAlumno { get; set; }
        public string Apellido { get; set; }
        public double pc1 { get; set; }
        public double pc2 { get; set; }
        public double ep { get; set; }
        public double ef { get; set; }
    }
}
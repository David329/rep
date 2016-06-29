using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UPCNETSystemCliente.Business_Entities
{
    public class CursoAlumno
    {
        public string IDAlumno { get; set; }
        public string IDCurso { get; set; }
        public double PC1 { get; set; }
        public double PC2 { get; set; }
        public double EP { get; set; }
        public double EF{ get; set; }
        public bool Retirado { get; set; }
        public int Inasistencias { get; set; }
        public bool Delegado { get; set; }
    }
}
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UPCNETSystemCliente.Business_Entities
{
    public class CursoAlumnoReporte
    {
        public string idCurso { get; set; }
        public string curso { get; set; }
        public string profesor { get; set; }
        public double pc1 { get; set; }
        public double pc2 { get; set; }
        public double ep { get; set; }
        public double ef { get; set; }
    }
}
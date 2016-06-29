using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UPCNETSystemCliente.Business_Entities
{
    public class CursoClaseAlumno
    {
        public string idCurso { get; set; }
        public string curso { get; set; }
        public string profesor { get; set; }
        public string dia { get; set; }
        public string horaInicio { get; set; }
        public string horaFin { get; set; }
    }
}
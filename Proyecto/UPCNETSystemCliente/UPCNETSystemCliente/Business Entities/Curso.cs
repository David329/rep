using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UPCNETSystemCliente.Business_Entities
{
    public class Curso
    {
        public string IDCurso { get; set; }
        public string Nombre { get; set; }
        public int CicloDeCurso { get; set; }
        public int MaxInasistencia { get; set; }
        public string IDProfesor { get; set; }
    }
}
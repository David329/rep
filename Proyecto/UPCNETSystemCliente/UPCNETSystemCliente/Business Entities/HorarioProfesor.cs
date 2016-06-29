using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UPCNETSystemCliente.Business_Entities
{
    public class HorarioProfesor
    {
        public string IDCurso { get; set; }
        public string Nombre { get; set; }
        public string Dia { get; set; }
        public string HoraIni { get; set; }
        public string HoraFin { get; set; }
    }
}
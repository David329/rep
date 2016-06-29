using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UPCNETSystemCliente.Business_Entities
{
    public class Ciclo
    {
        private String IdCiclo;
        private String IdAlumno;
        private String Boleta1;
        private String Boleta2;
        private String Boleta3;

        public Ciclo(string idCiclo, string idAlumno, string boleta1, string boleta2, string boleta3)
        {
            this.IdCiclo = idCiclo;
            this.IdAlumno = idAlumno;
            this.Boleta1 = boleta1;
            this.Boleta2 = boleta2;
            this.Boleta3 = boleta3;
        }
        
        public string getIdCiclo() { return IdCiclo; }
        public string getIdAlumno() { return IdAlumno; }
        public string getBoleta1() { return Boleta1; }
        public string getBoleta2() { return Boleta2; }
        public string getBoleta3() { return Boleta3; }
    }
}
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UPCNETSystemCliente.Business_Entities
{
    public class Incidencia
    {
        private String IdIncidencia;
        private String Asunto;
        private String IdAlumno;
        private String IdProfesor;

        public Incidencia(String idincidencia, String asunto, String idalumno, String idprofesor)
        {
            this.IdIncidencia = idincidencia;
            this.Asunto = asunto;
            this.IdAlumno = idalumno;
            this.IdProfesor = idprofesor;
        }

        public String getIdIncidencia() { return IdIncidencia; }
        public String getAsunto() { return Asunto; }
        public String getIdAlumno() { return IdAlumno; }
        public String getIdProfesor() { return IdProfesor; }
    }
}
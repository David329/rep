using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UPCNETSystemCliente.Business_Entities
{
    public class Recurso
    {
        private String IdRecurso;
        private String NombreRecurso;
        private String FechaPedido;
        private String CantidadHoras;
        private String Reservado;
        private String IdAlumno;
        private String IdProfesor;

        public Recurso(String idrecurso, String nombrerecurso, String fechapedido, String cantidadhoras,
            String reservado, String idalumno, String idprofesor)
        {
            this.IdRecurso = idrecurso;
            this.NombreRecurso = nombrerecurso;
            this.FechaPedido = fechapedido;
            this.CantidadHoras = cantidadhoras;
            this.Reservado = reservado;
            this.IdAlumno = idalumno;
            this.IdProfesor = idprofesor;
        }
        public String getIdrecurso() { return IdRecurso; }
        public String getNombreRecurso() { return NombreRecurso; }
        public String getFechaPedido() { return FechaPedido; }
        public String getCantidadHoras() { return CantidadHoras; }
        public String getReservado() { return Reservado; }
        public String getIdAlumno() { return IdAlumno; }
        public String getIdProfesor() { return IdProfesor; }
    }
}
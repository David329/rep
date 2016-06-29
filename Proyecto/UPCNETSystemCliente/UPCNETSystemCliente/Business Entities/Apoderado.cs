using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UPCNETSystemCliente.Business_Entities
{
    public class Apoderado
    {
        public string IDApoderado  { get; set; }
        public string Pass { get; set; }
        public string Nombre { get; set; }
        public string Apellido { get; set; }
        public int DNI { get; set; }
        public int Edad{ get; set; }
        public string Correo { get; set; }
        public string Direccion { get; set; }
        public string Condicion{ get; set; }
        public Apoderado() { }
    }
}
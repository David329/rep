using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UPCNETSystemCliente.UPCNETServiceApoderado;

namespace UPCNETSystemCliente.ViewModel.Panel
{
    public class _AddEditApoderado
    {
        public string Nombre { get; set; }
        public string Apellido { get; set; }
        public string Correo { get; set; }
        public int DNI { get; set; }
        public string Direccion { get; set; }
        public string Password { get; set; }
        public string IDApoderado { get; set; }
        public int Edad { get; set; }
        public string Modo { get; set; }
        public string Condicion { get; set; }

        public _AddEditApoderado()
        {

        }
        public void Fill(string IDApoderado, string Modo)
        {
            this.IDApoderado = IDApoderado;

            if (IDApoderado != "" && IDApoderado != null)
            {
                UPCNETServiceApoderadoClient proxy = new UPCNETServiceApoderadoClient();
                UPCNETServiceApoderado.apoderado objApoderado = proxy.getApoderadoById(IDApoderado);

                this.Nombre = objApoderado.nombre;
                this.Apellido = objApoderado.apellido;
                this.Correo = objApoderado.correo;
                this.DNI = objApoderado.DNI;
                this.Password = objApoderado.pass;
                this.Direccion = objApoderado.direccion;
                this.Edad = objApoderado.edad;
                this.Condicion = objApoderado.condicion;



            }
            this.Modo = Modo;
        }
    }

}
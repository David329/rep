using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using UPCNETSystemCliente.UPCNETServiceApoderado;

namespace UPCNETSystemCliente.ViewModel.Panel
{
    public class _MantenimientoApoderado
    {
        public List<Apoderado> ListObjetos { get; set; }

        public void Procesar(UPCNETServiceApoderado.apoderado[] apoderado)
        {
            ListObjetos = new List<Apoderado>();
            if (apoderado != null)
            {
                foreach (var item in apoderado)
                {
                    Apoderado objApoderado = new Apoderado();
                    objApoderado.Nombre = item.nombre;
                    objApoderado.Apellido = item.apellido;
                    objApoderado.Correo = item.correo;
                    objApoderado.Password = item.pass;
                    objApoderado.IDApoderado = item.IDApoderado;
                    objApoderado.Edad = item.edad;
                    objApoderado.Direccion = item.direccion;
                    objApoderado.DNI = item.DNI;
                    objApoderado.Condicion = item.condicion;

                    ListObjetos.Add(objApoderado);
                }
            }
        }
    }
    public class Apoderado
    {
        public string IDApoderado { get; set; }
        public string Password { get; set; }
        public string Nombre { get; set; }
        public string Apellido { get; set; }
        public string Correo { get; set; }
        public string Direccion { get; set; }
        public string Condicion { get; set; }
        public int DNI { get; set; }
        public int Edad { get; set; }
    }


}
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UPCNETSystemCliente.UPCNETServiceAlumno;
using UPCNETSystemCliente.UPCNETServiceCategoria;
using UPCNETSystemCliente.Business_Entities;
using System.Web.Mvc;
using UPCNETSystemCliente.UPCNETServiceApoderado;

namespace UPCNETSystemCliente.ViewModel.Panel
{
    public class _AddEditUsuario
    {
        public Business_Entities.Apoderado objApoderado { get; set; }
        public string Nombre { get; set; }
        public string Apellido { get; set; }
        public string Correo { get; set; }
        public int DNI { get; set; }
        public string Direccion { get; set; }
        public string Password { get; set; }
        public string IDAlumno { get; set; }
        public int Edad { get; set; }
        public string Modo { get; set; }

        public string IDCategoria{ get; set; }

        public List<Categoria> lstCategorias { get; set; }
        public IEnumerable<SelectListItem> selectCategorias { get; set; }
        public _AddEditUsuario()
        {

        }
        public void Fill(string IDAlumno, string Modo)
        {
            this.IDAlumno = IDAlumno;
            UPCNETServiceCategoriaClient proxyCAT = new UPCNETServiceCategoriaClient();
            if (IDAlumno != "" && IDAlumno!=null)
            {
                UPCNETServiceAlumnoClient proxyAL = new UPCNETServiceAlumnoClient();
                alumno objAlumno = proxyAL.getAlumnoById(IDAlumno);
                UPCNETServiceApoderadoClient proxyAP = new UPCNETServiceApoderadoClient();
                apoderado objApo= proxyAP.getApoderadoById(objAlumno.idApoderado);

                this.IDCategoria = objAlumno.idCategoria;
                this.Nombre = objAlumno.nombre;
                this.Apellido = objAlumno.apellido;
                this.Correo = objAlumno.correo;
                this.DNI = objAlumno.dni;
                this.Password = objAlumno.pass;
                this.Direccion = objAlumno.direccion;
                this.Edad = objAlumno.edad;
                ///Apoderado
                this.objApoderado= new Business_Entities.Apoderado();
                this.objApoderado.Apellido = objApo.apellido;
                this.objApoderado.Condicion = objApo.condicion;
                this.objApoderado.Correo = objApo.correo;
                this.objApoderado.Direccion = objApo.direccion;
                this.objApoderado.DNI = objApo.DNI;
                this.objApoderado.Edad = objApo.edad;
                this.objApoderado.IDApoderado = objApo.IDApoderado;
                this.objApoderado.Nombre = objApo.nombre;
                this.objApoderado.Pass = objApo.pass;
            }
            //CATEGORIAS

            lstCategorias = new List<Categoria>();
            foreach (var item in proxyCAT.getCategoria())
            {
                Categoria obj = new Categoria();
                obj.IDCategoria = item.idCategoria;
                obj.Monto = item.monto;
                lstCategorias.Add(obj);
            }
            selectCategorias = from c in lstCategorias
                               select new SelectListItem
                               {
                                   Text = c.Monto + " " + "[" + c.IDCategoria + "]",
                                   Value = c.IDCategoria
                               };
            this.Modo = Modo;
        }
    }
}



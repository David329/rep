using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UPCNETSystemCliente.UPCNETServiceCurso;
using System.Web.Mvc;
using UPCNETSystemCliente.UPCNETServiceProfesor;

namespace UPCNETSystemCliente.ViewModel.Panel
{
    public class _AddEditCurso
    {
        public Business_Entities.Curso objCurso { get; set; }
        public string IDCurso { get; set; }
        public string Nombre { get; set; }
        public string IDProfesor { get; set; }
        public string Modo { get; set; }

        public List<Business_Entities.Profesor> lstProfesores { get; set; }
        public IEnumerable<SelectListItem> selectProfesores { get; set; }
        public _AddEditCurso()
        {

        }
        public void Fill(string IDCurso, string Modo)
        {
            objCurso = new Business_Entities.Curso();
            objCurso.IDCurso = IDCurso;
//            this.IDCurso = IDCurso;
            UPCNETServiceProfesorClient proxyPR = new UPCNETServiceProfesorClient();
            if (IDCurso != "" && IDCurso != null)
            {
                UPCNETServiceCursoClient proxyCU = new UPCNETServiceCursoClient();
                curso obj = proxyCU.getCursoById(IDCurso);

                objCurso.IDProfesor = obj.idProfesor;
                objCurso.Nombre = obj.nombre;
                objCurso.CicloDeCurso = obj.cicloDeCurso;
                objCurso.MaxInasistencia = obj.maxInasistencia;
            }
            //Profesores --no es necesario todos los datos pero podemos sacar de ellos estos atributos, si lo colocamos en otra cosa q no sea CBox

            lstProfesores= new List<Business_Entities.Profesor>();
            foreach (var item in proxyPR.getProfesor())
            {
                Business_Entities.Profesor obj = new Business_Entities.Profesor();
                obj.IDProfesor = item.idProfesor;
                obj.Apellido = item.apellido;
                obj.Correo = item.correo;
                obj.Direccion = item.direccion;
                obj.DNI = item.dni;
                obj.Edad = item.edad;
                obj.Nombre = item.nombre;
                obj.Pass = item.pass;
                obj.Sueldo = item.sueldo;
                lstProfesores.Add(obj);
            }
            selectProfesores = from c in lstProfesores
                               select new SelectListItem
                               {
                                   Text = c.Nombre + " " + c.Apellido,
                                   Value = c.IDProfesor
                               };
            this.Modo = Modo;
        }
    }
}



using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using UPCNETSystemCliente.UPCNETServiceCurso;
using UPCNETSystemCliente.UPCNETServiceCursoClase;

namespace UPCNETSystemCliente.ViewModel.Panel
{
    public class _AddEditCursoClase
    {
        public Business_Entities.CursoClase objCursoClase { get; set; }
        public string IDClase { get; set; }
        public string IDCurso { get; set; }
        public string Modo { get; set; }

        public List<Business_Entities.Curso> lstCursos{ get; set; }
        public IEnumerable<SelectListItem> selectCursos{ get; set; }
        public _AddEditCursoClase()
        {

        }
        public void Fill(string IDCurso,string IDClase, string Modo)
        {
            objCursoClase = new Business_Entities.CursoClase();
            objCursoClase.IDCurso = IDCurso;
            objCursoClase.IDClase = IDClase;
            UPCNETServiceCursoClient proxyCU = new UPCNETServiceCursoClient();
            if (IDCurso != "" && IDCurso != null&&IDClase!=""&&IDClase!=null)
            {
                UPCNETServiceCursoClaseClient proxyCC = new UPCNETServiceCursoClaseClient();
                cursoClase obj = proxyCC.getCursoClaseByID(IDCurso, IDClase);
                objCursoClase.Dia = obj.dia;
                objCursoClase.HoraFin = obj.horaFin;
                objCursoClase.HoraIni = obj.horaIni;
                objCursoClase.IDClase = obj.idClase;
                objCursoClase.IDCurso = obj.idCurso;
            }
            //Profesores --no es necesario todos los datos pero podemos sakar de ellos estos atributos, si lo colocamos en otra cosa q no sea CBox

            lstCursos = new List<Business_Entities.Curso>();
            foreach (var item in proxyCU.getCursos())
            {
                Business_Entities.Curso obj = new Business_Entities.Curso();
                obj.IDProfesor = item.idProfesor;
                obj.Nombre = item.nombre;
                obj.CicloDeCurso = item.cicloDeCurso;
                obj.IDCurso = item.idCurso;
                obj.MaxInasistencia = item.maxInasistencia;
                lstCursos.Add(obj);
            }
            selectCursos = from c in lstCursos
                               select new SelectListItem
                               {
                                   Text = c.IDCurso + "|| Ciclo:" + c.CicloDeCurso,
                                   Value = c.IDCurso
                               };
            this.Modo = Modo;
        }
    }
}
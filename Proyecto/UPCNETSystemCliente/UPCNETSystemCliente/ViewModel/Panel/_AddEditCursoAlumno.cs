using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using UPCNETSystemCliente.UPCNETServiceCurso;
using UPCNETSystemCliente.UPCNETServiceCursoAlumno;

namespace UPCNETSystemCliente.ViewModel.Panel
{
    public class _AddEditCursoAlumno
    {
        public Business_Entities.CursoAlumno objCursoAlumno{ get; set; }
        public string IDCurso{ get; set; }
        public string IDAlumno{ get; set; }
        public string Modo { get; set; }

        public List<Business_Entities.Curso> lstCursos{ get; set; }
        public IEnumerable<SelectListItem> selectCursos{ get; set; }
        public _AddEditCursoAlumno()
        {

        }
        public void Fill(string IDCurso, string IDAlumno, string Modo)
        {
            objCursoAlumno = new Business_Entities.CursoAlumno();
            objCursoAlumno.IDCurso= IDCurso;
            objCursoAlumno.IDAlumno= IDAlumno;
            UPCNETServiceCursoClient proxyCU = new UPCNETServiceCursoClient();
            if (IDCurso != "" && IDCurso != null && IDAlumno != "" && IDAlumno!= null)
            {
                UPCNETServiceCursoAlumnoClient proxyCA = new UPCNETServiceCursoAlumnoClient();
                cursoAlumno obj = proxyCA.getCursoAlumnoByID(IDCurso, IDAlumno);
                objCursoAlumno.Delegado = obj.delegado;
                objCursoAlumno.EF = obj.ef;
                objCursoAlumno.EP = obj.ep;
                objCursoAlumno.Inasistencias = obj.inasistencias;
                objCursoAlumno.PC1 = obj.pc1;
                objCursoAlumno.PC2 = obj.pc2;
                objCursoAlumno.Retirado = obj.retirado;
            }

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
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UPCNETSystemCliente.UPCNETServiceCursoAlumno;

namespace UPCNETSystemCliente.ViewModel.Alumno
{
    public class LstCursoViewModel
    {
        public List<Business_Entities.CursoAlumnoReporte> listCursoAlumnoReporte { get; set; }

        public LstCursoViewModel() { }

        public void Fill(string idAlumno)
        {
            UPCNETServiceCursoAlumnoClient proxy = new UPCNETServiceCursoAlumnoClient();
            UPCNETServiceCursoAlumno.cursoAlumnoReporte[] lista = proxy.getCursoAlumnoReporte(idAlumno);
            listCursoAlumnoReporte = new List<Business_Entities.CursoAlumnoReporte>();

            if (lista != null)
            {
                foreach (var item in lista)
                {
                    Business_Entities.CursoAlumnoReporte obj = new Business_Entities.CursoAlumnoReporte();
                    obj.idCurso = item.idCurso;
                    obj.curso = item.curso;
                    obj.profesor = item.profesor;
                    obj.pc1 = item.pc1;
                    obj.pc2 = item.pc2;
                    obj.ep = item.ep;
                    obj.ef = item.ef;

                    listCursoAlumnoReporte.Add(obj);
                }
            }
        }
    }
}
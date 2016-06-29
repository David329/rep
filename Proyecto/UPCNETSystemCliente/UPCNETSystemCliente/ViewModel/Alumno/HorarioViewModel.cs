using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UPCNETSystemCliente.UPCNETServiceCursoClase;

namespace UPCNETSystemCliente.ViewModel.Alumno
{
    public class HorarioViewModel
    {
        public List<Business_Entities.CursoClaseAlumno> lstCursoClaseAlumno { get; set; }

        public HorarioViewModel() { }

        public void Fill(string idAlumno)
        {         
            UPCNETServiceCursoClaseClient proxy = new UPCNETServiceCursoClaseClient();
            UPCNETServiceCursoClase.cursoClaseAlumno[] lista = proxy.getCursoClaseAlumno(idAlumno);

            lstCursoClaseAlumno = new List<Business_Entities.CursoClaseAlumno>();
            if (lista != null)
            {
                foreach (var item in lista)
                {
                    Business_Entities.CursoClaseAlumno obj = new Business_Entities.CursoClaseAlumno();
                    obj.idCurso = item.idCurso;
                    obj.curso = item.curso;
                    obj.profesor = item.profesor;
                    obj.dia = item.dia;
                    obj.horaInicio = item.horaInicial;
                    obj.horaFin = item.horaFinal;

                    lstCursoClaseAlumno.Add(obj);
                }
            }
        }
    }
}
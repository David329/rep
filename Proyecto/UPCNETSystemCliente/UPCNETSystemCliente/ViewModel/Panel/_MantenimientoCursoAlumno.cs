using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UPCNETSystemCliente.ViewModel.Panel
{
    public class _MantenimientoCursoAlumno
    {
        public List<Business_Entities.Curso> ListObjetos { get; set; }

        public void Procesar(UPCNETServiceCursoAlumno.curso[] cursos)
        {
            ListObjetos = new List<Business_Entities.Curso>();
            if (cursos != null)
            {
                foreach (var item in cursos)
                {

                    Business_Entities.Curso objCurso = new Business_Entities.Curso();
                    objCurso.CicloDeCurso = item.cicloDeCurso;
                    objCurso.IDCurso = item.idCurso;
                    objCurso.IDProfesor = item.idProfesor;
                    objCurso.MaxInasistencia = item.maxInasistencia;


                    ListObjetos.Add(objCurso);
                }
            }
        }
    }
}
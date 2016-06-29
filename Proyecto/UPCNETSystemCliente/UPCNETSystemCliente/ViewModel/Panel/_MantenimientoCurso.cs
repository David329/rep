using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UPCNETSystemCliente.UPCNETServiceCursoClase;

namespace UPCNETSystemCliente.ViewModel.Panel
{
    public class _MantenimientoCurso
    {
        public List<Business_Entities.Curso> ListObjetos { get; set; }

        public void Procesar(UPCNETServiceCurso.curso[] cursos)
        {
            ListObjetos = new List<Business_Entities.Curso>();
            if (cursos != null)
            {
                foreach (var item in cursos)
                {
                    Business_Entities.Curso objCurso = new Business_Entities.Curso();
                    objCurso.CicloDeCurso = item.cicloDeCurso;
                    objCurso.IDCurso = item.idCurso;
                    objCurso.Nombre = item.nombre;
                    objCurso.MaxInasistencia = item.maxInasistencia;
                    objCurso.IDProfesor = item.idProfesor;

                    ListObjetos.Add(objCurso);//deberiamos agregar Profesor.Nombre();Si es q lo necesitamos///
                }
            }
        }
    }
}
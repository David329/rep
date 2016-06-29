using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UPCNETSystemCliente.UPCNETServiceProfesor;

namespace UPCNETSystemCliente.ViewModel.Profesor
{
    public class LstCursoViewModel
    {
        public List<Business_Entities.CursoProfesor> lstCurso { get; set; }

        public LstCursoViewModel() { }

        public void Fill(string idProfesor)
        {
            UPCNETServiceProfesorClient proxy = new UPCNETServiceProfesorClient();
            UPCNETServiceProfesor.cursoProfesor[] lista = proxy.getCursoProfesor(idProfesor);
            lstCurso = new List<Business_Entities.CursoProfesor>();

            if (lista != null)
            {
                foreach (var item in lista)
                {
                    Business_Entities.CursoProfesor obj = new Business_Entities.CursoProfesor();
                    obj.IDCurso = item.IDCurso;
                    obj.Nombre = item.nombre;
                    obj.Ciclo = item.cicloDeCurso;

                    lstCurso.Add(obj);
                }
            }
        }
    }
}
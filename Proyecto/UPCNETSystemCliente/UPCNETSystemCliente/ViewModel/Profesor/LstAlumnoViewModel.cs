using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UPCNETSystemCliente.UPCNETServiceProfesor;

namespace UPCNETSystemCliente.ViewModel.Profesor
{
    public class LstAlumnoViewModel
    {
        public List<Business_Entities.AlumnosEnCurso> lstAlumno { get; set; }

        public LstAlumnoViewModel() { }

        public void Fill(string idCurso)
        {
            UPCNETServiceProfesorClient proxy = new UPCNETServiceProfesorClient();
            UPCNETServiceProfesor.alumnosEnCurso[] lista = proxy.getAlumnosEnCurso(idCurso);
            lstAlumno = new List<Business_Entities.AlumnosEnCurso>();
            if (lista != null) 
            {
                foreach (var item in lista)
                {
                    Business_Entities.AlumnosEnCurso obj = new Business_Entities.AlumnosEnCurso();
                    obj.IDAlumno = item.IDAlumno;
                    obj.IDCurso = item.IDCurso;
                    obj.NombreCurso = item.nombrec;
                    obj.NombreAlumno = item.nombrea;
                    obj.Apellido = item.apellido;
                    obj.pc1 = item.pc1;
                    obj.pc2 = item.pc2;
                    obj.ep = item.ep;
                    obj.ef = item.ef;

                    lstAlumno.Add(obj);
                }
            }
        }
    }
}
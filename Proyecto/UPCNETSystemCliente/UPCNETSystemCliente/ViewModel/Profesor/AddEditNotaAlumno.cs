using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UPCNETSystemCliente.UPCNETServiceProfesor;

namespace UPCNETSystemCliente.ViewModel.Profesor
{
    public class AddEditNotaAlumno
    {
        public alumnosEnCurso objAlumnosEnCurso { get; set; }
        public string Evaluacion { get; set; }
        public double Nota { get; set; }
        public AddEditNotaAlumno() { }
        public void Fill()
        {
            if (Evaluacion != "")
            {
                UPCNETServiceProfesorClient proxy = new UPCNETServiceProfesorClient();
                if (Evaluacion == "PC1") objAlumnosEnCurso.pc1 = Nota;
                else if (Evaluacion == "PC2") objAlumnosEnCurso.pc2 = Nota;
                else if (Evaluacion == "EP") objAlumnosEnCurso.ep = Nota;
                else if (Evaluacion == "EF") objAlumnosEnCurso.ef = Nota;
                proxy.setNotaAlumnosEnCurso(objAlumnosEnCurso);
            }
        }
    }
}
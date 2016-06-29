using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UPCNETSystemCliente.UPCNETServiceProfesor;

namespace UPCNETSystemCliente.ViewModel.Profesor
{
    public class HorarioViewModel
    {
        public List<Business_Entities.HorarioProfesor> lstHorario { get; set; }

        public HorarioViewModel() { }

        public void Fill(string idProfesor)
        {
            UPCNETServiceProfesorClient proxy = new UPCNETServiceProfesorClient();
            UPCNETServiceProfesor.horarioProfesor[] lista = proxy.getHorarioProfesor(idProfesor);
            lstHorario = new List<Business_Entities.HorarioProfesor>();
            if (lista != null) 
            {
                foreach (var item in lista)
                {
                    Business_Entities.HorarioProfesor obj = new Business_Entities.HorarioProfesor();
                    obj.IDCurso = item.IDCurso;
                    obj.Nombre = item.nombre;
                    obj.Dia = item.dia;
                    obj.HoraIni = item.horaIni;
                    obj.HoraFin = item.horaFin;
                    lstHorario.Add(obj);
                }
            }
        }
    }
}
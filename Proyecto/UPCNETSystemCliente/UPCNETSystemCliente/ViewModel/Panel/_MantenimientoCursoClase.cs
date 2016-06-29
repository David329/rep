using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UPCNETSystemCliente.ViewModel.Panel
{
    public class _MantenimientoCursoClase
    {
        public List<Business_Entities.CursoClase> ListObjetos { get; set; }

        public void Procesar(UPCNETServiceCursoClase.cursoClase[] cursoclases)
        {
            ListObjetos = new List<Business_Entities.CursoClase>();

            if (cursoclases != null)
            {
                foreach (var item in cursoclases)
                {
                    Business_Entities.CursoClase objCursoClase = new Business_Entities.CursoClase();
                    objCursoClase.Dia = item.dia;
                    objCursoClase.HoraFin = item.horaFin;
                    objCursoClase.HoraIni = item.horaIni;
                    objCursoClase.IDClase = item.idClase;
                    objCursoClase.IDCurso = item.idCurso;

                    ListObjetos.Add(objCursoClase);
                }
            }
        }
    }
}
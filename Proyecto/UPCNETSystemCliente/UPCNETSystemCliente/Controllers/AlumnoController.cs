using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using UPCNETSystemCliente.ViewModel.Alumno;

namespace UPCNETSystemCliente.Controllers
{
    public class AlumnoController : Controller
    {
        public ActionResult Alumno()
        {
            return RedirectToAction("Principal");
        }

        public ActionResult Principal()
        {
            HorarioViewModel objViewModel = new HorarioViewModel();
            objViewModel.Fill(Session["idAlumno"].ToString());
            return View(objViewModel);
        }

        public ActionResult LstCurso()
        {
            LstCursoViewModel objViewModel = new LstCursoViewModel();
            objViewModel.Fill(Session["idAlumno"].ToString());
            return View(objViewModel);
        }
    }
}

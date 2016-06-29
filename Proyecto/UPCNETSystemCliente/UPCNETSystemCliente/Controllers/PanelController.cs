using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using UPCNETSystemCliente.ViewModel.Panel;
using UPCNETSystemCliente.UPCNETServiceAlumno;
using UPCNETSystemCliente.UPCNETServiceApoderado;
using UPCNETSystemCliente.UPCNETServiceProfesor;
using UPCNETSystemCliente.Globalization;
using UPCNETSystemCliente.Helpers;
using UPCNETSystemCliente.UPCNETServiceCurso;
using UPCNETSystemCliente.UPCNETServiceCursoClase;
using UPCNETSystemCliente.UPCNETServiceCursoAlumno;

namespace UPCNETSystemCliente.Controllers
{
    public class PanelController : BaseController
    {

        public ActionResult Administrador()
        {

            return RedirectToAction("MantenimientoUsuarios");
        }
        #region Profesor
        public ActionResult MantenimientoProfesores()
        {
            UPCNETServiceProfesorClient proxy = new UPCNETServiceProfesorClient();
            _MantenimientoProfesores objMantenimientoProfesor = new _MantenimientoProfesores();
            objMantenimientoProfesor.Procesar(proxy.getProfesor());
            return View(objMantenimientoProfesor);
        }
        public ActionResult AddEditProfesor(string IDProfesor, string Modo)
        {
            _AddEditProfesor objAddEditProfesor = new _AddEditProfesor();
            objAddEditProfesor.Fill(IDProfesor, Modo);
            return View(objAddEditProfesor);
        }
        [HttpPost]
        public ActionResult AddEditProfesor(_AddEditProfesor objViewModel)
        {
            try
            {
                UPCNETServiceProfesor.profesor objProfesor = null;
                UPCNETServiceProfesorClient proxy = new UPCNETServiceProfesorClient();
                if (objViewModel.Modo == "Editar")
                {
                    objProfesor = proxy.getProfesorById(objViewModel.IDProfesor);
                    objProfesor.nombre = objViewModel.Nombre;
                    objProfesor.apellido = objViewModel.Apellido;
                    objProfesor.correo = objViewModel.Correo;
                    objProfesor.direccion = objViewModel.Direccion;
                    objProfesor.dni = objViewModel.DNI;
                    objProfesor.idProfesor = objViewModel.IDProfesor;
                    objProfesor.pass = objViewModel.Password;
                    objProfesor.edad = objViewModel.Edad;
                    objProfesor.sueldo = objViewModel.Sueldo;

                    proxy.editProfesor(objProfesor);
                }
                else
                {
                    objProfesor = new UPCNETServiceProfesor.profesor();
                    objProfesor.nombre = objViewModel.Nombre;
                    objProfesor.apellido = objViewModel.Apellido;
                    objProfesor.correo = objViewModel.Correo;
                    objProfesor.direccion = objViewModel.Direccion;
                    objProfesor.dni = objViewModel.DNI;
                    objProfesor.idProfesor = objViewModel.IDProfesor;
                    objProfesor.pass = objViewModel.Password;
                    objProfesor.edad = objViewModel.Edad;
                    objProfesor.sueldo = objViewModel.Sueldo;
                    objProfesor.edadSpecified = true;
                    objProfesor.sueldoSpecified = true;
                    objProfesor.dniSpecified = true;

                    proxy.setProfesor(objProfesor);
                }

                return RedirectToAction("MantenimientoProfesores", "Panel");



            }
            catch (Exception ex)
            {
                return View(objViewModel);
            }
        }
        #endregion
        #region Alumno
        public ActionResult MantenimientoUsuarios()
        {
            UPCNETServiceAlumnoClient proxy = new UPCNETServiceAlumnoClient();
            _MantenimientoUsuarios objMantenimientoUsuarios = new _MantenimientoUsuarios();
            objMantenimientoUsuarios.Procesar(proxy.getAlumnos());
            return View(objMantenimientoUsuarios);
        }
        public ActionResult AddEditUsuario(string IDAlumno, string Modo)
        {
            _AddEditUsuario objAddEditUsuario = new _AddEditUsuario();
            objAddEditUsuario.Fill(IDAlumno, Modo);
            return View(objAddEditUsuario);
        }
        [HttpPost]
        public ActionResult AddEditUsuario(_AddEditUsuario objViewModel)
        {
            try
            {
                UPCNETServiceAlumno.alumno objAlumno = new UPCNETServiceAlumno.alumno();
                apoderado objApoderado = new apoderado();
                UPCNETServiceAlumnoClient proxyAL = new UPCNETServiceAlumnoClient();
                UPCNETServiceApoderadoClient proxyAP = new UPCNETServiceApoderadoClient();
                if (objViewModel.Modo == "Editar")
                {
                    objAlumno = proxyAL.getAlumnoById(objViewModel.IDAlumno);
                    objApoderado = proxyAP.getApoderadoById(objAlumno.idApoderado);

                    proxyAL.editAlumno(objAlumno);
                    proxyAP.editApoderado(objApoderado);
                }
                else
                {
                    //APODERADO =>PRIMERO XQ ES FK HACIA ALUMNO 
                    objApoderado.IDApoderado = objViewModel.objApoderado.IDApoderado;
                    objApoderado.apellido = objViewModel.objApoderado.Apellido;
                    objApoderado.condicion = objViewModel.objApoderado.Condicion;
                    objApoderado.correo = objViewModel.objApoderado.Correo;
                    objApoderado.direccion = objViewModel.objApoderado.Direccion;
                    objApoderado.DNI = objViewModel.objApoderado.DNI;
                    objApoderado.edad = objViewModel.objApoderado.Edad;
                    objApoderado.nombre = objViewModel.objApoderado.Nombre;
                    objApoderado.pass = objViewModel.objApoderado.Pass;

                    proxyAP.setApoderado(objApoderado);//DEBE EXISTIR PRIMERO SINO Objalumno.idpaoderado daria error
                    //Alumno
                    objAlumno.idCategoria = objViewModel.IDCategoria;
                    objAlumno.nombre = objViewModel.Nombre;
                    objAlumno.apellido = objViewModel.Apellido;
                    objAlumno.correo = objViewModel.Correo;
                    objAlumno.direccion = objViewModel.Direccion;
                    objAlumno.dni = objViewModel.DNI;
                    objAlumno.idAlumno = objViewModel.IDAlumno;
                    objAlumno.pass = objViewModel.Password;
                    objAlumno.edad = objViewModel.Edad;
                    objAlumno.dniSpecified = true;
                    objAlumno.edadSpecified = true;
                    objAlumno.idApoderado = objViewModel.objApoderado.IDApoderado;

                    ///ADD
                    proxyAL.setAlumno(objAlumno);
                }
                return RedirectToAction("MantenimientoUsuarios", "Panel");
            }
            catch (Exception ex)
            {
                return View(objViewModel);
            }
        }
        #endregion

        #region Apoderado
        public ActionResult MantenimientoApoderado()
        {
            UPCNETServiceApoderadoClient proxy = new UPCNETServiceApoderadoClient();
            _MantenimientoApoderado objMantenimientoApoderado = new _MantenimientoApoderado();
            objMantenimientoApoderado.Procesar(proxy.getApoderado());
            return View(objMantenimientoApoderado);
        }
        #endregion
        #region Curso
        public ActionResult MantenimientoCursos()
        {
            UPCNETServiceCursoClient proxy = new UPCNETServiceCursoClient();
            _MantenimientoCurso objMantenimientoCursos= new _MantenimientoCurso();
            objMantenimientoCursos.Procesar(proxy.getCursos());
            return View("MantenimientoCurso",objMantenimientoCursos);
        }

        public ActionResult AddEditCurso(string IDCurso, string Modo)
        {
            _AddEditCurso objAddEditCurso= new _AddEditCurso();
            objAddEditCurso.Fill(IDCurso, Modo);
            return View("AddEditCurso",objAddEditCurso);
        }

        [HttpPost]
        public ActionResult AddEditCurso(_AddEditCurso objViewModel)
        {
            try
            {
                UPCNETServiceCurso.curso objCurso= new UPCNETServiceCurso.curso();
                UPCNETServiceCursoClient proxyCU = new UPCNETServiceCursoClient();
                if (objViewModel.Modo == "Editar")
                {
                    objCurso.cicloDeCurso = objViewModel.objCurso.CicloDeCurso;
                    objCurso.idCurso = objViewModel.objCurso.IDCurso;
                    objCurso.nombre = objViewModel.objCurso.Nombre;
                    objCurso.idProfesor = objViewModel.objCurso.IDProfesor;
                    objCurso.maxInasistencia = objViewModel.objCurso.MaxInasistencia;
                    proxyCU.editCurso(objCurso);
                }
                else
                {
                    //Curso
                    objCurso.cicloDeCurso = objViewModel.objCurso.CicloDeCurso;
                    objCurso.idCurso = objViewModel.objCurso.IDCurso;
                    objCurso.nombre = objViewModel.objCurso.Nombre;
                    objCurso.idProfesor = objViewModel.objCurso.IDProfesor;
                    objCurso.maxInasistencia = objViewModel.objCurso.MaxInasistencia;
                    
                    ///ADD
                    proxyCU.setCurso(objCurso);
                }
                return RedirectToAction("MantenimientoCursos", "Panel");
            }
            catch (Exception ex)
            {
                return View(objViewModel);
            }
        }
        #endregion
        #region CursoClase
        public ActionResult MantenimientoCursoClase(string IDCurso)
        {
            UPCNETServiceCursoClaseClient proxy = new UPCNETServiceCursoClaseClient();
            _MantenimientoCursoClase objMantenimientoCursoClase = new _MantenimientoCursoClase();
            objMantenimientoCursoClase.Procesar(proxy.getCursoClaseByIdCurso(IDCurso));
            if(objMantenimientoCursoClase.ListObjetos==null)objMantenimientoCursoClase.ListObjetos = new List<Business_Entities.CursoClase>();
            return View(objMantenimientoCursoClase);
        }
        public ActionResult AddEditCursoClase(string IDCurso,string IDClase, string Modo)
        {
            _AddEditCursoClase objAddEditCursoClase = new _AddEditCursoClase();
            objAddEditCursoClase.Fill(IDCurso,IDClase, Modo);
            return View("AddEditCursoClase", objAddEditCursoClase);
        }
        [HttpPost]
        public ActionResult AddEditCursoClase(_AddEditCursoClase objViewModel)
        {
            try
            {
                var HoraI = Request.Form["HoraInicio"].ToString();
                var HoraF = Request.Form["HoraFin"].ToString();
                UPCNETServiceCursoClase.cursoClase objCursoclase = new cursoClase();
                UPCNETServiceCursoClaseClient proxyCC = new UPCNETServiceCursoClaseClient();
                if (objViewModel.Modo == "Editar")
                {
                    objCursoclase = proxyCC.getCursoClaseByID(objViewModel.IDCurso,objViewModel.IDClase);
                    proxyCC.editCursoClase(objCursoclase);
                }
                else
                {
                    //Curso
                    objCursoclase.dia = objViewModel.objCursoClase.Dia;
                    objCursoclase.horaFin = HoraF;
                    objCursoclase.horaIni = HoraI;
                    objCursoclase.idClase = objViewModel.objCursoClase.IDClase;
                    objCursoclase.idCurso = objViewModel.objCursoClase.IDCurso;

                    ///ADD
                    proxyCC.setCursoClase(objCursoclase);
                }
                return RedirectToAction("MantenimientoCursos", "Panel");
            }
            catch (Exception ex)
            {
                return View(objViewModel);
            }
        }
        #endregion

        #region CursoAlumno
        public ActionResult MantenimientoCursoAlumnos(string IDAlumno)
        {
            UPCNETServiceCursoAlumnoClient proxy = new UPCNETServiceCursoAlumnoClient();
            _MantenimientoCursoAlumno objMantenimientoCursoAlumno= new _MantenimientoCursoAlumno();
           
            objMantenimientoCursoAlumno.Procesar(proxy.getCursoByIdAlumno(IDAlumno));
            return View("MantenimientoCursoAlumno", objMantenimientoCursoAlumno);
        }
        public ActionResult AddEditCursoAlumno(string IDCurso, string IDAlumno, string Modo)
        {
            _AddEditCursoAlumno objAddEditCursoAlumno= new _AddEditCursoAlumno();
            objAddEditCursoAlumno.Fill(IDCurso, IDAlumno, Modo);
            return View("AddEditCursoAlumno", objAddEditCursoAlumno);
        }
        [HttpPost]
        public ActionResult AddEditCursoAlumno(_AddEditCursoAlumno objViewModel)
        {
            try
            {
                UPCNETServiceCursoAlumno.cursoAlumno objCursoalumno= new cursoAlumno();
                UPCNETServiceCursoAlumnoClient proxyCA = new UPCNETServiceCursoAlumnoClient();
                if (objViewModel.Modo == "Editar")
                {
                    objCursoalumno = proxyCA.getCursoAlumnoByID(objViewModel.IDCurso, objViewModel.IDAlumno);
                    proxyCA.editCursoAlumno(objCursoalumno);
                }
                else
                {
                    //Curso
                    objCursoalumno.delegado = objViewModel.objCursoAlumno.Delegado;
                    objCursoalumno.ef = objViewModel.objCursoAlumno.EF;
                    objCursoalumno.ep = objViewModel.objCursoAlumno.EP;
                    objCursoalumno.inasistencias = objViewModel.objCursoAlumno.Inasistencias;
                    objCursoalumno.pc1 = objViewModel.objCursoAlumno.PC1;
                    objCursoalumno.pc2 = objViewModel.objCursoAlumno.PC2;
                    objCursoalumno.retirado = objViewModel.objCursoAlumno.Retirado;
                    objCursoalumno.idAlumno = objViewModel.objCursoAlumno.IDAlumno;
                    objCursoalumno.idCurso = objViewModel.objCursoAlumno.IDCurso;

                    ///ADD
                    proxyCA.setCursoAlumno(objCursoalumno);
                }
                return RedirectToAction("MantenimientoUsuarios", "Panel");
            }
            catch (Exception ex)
            {
                return View(objViewModel);
            }
        }
        #endregion

        #region xxx
        public ActionResult AddEditApoderado(string IDApoderado, string Modo)
        {
            _AddEditApoderado objAddEditApoderado = new _AddEditApoderado();
            objAddEditApoderado.Fill(IDApoderado, Modo);
            return View(objAddEditApoderado);
        }
        [HttpPost]
        public ActionResult AddEditApoderado(_AddEditApoderado objViewModel)
        {
            try
            {
                UPCNETServiceApoderado.apoderado objApoderado = null;
                UPCNETServiceApoderadoClient proxy = new UPCNETServiceApoderadoClient();
                if (objViewModel.Modo == "Editar")
                {
                    objApoderado = proxy.getApoderadoById(objViewModel.IDApoderado);
                    objApoderado.nombre = objViewModel.Nombre;
                    objApoderado.apellido = objViewModel.Apellido;
                    objApoderado.correo = objViewModel.Correo;
                    objApoderado.direccion = objViewModel.Direccion;
                    objApoderado.DNI = objViewModel.DNI;
                    objApoderado.IDApoderado = objViewModel.IDApoderado;
                    objApoderado.pass = objViewModel.Password;
                    objApoderado.edad = objViewModel.Edad;
                    objApoderado.condicion = objViewModel.Condicion;

                    proxy.editApoderado(objApoderado);
                }
                else
                {
                    objApoderado = new UPCNETServiceApoderado.apoderado();
                    objApoderado.nombre = objViewModel.Nombre;
                    objApoderado.apellido = objViewModel.Apellido;
                    objApoderado.correo = objViewModel.Correo;
                    objApoderado.direccion = objViewModel.Direccion;
                    objApoderado.DNI = objViewModel.DNI;
                    objApoderado.IDApoderado = objViewModel.IDApoderado;
                    objApoderado.pass = objViewModel.Password;
                    objApoderado.edad = objViewModel.Edad;
                    objApoderado.condicion = objViewModel.Condicion;

                    proxy.setApoderado(objApoderado);
                }
                return RedirectToAction("MantenimientoApoderado", "Panel");
            }
            catch (Exception ex)
            {
                return View(objViewModel);
            }
        }
        #endregion
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using NUnit.Framework;

namespace UPCNETUnitTesting.ViewModel
{
    [TestFixture]
    class ViewModelTesting
    {
        public const string username = "username";
        public const string password = "password";
        public const string alumnoId = "alumno";
        public const string profesorId = "profesor";
        public const string cursoId = "curso";
        public const string nombre = "nombre";
        public const string apellido = "apellido";
        public const string correo = "apoderado@correo.com";
        public const string modo = "modo";
        public const string condicion = "condicion";
        public const string apoderadoId = "AP101";
        public const string direccion = "direccion";
        public const string idapoderado = "AP101";
        public const int edad = 33;
        public const int cicloDeCurso = 1;
        public const int maxInasistencia = 10;
        public const int dni = 12345678;

        private UPCNETSystemCliente.ViewModel.Alumno.HorarioViewModel objHorarioViewModelAlumno;
        private UPCNETSystemCliente.ViewModel.Alumno.LstCursoViewModel objLstCursoViewModelAlumno;
        private UPCNETSystemCliente.ViewModel.Login._LoginViewModel objLoginViewModelLogin;
        private UPCNETSystemCliente.ViewModel.Profesor.HorarioViewModel objHorarioViewModelProfesor;
        private UPCNETSystemCliente.ViewModel.Profesor.LstAlumnoViewModel objLstAlumnoViewModelProfesor;
        private UPCNETSystemCliente.ViewModel.Profesor.LstCursoViewModel objLstCursoViewModelProfesor;
        private UPCNETSystemCliente.ViewModel.Panel._AddEditApoderado objAddEditApoderado;
        private UPCNETSystemCliente.ViewModel.Panel._MantenimientoApoderado objMantenimientoApoderado;
        private UPCNETSystemCliente.ViewModel.Panel._MantenimientoCurso objMantenimientoCurso;

        [SetUp]
        public void Initialize()
        {
            objHorarioViewModelAlumno = new UPCNETSystemCliente.ViewModel.Alumno.HorarioViewModel();
            objLstCursoViewModelAlumno = new UPCNETSystemCliente.ViewModel.Alumno.LstCursoViewModel();
            objLoginViewModelLogin = new UPCNETSystemCliente.ViewModel.Login._LoginViewModel();
            objHorarioViewModelProfesor = new UPCNETSystemCliente.ViewModel.Profesor.HorarioViewModel();
            objLstAlumnoViewModelProfesor = new UPCNETSystemCliente.ViewModel.Profesor.LstAlumnoViewModel();
            objLstCursoViewModelProfesor = new UPCNETSystemCliente.ViewModel.Profesor.LstCursoViewModel();
            objAddEditApoderado = new UPCNETSystemCliente.ViewModel.Panel._AddEditApoderado();
            objMantenimientoApoderado = new UPCNETSystemCliente.ViewModel.Panel._MantenimientoApoderado();
            objMantenimientoCurso = new UPCNETSystemCliente.ViewModel.Panel._MantenimientoCurso();
        }

        [TestCase(cicloDeCurso, cursoId, nombre, maxInasistencia, profesorId)]
        public void Curso_MantenimientoCurso_GetSet(int cicloDeCurso, string cursoId, string nombre, int maxInasistencia, string profesorId)
        {
            List<UPCNETSystemCliente.Business_Entities.Curso> lstObjetos = new List<UPCNETSystemCliente.Business_Entities.Curso>();
            UPCNETSystemCliente.Business_Entities.Curso objCurso = new UPCNETSystemCliente.Business_Entities.Curso();
            objCurso.CicloDeCurso = cicloDeCurso;
            objCurso.IDCurso = cursoId;
            objCurso.Nombre = nombre;
            objCurso.MaxInasistencia = maxInasistencia;
            objCurso.IDProfesor = profesorId;
            lstObjetos.Add(objCurso);
            objMantenimientoCurso.ListObjetos = lstObjetos;
            Assert.AreEqual(objMantenimientoCurso.ListObjetos, lstObjetos);
        }

        [TestCase(nombre,apellido,correo,password,apoderadoId,edad,direccion,dni,condicion)]
        public void Apoderado_MantenimientoApoderado_GetSet(string nombre, string apellido, string correo, string pasword, string apoderadoId, int edad, string direccion, int dni, string condicion)
        {
            List<UPCNETSystemCliente.ViewModel.Panel.Apoderado> lstObjetos = new List<UPCNETSystemCliente.ViewModel.Panel.Apoderado>();
            UPCNETSystemCliente.ViewModel.Panel.Apoderado objApoderado =  new UPCNETSystemCliente.ViewModel.Panel.Apoderado();
            objApoderado.Nombre = nombre;
            objApoderado.Apellido = apellido;
            objApoderado.Correo = correo;
            objApoderado.Password = pasword;
            objApoderado.IDApoderado = apoderadoId;
            objApoderado.Edad = edad;
            objApoderado.Direccion = direccion;
            objApoderado.DNI = dni;
            objApoderado.Condicion = condicion;
            lstObjetos.Add(objApoderado);
            objMantenimientoApoderado.ListObjetos = lstObjetos;
            Assert.AreEqual(objMantenimientoApoderado.ListObjetos.Count, 1);
        }

        [TestCase(apoderadoId,modo)]
        public void Apoderado_AddEditApoderado_Fill(string apoderadoId, string modo)
        {
            objAddEditApoderado.Fill(apoderadoId, modo);
            Assert.AreEqual(objAddEditApoderado.IDApoderado, idapoderado);
        }

        [TestCase(nombre,apellido,correo,dni,direccion,idapoderado,edad,modo,condicion)]
        public void Apoderado_AddEditApoderado_GetSet(String Nombre, String Apellido, String Correo, int DNI, String Direccion, String Password, int Edad, String Modo, String Condicion)
        {
            objAddEditApoderado.Nombre = Nombre;
            objAddEditApoderado.Apellido = Apellido;
            objAddEditApoderado.Correo = Correo;
            objAddEditApoderado.DNI = DNI;
            objAddEditApoderado.Direccion = Direccion;
            objAddEditApoderado.IDApoderado = idapoderado;
            objAddEditApoderado.Edad = Edad;
            objAddEditApoderado.Modo = Modo;
            objAddEditApoderado.Condicion = Condicion;
            Assert.AreEqual(objAddEditApoderado.Nombre, Nombre);
            Assert.AreEqual(objAddEditApoderado.Apellido, Apellido);
            Assert.AreEqual(objAddEditApoderado.Correo, Correo);
            Assert.AreEqual(objAddEditApoderado.DNI, DNI);
            Assert.AreEqual(objAddEditApoderado.Direccion, Direccion);
            Assert.AreEqual(objAddEditApoderado.IDApoderado, idapoderado);
            Assert.AreEqual(objAddEditApoderado.Edad, Edad);
            Assert.AreEqual(objAddEditApoderado.Modo, Modo);
            Assert.AreEqual(objAddEditApoderado.Condicion, Condicion);
        }


        [TestCase(username, password)]
        public void Login_LoginViewModel_GetSet(string Username, string Password) {
            objLoginViewModelLogin.UsuarioCodigo = Username;
            objLoginViewModelLogin.UsuarioPassword = Password;
            Assert.AreEqual(Username, objLoginViewModelLogin.UsuarioCodigo);
            Assert.AreEqual(Password, objLoginViewModelLogin.UsuarioPassword);
        }

        [TestCase(alumnoId)]
        public void Alumno_HorarioViewModel_Fill(string alumnoId) {
            Assert.Null(objHorarioViewModelAlumno.lstCursoClaseAlumno);
            objHorarioViewModelAlumno.Fill(alumnoId);
            Assert.NotNull(objHorarioViewModelAlumno.lstCursoClaseAlumno);
        }

        [TestCase(alumnoId)]
        public void Alumno_LstCursoViewModel_Fill(string alumnoId) {
            Assert.Null(objLstCursoViewModelAlumno.listCursoAlumnoReporte);
            objLstCursoViewModelAlumno.Fill(alumnoId);
            Assert.NotNull(objLstCursoViewModelAlumno.listCursoAlumnoReporte);
        }

        [TestCase(profesorId)]
        public void Profesor_HorarioViewModel_Fill(string profesorId)
        {
            Assert.Null(objHorarioViewModelProfesor.lstHorario);
            objHorarioViewModelProfesor.Fill(profesorId);
            Assert.NotNull(objHorarioViewModelProfesor.lstHorario);
        }

        [TestCase(cursoId)]
        public void Profesor_LstAlumnoViewModel_Fill(string cursoId)
        {
            Assert.Null(objLstAlumnoViewModelProfesor.lstAlumno);
            objLstAlumnoViewModelProfesor.Fill(cursoId);
            Assert.NotNull(objLstAlumnoViewModelProfesor.lstAlumno);
        }

        [TestCase(profesorId)]
        public void Profesor_LstCursoViewModel_Fill(string profesorId)
        {
            Assert.Null(objLstCursoViewModelProfesor.lstCurso);
            objLstCursoViewModelProfesor.Fill(cursoId);
            Assert.NotNull(objLstCursoViewModelProfesor.lstCurso);
        }

        

    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using UPCNETSystemCliente.Globalization;

namespace UPCNETSystemCliente.ViewModel.Login
{
    public class _LoginViewModel
    {
        [Required(ErrorMessageResourceName = "CampoUsuario", ErrorMessageResourceType = typeof(ValidationString))]
        public string UsuarioCodigo { get; set; }
        [Required(ErrorMessageResourceName = "CampoPassword", ErrorMessageResourceType = typeof(ValidationString))]
        public string UsuarioPassword { get; set; }
    }
}
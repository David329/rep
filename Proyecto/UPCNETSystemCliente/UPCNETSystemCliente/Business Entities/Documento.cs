using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UPCNETSystemCliente.Business_Entities
{
    public class Documento
    {
        private String IdDocumento;
        private String IdCurso;
        private String NomDocumento;
        private String DocumentoFis;

        public Documento(string idDocumento, string idCurso, string nomDocumento, string documentoFis)
        {
            IdDocumento = idDocumento;
            IdCurso = idCurso;
            NomDocumento = nomDocumento;
            DocumentoFis = documentoFis;
        }

        public String getIdDocumento() { return IdDocumento; }
        public String getIdCurso() { return IdCurso; }
        public String getNomDocumento() { return NomDocumento; }
        public String getDocumentoFis() { return DocumentoFis; }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.web.dr.processor;

import javax.servlet.ServletOutputStream;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;

/**
 *
 * @author attia
 */
public class PDFDRProcessor extends DRProcessor{

    public PDFDRProcessor() {
        super("PDF", "pdf", "fa fa-file-pdf-o text-red");
    }
    
    

    @Override
    public void doExport(ServletOutputStream stream) throws JRException{
        JasperExportManager.exportReportToPdfStream(this.jasperPrint, stream);
    }
    
}

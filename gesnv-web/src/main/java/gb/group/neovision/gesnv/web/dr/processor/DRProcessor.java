/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.web.dr.processor;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author attia
 */
public abstract class DRProcessor implements Serializable{
    
    protected static final String EXPORT_FILE_NAME = "report";
    
    protected static final String JASPER_FILES_DIRECTORY = "/jasper/reports/";
    
    protected String jasperFile;
    
    protected JasperPrint jasperPrint;
    
    protected Map params;
    
    protected final String exportFormatLabel;
    
    protected final String exportFormatExtension;
    
    protected final String exportFormatClass;
    
    protected List<?> data;

    public DRProcessor(String exportFormatLabel, String exportFormatExtension, String exsportFormatIcon) {
        this.exportFormatLabel = exportFormatLabel;
        this.exportFormatExtension = exportFormatExtension;
        this.exportFormatClass = exsportFormatIcon;
        this.data = Collections.EMPTY_LIST;
        this.params = new HashMap();
                               
    }
    
    public void init() throws JRException{
        JRBeanCollectionDataSource dataSource =  new JRBeanCollectionDataSource(this.data);
        InputStream reportStream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(JASPER_FILES_DIRECTORY + this.jasperFile);
        System.out.println("---> " + reportStream);
        this.jasperPrint = JasperFillManager.fillReport(reportStream, this.params, dataSource);
    }
    
    public void  export() throws JRException, IOException {
        init();
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + this.getExportFileName());
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        this.doExport(servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    public abstract void doExport(ServletOutputStream stream) throws JRException;
    
    protected String getExportFileName(){
        return EXPORT_FILE_NAME +"."+ this.exportFormatExtension;
    }

    public String getExportFormatLabel() {
        return exportFormatLabel;
    }

    public String getExportFormatClass() {
        return exportFormatClass;
    }
    
    public String getJasperFile() {
        return jasperFile;
    }

    public void setJasperFile(String jasperFile) {
        this.jasperFile = jasperFile;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
    
    
}

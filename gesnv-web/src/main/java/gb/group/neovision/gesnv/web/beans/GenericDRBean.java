/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.web.beans;

import gb.group.neovision.gesnv.web.dr.processor.DRProcessor;
import gb.group.neovision.gesnv.web.dr.processor.PDFDRProcessor;
import gb.group.neovision.gesnv.web.dr.processor.XlsxDRProcessor;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author attia
 */
public abstract class GenericDRBean implements Serializable{
    
    protected List<DRProcessor> processors;
    

    public GenericDRBean() {
    }
    
    public void init(){
     this.populateProcessors();
    }
    
    public void export(DRProcessor processor) throws JRException, IOException{
       processor.setData(Collections.EMPTY_LIST);
       processor.setParams(this.getReportParameters());
       processor.export();
    }
    
    
    protected void populateProcessors(){
        this.processors= new ArrayList<>();
        this.processors.add(new PDFDRProcessor());
        this.processors.add(new XlsxDRProcessor());
        System.out.println("populateProcessors() -> " + this.processors);
    }
    
    public Map getReportParameters() {
        return new HashMap();
    }

    public List<DRProcessor> getProcessors() {
        System.out.println("getProcessors() -> " + this.processors);
        return processors;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gb.group.neovision.gesnv.web.dr;

import java.io.Serializable;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;

/**
 *
 * @author attia
 */
public abstract class AbstractGesnvDRDesign implements Serializable{
    
    public void init(JasperReportBuilder builder){
        this.pageFormat(builder);
    }
    
    public ComponentBuilder<?,?> headerComponent(){
        return cmp.horizontalList(cmp.image(getClass().getResourceAsStream("../images/logo.png"))
                        .setFixedDimension(60,60),
        
               cmp.verticalList(
                    cmp.text("Gabon-Libreville")
                        .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER),
                    cmp.text("GROUP-NEOVISION")
                        .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER),
                    cmp.text(ReportTitleLabel())
                        .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER))
                
                
                       ).newRow().add(cmp.line()).newRow(4);
        
    }
    
    public abstract String  ReportTitleLabel();
    
    public void pageFormat(JasperReportBuilder builder){
        builder.setPageFormat(PageType.A4, PageOrientation.PORTRAIT);
    }
    
    
}

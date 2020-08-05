package com.amyliascarlet.demo.FreeMarker.service;

import com.amyliascarlet.demo.FreeMarker.constants.Constants;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

@Service
public class FreeMarkerService {

    Configuration configuration=new Configuration();

    public void genTemplate(String tname, Map params) {
        try {
            configuration.setDirectoryForTemplateLoading(new File(Constants.tplPath));
            Template template = configuration.getTemplate(tname+".ftl");
            Writer out =new FileWriter(new File(Constants.outPath+tname+".html"));
            template.process(params, out);
            out.close();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}

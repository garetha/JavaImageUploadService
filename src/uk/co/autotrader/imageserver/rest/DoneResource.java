package uk.co.autotrader.imageserver.rest;

import org.restlet.data.LocalReference;
import org.restlet.data.MediaType;
import org.restlet.ext.freemarker.TemplateRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.HashMap;
import java.util.Map;

public class DoneResource extends ServerResource {

    @Get
    public Representation represent() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("file", "/resources/upload.png");
        Representation response = new ClientResource(LocalReference.createClapReference(getClass().getPackage()) + "/done.ftl").get();
        return new TemplateRepresentation(response, model, MediaType.TEXT_HTML);
    }
}

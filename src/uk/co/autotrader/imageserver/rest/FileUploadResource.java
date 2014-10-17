package uk.co.autotrader.imageserver.rest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.restlet.data.LocalReference;
import org.restlet.data.MediaType;
import org.restlet.ext.fileupload.RestletFileUpload;
import org.restlet.ext.freemarker.TemplateRepresentation;
import org.restlet.representation.EmptyRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FileUploadResource extends ServerResource {

    @Get
    public Representation represent() {
        Representation response = new ClientResource(LocalReference.createClapReference(getClass().getPackage()) + "/form.ftl").get();
        return new TemplateRepresentation(response,  MediaType.TEXT_HTML);
    }

    @Put
    public EmptyRepresentation  store(Representation input) throws Exception {
        RestletFileUpload fileUpload = new RestletFileUpload(new DiskFileItemFactory());
        List<FileItem> items = fileUpload.parseRepresentation(input);
        for(FileItem item : items) {
            if(!item.isFormField()) {
                saveImage(item.getInputStream());
            }
        }

        return new EmptyRepresentation();
    }

    private void saveImage(InputStream inputStream) {
        try {
            BufferedImage bi = ImageIO.read(inputStream);
            File outputfile = new File("/Users/gaz/Public/upload.png");
            ImageIO.write(bi, "png", outputfile);
        } catch (IOException e) {
        }
    }
}

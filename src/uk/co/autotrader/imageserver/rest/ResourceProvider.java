package uk.co.autotrader.imageserver.rest;

import org.restlet.data.MediaType;
import org.restlet.representation.ByteArrayRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ResourceProvider extends ServerResource {

    @Get
    public ByteArrayRepresentation getImage() throws IOException {
        File file = new File("/Users/gaz/Public/upload.png");
        BufferedImage bi = ImageIO.read(file);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "png", baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();

        return new ByteArrayRepresentation(imageInByte , MediaType.IMAGE_PNG);
    }
}

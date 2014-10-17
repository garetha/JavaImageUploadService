package uk.co.autotrader.imageserver.rest;

import org.restlet.data.MediaType;
import org.restlet.representation.OutputRepresentation;

import java.io.IOException;
import java.io.OutputStream;

public class DynamicFileRepresentation extends OutputRepresentation {

    private byte[] fileData;

    public DynamicFileRepresentation(MediaType mediaType, long expectedSize, byte[] fileData) {
        super(mediaType, expectedSize);
        this.fileData = fileData;
    }

    @Override
    public void write(OutputStream outputStream) throws IOException {
        outputStream.write(fileData);
    }
}

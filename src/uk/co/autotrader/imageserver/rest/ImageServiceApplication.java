package uk.co.autotrader.imageserver.rest;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class ImageServiceApplication extends Application {

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/upload", FileUploadResource.class);
        router.attach("/done", DoneResource.class);
        router.attach("/resources/{filename}", ResourceProvider.class);

        return router;
    }
}

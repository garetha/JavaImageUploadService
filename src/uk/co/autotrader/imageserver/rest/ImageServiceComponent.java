package uk.co.autotrader.imageserver.rest;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class ImageServiceComponent extends Component {

    public static void main(String... args) throws Exception {
        new ImageServiceComponent().start();
    }

    public ImageServiceComponent() {
        getServers().add(Protocol.HTTP, 6081);
        getClients().add(Protocol.CLAP);
        getClients().add(Protocol.FILE);
        getDefaultHost().attachDefault(new ImageServiceApplication());
    }
}

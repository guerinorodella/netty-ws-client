package com.gear.dev.nett.ws.client.app;

import com.gear.dev.nett.ws.client.core.ClientLoaderService;
import com.gear.dev.nett.ws.client.core.WSClientManager;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * @author guerinorodella
 */
@Component
public class AppStarter {

    private static final String DEFAULT_CONNECTION_URL = "wss://echo.websocket.org";

    private final ClientLoaderService clientLoaderService;
    private final WSClientManager clientManager;

    @Inject
    public AppStarter(ClientLoaderService clientLoaderService,
                      WSClientManager clientManager) {
        this.clientLoaderService = clientLoaderService;
        this.clientManager = clientManager;
    }

    public void start() {
        System.out.println("[NETTY-WS-Client] - Aplicação iniciada");

        var clientDataList = clientLoaderService.loadAll(DEFAULT_CONNECTION_URL);
        System.out.println("[NETTY-WS-Client] - Foram encontrados [" + clientDataList.size() + "] clientes");
        clientManager.start(clientDataList);
    }
}

package net.donationstore.commands;

import java.net.http.HttpClient;
import java.util.ArrayList;

public abstract class AbstractCommand implements Command {

    private String secretKey;

    private String webstoreAPILocation;

    private HttpClient httpClient;

    private ArrayList<String> logs;

    public AbstractCommand() {
        logs = new ArrayList<>();
        httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
    }

    public abstract String getSupportedCommand();

    public abstract Command validate(String[] args);

    public abstract CommandType commandType();

    public abstract ArrayList<String> runCommand() throws Exception;

    public abstract String helpInfo();

    public String getInvalidCommandMessage() {
        return "Invalid usage of command. Help Info: ";
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getWebstoreAPILocation() {
        return webstoreAPILocation;
    }

    public void setWebstoreAPILocation(String webstoreAPILocation) {
        this.webstoreAPILocation = webstoreAPILocation;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public ArrayList<String> getLogs() {
        return logs;
    }
}

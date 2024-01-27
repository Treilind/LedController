package at.edu.c02.ledcontroller;

import org.json.JSONObject;

import java.io.IOException;

public interface ApiService {
    JSONObject communicateGET(String link) throws IOException;
    void communicatePUT(String link, String change, String changeTo) throws IOException;

    String setURL (String method);
    String setURL (String method, int id);
}

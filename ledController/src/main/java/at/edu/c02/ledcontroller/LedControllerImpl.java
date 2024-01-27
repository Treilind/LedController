package at.edu.c02.ledcontroller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the actual logic
 */
public class LedControllerImpl implements LedController {
    private final ApiService apiService;

    public LedControllerImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void demo() throws IOException {
        // Call `getLights`, the response is a json object in the form `{ "lights": [ { ... }, { ... } ] }`
        JSONObject response = apiService.communicate(apiService.setURL("getLights"));
        // get the "lights" array from the response
        JSONArray lights = response.getJSONArray("lights");
        // read the first json object of the lights array
        JSONObject firstLight = lights.getJSONObject(0);
        // read int and string properties of the light
        System.out.println("First light id is: " + firstLight.getInt("id"));
        System.out.println("First light color is: " + firstLight.getString("color"));
    }

    @Override
    public void getLights() throws IOException {
        JSONObject response = apiService.communicate(apiService.setURL("getLights"));
        JSONArray lights = response.getJSONArray("lights");
        for (int i = 0; i < lights.length(); i++) {
            System.out.println(lights.get(i).toString());

        }
    }

    @Override
    public void getLight(int id) throws IOException {
        JSONObject response = apiService.communicate(apiService.setURL("getLight", id));
        JSONArray lights = response.getJSONArray("lights");
        for (int i = 0; i < lights.length(); i++) {
            System.out.println(lights.get(i).toString());
        }
    }

    public String[] getGroupLeds() throws IOException {

        JSONObject response = apiService.communicate("getGroupLeds");
        JSONArray lights = response.getJSONArray("lights");
        String[] result = new String[lights.length()];
        for (int i = 0; i < result.length - 1; i++) {
            String group = lights.getJSONObject(i).getString("name");
            if (group.equals("F")) {
                result[i] = lights.getJSONObject(i).getString("status");

            }
        }
        return result;

    }

    @Override
    public void turnOffAllLeds() throws IOException {
        String[] groupLeds = getGroupLeds();
        for (int i = 1; i < groupLeds.length - 1; i++) {
            apiService.communicatePUT(apiService.setURL("setLight",i), "on", "false");
        }

    }
}

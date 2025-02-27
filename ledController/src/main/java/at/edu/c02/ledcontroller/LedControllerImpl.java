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
        JSONObject response = apiService.communicateGET(apiService.setURL("getLights"));
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
        JSONObject response = apiService.communicateGET(apiService.setURL("getLights"));
        JSONArray lights = response.getJSONArray("lights");
        for (int i = 0; i < lights.length(); i++) {
            System.out.println(lights.get(i).toString());

        }
    }

    @Override
    public void getLight(int id) throws IOException {
        JSONObject response = apiService.communicateGET(apiService.setURL("getLight", id));
        JSONArray lights = response.getJSONArray("lights");
        for (int i = 0; i < lights.length(); i++) {
            System.out.println(lights.get(i).toString());
        }
    }

    public String[] getGroupLeds() throws IOException {

        JSONObject response = apiService.communicateGET(apiService.setURL("getLights"));
        JSONArray lights = response.getJSONArray("lights");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < lights.length(); i++) {
            JSONObject groupByGroup = lights.getJSONObject(i).getJSONObject("groupByGroup");
            String group = groupByGroup.getString("name");
            if (group.equalsIgnoreCase("F")){
                String status = "";
                if (lights.getJSONObject(i).getBoolean("on") == false){
                    status = "off";
                }
                else status = "on";
                String id = String.valueOf(lights.getJSONObject(i).getInt("id"))+";"+ status +";"+lights.getJSONObject(i).getString("color");
                list.add(id);
            }
        }
        String [] result = list.toArray(new String[list.size()]);
        return result;

    }

    @Override
    public void setLight(int id, String color, boolean state) throws IOException {
        apiService.communicatePUT(id, color, state);
    }

    @Override
    public void turnOffAllLeds() throws IOException{

        String[] result = getGroupLeds();

        for (int i = 0; i < result.length; i++) {
            String[] split = result[i].split(";");
            apiService.communicatePUT(Integer.parseInt(split[0]), "#000", false);
        }
    }


}

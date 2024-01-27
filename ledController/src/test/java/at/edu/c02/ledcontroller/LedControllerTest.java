package at.edu.c02.ledcontroller;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.configuration.IMockitoConfiguration;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class LedControllerTest {
    /**
     * This test is just here to check if tests get executed. Feel free to delete it when adding your own tests.
     * Take a look at the stack calculator tests again if you are unsure where to start.
     */
    @Test
    public void dummyTest() {
        assertEquals(1, 1);
    }

    @Test
    public void testGetGroupLeds() throws IOException {

        ApiService apiService= mock(ApiService.class);
        LedControllerImpl ledController= new LedControllerImpl(apiService);
        when(apiService.communicateGET(anyString())).thenReturn(new JSONObject("{\"lights\":[{\"id\":1,\"color\":\"#c13663\",\"on\":true,\"groupByGroup\":{\"name\":\"F\"}}, {\"id\":2,\"color\":\"#f00\",\"on\":true,\"groupByGroup\":{\"name\":\"B\"}}, {\"id\":3,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"F\"}}, {\"id\":4,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"F\"}}, {\"id\":5,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"F\"}}, {\"id\":6,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"F\"}}, {\"id\":7,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"F\"}}, {\"id\":8,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"F\"}}, {\"id\":9,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"F\"}}, {\"id\":10,\"color\":\"#cde\",\"on\":true,\"groupByGroup\":{\"name\":\"B\"}}, {\"id\":11,\"color\":\"#f00\",\"on\":true,\"groupByGroup\":{\"name\":\"B\"}}, {\"id\":12,\"color\":\"#f00\",\"on\":true,\"groupByGroup\":{\"name\":\"B\"}}, {\"id\":13,\"color\":\"#f00\",\"on\":true,\"groupByGroup\":{\"name\":\"B\"}}, {\"id\":14,\"color\":\"#f00\",\"on\":true,\"groupByGroup\":{\"name\":\"B\"}}, {\"id\":15,\"color\":\"#f00\",\"on\":true,\"groupByGroup\":{\"name\":\"B\"}}, {\"id\":16,\"color\":\"#f00\",\"on\":true,\"groupByGroup\":{\"name\":\"B\"}}, {\"id\":20,\"color\":\"#ff00ff\",\"on\":false,\"groupByGroup\":{\"name\":\"C\"}}, {\"id\":21,\"color\":\"#ff00ff\",\"on\":false,\"groupByGroup\":{\"name\":\"C\"}}, {\"id\":22,\"color\":\"#ff00ff\",\"on\":false,\"groupByGroup\":{\"name\":\"C\"}}, {\"id\":23,\"color\":\"#ff00ff\",\"on\":false,\"groupByGroup\":{\"name\":\"C\"}}, {\"id\":24,\"color\":\"#ff00ff\",\"on\":false,\"groupByGroup\":{\"name\":\"C\"}}, {\"id\":25,\"color\":\"#ff00ff\",\"on\":false,\"groupByGroup\":{\"name\":\"C\"}}, {\"id\":26,\"color\":\"#ff00ff\",\"on\":false,\"groupByGroup\":{\"name\":\"C\"}}, {\"id\":27,\"color\":\"#ff00ff\",\"on\":false,\"groupByGroup\":{\"name\":\"C\"}}, {\"id\":28,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"D\"}}, {\"id\":29,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"D\"}}, {\"id\":30,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"D\"}}, {\"id\":31,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"D\"}}, {\"id\":32,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"D\"}}, {\"id\":33,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"D\"}}, {\"id\":34,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"D\"}}, {\"id\":35,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"D\"}}, {\"id\":36,\"color\":\"#f00\",\"on\":true,\"groupByGroup\":{\"name\":\"E\"}}, {\"id\":37,\"color\":\"#000\",\"on\":true,\"groupByGroup\":{\"name\":\"E\"}}, {\"id\":38,\"color\":\"#000\",\"on\":true,\"groupByGroup\":{\"name\":\"E\"}}, {\"id\":39,\"color\":\"#000\",\"on\":true,\"groupByGroup\":{\"name\":\"E\"}}, {\"id\":40,\"color\":\"#000\",\"on\":true,\"groupByGroup\":{\"name\":\"E\"}}, {\"id\":41,\"color\":\"#0ff\",\"on\":true,\"groupByGroup\":{\"name\":\"E\"}}, {\"id\":42,\"color\":\"#000\",\"on\":true,\"groupByGroup\":{\"name\":\"E\"}}, {\"id\":43,\"color\":\"#000\",\"on\":true,\"groupByGroup\":{\"name\":\"E\"}}, {\"id\":46,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"G\"}}, {\"id\":47,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"G\"}}, {\"id\":48,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"G\"}}, {\"id\":49,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"G\"}}, {\"id\":50,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"G\"}}, {\"id\":51,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"G\"}}, {\"id\":52,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"G\"}}, {\"id\":53,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"G\"}}, {\"id\":54,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"A\"}}, {\"id\":55,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"A\"}}, {\"id\":56,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"A\"}}, {\"id\":57,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"A\"}}, {\"id\":58,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"A\"}}, {\"id\":59,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"A\"}}, {\"id\":60,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"A\"}}, {\"id\":61,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"A\"}}]}"));
        var groupLeds = ledController.getGroupLeds();
        assertEquals(groupLeds.length, 8);

    }

    @Test
    public void testSetLight() throws IOException {

        ApiServiceImpl apiService = new ApiServiceImpl();
        LedControllerImpl ledController = new LedControllerImpl(apiService);
        ledController.setLight(1,"#eb1a07",true);
        ledController.setLight(3,"#f2f207",true);
        ledController.setLight(4,"#46d413",true);
    }


}
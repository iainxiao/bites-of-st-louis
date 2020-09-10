package org.launchcode.bitesofstlouis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/restaurants")
public class PlacesController {

//    @Value("${GGL_PLCS_API_KEY}")
    private String apiKey = "AIzaSyDFEht0SIGBp2Ho7bH1JwXj0nrsyb46UIo";

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

//    public static String base_url = "https://maps.googleapis.com/maps/api/";

    @RequestMapping(value="", method = RequestMethod.GET)
    public String getRestaurantData(String search) {

        search = "pizza";

        String restaurantListing = restTemplate.getForObject(
                "https://maps.googleapis.com/maps/api/place/textsearch/json?input=" + search + "&inputtype=textquery&fields=formatted_address,name,rating,opening_hours&key=" + apiKey,
                String.class
        );
        return String.format(restaurantListing);
    }

}

package org.launchcode.bitesofstlouis;

import org.json.JSONArray;
import org.launchcode.bitesofstlouis.Models.Restaurants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import javax.xml.xpath.*;
import java.io.*;
import java.io.*;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.ArrayList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/results")
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


    @RequestMapping(value = "", method = RequestMethod.GET)
//    @ResponseBody
    public String searchResults(Model model, @RequestParam String query) {

//        search = "pizza";

        String restaurantListing = restTemplate.getForObject(
                "https://maps.googleapis.com/maps/api/place/textsearch/json?input=" + query + "&inputtype=textquery&types=restaurants&key=" + apiKey,
                String.class
        );
//        return String.format(restaurantListing);

        ArrayList<Restaurants> Restaurants_ = new ArrayList<>();
//        Restaurants restaurant = new Restaurants();
//        String name = null;
//        String address = null;
//        Integer price = null;
//        Integer rating = null;

        String jsonString = String.format(restaurantListing);
        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("results");

//        for (int i = 0; i < arr.length(); i++) {
//            address = arr.getJSONObject(i).getString("formatted_address");
////            name = arr.getJSONObject(i).getString("name");
//////            price = arr.getJSONObject(i).getInt("price_level");
////            rating = arr.getJSONObject(i).getInt("rating");
//
//        }
        for (int i = 0; i < arr.length(); i++) {
//            JSONObject object = arr.getJSONObject(i);
            Restaurants restaurant = new Restaurants();

            restaurant.setAddress(arr.getJSONObject(i).getString("formatted_address"));
            restaurant.setName(arr.getJSONObject(i).getString("name"));
//            restaurant.getPrice(arr.getJSONObject(i).getInt("price_level"));
            restaurant.setRating(arr.getJSONObject(i).getInt("rating"));
            Restaurants_.add(restaurant);

            model.addAttribute("title", "results for: " + query);
            model.addAttribute("restaurant", Restaurants_);
        }
        return "results";


//        return "Name: " + name + "\n" + "Address: " + address + "Price: " + price + "Rating: " + rating;

//        String jsonString = String.format(restaurantListing);
//        JSONObject obj = new JSONObject(jsonString);
//        String address = obj.getString("");
//        return address;
//
//        JSONArray arr = obj.getJSONArray("posts");
//        for (int i = 0; i < arr.length(); i++) {
//            String post_id = arr.getJSONObject(i).getString("post_id");
//    ......
//        }
    }
}


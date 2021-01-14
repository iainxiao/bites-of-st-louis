package org.launchcode.bitesofstlouis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {


    @GetMapping("search")
    @ResponseBody
    public String searchForm() {
        String html =
            "<html>" +
                "<body>" +
                    "<form method = 'get' action = '/results'>" +
                        "<input type = 'text' name = 'query'>" +
                        "<input type = 'submit' value = 'Go!'?" +
                    "</form>" +
                "</body>" +
            "</html>";
        return html;
    }

//    @GetMapping("results")
//    @ResponseBody
//    public String searchResults(@RequestParam String query) {
//
//        return "Hello, " + query + "!";
//
//    }





}

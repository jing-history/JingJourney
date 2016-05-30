package tk.jingzing.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Louis Wang on 2016/5/30.
 */

@RestController
@RequestMapping(value="/love")
public class LoveTimeController {

    @RequestMapping("/times")
    // @ResponseBody
    public String love() {
        return "success";
    }
}

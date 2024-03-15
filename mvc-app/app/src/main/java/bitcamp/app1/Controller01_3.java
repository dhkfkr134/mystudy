package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c01_3")
public class Controller01_3 {

  @RequestMapping("h1")
  @ResponseBody
  public String handler(){
    return "c01_3_h1";
  }

  @RequestMapping("/h2")
  @ResponseBody
  public String handler2(){
    return "c01_3_h2";
  }

  @RequestMapping("/1/h3")
  @ResponseBody
  public String handler3(){
    return "c01_3_h3";
  }

  @RequestMapping("/2h4")
  @ResponseBody
  public String handler4(){
    return "c01_3_h4";
  }


}

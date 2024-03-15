package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c03_1")
public class Controller03_1 {

  @GetMapping(params = "name")
  @ResponseBody
  public String handler1(){
    return "hander1";
  }

  @GetMapping(params = "age")
  @ResponseBody
  public String handler2(){
    return "hander2";
  }

  @GetMapping(params = {"name","age"})
  @ResponseBody
  public String handler3(@RequestParam("name") String name){
    return "hander3";
  }

  @GetMapping(params = "okok")
  @ResponseBody
  public String handler4(){
    return "hander4";
  }

  @PostMapping(params = "name")
  @ResponseBody
  public String handler5(){
    return "handler2";
  }
}

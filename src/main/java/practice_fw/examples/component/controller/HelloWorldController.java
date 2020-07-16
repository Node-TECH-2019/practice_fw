package practice_fw.examples.component.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
  /**
   * デフォルトコンストラクタ
   */
  public HelloWorldController() {
    super();
  }

  @RequestMapping(value = "/hello_world.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")

  @ResponseBody
  public String handleRequest() {
    String src = "Hello world !!";
    return src;
  }
}

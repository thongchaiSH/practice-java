package com.thongchai;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

    private static int counter = 0;
    private static final String VIEW_INDEX = "index";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

//  @Autowired
//  private GithubProperties properties;

//  @Autowired
//  private MyPropeties myProperties;

    @Autowired
    Environment env;

    @Value("${app-evn}")
    private String appEnv;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

//    model.addAttribute("message", "Welcome github prop=" + properties.getCloneBaseDir() + " envProp=" + env.getProperty("github.cloneBaseDir") + " AND MORE MORE MORE beanProp=" + myProperties.getToken());
        model.addAttribute("counter", ++counter);
        logger.debug("[welcome] counter : {}", counter);
        logger.debug("appEnv : {}",appEnv);
        model.addAttribute("message","APP-ENV:"+appEnv);
        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;

    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {

        model.addAttribute("message", "Welcome " + name);
        model.addAttribute("counter", ++counter);
        logger.debug("[welcomeName] counter : {}", counter);
        return VIEW_INDEX;

    }

}

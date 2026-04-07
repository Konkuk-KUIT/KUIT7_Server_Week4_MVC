package controller;

import frontcontroller.ModelAndView;

import java.util.Map;

public interface Controller {

    public ModelAndView process(Map<String,String> paraMap);

}

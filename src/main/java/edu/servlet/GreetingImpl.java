package edu.servlet;


import javax.ejb.LocalBean;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class GreetingImpl implements Greeting {

    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String greeting() {
        return "Hello " + name;
    }
}

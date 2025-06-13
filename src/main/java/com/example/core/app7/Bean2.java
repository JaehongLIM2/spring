package com.example.core.app7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bean2 {
    public final Bean1 bean1;

    public Bean2(Bean1 bean1) {
        this.bean1 = bean1;
    }

//    @Autowired
//    public Bean2(Bean1 bean1) {
//        this.bean1 = bean1;
//    }

    public void action() {
        bean1.go();
    }
}
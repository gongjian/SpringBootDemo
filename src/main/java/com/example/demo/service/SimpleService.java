package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.gj.test.annotation.Log;

@Service
public class SimpleService {
 
    @Log
    public void test(int num) {
        System.out.println("----test---- " + num);
    }
 
    @Log
    public void core(int num) {
        System.out.println("----core---- " + num);
    }
 
    public void work(int num) {
        System.out.println("----work---- " + num);
    }
 
}

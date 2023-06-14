package com.problem;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    Map<String,Trie> dict;
    boolean isEnd;
    String value;
    Trie(){
        dict=new HashMap<>();
        isEnd=false;
        this.value=null;
    }
}

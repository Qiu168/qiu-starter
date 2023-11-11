package com.test;

import com.cat.json.GeneratePrint;
import com.cat.json.JSONIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class P{
    @JSONIgnore
    String name;
    @GeneratePrint
    String password;
}
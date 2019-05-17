package cn.zwr.generator;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Hello implements Serializable {
    private String a;
    private int b;

}

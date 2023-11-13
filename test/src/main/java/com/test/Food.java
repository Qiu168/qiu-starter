package com.test;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.cat.encrypt.AlgorithmType;
import com.cat.encrypt.Encrypt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 14629
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Food {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @Encrypt/*(algorithm = AlgorithmType.BASE64)*/
    private String name;

    public Food(String name) {
        this.name = name;
    }
}

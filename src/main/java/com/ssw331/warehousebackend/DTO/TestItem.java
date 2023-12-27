package com.ssw331.warehousebackend.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("test_table")
public class TestItem {
    @TableId(type = IdType.AUTO)
    private int id;
}

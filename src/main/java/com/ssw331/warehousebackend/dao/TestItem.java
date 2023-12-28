package com.ssw331.warehousebackend.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("Movie")
public class TestItem {
    @TableId(type = IdType.AUTO)
    private int id;
}

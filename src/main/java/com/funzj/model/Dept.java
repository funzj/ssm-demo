package com.funzj.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author D.Yang
 * @since 2019-12-05
 */
@TableName("dept")
public class Dept extends Model<Dept> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "deptno", type = IdType.AUTO)
    private Long deptno;
    private String dname;
    @TableField("db_source")
    private String dbSource;


    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    @Override
    protected Serializable pkVal() {
        return this.deptno;
    }

    @Override
    public String toString() {
        return "Dept{" +
        "deptno=" + deptno +
        ", dname=" + dname +
        ", dbSource=" + dbSource +
        "}";
    }
}

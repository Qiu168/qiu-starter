package com.test;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.cat.encrypt.AlgorithmType;
import com.cat.encrypt.Encrypt;

/**
 * @author _qiu
 */
public class Food {
    @TableId(type = IdType.AUTO)
    private Integer id;
    /*(algorithm = AlgorithmType.BASE64)*/
    @Encrypt
    private String name;

    public Food(String name) {
        this.name = name;
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getName() {
        return this.name;
    }

    @SuppressWarnings("all")
    public void setId(final Integer id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Food)) return false;
        final Food other = (Food) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof Food;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    @SuppressWarnings("all")
    public Food(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }

    @SuppressWarnings("all")
    public Food() {
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "Food(id=" + this.getId() + ", name=" + this.getName() + ")";
    }
    //</editor-fold>
}

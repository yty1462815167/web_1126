package org.aly.yty.entity;

/**
 * @ClassName: Usertype
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/12/2 16:44
 * @Version: V1.0
 */
public class Usertype {
    private String typeID;
    private String typeName;

    public Usertype() {
    }

    public Usertype(String typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Usertype{" +
                "typeID='" + typeID + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
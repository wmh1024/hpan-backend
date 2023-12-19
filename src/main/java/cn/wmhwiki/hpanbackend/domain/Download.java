package cn.wmhwiki.hpanbackend.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName download
 */
@TableName(value = "download")
@Data
public class Download implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     *
     */
    private Integer type;
    /**
     *
     */
    private Integer isEnable;
    /**
     *
     */
    private String itemName;
    /**
     *
     */
    private String channel0;
    /**
     *
     */
    private String channel1;
    /**
     *
     */
    private String channel0Url;
    /**
     *
     */
    private String channel1Url;
    /**
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdtime;
    /**
     *
     */
    @TableLogic
    private Integer isDeleted;
    /**
     *
     */
    private String img;
    /**
     *
     */
    private String des;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Download other = (Download) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getIsEnable() == null ? other.getIsEnable() == null : this.getIsEnable().equals(other.getIsEnable()))
                && (this.getItemName() == null ? other.getItemName() == null : this.getItemName().equals(other.getItemName()))
                && (this.getChannel0() == null ? other.getChannel0() == null : this.getChannel0().equals(other.getChannel0()))
                && (this.getChannel1() == null ? other.getChannel1() == null : this.getChannel1().equals(other.getChannel1()))
                && (this.getChannel0Url() == null ? other.getChannel0Url() == null : this.getChannel0Url().equals(other.getChannel0Url()))
                && (this.getChannel1Url() == null ? other.getChannel1Url() == null : this.getChannel1Url().equals(other.getChannel1Url()))
                && (this.getCreatedtime() == null ? other.getCreatedtime() == null : this.getCreatedtime().equals(other.getCreatedtime()))
                && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
                && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
                && (this.getDes() == null ? other.getDes() == null : this.getDes().equals(other.getDes()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getIsEnable() == null) ? 0 : getIsEnable().hashCode());
        result = prime * result + ((getItemName() == null) ? 0 : getItemName().hashCode());
        result = prime * result + ((getChannel0() == null) ? 0 : getChannel0().hashCode());
        result = prime * result + ((getChannel1() == null) ? 0 : getChannel1().hashCode());
        result = prime * result + ((getChannel0Url() == null) ? 0 : getChannel0Url().hashCode());
        result = prime * result + ((getChannel1Url() == null) ? 0 : getChannel1Url().hashCode());
        result = prime * result + ((getCreatedtime() == null) ? 0 : getCreatedtime().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getDes() == null) ? 0 : getDes().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", isEnable=").append(isEnable);
        sb.append(", itemName=").append(itemName);
        sb.append(", channel0=").append(channel0);
        sb.append(", channel1=").append(channel1);
        sb.append(", channel0Url=").append(channel0Url);
        sb.append(", channel1Url=").append(channel1Url);
        sb.append(", createdtime=").append(createdtime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", img=").append(img);
        sb.append(", des=").append(des);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
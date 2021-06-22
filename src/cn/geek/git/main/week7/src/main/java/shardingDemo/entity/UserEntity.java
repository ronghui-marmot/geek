package shardingDemo.entity;

import java.sql.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserEntity {

    private Integer id;

    private String name;

    private String sex;

    private Date createTime;

    private Date lastUpdateTime;

	public void setCreateTime(Date date) {
		// TODO Auto-generated method stub
		this.createTime = date;
	}

	public void setName(String string) {
		// TODO Auto-generated method stub
		this.name = string;
	}

	public void setSex(String string) {
		// TODO Auto-generated method stub
		this.sex = string;
	}
}

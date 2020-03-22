package remember.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t_jpa_user")
@NoArgsConstructor
@Data
public class UserEntity {
	@Id //PK
	@GeneratedValue(strategy=GenerationType.AUTO)//primarykey auto Increment
	private int id;
	
	private String userId;
	
	private String nickname;
	
	@Column(columnDefinition = "int default 1")
	private int status;
	
	
}
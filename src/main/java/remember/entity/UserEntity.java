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
	@Id //PK임을 나타냄
	@GeneratedValue(strategy=GenerationType.AUTO)//기본키의 생성전략을 설정(DB에서 제공하는 기본키 생성전략을 따르게됨)
	private int id;
	
	private String userId;
	
	private String nickname;
	
	@Column(columnDefinition = "int default 1")
	private int status;
	
	
}
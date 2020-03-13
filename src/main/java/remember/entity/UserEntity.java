package remember.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t_jpa_board")
@NoArgsConstructor
@Data
public class UserEntity {
	@Id //PK임을 나타냄
	@GeneratedValue(strategy=GenerationType.AUTO)//기본키의 생성전략을 설정(DB에서 제공하는 기본키 생성전략을 따르게됨)
	private int boardIdx;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String contents;
	
	@Column(nullable = false)
	private int hitCnt = 0;
	
	@Column(nullable = false)
	private String creatorId;
	
	@Column(nullable = false)
	private LocalDateTime createdDatetime = LocalDateTime.now();
	
	private String updateId;
	
	private LocalDateTime updatedDatetime;

}
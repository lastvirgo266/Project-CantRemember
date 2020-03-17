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
@Table(name="t_jpa_game")
@NoArgsConstructor
@Data
public class GameEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//�⺻Ű�� ���������� ����(DB���� �����ϴ� �⺻Ű ���������� �����Ե�)
	private int id;
	
	
	private String userNickname;
	
	private String game;
	
	private String gameId;
	
	private String hashedPassword;

}
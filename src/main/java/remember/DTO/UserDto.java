package remember.DTO;

import java.util.List;

import lombok.Data;

@Data
public class UserDto {
	
	private String id;
	private String hashedPassword;
	private String game;
	private String gameId;

}

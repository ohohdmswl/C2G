package ABE.C2G.cmmn.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {

	private String board_id;
	private String wrtr;
	private String cnt;
	private String created;
	@Override
	public String toString() {
		return "BoardVO [board_id=" + board_id + ", wrtr=" + wrtr + ", cnt=" + cnt + ", created=" + created + "]";
	}
	
	
	
}

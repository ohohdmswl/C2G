package ABE.C2G.cmmn.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO extends BasicVO{

	private String board_id;
	private String wrtr;
	private String board_nm;
	private String created;
	private String board_cmnt_yn;
	private String board_reply_yn;
	private int board_pst_cnt;
	private String board_use_yn;

	
	
	
}

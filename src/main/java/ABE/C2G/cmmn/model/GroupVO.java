package ABE.C2G.cmmn.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GroupVO extends BasicVO{

	private String group_id;					// 스터디그룹 코드
	private String group_nm;					// 스터디그룹 이름
	private String crt_crtr;					// 스터디그룹 생성자
	private String crt_dt;						// 스터디그룹 생성일
	private String group_use_yn;				// 스터디그룹 사용여부
//	private String board_cmnt_yn;				// 
//	private String board_reply_yn;
//	private int board_pst_cnt;

	
	
	
}

package remember.controller;


import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import lombok.extern.slf4j.Slf4j;
import remember.BO.KakaoAPI;
import remember.BO.KakaoLogin;

@Slf4j
@RestController
public class RestApiController {
	
//	@Autowired
//	private BoardService boardService;
	
	@Autowired
	private KakaoAPI kakao;
	
	@Autowired
	private KakaoLogin login;
	
	@RequestMapping(value="/main", method= RequestMethod.GET)
	public RedirectView Main() {
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(login.getURL());
		return redirectView;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public void KaKaoLogin(@RequestParam("code") String code ) {
		
		String access_Token = kakao.getAccessToken(code);
		log.info("code  : " + code +"\n"+ "Aceess : " + access_Token+"\n");
		
		kakao.SaveUserInfo(access_Token);
	}
	
	
	
//	@RequestMapping(value="/api/board", method=RequestMethod.GET)
//	public List<UserDto> openBoardList() throws Exception{
//		return boardService.selectBoardList();
//	}
//	
//	@RequestMapping(value="/api/board/write", method=RequestMethod.POST)
//	public void insertBoard(@RequestBody UserDto board) throws Exception{
//		boardService.insertBoard(board, null);
//	}
//	
//	@RequestMapping(value = "/api/board/{boardIdx}", method = RequestMethod.GET)
//	public UserDto openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception{
//		return boardService.selectBoardDetail(boardIdx);
//	}
//	
//	@RequestMapping(value = "/api/board/{boardIdx}", method = RequestMethod.PUT)
//	public String updateBoard(@RequestBody UserDto board) throws Exception{
//		boardService.updateBoard(board);
//		return "redirect:/board";
//	}
//	
//
//	@RequestMapping(value = "/api/board/{boardIdx}", method = RequestMethod.DELETE)
//	public String deleteBoard(@PathVariable int boardIdx) throws Exception{
//		boardService.deleteBoard(boardIdx);
//		return "redirect:/board";
//	}
	
	

}

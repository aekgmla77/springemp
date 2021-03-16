package com.company.board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.company.board.service.BoardsVO;
import com.company.board.service.impl.BoardMapper;
import com.company.common.FileRenamePolicy;

@Controller
public class BoardsController {

	@Autowired
	BoardMapper boardMapper;

	//입력폼 호출
	@GetMapping("/insertBoard")
	public String insertBoardForm(BoardsVO vo) {
		return "board/insertBoard";
	}

	@PostMapping("/insertBoard")
	public String insertBoard(BoardsVO vo) throws Exception {
		System.out.println(vo);
		// 철부파일 처리
		// for(반복 처리) -> 여러 파일 넣는 거
		// 한 건 MultipartFile file = vo.getUploadFile();
		MultipartFile[] files = vo.getUploadFile();
		String filenames = "";
		boolean start = true;
		for(MultipartFile file : files) {
			if (file != null && !file.isEmpty() && file.getSize() > 0) {
				String filename = file.getOriginalFilename();
				//file명 중복체크 -> rename
				File rename = FileRenamePolicy.rename(new File("c:/upload", filename));
				// rename.getName() -> 파일명 읽어내는 거 (파일명 뒤에 숫자가 붙음)
//				vo.setFilename(rename.getName()); // vo에 저장  --> 한 건
				if(! start ) {
					filenames += ",";
				} else {
					start = false;
				}
				filenames += rename.getName();
				// 임시폴더에서 업로드 폴더로 파일 이동
				file.transferTo(rename);
			}
		}
		vo.setFilename(filenames);
		// 등록 서비스 호출
		boardMapper.insertBoard(vo);
		return "redirect:/getBoard?seq=" + vo.getSeq();
	}

	// 단건조회(리턴 폼)
	@GetMapping("/getBoard")
	public String getBoard(BoardsVO vo, Model model) {
		model.addAttribute("board", boardMapper.getBoard(vo));
		return "board/getBoard";
	}

	//파일 다운로드
	@RequestMapping("/fileDown")
	public void fileDown(BoardsVO vo, HttpServletResponse response) throws Exception {
		vo = boardMapper.getBoard(vo);
		File file = new File("c:/upload", vo.getFilename());
		if (file.exists()) {
			// 다운 받을 파일 알려주는 거
			response.setContentType("application/octet-stream;charset=UTF-8");
			response.setHeader("Content-Disposition",
					"attachment; filename=\"" + URLEncoder.encode(vo.getFilename(), "utf-8") + "\"");

			BufferedInputStream in = null;
			BufferedOutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(file));
				out = new BufferedOutputStream(response.getOutputStream());
				FileCopyUtils.copy(in, out);
				out.flush();
			} catch (IOException ex) {
			} finally {
				in.close();
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
		} else {
			// 파일이 없을 때 나오는 거
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter()
						.append("<script>")
						.append("alert('file not found(해당 파일이 없습니다.)');")
						.append("history.back();") // history.go(-1)
						.append("</script>");
		}
	}
	
	
	//파일 여러건 다운로드
	//단건과 다른 부분 -> 한 건 조회 부분만 삭제했음.
	@RequestMapping("/fileNameDown")
	public void fileNameDown(BoardsVO vo, HttpServletResponse response) throws Exception {
		File file = new File("c:/upload", vo.getFilename());
		if (file.exists()) {
			// 다운 받을 파일 알려주는 거
			response.setContentType("application/octet-stream;charset=UTF-8");
			response.setHeader("Content-Disposition",
					"attachment; filename=\"" + URLEncoder.encode(vo.getFilename(), "utf-8") + "\"");

			BufferedInputStream in = null;
			BufferedOutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(file));
				out = new BufferedOutputStream(response.getOutputStream());
				FileCopyUtils.copy(in, out);
				out.flush();
			} catch (IOException ex) {
			} finally {
				in.close();
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
		} else {
			// 파일이 없을 때 나오는 거
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter()
						.append("<script>")
						.append("alert('file not found(해당 파일이 없습니다.)');")
						.append("history.back();") // history.go(-1)
						.append("</script>");
		}
	}
}

package com.company.temp;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.temp.service.SalesVO;
import com.company.temp.service.impl.EmpMapper;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class ExcelPdfController {

	@Autowired
	EmpMapper empMapper;
	@Autowired
	DataSource dataSource;

	@RequestMapping("/getEmpExcel")
	public String getEmpExcel(Model model) {
		List<Map<String, Object>> list = empMapper.getEmpList();
		System.out.println(list.get(0));
		model.addAttribute("filename", "empList");
		model.addAttribute("headers", new String[] { "firstName", "lastName", "salary" });
		model.addAttribute("datas", empMapper.getEmpList());
		return "commonExcelView";
	}

	@RequestMapping("/empListpdf")
	public String getPdfEmpList(Model model) {
		model.addAttribute("filename", "/reports/empList.jasper");
		return "pdfView";
	}

	@RequestMapping("/empListpdf2")
	public String getPdfEmpList(Model model, @RequestParam String dept) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("P_DEPARTMENT_ID", dept);
		model.addAttribute("param", map);
		model.addAttribute("filename", "/reports/empList2.jasper");
		return "pdfView";
	}

	@RequestMapping("/empListpdf3")
	public String getPdfEmpList3(Model model) {
		model.addAttribute("filename", "/reports/empList3.jasper");
		return "pdfView";
	}

	@RequestMapping("/empListpdf4")
	public void getPdfEmpList4(HttpServletResponse response) throws Exception {
		Connection conn = dataSource.getConnection();
		// 소스파일 컴파일하여 저장 : compileReportToFile
		String jrxmlFile = getClass().getResource("/reports/empList3.jrxml").getFile();
		String jasperFile = JasperCompileManager.compileReportToFile(jrxmlFile);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile, null, conn);
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}

	@RequestMapping("/getChartData")
	@ResponseBody
	public List<Map<String, Object>> getChartData() {
		return empMapper.getSumList();
	}
}

package com.jinjikanri.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jinjikanri.common.util.ErrorMessage;
import com.jinjikanri.common.util.Tools;
import com.jinjikanri.entity.JIN0003QbbgEntity;
import com.jinjikanri.entity.JIN0006AdmitEntity;
import com.jinjikanri.service.AdmitService;

@Controller
@RequestMapping(value="/admit")
public class AdmitController {
	@Autowired
	private AdmitService admitService;

	
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/selectAdmit")
		public String selectAdmit(JIN0006AdmitEntity admit, Integer pageIndex, Model model) {
			if (pageIndex == null) {
				pageIndex = 1;
			}
			Map<String, Object> result = this.admitService.selectAdmit(admit, pageIndex);
			List<JIN0006AdmitEntity> admitList = (List<JIN0006AdmitEntity>) result.get("admitList");
			model.addAttribute("total", result.get("total"));
			model.addAttribute("pages", result.get("pages"));
			model.addAttribute("admitList", admitList);
			model.addAttribute("admit", admit);
			return "admit/admitlist";
		}
		
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/selectAdmit2")
		public String selectAdmit2(JIN0006AdmitEntity admit, Integer pageIndex, Model model) {
			if (pageIndex == null) {
				pageIndex = 1;
			}
			Map<String, Object> result = this.admitService.selectAdmit2(admit, pageIndex);
			List<JIN0006AdmitEntity> admitList = (List<JIN0006AdmitEntity>) result.get("admitList");
			model.addAttribute("total", result.get("total"));
			model.addAttribute("pages", result.get("pages"));
			model.addAttribute("admitList", admitList);
			model.addAttribute("admit", admit);
			return "admit/admithistory";
		}
		
		@RequestMapping("/selectAdmitById")
		public String selectAdmitById(Integer dateId,Model model) {
			JIN0006AdmitEntity admit = admitService.selectAdmitById(dateId);
			model.addAttribute("admit", admit);
			model.addAttribute("sign", "0");
			return "admit/admitadd";
		}
		
		@RequestMapping("/selectById")
		public String selectById(Integer dateId,Model model) {
			JIN0006AdmitEntity admit = admitService.selectById(dateId);
			model.addAttribute("admit", admit);
			model.addAttribute("sign", "1");
			return "admit/admitadd";
		}
		
		@RequestMapping("updateAdmitById")
		public String updateAdmitById(JIN0006AdmitEntity admit,Model model) {
			/*JIN0006AdmitEntity  jin0006admitEntity= admitService.selectById(admit.getDateId());
			if(jin0006admitEntity == null) {
				return ErrorMessage.ERR0029();
			} else {
				System.out.println(admit.getRecKosnZituYmdHms()+"JJJJJJJ");
				JIN0006AdmitEntity  admitEntity= admitService.getDataByIdTime(admit.getDateId(),admit.getRecKosnZituYmdHms());
				if(admitEntity == null) {
					return ErrorMessage.ERR0048();
				} else {*/
					/*admit.setRecognitionState(1);*/
					/*admit.setRecSaksZituYmdHms(Tools.getSysDate());*/
					admit.setRecKosnZituYmdHms(Tools.getSysDate());
					
					admitService.updateAdmitById(admit);
					model.addAttribute("sign", "0");
					model.addAttribute("admit", admit);
					return "admit/admitadd";
				}
			/*}*/		
			
			
		/*}*/
		/*@RequestMapping("updateAdmitById1")
		public String updateAdmitById1(JIN0006AdmitEntity admit,Model model) {
			admit.setRecognitionState(2);
			admit.setRecKosnZituYmdHms(Tools.getSysDate());
			admit.setRecSaksZituYmdHms(Tools.getSysDate());
			admitService.updateAdmitById(admit);
			model.addAttribute("admit", admit);
			return "admit/admitadd";
		}
		*/
		
		
	
}

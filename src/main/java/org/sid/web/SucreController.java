package org.sid.web;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.validation.Valid;
import org.apache.commons.io.IOUtils;

import org.sid.dao.SucresRepository;
import org.sid.entities.Sucrerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SucreController {
	@Autowired
   private SucresRepository sucreRepository;
	@Value("${dir.images}")
	private String imageDir;
	@RequestMapping(value="/index")
	public String index(Model model,@RequestParam(name="page",defaultValue = "0")int p,
			@RequestParam(name="size",defaultValue = "2")int s,
			@RequestParam(name="motCle",defaultValue = "")String mc
			) {
		Page <Sucrerie>pageSucre=sucreRepository.chercher("%"+mc+"%",PageRequest.of(p, s));
		model.addAttribute("lesSables", pageSucre.getContent());
		int []nbpages=new int[pageSucre.getTotalPages()];
		model.addAttribute("nombrePage",nbpages);
		model.addAttribute("size",s);
		model.addAttribute("pageCourante",p);
		model.addAttribute("motCle",mc);
		return "Sucre";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
public String delete(Long id,String motCle,int page,int size) {
		sucreRepository.deleteById(id);
		return"redirect:/index?page="+page+"&size="+size+"&motCle="+motCle;
	}
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form(Model model) {	
		model.addAttribute("sucrerie", new Sucrerie());
		return "form";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Model model,@Valid Sucrerie sucrerie, BindingResult bindingResult,
			@RequestParam(name="picture")MultipartFile file) throws Exception {
		 if(bindingResult.hasErrors()) {
			return "form";}
		 if(!(file.isEmpty())){
			 sucrerie.setUrl(file.getOriginalFilename());
		 }
		 sucreRepository.save(sucrerie);
		if(!(file.isEmpty())){	
			sucrerie.setUrl(file.getOriginalFilename());
			file.transferTo(new File(imageDir+sucrerie.getId()));
		}
		
		return "Confirmation";
	}
	@RequestMapping(value="/getUrl",
			produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getUrl(Long id) throws Exception{
		File f=new File(imageDir+id);
      return IOUtils.toByteArray(new FileInputStream(f));
      //https://stackoverflow.com/questions/16535032/what-to-import-to-use-ioutils-tostring
		
	}
}


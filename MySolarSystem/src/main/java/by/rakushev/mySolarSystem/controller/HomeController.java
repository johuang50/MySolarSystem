package by.rakushev.mySolarSystem.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import by.rakushev.mySolarSystem.crud.Crud;
import by.rakushev.mySolarSystem.entity.Card;
import by.rakushev.mySolarSystem.entity.FileUploadForm;
import by.rakushev.mySolarSystem.entity.Planets;

@Controller
public class HomeController {

	@Autowired
	Crud crud;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<Planets> list = crud.list(Planets.class);
		model.addAttribute("list", list);
		return "main";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Model model, @ModelAttribute Planets planet,
			@ModelAttribute("uploadForm") FileUploadForm uploadForm) {
		List<MultipartFile> files = null;
		MultipartFile file = null;
		byte[] image = new byte[1024 * 1024 * 100];

		files = uploadForm.getFiles();
		file = files.get(0);
		try {
			image = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		planet.setImage(image);
		crud.merge(planet);

		List<Planets> list = crud.list(Planets.class);
		model.addAttribute("news", list);

		return "redirect:/";
	}

	@RequestMapping(value = "/card", method = RequestMethod.POST)
	public String addInfo(Model model, @ModelAttribute Card card,
			@RequestParam("planet") String planet) {
		card.setNameOfPlanet(planet);
		crud.saveOrUpdate(card);

		return "redirect:/";
	}

	@RequestMapping(value = "/planet", method = RequestMethod.GET)
	public String getPlanet(Model model, @RequestParam("name") String name) {
		model.addAttribute("nameOfPlanet", name);
		Card card = crud.getPlanet(Card.class, name);
		model.addAttribute("card", card);
		return "planet";
	}

	@RequestMapping("/image")
	public void getImage(@RequestParam("index") Long id,
			HttpServletResponse resp) {
		Planets planetImage = crud.check(Planets.class, id);
		try {
			resp.setContentType("image/jpeg");
			OutputStream out = resp.getOutputStream();
			resp.setContentLength(planetImage.getImage().length);
			out.write(planetImage.getImage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@ModelAttribute("planet")
	public Planets newPlanet() {
		return new Planets();
	}

	@ModelAttribute("card")
	public Card newCard() {
		return new Card();
	}

}

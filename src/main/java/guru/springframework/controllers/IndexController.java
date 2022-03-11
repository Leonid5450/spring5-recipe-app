package guru.springframework.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasreRepository;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {

	private CategoryRepository categoryRepository;
	private UnitOfMeasreRepository unitOfMeasreRepository;
	
	
	
    public IndexController(CategoryRepository categoryRepository, UnitOfMeasreRepository unitOfMeasreRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.unitOfMeasreRepository = unitOfMeasreRepository;
	}

   

	@RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
		
		System.out.println("Category id = ");
		
	Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
	Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasreRepository.findByDescription("Teaspoon");
	
	System.out.println("Category id = " + categoryOptional.get().getId());
	System.out.println("Unit of measure id =" + unitOfMeasureOptional.get().getId());
        return "index";
    }
}

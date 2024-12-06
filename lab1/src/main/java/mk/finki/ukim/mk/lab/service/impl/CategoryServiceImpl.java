package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.repository.CategoryRepository;
import mk.finki.ukim.mk.lab.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository obj;
    public CategoryServiceImpl(CategoryRepository obj){
        this.obj=obj;
    }

    public List<Category> findAll() {
        return obj.findAll();
    }
    public void save(Category loc){
        obj.save(loc);
    }
    public Category findByID(Long id) {
        if(obj.findById(id).isPresent()){
            return obj.findById(id).get();
        }else
            return null;
    }
}

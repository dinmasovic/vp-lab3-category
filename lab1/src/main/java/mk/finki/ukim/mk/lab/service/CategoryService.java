package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Location;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();
    public Category findByID(Long id);
}

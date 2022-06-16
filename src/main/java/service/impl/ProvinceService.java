package service.impl;

import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ProvinceRepository;

import java.util.Optional;

public class ProvinceService implements service.IProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;
    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);

    }

    @Override
    public void remove(long id) {
        provinceRepository.deleteById(id);

    }
}

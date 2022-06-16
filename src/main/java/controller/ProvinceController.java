package controller;

import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.IProvinceService;


@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    IProvinceService provinceService;

    @GetMapping
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("provinces", provinceService.findAll());//provinces la ten de thong qua giua java va html,phai giong nhau moi duoc thong qua
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("provinces", provinceService.findAll());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView save(Province province){
        provinceService.save(province);
        ModelAndView modelAndView =new ModelAndView("redirect:/provinces");
        return modelAndView;
    }
//
//    @GetMapping("/edit ")
//    public ModelAndView showEditForm(@PathVariable Long id) {
//        ModelAndView modelAndView = new ModelAndView("/province/edit");
//        Province province = provinceService.findById(id).get();//lấy đối tượng province theo id
//        modelAndView.addObject("pro",province);//thêm vào modelAndview để trả, dat ten la pro lay tu province
//        return modelAndView;
//    }
//
//    @PostMapping("/edit/{id}")
//    public ModelAndView update(@PathVariable Long id, Province province ){
//        ModelAndView modelAndView =new ModelAndView("redirect:/provinces");
//        Province usedProvince = provinceService.findById(id).get();
//        usedProvince.setDescription(province.getDescription());
//        usedProvince.setName(province.getName());//tìm cái đã có qua id rồi đặt tên mới thông qua thông tin nhận từ province.getname
//        return modelAndView;
//
//    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/province/edit");
        Province province = provinceService.findById(id).get();
        modelAndView.addObject("pro", province);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView update(@PathVariable Long id, Province province) {
        ModelAndView modelAndView = new ModelAndView("redirect:/provinces");
        provinceService.save(province);
        return modelAndView;
    }
}

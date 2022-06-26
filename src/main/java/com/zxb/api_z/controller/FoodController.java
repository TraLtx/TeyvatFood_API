package com.zxb.api_z.controller;

import com.zxb.api_z.model.Account;
import com.zxb.api_z.model.Food;
import com.zxb.api_z.reposition.AccountRepository;
import com.zxb.api_z.reposition.FoodRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.activation.FileTypeMap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

    @Autowired
    private FoodRepository foodRepo;

    @GetMapping
    public List<Food> getAllFood(){
        return foodRepo.findAll();
    }

    @PostMapping("/add")
    public Food addFood(@RequestParam("foodid") int foodid ,@RequestParam("image") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        Food food = foodRepo.findById(foodid);
        food.setImage(fileName);

        Food saveFood = foodRepo.save(food);
        String uploadDir = "food-images/";
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return saveFood;
    }

    @GetMapping("/suggest")
    public List<Food> getFoodSuggest(){
        return foodRepo.findByCountry("suggest");
    }

    @GetMapping("/search")
    public List<Food> search(@RequestParam("key") String key){
        if(key != null){
            System.out.println("-"+key+"-");
            return foodRepo.findByFnameContaining(key);
        }
        return foodRepo.findAll();
    }
    @GetMapping("/type")
    public List<Food> getFoodByType(@RequestParam("type") String type){
        return foodRepo.findByFtype(type);
    }

    @GetMapping("/image")
    public ResponseEntity<byte[]> getImage(@RequestParam("name") String name) throws IOException{
        File img = new File("src/image/"+name);
        return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
    }

//    @GetMapping(value = "/image")
//    public @ResponseBody byte[] getImage() throws IOException {
//        InputStream in = getClass()
//                .getResourceAsStream("com/ic_appdemo.jpeg");
//        System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFF getImage: "+ in);
//        return IOUtils.toByteArray(in);
//    }
//    @PostMapping("/add/img")
//    public Food addFood(@RequestParam("image") MultipartFile multipartFile) throws IOException {
//        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//
//
//        Food f = foodRepo.findById(1);
//        f.setImage(fileName);
//        String uploadDir = "food-images/" + f.getId();
//        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//
//        return f;
//    }

//    public RedirectView saveUser(User user,
//                                 @RequestParam("image") MultipartFile multipartFile) throws IOException {
//
//        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        user.setPhotos(fileName);
//
//        User savedUser = repo.save(user);
//
//        String uploadDir = "user-photos/" + savedUser.getId();
//
//        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//
//        return new RedirectView("/users", true);
//    }
//    @GetMapping()
//    public List<Food> getFoodByCountry(@ModelAttribute("country") String country){
//        return foodRepo.findByCountry(country);
//    }
}

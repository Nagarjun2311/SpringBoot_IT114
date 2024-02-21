package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RegisterModel;
import com.example.demo.service.RegisterService;


@RestController
public class RegisterController {
    private RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;

        
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterModel>postProduct(@RequestBody RegisterModel registerModel)
    {
        if(registerService.saveRegister(registerModel)==true)
        {
            return new ResponseEntity<>(registerModel,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(registerModel,HttpStatus.INTERNAL_SERVER_ERROR);
        
    }

    @GetMapping("/register/{id}")
    public ResponseEntity<RegisterModel> getProduct(@PathVariable("id") int id)
    {
        RegisterModel p=registerService.getRegister(id);
        if(p==null)
        {
            return new ResponseEntity<>(p,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
       
        
    }

    @GetMapping("/registers")
    public ResponseEntity<List> getProducts()
    {
        List<RegisterModel>b=registerService.getAllRegister();
        if(b.size()==0)
        {
            return new ResponseEntity<>(b,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(b,HttpStatus.OK);
    }

    @PutMapping("register/{id}")
    public ResponseEntity<RegisterModel> putMethodName(@PathVariable("id") int id, @RequestBody  RegisterModel registerModel)
    {
        if(registerService.updateRegister(id,registerModel)==true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("register/{id}")
    public ResponseEntity<RegisterModel>delete(@PathVariable int id)
    {
        if(registerService.deleteRegister(id)==true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}


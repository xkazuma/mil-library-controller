package jp.xkzm.millibrary.controller;

import com.alibaba.fastjson.JSON;
import jp.xkzm.millibrary.dto.LiteratureRequest;
import jp.xkzm.millibrary.entity.Literature;
import jp.xkzm.millibrary.service.LiteratureService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/literatures")
@RequiredArgsConstructor
public class LiteratureController {

    LiteratureService literatureService;

    @Autowired
    public LiteratureController(LiteratureService literatureService) {

        this.literatureService = literatureService;

    }

    @PostMapping(value = "/literature/create")
    public String create(@RequestBody LiteratureRequest literatureRequest) {

        literatureService.create(literatureRequest);

        return "redirect:/";

    }

    @GetMapping(value = "/list")
    public String getLiteraturesList() {

        List<Literature> literatures = this.literatureService.searchAll();

        return JSON.toJSONString(literatures);

    }

    @RequestMapping(value = "/isbn/{inputIsbn}")
    public String searchByIsbn(@PathVariable("inputIsbn") String inputIsbn) {

        List<Literature> literatures = this.literatureService.searchByIsbn(inputIsbn);

        return JSON.toJSONString(literatures);

    }

    @RequestMapping(value = "/title/{partTitle}")
    public String searchByTitle(@PathVariable("partTitle") String partTitle) {

        List<Literature> literatures = this.literatureService.searchByTitle(partTitle);

        return JSON.toJSONString(literatures);

    }
}
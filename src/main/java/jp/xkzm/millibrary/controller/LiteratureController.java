package jp.xkzm.millibrary.controller;

import com.alibaba.fastjson.JSON;
import jp.xkzm.millibrary.entity.Literature;
import jp.xkzm.millibrary.service.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/literatures")
public class LiteratureController {

    LiteratureService literatureService;

    @Autowired
    public LiteratureController(LiteratureService literatureService) {

        this.literatureService = literatureService;

    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
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
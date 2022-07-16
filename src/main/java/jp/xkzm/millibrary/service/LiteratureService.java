package jp.xkzm.millibrary.service;

import jp.xkzm.millibrary.entity.Literature;
import jp.xkzm.millibrary.repository.LiteratureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LiteratureService {

    LiteratureRepository literatureRepository;

    @Autowired
    public LiteratureService(LiteratureRepository literatureRepository) {

        this.literatureRepository = literatureRepository;

    }

    public List<Literature> searchAll() {

        return literatureRepository.findAll();

    }

    public List<Literature> searchByIsbn(String isbn) {

        Literature literature = new Literature();
        literature.setIsbn(isbn);

        Optional<Literature> optionalL = literatureRepository.findByIsbn(isbn);


        return new ArrayList<>(){{ add(optionalL.orElse(null)); }};

    }

    public List<Literature> searchByTitle(String title) {

        return literatureRepository.findByTitleLike("%" + title + "%");

    }


}

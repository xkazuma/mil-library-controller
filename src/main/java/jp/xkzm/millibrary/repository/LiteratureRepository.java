package jp.xkzm.millibrary.repository;

import jp.xkzm.millibrary.entity.Literature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LiteratureRepository extends JpaRepository<Literature, Long> {

    List<Literature> findByTitleLike(String string);

    Optional<Literature> findByIsbn(String isbn);

}

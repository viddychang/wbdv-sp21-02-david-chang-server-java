
package com.example.wbdvsp2102davidchangserverjava.repositories;


import com.example.wbdvsp2102davidchangserverjava.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository
        extends CrudRepository<Widget, Long> {

  @Query(value = "SELECT * FROM widgets WHERE topic_ic=:tid", nativeQuery = true)
  public List<Widget> findWidgetsForTopic(@Param("tid") String topicId);
}
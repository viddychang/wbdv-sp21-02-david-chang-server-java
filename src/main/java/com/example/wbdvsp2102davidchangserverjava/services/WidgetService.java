package com.example.wbdvsp2102davidchangserverjava.services;

import com.example.wbdvsp2102davidchangserverjava.models.Widget;
import com.example.wbdvsp2102davidchangserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {
  @Autowired
  WidgetRepository repository;

  /*
  private List<Widget> widgets = new ArrayList<Widget>();
  {

    Widget w1 = new Widget(123l, "ABC123", "HEADING", 1, "Widgets for Topic ABC123");
    Widget w2 = new Widget(234l, "ABC123", "PARAGRAPH", 1, "Lorem Ipsum");
    Widget w3 = new Widget(345l, "ABC234", "HEADING", 2, "Widgets for Topic ABC234");
    Widget w4 = new Widget(456l, "ABC234", "PARAGRAPH", 1, "Lorem Ipsum");
    Widget w5 = new Widget(567l, "ABC234", "PARAGRAPH", 1, "Lorem Ipsum");

    widgets.add(w1);
    widgets.add(w2);
    widgets.add(w3);
    widgets.add(w4);
    widgets.add(w5);

  }
*/

  public Widget createWidget(String topicId, Widget widget) {
    widget.setTopicId(topicId);
    return repository.save(widget);
//    widget.setId((new Date()).getTime());
//    widgets.add(widget);
//    return widget;
  }

  public List<Widget> findAllWidgets() {
    return (List<Widget>) repository.findAll();
    //    return widgets;
  }
  public List<Widget> findWidgetsForTopic(String topicId) {
    return repository.findWidgetsForTopic(topicId);
//    List<Widget> ws = new ArrayList<Widget>();
//    for(Widget w: widgets) {
//      if(w.getTopicId().equals(topicId)) {
//        ws.add(w);
//      }
//    }
//    return ws;
  }

  public Integer deleteWidget(Long id) {
    repository.deleteById(id);
//    int index = -1;
//    for(int i=0; i<widgets.size(); i++) {
//      if(widgets.get(i).getId().equals(id)) {
//        index = i;
//        widgets.remove(index);
//        return 1;
//      }
//    }
    return 1;
  }

  public Integer updateWidget(Long id, Widget widget) {
    if(repository.findById(id).isPresent()) {
      Widget actualWidget = repository.findById(id).get();

      if (widget.getTopicId() != null) {
        actualWidget.setTopicId(widget.getTopicId());
      }

      if (widget.getName() != null) {
        actualWidget.setName(widget.getName());
      }

      if (widget.getType() != null) {
        actualWidget.setType(widget.getType());
      }

      if (widget.getWidgetOrder() != null) {
        actualWidget.setWidgetOrder(widget.getWidgetOrder());
      }

      if (widget.getText() != null) {
        actualWidget.setText(widget.getText());
      }

      if (widget.getSrc() != null) {
        actualWidget.setSrc(widget.getSrc());
      }

      if (widget.getSize() != null) {
        actualWidget.setSize(widget.getSize());
      }

      if (widget.getWidth() != null) {
        actualWidget.setWidth(widget.getWidth());
      }

      if (widget.getHeight() != null) {
        actualWidget.setHeight(widget.getHeight());
      }

      if (widget.getCssClass() != null) {
        actualWidget.setCssClass(widget.getCssClass());
      }

      if (widget.getStyle() != null) {
        actualWidget.setStyle(widget.getStyle());
      }

      if (widget.getValue() != null) {
        actualWidget.setValue(widget.getValue());
      }

      if (widget.getOrdered() != null) {
        actualWidget.setOrdered(widget.getOrdered());
      }

      repository.save(actualWidget);
    }

    return 1;


//    for(int i=0; i<widgets.size(); i++) {
//      if(widgets.get(i).getId().equals(id)) {
//        widgets.set(i, widget);
//        return 1;
//      }
//    }
//    return -1;
  }
}


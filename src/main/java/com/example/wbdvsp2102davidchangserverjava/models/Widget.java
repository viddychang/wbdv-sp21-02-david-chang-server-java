package com.example.wbdvsp2102davidchangserverjava.models;


import javax.persistence.*;

@Entity
@Table(name="widgets")
public class Widget {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
<<<<<<< HEAD

  private String topicId;
  private String name;
=======
  private String topicIc;
>>>>>>> parent of eb48cd0 (assignment5)
  private String type;
  private Integer widgetOrder;
  private String text;
  private String src;
  private Integer size;
  private Integer width;
  private Integer height;
  private String cssClass;
  private String style;
  private String value;
  private Boolean ordered;

  public Widget(Long id, String topicId, String type, Integer size, String text) {
    this.id = id;
    this.topicId = topicId;
    this.type = type;
    this.size = size;
    this.text = text;
  }

  public Widget() {
  }

  public Boolean getOrdered() {
    return ordered;
  }

  public void setOrdered(Boolean ordered) {
    this.ordered = ordered;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getWidgetOrder() {
    return widgetOrder;
  }

  public void setWidgetOrder(Integer widgetOrder) {
    this.widgetOrder = widgetOrder;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTopicIc() {
    return topicIc;
  }

  public void setTopicIc(String topicIc) {
    this.topicIc = topicIc;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

<<<<<<< HEAD
=======
  public Widget(Long id, String topicIc, String type, Integer size, String text) {
    this.id = id;
    this.topicIc = topicIc;
    this.type = type;
    this.size = size;
    this.text = text;
  }
>>>>>>> parent of eb48cd0 (assignment5)

}

/*
    create table widget (
       id bigint not null,
        size integer,
        text varchar(255),
        topic_id varchar(255),
        type varchar(255),
        primary key (id)
    ) engine=InnoDB
 */

/*
    create table widgets (
       id bigint not null auto_increment,
        size integer,
        text varchar(255),
        topic_id varchar(255),
        type varchar(255),
        primary key (id)
    ) engine=InnoDB
 */
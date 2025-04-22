package com.food.ordering.system.domain.entity;

// aggregateRoot라는걸 표시하기 위해 marker 클래스로 사용
public abstract class AggregateRoot<ID> extends BaseEntity<ID> {

}

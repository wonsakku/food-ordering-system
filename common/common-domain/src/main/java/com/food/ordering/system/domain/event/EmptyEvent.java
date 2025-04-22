package com.food.ordering.system.domain.event;

// 일부 saga 단계에서는 예를 들어 종료 작업일 경우 이벤트를 실행시킬 필요가 없음.
// 이런 경우를 처리하기 위해 EmptyEvent 를 사용.
public final class EmptyEvent implements DomainEvent<Void> {

    public static final EmptyEvent INSTANCE = new EmptyEvent();

    private EmptyEvent(){
    }

    @Override
    public void fire() {

    }

}

package com.umc.study.domain.mapping;

import com.umc.study.domain.FoodCategory;
import com.umc.study.domain.Member;
import com.umc.study.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // N : 1에서 N에 해당하는 엔티티가 1에 해당하는 엔티티와 연관 관계를 매핑할 때
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne // 다대일 관계(하나의 카테고리 아이디는 여러개의 선호도 소유가능)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory; // 클래스명 실수

    public void setMember(Member member){
        if(this.member != null)
            member.getMemberPreferList().remove(this);
        this.member = member;
        member.getMemberPreferList().add(this);
    }

    public void setFoodCategory(FoodCategory foodCategory){
        this.foodCategory = foodCategory;
    }
}

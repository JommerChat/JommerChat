package com.parlantos.guild.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "friend")
public class FriendEntity {
  @Id
  @Column(name = "id")
  private BigInteger id;

  public BigInteger getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FriendEntity that = (FriendEntity) o;
    return id.equals(that.id) && Objects.equals(memberEntity, that.memberEntity) && Objects.equals(memberEntity2, that.memberEntity2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, memberEntity, memberEntity2);
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public MemberEntity getMemberEntity() {
    return memberEntity;
  }

  public void setMemberEntity(MemberEntity memberEntity) {
    this.memberEntity = memberEntity;
  }

  public MemberEntity getMemberEntity2() {
    return memberEntity2;
  }

  public void setMemberEntity2(MemberEntity memberEntity2) {
    this.memberEntity2 = memberEntity2;
  }

  @ManyToOne(optional = false)
  @JoinColumn(name = "member_one_id", nullable = false, referencedColumnName = "id")
  private MemberEntity memberEntity;

  @ManyToOne(optional = false)
  @JoinColumn(name = "member_two_id", nullable = false, referencedColumnName = "id")
  private MemberEntity memberEntity2;
}

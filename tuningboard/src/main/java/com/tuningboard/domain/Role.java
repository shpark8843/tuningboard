package com.tuningboard.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;

    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<UserInfo> userinfo;
    
	@Builder
	public Role(Long role_id, String role) {
		this.role_id = role_id;
		this.role = role;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}

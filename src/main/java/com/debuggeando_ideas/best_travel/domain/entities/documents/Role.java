package com.debuggeando_ideas.best_travel.domain.entities.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Role {

    @Field(name = "granted_authorities")
    private Set<String> grantedAuthorities;
}

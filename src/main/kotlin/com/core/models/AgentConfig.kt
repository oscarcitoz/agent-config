package com.core.models

import com.fasterxml.jackson.annotation.JsonProperty
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import org.hibernate.annotations.Type
import java.time.LocalDateTime

@Serdeable
@Entity(name = "agent_configs")
class AgentConfig{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agent_config_seq_generator")
    @SequenceGenerator(name = "agent_config_seq_generator", sequenceName = "agent_configs_id_seq", allocationSize = 1)
     var id: Long? = null

    @Column(name = "agent_id")
    @field:JsonProperty("agent_id")
    var agentId: String = ""

    @Type(value = JsonBinaryType::class)
    @Column(name = "preferences", columnDefinition = "jsonb")
    var preferences: Preference? = null

    @Column(name = "created_at")
    @field:JsonProperty("created_at")
    var createdAt: LocalDateTime = LocalDateTime.now()

    @Column(name = "updated_at")
        @field:JsonProperty("updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now()
}
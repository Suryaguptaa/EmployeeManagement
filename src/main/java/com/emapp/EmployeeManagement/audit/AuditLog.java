package com.emapp.EmployeeManagement.audit;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String action;

    @Column(nullable = false)
    private String entityType;

    @Column(nullable = false)
    private String entityId;

    @Column(nullable = false)
    private String actorType;

    @Column(nullable = false)
    private String actorId;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    protected AuditLog(){}

    public AuditLog(
            String action,
            String entityType,
            String entityId,
            String actorType,
            String actorId
    ){
        this.action = action;
        this.entityType = entityType;
        this.entityId = entityId;
        this.actorType = actorType;
        this.actorId = actorId;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getAction() {
        return action;
    }

    public String getEntityType() {
        return entityType;
    }

    public String getEntityId() {
        return entityId;
    }

    public String getActorType() {
        return actorType;
    }

    public String getActorId() {
        return actorId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

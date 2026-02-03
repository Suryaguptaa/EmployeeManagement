package com.emapp.EmployeeManagement.audit;

import org.springframework.stereotype.Service;

@Service
public class AuditService {

    private final AuditLogRepository auditLogRepository;

    public AuditService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public void log(
            String action,
            String entityType,
            String entityId,
            String actorType,
            String actorId
    ){
        AuditLog log = new AuditLog(
                action,
                entityType,
                entityId,
                actorType,
                actorId
        );

        auditLogRepository.save(log);
    }
}

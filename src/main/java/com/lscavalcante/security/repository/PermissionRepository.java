package com.lscavalcante.security.repository;

import com.lscavalcante.security.model.Permission;
import com.lscavalcante.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}

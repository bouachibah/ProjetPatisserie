package org.sid.dao;



import org.sid.entities.Sucrerie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SucresRepository extends JpaRepository<Sucrerie, Long>{
   @Query("select suc from Sucrerie suc where suc.nom like :x")
	public Page<Sucrerie> chercher(@Param("x")String mc, Pageable pageable);
}

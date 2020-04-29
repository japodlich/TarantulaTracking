package dmacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import dmacc.beans.Molt;
import dmacc.beans.Tarantula;



public interface MoltRepository extends JpaRepository <Molt, Long> {

	//@SuppressWarnings("hiding")
	//@Query("select m, t.id FROM Molt m JOIN Tarantula t ON " + "t.id = m.tId")

	List<Molt> findByTarantula(Tarantula t);
	
	
	
//	@Query("select e, d.dept_label FROM Employee e JOIN Department d ON "
//    + "d.dept_id = e.emp_id") 
//public List<Molt> return getMolt();
}
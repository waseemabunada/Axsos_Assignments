package com.example.axsos.repositories;
	import org.springframework.stereotype.Repository;
	import org.springframework.data.repository.CrudRepository;
	import java.util.List;
	import com.example.axsos.models.Dojo ;

		@Repository
		public interface DojoRepository  extends CrudRepository<Dojo, Long>{  //<modelname,long اللي هو تبع id>
		    // this method retrieves all the books from the database
		    List<Dojo> findAll();
//		    // this method finds books with descriptions containing the search string
//		    List<Burger> findByDescriptionContaining(String search);
//		    // this method counts how many titles contain a certain string
//		    Long countByTitleContaining(String search);
//		    // this method deletes a book that starts with a specific title
//		    Long deleteByTitleStartingWith(String search);
		}


	


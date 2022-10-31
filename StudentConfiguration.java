package com.mysite.core.services.impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
//import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Student Configuration",description="Configuration by kapil")
public @interface StudentConfiguration {

	@AttributeDefinition(
			name = "Number", required = true,
			description = "Number of students allowed in the class")
	        int no_of_students_allowed();


	@AttributeDefinition(
			name = "Marks", required = true,
			description = "Passing marks required")
	        double marks_required_to_pass();

}

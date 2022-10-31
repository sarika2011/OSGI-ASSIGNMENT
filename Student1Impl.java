package com.mysite.core.services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;


import com.mysite.core.services.Student1;

@Component(service = Student1.class, immediate =true)
@Designate(ocd = classConfigurationService.class)
public class Student1Impl implements Student1{
	
	
	int numberOfStudent; 
	
	int marksRequired;
	@Activate
	public void activatedMethod(classConfigurationService config)
	{
		numberOfStudent=config.total_student();
		marksRequired=config.get_passing_marks();
	}
	@Override
	public boolean isClassLimitReached(int list) {
		if(list<numberOfStudent) {
			return true;
		}
		else {
		return false;
	}
	}
	@Override
	public int getPassingMarks() {
		
		return marksRequired;
	}

}

import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		try{
			if(students == null) throw new IllegalArgumentException();
			else
				this.students = students;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		try{
			if(index<0 || index>=students.length) throw new IllegalArgumentException();
			else return students[index];
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		try{
			if(students == null) throw new IllegalArgumentException();
			else if(index<0 || index>=students.length) throw new IllegalArgumentException();
			else students[index] = student;
			
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		try{
			if(students == null) throw new IllegalArgumentException();
			else 
			{
				int length = students.length+1;
				for(int i = length; i>0; i--)
				{
					students[i]=students[i-1];
				}
				students[0]=student;
			}
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		try{
			if(students == null) throw new IllegalArgumentException();
			else 
			{
				students[students.length+1] = student;
			}
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		try{
			if(students == null) throw new IllegalArgumentException();
			else if (index<0 || index>=students.length)throw new IllegalArgumentException();
			else 
			{
				int length = students.length+1;
				for(int i = length; i>index; i--)
				{
					students[i]= students[i-1];
				}
				students[index] = student;
			}
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		try{
			if (index<0 || index>=students.length)throw new IllegalArgumentException();
			else 
			{
				for(int i = index; i<=students.length; i++)
				{
					students[i] = students[i+1];
				}
				students[students.length]=null;
			}
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		int index=-1;
		try
		{
			if(students == null) throw new IllegalArgumentException();
			else 
			{
				for(int i=0; i<students.length; i++)
				{
					if(students[i].equals(student)){
					 index = i;		
					}
				}
				if(index==-1) throw new IllegalArgumentException();
				else
				{
					for(int j = index; j<=students.length; j++)
					{
						students[j] = students[j+1];
					}
					students[students.length] = null;
				}
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Student does not exist");
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		try{
			if(index<0 || index>=students.length) throw new IllegalArgumentException();
			else
			{
				for(int i = index+1; i<=students.length; i++)
				{
					students[i] = null;
				}
			}
		}catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		int index=-1;
		try{
			if(students == null) throw new IllegalArgumentException();
			else
			{
				for(int i=0; i<students.length; i++)
				{
					if(students[i].equals(student)) index=i;
				}
				if(index==-1) throw new IllegalArgumentException();
				else
				{
					for(int j=index+1; j<=students.length; j++)
						students[j]=null;
				}
			}
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		try{
			if(index<0 || index>=students.length) throw new IllegalArgumentException();
			else
			{
				for(int i=0; i<index; i++)
				{
					students[i]=null;
				}
			}
		}catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		int index=-1;
		try{
			if(students == null) throw new IllegalArgumentException();
			else
			{
				for(int i=0; i<students.length; i++)
				{
					if(students[i].equals(student)) index=i;
				}
				if(index==-1) throw new IllegalArgumentException();
				else
				{
					for(int j=0; j<index; j++)
					{
						students[j]=null;
					}
				}
				
			}
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		//bubble sort by avgmark
		double temp;
		for(int i=0; i<students.length-1; i++)
		{
			for(int j=i+1; j<students.length-1-i; j++)
			{
				if(students[j].getAvgMark()>students[j+1].getAvgMark())
				{
					temp = students[j].getAvgMark();
					students[j].setAvgMark(students[j+1].getAvgMark());
					students[j+1].setAvgMark(temp);
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		int j=0;
		Student satisfydate[] = new Student[students.length];
		try{
			if(date == null) throw new IllegalArgumentException();
			else
			{
				
			}
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		 long ageInMillis = new Date().getTime() - students[indexOfStudent].getBirthDate().getTime();

		    return (int )ageInMillis/(1000*60*60*24*365);
		
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double max=students[0].getAvgMark();
		
		for(int i=1; i<=students.length; i++)
		{
			if(students[i].getAvgMark()>max)
			{
				max=students[i].getAvgMark();
			}
		}
		Student satisfyMark[] = new Student[students.length];
		int j=0;
		for(int i=0; i<students.length; i++)
		{
			if(max == students[i].getAvgMark()) { satisfyMark[j]=students[i]; j++;}
		}
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		try{
			if(students==null) throw new IllegalArgumentException();
			else
			{
				for(int i=0; i<students.length; i++)
				{
					if(students[i].equals(student))
						return students[i+1];
				}
			}
				
		}catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}

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
		return students;
		// Add your implementation here
		
	}

	@Override
	public void setStudents(Student[] students) {
		int count=0;
		
			if(students==null)
				throw new IllegalArgumentException();
			else
			{
				for(int i=0;i<students.length;i++)
				{
					this.students[i].setId(students[i].getId());
					this.students[i].setBirthDate(students[i].getBirthDate());
					this.students[i].setFullName(students[i].getFullName());
					this.students[i].setBirthDate(students[i].getBirthDate());
					this.students[i].setAvgMark(students[i].getAvgMark());
					
				}
			}
		
		
		// Add your implementation here
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		
		if(index<0 || index>students.length)
			throw new IllegalArgumentException();
		return students[index];
		
	}
	@Override
	public void setStudent(Student student, int index) {
		
			if(index<0 || index>students.length)
			{
				throw new IllegalArgumentException();
			}
			
				this.students[index]=student;
		// Add your implementation here
				}

	@Override
	public void addFirst(Student student) {
			if(student==null)
				throw new IllegalArgumentException();
			add(student,0);
			
		
		// Add your implementation here
	}

	@Override
	public void addLast(Student student) {
		if(student==null)
			throw new IllegalArgumentException();
		add(student,students.length);
		// Add your implementation here
	}

	@Override
	public void add(Student student, int index) {
		if(student==null || index<0)
			throw new IllegalArgumentException();
		Student s[]=new  Student[students.length+1];
		for(int i=0;i<index;i++)
			s[i]=students[i];
		s[index]=student;
		for(int i=index+1;i<students.length;i++)
			s[i]=students[i];
		
		setStudents(s);
		// Add your implementation here
	}

	@Override
	public void remove(int index) {
		if(index<0 || index>students.length)
			throw new IllegalArgumentException();
		Student s[]=new  Student[students.length-1];
		for(int i=0;i<index;i++)
			s[i]=students[i];
		for(int i=index+1;i<students.length;i++)
		{
			s[i]=students[i];
		}
		setStudents(s);
		// Add your implementation here
	}

	@Override
	public void remove(Student student) {
		if(student==null)
			throw new IllegalArgumentException();
		for(int i=0;i<students.length;i++)
		{
			if(students[i]==student)
			{
				remove(i);
			}
		}
		// Add your implementation here
	}

	@Override
	public void removeFromIndex(int index) {
		if(index==0 || index<students.length)
			throw new IllegalArgumentException();
		Student s[]=new  Student[students.length-1];
		for(int i=0;i<index;i++)
		{
			s[i]=students[i];
		}
		students=null;
		setStudents(s);
		// Add your implementation here
	}

	@Override
	public void removeFromElement(Student student) {
		if(student==null)
			throw new IllegalArgumentException();
		Student s[]=new  Student[students.length-1];
		for(int i=0;i<students.length;i++)
		{
			if(students[i]==student)
			{
				removeFromIndex(i+1);
			}
		}
		// Add your implementation here
	}

	@Override
	public void removeToIndex(int index) {
		if(index<0||index>students.length)
			throw new IllegalArgumentException();
		Student s[]=new  Student[students.length];
		for(int i=index;i<students.length;i++)
		{
			s[index-i]=students[i];
		}
		students=null;
		setStudents(s);
		// Add your implementation here
	}

	@Override
	public void removeToElement(Student student) {
		if(student==null)
			throw new IllegalArgumentException();
		Student s[]=new  Student[students.length-1];
		for(int i=0;i<students.length;i++)
		{
			if(students[i]==student)
			{
				removeToIndex(i);
			}
		}
		// Add your implementation here
	}

	@Override
	public void bubbleSort() {
		
		
		// Add your implementation here
		for(int i=0;i<students.length;i++)
		{
			for(int j=0;j<students.length;j++)
			{
				if(students[j].compareTo(students[j+1])>0)
				{
					Student temp=students[j];
					students[j]=students[j+1];
					students[j+1]=temp;
			   }
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		if(date==null)
			throw new IllegalArgumentException();
		Student s[]=new  Student[students.length];
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getBirthDate().before(date) || students[i].getBirthDate()==date)
			{
				s[i]=students[i];
			}
		}
		return s;
		// Add your implementation here
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		if(firstDate==null || lastDate==null)
			throw new IllegalArgumentException();
		Student s[]=new  Student[students.length];
		int count=0;
		for(int i=0;i<students.length;i++)
		{
			if((students[i].getBirthDate().after(firstDate))&&(students[i].getBirthDate().before(lastDate))
					||students[i].getBirthDate()==firstDate || (students[i].getBirthDate()==lastDate))
					{
				         s[count]=students[i];
				         count++;
					}
		}
		// Add your implementation here
		return s;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
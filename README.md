# easy-query
**A easy way to make sql queries on hibernate**

This simple library pretends to ease the building of hibernate queries.

## Compatibility
The library is compatible with Java 6 or newer and hibernate 3 or newer

## Usage
To use easy-query just instance `org.easyquery.EasyQuery` with the hibernate `Session`:
```
EasyQuery easyQuery = new EasyQuery(session);
```
then, build a query:
```
List<Teacher> teachers = easyQuery.from(Teacher.class).list();
```
If you are using Spring, you can define it as a bean by passing SessionFactory as a constructor-arg:
```
<bean id="easyQuery" class="org.easyquery.EasyQuery">
	<constructor-arg ref="sessionFactory" />
</bean> 
```
## Examples
```
Teacher teacher = easyQuery.from(Teacher.class).where("id").equal(1).uniqueResult();

String teacherName = (String) easyQuery.select("name")
			.from(Teacher.class).where("id").equal(1).uniqueResult();

List<Object[]> courses = easyQuery.from(Course.class, "c")
                .innerJoin("c.teacher", "t")
                .where("t.id").equal(1).list();
```

| Module.Question | Data Management: JDBC, Transactions, Spring Data JPA                                                         |
|-----------------|--------------------------------------------------------------------------------------------------------------|
| 03.01           | What is the difference between checked and unchecked exceptions?                                             |
|                 | Why does Spring prefer unchecked exceptions?                                                                 |
|                 | What is the data access exception hierarchy?                                                                 |
|                 |                                                                                                              |
| 03.02           | How do you configure a DataSource in Spring?                                                                 |
|                 | Which bean is very useful for development/test databases?                                                    |
|                 |                                                                                                              |
| 03.03           | What is the Template design pattern and what is the JDBC template?                                           |
|                 |                                                                                                              |
| 03.04           | What is a callback?                                                                                          |
|                 | What are the three JdbcTemplate callback interfaces that can be used with queries?                           |
|                 | What is each used for?                                                                                       |
|                 |                                                                                                              |
| 03.05           | Can you execute a plain statement with the JDBC template?                                                    |
|                 |                                                                                                              |
| 03.06           | When does the JDB template acquire (and release) a connection, for every method called or once per template? |
|                 |                                                                                                              |
| 03.07           | How does the JdbcTemplate support generic queries?                                                           |
|                 | How does it return objects and lists/maps of objects?                                                        |
|                 |                                                                                                              |
| 03.08           | What is a transaction?                                                                                       |
|                 | What is the difference between a local and a global transaction?                                             |
|                 |                                                                                                              |
| 03.09           | Is a transaction a cross cutting concern?                                                                    |
|                 | How is it implemented by Spring?                                                                             |
|                 |                                                                                                              |
| 03.10           | How are you going to define a transaction in Spring?                                                         |
|                 | What does @Transactional do?                                                                                 |
|                 | What is the PlatformTransactionManager?                                                                      |
|                 |                                                                                                              |
| 03.11           | Is the JDBC template able to participate in an existing transaction?                                         |
|                 |                                                                                                              |
| 03.12           | What is a transaction isolation level?                                                                       |
|                 | How many do we have and how are they ordered?                                                                |
|                 |                                                                                                              |
| 03.13           | What is _@EnableTransactionManagement_ for?                                                                  |
|                 |                                                                                                              |
| 03.14           | What does transaction propagation mean?                                                                      |
|                 |                                                                                                              |
| 03.15           | What happens if one @Transactional annotated method is calling another @Transactional annotated method       |
|                 | on the same object instance?                                                                                 |
|                 |                                                                                                              |
| 03.16           | Where can @Transactional annotation be used?                                                                 |
|                 | What is a typical usage if you put it at class level?                                                        |
|                 |                                                                                                              |
| 03.17           | What does declarative transaction management mean?                                                           |
|                 |                                                                                                              |
| 03.18           | What is the default rollback policy and how can you override it?                                             |
|                 |                                                                                                              |
| 03.19           | What is the default rollback policy in a JUnit 4 & 5 test (@RunWith(SpringJUnit4ClassRunner.class) or        |
|                 | @ExtendWith(SpringExtension.class)) and annotate your @Test annotated method with @Transactional?            |
|                 |                                                                                                              |
| 03.20           | Why is the term "unit of work" so important and why does JDBC AutoCommit violate this pattern?               |
|                 |                                                                                                              |
| 03.21           | What do you need to do in (vanilla) Spring Framework if you would like to work with JPA?                     |
|                 |                                                                                                              |
| 03.22           | Are you able to participate in a given transaction in Spring while working with JPA?                         |
|                 |                                                                                                              |
| 03.23           | Which PlatformTransactionManager(s) can you use with JPA?                                                    |
|                 |                                                                                                              |
| 03.24           | What do you have to configure to use JPA with Spring?                                                        |
|                 | How does Spring Boot make this easier?                                                                       |
|                 |                                                                                                              |
| 03.25           | What is a Repository interface?                                                                              |
|                 |                                                                                                              |
| 03.26           | How do you define a Repository interface?                                                                    |
|                 | Why is it an interface not a class?                                                                          |
|                 |                                                                                                              |
| 03.27           | What is the naming convention for finder methods in a Repository interface?                                  |
|                 |                                                                                                              |
| 03.28           | How are Spring Data Repositories implemented by Spring at runtime?                                           |
|                 |                                                                                                              |
| 03.29           | What is @Query used for?                                                                                     |

TESTED WITH JAVA 11
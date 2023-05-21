# **Module Clearance Test**

## Name :- Music streaming service API
## Framework :- Spring
## Language :- Java
## Database :- MySQL

### Application Properties

spring.datasource.url=jdbc:mysql://localhost:3306/musicStreaming  
spring.datasource.username=root  
spring.datasource.password=root  
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver  
spring.jpa.hibernate.ddl-auto=update  

spring.jpa.properties.hibernate.show_sql=true  
spring.jpa.properties.hibernate.use_sql_comments=true  
spring.jpa.properties.hibernate.format_sql=true    

## Data Flow

### Controller Package

This Package Handles the HTTP Request from the client. It contains the two classes

1.PlaylistController  
2.SongController

1.PlaylistController:-

This controller class handles HTTP requests related to playlists. It exposes various endpoints for managing playlists.Class level annotations:
@RestController indicates that this class is a REST controller that handles HTTP requests and returns the response directly to the client.
@RequestMapping("/") specifies the base URL mapping for all the endpoints in this controller. Autowired dependency for the PlaylistService class, used to perform operations on playlists. Autowired dependency for the UserService class, used to retrieve user information.
Endpoints are GET /{userId} retrieves all playlists for a given user. Path Variable is userId (Long)  of the user for which playlists need to be retrieved.
Returns a list of Playlist objects representing the playlists associated with the user. GET /{id} retrieves a playlist by ID. Path Variable is
id (Long) of the playlist to be retrieved. Returns the Playlist object with the specified ID. POST /{userId} creates a new playlist for a user.
Path Variable is userId (Long) the ID of the user for which the playlist needs to be created. Request Body playlist (JSON object) the playlist object to be created. It should be a valid and complete Playlist object.
Returns the created Playlist object if successful, or null if the user doesn't exist or the provided user is not the owner of the playlist. PUT /{id} updates a playlist by ID.
Path Variable is id (Long)  of the playlist to be updated. Request Body playlist (JSON object)  updated playlist object. It should be a valid and complete Playlist object.
Returns the updated Playlist object if successful, or null if the playlist doesn't exist. DELETE /{id} deletes a playlist by ID. Path Variable 
id (Long) of the playlist to be deleted. It returns None.

2.SongController:-

This controller class handles HTTP requests related to songs. It provides endpoints for managing songs. Class level annotations are @RestController indicates that this class is a REST controller that handles HTTP requests and returns the response directly to the client. 
@RequestMapping("/api") Specifies the base URL mapping for all the endpoints in this controller. Dependencies are SongService Autowired dependency for the SongService class, used to perform operations on songs. 
Endpoints are GET /songs retrieves all songs. A list of Song objects representing all the songs in the system. GET /{id} 
retrieves a song by ID. Path Variable is id (Long) of the song to be retrieved. Returns the Song object with the specified ID. POST /create creates a new song. Request Body is
Song (JSON object) object to be created. It should be a valid and complete Song object. Returns the created Song object. PUT /api/{id} updates a song by ID.
Path Variable is id (Long) of the song to be updated. Request Body is Song (JSON object)  updated song object. It should be a valid and complete Song object.
Returns the updated Song object if successful, or null if the song doesn't exist. DELETE /api/{id} deletes a song by ID. Path Variable id (Long) of the song to be deleted. It Returns None.


### Service Package


1.PlaylistService  
2.SongService  
3.UserService

The classes is annotated with @Service, indicating that it is a service component.

1.PlaylistService:- 

Dependencies  are IPlaylistRepo Autowired dependency for the IPlaylistRepo interface, used to interact with the playlist repository.
public List<Playlist> getAllPlaylists(Long userId) retrieves all playlists associated with a specific user.
Parameters are userId (Long): The ID of the user whose playlists should be retrieved.
It returns a list of Playlist objects representing all the playlists associated with the specified user.
public Playlist getPlaylistById(Long id) is retrieves a playlist by its ID. Parameters are id (Long): The ID of the playlist to be retrieved.
Returns the Playlist object with the specified ID, or null if the playlist doesn't exist.
public Playlist savePlaylist(Playlist playlist) Saves a playlist.
Parameters are playlist (Playlist): The playlist object to be saved.
Returns the saved Playlist object. public void deletePlaylist(Long id) Deletes a playlist by its ID.
Parameters are id (Long): The ID of the playlist to be deleted.Returns the None.
public boolean isUserPlaylistOwner(Long playlistId, Long userId) is Checks if a user is the owner of a playlist.
Parameters are playlistId (Long): The ID of the playlist. userId (Long): The ID of the user to be checked.
Returns a boolean value indicating whether the user is the owner of the playlist (true) or not (false).


2.SongService:- 

This class provides service methods for managing songs. Dependencies are ISongRepo Autowired dependency for the ISongRepo interface, used to interact with the song repository.
Methods are public List<Song> getAllSongs() is Retrieves all songs. Returns a list of Song objects representing all the songs.
public Song getSongById(Long id) is retrieves a song by its ID. Parameters are id (Long): The ID of the song to be retrieved.
Returns the Song object with the specified ID, or null if the song doesn't exist. public Song saveSong(Song song) Description is Saves a song.
Parameters are song (Song): The song object to be saved. Returns the saved Song object. public void deleteSong(Long id) Description are Deletes a song by its ID.
Parameters are id (Long): The ID of the song to be deleted. Returns the None.


3.UserService:- 

This class provides service methods for managing users. Dependencies are used IUserRepo Autowired dependency for the IUserRepo interface, used to interact with the user repository.
Methods are public User getUserByUsername(String username) retrieves a user by their username.
Parameters are username (String): The username of the user to be retrieved. Returns the User object with the specified username, or null if the user doesn't exist.


### Repository Package

This package consist of interfaces. Which defines a set of methods that can be used to interact with the underlying database. The interface extends the JpaRepository interface and specifies the Job entity and the data type of its primary key Integer. The interface contains several custom finder methods that use the naming convention of Spring Data JPA to automatically generate the queries. In summary, this code implements a simple REST ful API for managing Job objects with endpoints for performing CRUD operations.

1.IPlaylistRepo  
2.ISongRepo  
3.IUserRepo

All the Interfaces extends JpaRepository.

### Model Package

All the class present in this package will be Present in the Database as Table. This package consist of three classes and one enum:

classes:  
Playlist  
Song  
User  

Enum:  
UserRole 

All the common annotation in these classes are :

@Data annotation: This annotation is part of the Lombok library and is used to generate boilerplate code for the entity class, such as getters, setters, equals(), hashCode(), and toString() methods.    
@NoArgsConstructor annotation: This annotation is from Lombok and generates a no-argument constructor for the entity class.  
@AllArgsConstructor annotation: This annotation is from Lombok and generates an all-argument constructor for the entity class.  
@Entity annotation: This JPA (Java Persistence API) annotation indicates that the class is an entity and should be mapped to a database table.  
@Id annotation: This JPA annotation is used to mark the primary key field of the entity.  
@GeneratedValue annotation: This JPA annotation specifies the generation strategy for the primary key. In this case, GenerationType.IDENTITY is used, which indicates that the primary key values are automatically generated by the database.  


private Long id: This field represents the primary key of the User entity.  
private String userName: This field represents the name of the user.   
private String password: This field represents the password of the user.  


private Long id: This field represents the primary key of the User entity.  
private String name: This field represents the name of the playlist.  
@ManyToOne annotation: This JPA annotation establishes a many-to-one relationship between the Playlist entity and the User entity.   
private User user: This field represents the user who created the playlist. It is annotated with @ManyToOne to establish the relationship between the Recipe and User entities.   


private String title: This field represents the title of the song.  
private String artist: This field represents the artist of the song.  
private String album: This field represents the album of the song.  
private int duration: This field represents the duration of the song.  
private LocalDate registeredDate: This field represents the registered date of the user. It uses the LocalDate class from Java's date and time.  


### Summery Of Project

The Music streaming service API is a Spring Boot-based application that allows users to save and manage songs. The API supports CRUD (Create, Read, Update, Delete) operations on song, as well as the ability for users to add a any song which is search by user the song  add in a playlist. The project includes the necessary annotations and relationships between the entities to establish the database mappings. It leverages Spring Boot's autoconfiguration and dependency injection capabilities to manage dependencies and simplify development. To use the Music streaming service API, you can make HTTP requests to the exposed endpoints for performing CRUD operations on songs, playlist. This project serves as a foundation for building a Music streaming service.